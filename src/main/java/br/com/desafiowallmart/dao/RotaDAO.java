package br.com.desafiowallmart.dao;

import java.util.List;

import br.com.desafiowallmart.dao.exception.DadosFaltandoException;
import br.com.desafiowallmart.dao.exception.NaoExisteCaminhoException;
import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;
import br.com.desafiowallmart.vo.RotaVO;


/**
 * Dao de acesso ao banco para cadastro e consulta de rota
 * @author jorge
 *
 */
public interface RotaDAO {

	/**
	 * Cadastra nova Rota
	 * @param origem Nome da origem da rota
	 * @param destino Nome do destino da rota
	 * @param distancia Distancia em KM dessa rota
	 */
	public void cadastraRota(String origem, String destino, Double distancia);
	
	/**
	 * Consulta a menor rota entre dois pontos
	 * 
	 * @param origem Nome da origem da rota
	 * @param destino Nome do destino da rota
	 * @return {@link ConsultaRotaOutputVO} com os dados da rota
	 * @throws DadosFaltandoException 
	 * @throws NaoExisteCaminhoException 
	 */
	public ConsultaRotaOutputVO consutlaMenorRota(String origem, String destino) throws DadosFaltandoException, NaoExisteCaminhoException;

	/**
	 * @param listRotaVO
	 */
	void cadastraRota(List<RotaVO> listRotaVO);
}
