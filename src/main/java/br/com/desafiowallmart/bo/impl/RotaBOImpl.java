package br.com.desafiowallmart.bo.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import br.com.desafiowallmart.bo.RotaBO;
import br.com.desafiowallmart.dao.RotaDAO;
import br.com.desafiowallmart.dao.exception.DadosFaltandoException;
import br.com.desafiowallmart.service.vo.ConsultaRotaVO;
import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;
import br.com.desafiowallmart.vo.RotaVO;

/**
 * Bo que contem as regras de negocio para a consulta de Rota
 * @author jorge
 *
 */
@Component
public class RotaBOImpl implements RotaBO{

	@Resource
	private RotaDAO rotaDAO;
	
	@Override
	public void cadastraRota(RotaVO inputVO) throws DadosFaltandoException {

		//TODO: Refactor, criar um validador do spring para isso
		if (inputVO == null || StringUtils.isEmpty(inputVO.getDestino()) || StringUtils.isEmpty(inputVO.getOrigem()) || inputVO.getDistancia() == null) {
			throw new DadosFaltandoException("Está faltando alguma informação, Origem, Destino ou Distancia");
		}
		rotaDAO.cadastraRota(inputVO.getOrigem(), inputVO.getDestino(), inputVO.getDistancia());
	}

	@Override
	public ConsultaRotaOutputVO consutlaRota(ConsultaRotaVO inputVO) throws DadosFaltandoException {
		ConsultaRotaOutputVO retorno = rotaDAO.consutlaMenorRota(inputVO.getOrigem(), inputVO.getDestino());
		double litrosGastos = retorno.getDistancia() / inputVO.getAutonomia();
		retorno.setGasto(litrosGastos * inputVO.getValorCombustivel());
		return retorno;
	}

}
