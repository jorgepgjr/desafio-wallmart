package br.com.desafiowallmart.bo;

import org.springframework.stereotype.Service;

import br.com.desafiowallmart.service.vo.ConsultaRotaVO;
import br.com.desafiowallmart.vo.RotaVO;

//@Service
public interface RotaBO {

	public void cadastraRota(RotaVO inputVO);
	public void consutlaRota(ConsultaRotaVO inputVO);
	
}
