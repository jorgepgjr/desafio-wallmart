package br.com.desafiowallmart.domain;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Local {
	private final static String DISTANCIA = "DISTANCIA";

	@GraphId
	private Long id;
	
	@Indexed
	private String nome;
	
    @RelatedTo(type = DISTANCIA, direction = Direction.BOTH)
    private @Fetch Set<Local> rotas;

    
	public Local() {
		super();
	}
	
    public void criarRota(Local local) {
        if (rotas == null) {
            rotas = new HashSet<Local>();
        }
        rotas.add(local);
    }
	
    public Local(String nome) { this.nome = nome; }    
	public Local(String nome, Set<Local> rotas) {
		Local local = new Local();
		local.setNome(nome);
		local.setRotas(rotas);
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

	public Set<Local> getRotas() {
		return rotas;
	}

	public void setRotas(Set<Local> rotas) {
		this.rotas = rotas;
	}
    
}
