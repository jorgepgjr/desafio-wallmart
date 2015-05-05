package br.com.desafiowallmart.service.vo;

import java.io.Serializable;


public class ConsultaRotaVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String origem;
	private String destino;
	private Double autonomia;
	private Double valorCombustivel;

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
	public Double getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(Double autonomia) {
		this.autonomia = autonomia;
	}
	public Double getValorCombustivel() {
		return valorCombustivel;
	}
	public void setValorCombustivel(Double valorCombustivel) {
		this.valorCombustivel = valorCombustivel;
	}
	}
