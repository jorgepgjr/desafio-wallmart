package br.com.desafiowallmart.vo;

import java.io.Serializable;


public class RotaVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String origem;
	private String destino;
	private Double distancia;
	
	public RotaVO(String origem, String destino, Double distancia) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}
	
	public RotaVO() {
		super();
	}

	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

}
