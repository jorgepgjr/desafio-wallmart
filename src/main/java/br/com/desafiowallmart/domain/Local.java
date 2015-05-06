package br.com.desafiowallmart.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

@NodeEntity
public class Local {
	private final static String DISTANCIA = "DISTANCIA";

	@GraphId
	Long id;

	@Indexed
	private String nome;

	@RelatedToVia
	Set<Rota>rotas = new HashSet<Rota>();	
	public Rota rotaPara(Local destino, Long distancia) {
        Rota rota=new Rota(this, destino, distancia);
        rotas.add(rota);
		return rota;
    }
	

	@Override
	public String toString() {
		return "Local [id=" + id + ", nome=" + nome + ", rotas=" + rotas + "]";
	}


	public Local() {
		super();
	}

	public Local(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(Set<Rota> rotas) {
		this.rotas = rotas;
	}
}
