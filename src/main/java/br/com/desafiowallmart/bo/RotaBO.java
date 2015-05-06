package br.com.desafiowallmart.bo;

import br.com.desafiowallmart.service.vo.ConsultaRotaVO;
import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;
import br.com.desafiowallmart.vo.RotaVO;

public interface RotaBO {

	public void cadastraRota(RotaVO inputVO);
	public ConsultaRotaOutputVO consutlaRota(ConsultaRotaVO inputVO);
	
}
