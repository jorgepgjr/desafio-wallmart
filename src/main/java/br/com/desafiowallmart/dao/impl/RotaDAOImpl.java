package br.com.desafiowallmart.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.neo4j.graphalgo.GraphAlgoFactory;
import org.neo4j.graphalgo.PathFinder;
import org.neo4j.graphalgo.WeightedPath;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.PathExpanders;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.stereotype.Component;

import br.com.desafiowallmart.dao.RotaDAO;
import br.com.desafiowallmart.dao.exception.DadosFaltandoException;
import br.com.desafiowallmart.dao.exception.NaoExisteCaminhoException;
import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;
import br.com.desafiowallmart.vo.RotaVO;

@Component
public class RotaDAOImpl implements RotaDAO {

	@Autowired
	GraphDatabaseService graphDatabaseService;

	@Resource
	GraphDatabase graphDatabase;

	private final String NOME_PROPERTIE = "nome";
	private final static String DISTANCIA_PROPERTIE = "distancia";

	private static RelationshipType DISTANCIA = DynamicRelationshipType
			.withName(DISTANCIA_PROPERTIE);

	@Override
	public void cadastraRota(String origem, String destino, Double distancia) {
		Transaction tx = graphDatabase.beginTx();
		try {
			this.salvaRota(origem, destino, distancia);
			tx.success();
		} finally {
			tx.close();
		}
	}

	@Override
	public void cadastraRota(List<RotaVO> listRotaVO) {
		Transaction tx = graphDatabase.beginTx();
		try {
			for (RotaVO rotaVO : listRotaVO) {
				this.salvaRota(rotaVO.getOrigem(), rotaVO.getDestino(), rotaVO.getDistancia());
			}

			tx.success();
		} finally {
			tx.close();
		}
	}
	
	private void salvaRota(String origem, String destino, Double distancia) {
		Node nodeOrigem = this.criaNode(origem);

		Node nodeDestino = this.criaNode(destino);

		Relationship relacao = nodeOrigem.createRelationshipTo(
				nodeDestino, DISTANCIA);
		relacao.setProperty(DISTANCIA_PROPERTIE, distancia);
	}

	@Override
	public ConsultaRotaOutputVO consutlaMenorRota(String origem, String destino)
			throws DadosFaltandoException, NaoExisteCaminhoException {
		final Transaction tx = graphDatabase.beginTx();
		final Node origemNode;
		final Node destinoNode;
		final WeightedPath path;
		final ConsultaRotaOutputVO vo;
		try {

			Index<Node> indexService = graphDatabaseService.index().forNodes(
					"locais");
			origemNode = indexService.get(NOME_PROPERTIE, origem).getSingle();

			if (origemNode == null) {
				throw new DadosFaltandoException("Origem não encontrada");
			}

			destinoNode = indexService.get(NOME_PROPERTIE, destino).getSingle();

			if (destinoNode == null) {
				throw new DadosFaltandoException("Destino não encontrado");
			}

			PathFinder<WeightedPath> finder = GraphAlgoFactory.dijkstra(
					PathExpanders
							.forTypeAndDirection(DISTANCIA, Direction.BOTH),
					"distancia");

			path = finder.findSinglePath(origemNode, destinoNode);

			if (path == null) {
				throw new NaoExisteCaminhoException("Não é possivel construir uma rota");
			}

			vo = new ConsultaRotaOutputVO();
			vo.setDistancia(path.weight());
			for (Node n : path.nodes()) {
				vo.addRota(n.getProperty(NOME_PROPERTIE).toString());
			}
			tx.success();
		} finally {
			tx.close();
		}
		return vo;
	}

	private Node criaNode(String nome) {
		Node searchNode;

		Index<Node> indexService = graphDatabaseService.index().forNodes(
				"locais");
		searchNode = indexService.get(NOME_PROPERTIE, nome).getSingle();

		if (searchNode == null) {
			searchNode = graphDatabaseService.createNode();
			searchNode.setProperty(NOME_PROPERTIE, nome);
			indexService.add(searchNode, NOME_PROPERTIE, nome);
		}
		return searchNode;
	}

}
