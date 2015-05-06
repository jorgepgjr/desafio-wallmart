package br.com.desafiowallmart.bo.impl;

import javax.annotation.Resource;

import br.com.desafiowallmart.bo.RotaBO;
import br.com.desafiowallmart.dao.RotaDAO;
import br.com.desafiowallmart.service.vo.ConsultaRotaVO;
import br.com.desafiowallmart.vo.RotaVO;

public class RotaBOImpl implements RotaBO{

	@Resource
	private RotaDAO rotaDAO;
	
	@Override
	public void cadastraRota(RotaVO inputVO) {
		rotaDAO.cadastraRota(inputVO.getOrigem(), inputVO.getDestino(), inputVO.getDistancia());
	}

	@Override
	public void consutlaRota(ConsultaRotaVO inputVO) {
		// TODO Auto-generated method stub
		
	}

}
