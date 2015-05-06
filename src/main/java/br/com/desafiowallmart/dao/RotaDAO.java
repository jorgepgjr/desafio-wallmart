package br.com.desafiowallmart.dao;

import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;


public interface RotaDAO {

	public void cadastraRota(String origem, String destino, Double distancia);
	public ConsultaRotaOutputVO consutlaMenorRota(String origem, String destino);
}
