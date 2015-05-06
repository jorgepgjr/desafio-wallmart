package br.com.desafiowallmart.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;



public class ConsultaRotaOutputVO {

	private List<String> rota;
	private Double distancia;
	private Double gasto;
	
	public void addRota(String local){
		if (rota == null) {
			rota = new ArrayList<String>();
		}
		rota.add(local);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Distancia: " + distancia + " Gasto: " + gasto +" Rota: ");
		if (!CollectionUtils.isEmpty(rota)) {
			for (String r : rota) {
				sb.append(r +" ");
			}
		}
		return sb.toString();
	}

	public List<String> getRota() {
		return rota;
	}
	public void setRota(List<String> rota) {
		this.rota = rota;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public Double getGasto() {
		return gasto;
	}
	public void setGasto(Double gasto) {
		this.gasto = gasto;
	}
}
