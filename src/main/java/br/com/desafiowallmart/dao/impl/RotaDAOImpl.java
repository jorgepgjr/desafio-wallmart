package br.com.desafiowallmart.dao.impl;

import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;

import br.com.desafiowallmart.dao.RotaDAO;

public class RotaDAOImpl implements RotaDAO {

	@Autowired
	GraphDatabaseService graphDatabaseService;
	
	@Autowired
	GraphDatabase graphDatabase;

	private static RelationshipType DISTANCIA = DynamicRelationshipType
			.withName("DISTANCIA");

	@Override
	public void cadastraRota(String origem, String destino, Double distancia) {
		Transaction tx = graphDatabase.beginTx();
		try {
			Node a = graphDatabaseService.createNode();
			a.setProperty("name", origem);

			Node b = graphDatabaseService.createNode();
			b.setProperty("name", destino);

			Relationship relacao = a.createRelationshipTo(b, DISTANCIA);
			relacao.setProperty("distancia", distancia);

			tx.success();
		} finally {
			tx.close();
		}

	}
}
