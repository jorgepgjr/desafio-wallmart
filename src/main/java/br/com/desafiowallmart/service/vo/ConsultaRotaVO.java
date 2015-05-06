package br.com.desafiowallmart.service.vo;



public class ConsultaRotaVO{

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
