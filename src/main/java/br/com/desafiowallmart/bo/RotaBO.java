package br.com.desafiowallmart.bo;

import java.util.List;

import br.com.desafiowallmart.dao.exception.DadosFaltandoException;
import br.com.desafiowallmart.dao.exception.NaoExisteCaminhoException;
import br.com.desafiowallmart.service.vo.ConsultaRotaVO;
import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;
import br.com.desafiowallmart.vo.RotaVO;

public interface RotaBO {

	public void cadastraRota(List<RotaVO> inputVO) throws DadosFaltandoException;
	public void cadastraRota(RotaVO inputVO) throws DadosFaltandoException;
	public ConsultaRotaOutputVO consutlaRota(ConsultaRotaVO inputVO) throws DadosFaltandoException, NaoExisteCaminhoException;
	
}
