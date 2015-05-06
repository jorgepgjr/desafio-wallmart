package br.com.desafiowallmart.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = "ROTA")
public class Rota {
	@GraphId
	Long id;
	@StartNode
	Local origem;
	@EndNode
	Local destino;
	Long distancia;

	public Rota(Local origem, Local destino, Long distancia) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}

	Rota() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Local getOrigem() {
		return origem;
	}

	public void setOrigem(Local origem) {
		this.origem = origem;
	}

	public Local getDestino() {
		return destino;
	}

	public void setDestino(Local destino) {
		this.destino = destino;
	}

	public Long getDistancia() {
		return distancia;
	}

	public void setDistancia(Long distancia) {
		this.distancia = distancia;
	}

	
}
