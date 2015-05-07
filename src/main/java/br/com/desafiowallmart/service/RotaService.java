/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.desafiowallmart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiowallmart.bo.RotaBO;
import br.com.desafiowallmart.dao.exception.DadosFaltandoException;
import br.com.desafiowallmart.dao.exception.NaoExisteCaminhoException;
import br.com.desafiowallmart.service.vo.CadastraRotaVO;
import br.com.desafiowallmart.service.vo.ConsultaRotaVO;
import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;
import br.com.desafiowallmart.vo.RotaVO;

/**
 * Servico de Rota
 * @author jorge
 *
 */
@RestController
public class RotaService {

	private static final String CADASTRO_SUCESSO = "Rota cadastrada com sucesso";
	
	@Autowired(required=false)
	private RotaBO rotaBO;

	
	/**
	 * Cadastra uma nova rota. 
	 * @param cadastraRotaVO rota a ser cadastrada
	 * @return Mensagem de Sucesso ou erro
	 */
	@RequestMapping(value="/cadastraRota", method = RequestMethod.PUT)
	public @ResponseBody String cadastraRota(@RequestBody CadastraRotaVO cadastraRotaVO) {
		try {
			rotaBO.cadastraRota(cadastraRotaVO.getRotaVO());
		} catch (DadosFaltandoException e) {
			return e.getMessage();
		}
		return CADASTRO_SUCESSO;
	}
	

	/**
	 * Consulta a menor rota entre dois pontos
	 * @param inputVO
	 * @return {@link ConsultaRotaOutputVO} 
	 * @throws DadosFaltandoException 
	 * @throws NaoExisteCaminhoException 
	 */
	@RequestMapping(value="/consultaRota", method = RequestMethod.POST)
	public @ResponseBody ConsultaRotaOutputVO consultaRota(@RequestBody ConsultaRotaVO inputVO) throws DadosFaltandoException, NaoExisteCaminhoException {
		ConsultaRotaOutputVO vo = rotaBO.consutlaRota(inputVO);
		//TODO: melhorar o retorno de erro
		return vo;
	}
	
	/**
	 * Exemplo de JSON a ser passado para o methodo {@link RotaService.consultaRota}}
	 * @return
	 */
	@RequestMapping(value="/consultaRotaExample", method = RequestMethod.GET)
	public ConsultaRotaVO consultaRotaExample() {
		ConsultaRotaVO inputVO = new ConsultaRotaVO();
		inputVO.setAutonomia(new Double(10));
		inputVO.setDestino("Destino");
		inputVO.setOrigem("Origem");
		inputVO.setValorCombustivel(new Double(3.10));
		return inputVO;
	}
	
	/**
	 * Exemplo de JSON a ser passado para o methodo {@link RotaService.cadastraRota}}
	 * @return
	 */
	@RequestMapping(value="/cadastraRotaExample", method = RequestMethod.GET)
	public CadastraRotaVO cadastraRotaExample() {
		CadastraRotaVO cadastraRotaVO = new CadastraRotaVO();
		cadastraRotaVO.setNomeMapa("teste");
		RotaVO rotaVO = new RotaVO();
		rotaVO.setOrigem("origem");
		rotaVO.setDestino("destino");
		rotaVO.setDistancia(new Double(10));
		
		List<RotaVO> listRotaVO = new ArrayList<RotaVO>();
		listRotaVO.add(new RotaVO("Origem", "Destino", new Double(10)));
		listRotaVO.add(new RotaVO("Origem2", "Destino2", new Double(20)));
		listRotaVO.add(new RotaVO("Origem3", "Destino3", new Double(30)));
		cadastraRotaVO.setRotaVO(listRotaVO);	
		return cadastraRotaVO;
	}

}
