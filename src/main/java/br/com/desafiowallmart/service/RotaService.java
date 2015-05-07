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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiowallmart.bo.RotaBO;
import br.com.desafiowallmart.service.vo.CadastraRotaVO;
import br.com.desafiowallmart.service.vo.ConsultaRotaVO;
import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;
import br.com.desafiowallmart.vo.RotaVO;

@RestController
public class RotaService {

	private static final String CADASTRO_SUCESSO = "Rota cadastrada com sucesso";
	
	@Autowired(required=false)
	private RotaBO rotaBO;
	
	
	@RequestMapping(value="/cadastraRota", method = RequestMethod.PUT)
	public String cadastraRota(@RequestBody CadastraRotaVO cadastraRotaVO) {
		System.out.println(cadastraRotaVO.getNomeMapa());
		rotaBO.cadastraRota(cadastraRotaVO.getRotaVO());
		return CADASTRO_SUCESSO;
	}
	
	@RequestMapping(value="/cadastraRotaExample", method = RequestMethod.GET)
	public CadastraRotaVO consultaRotaExample() {
		CadastraRotaVO cadastraRotaVO = new CadastraRotaVO();
		cadastraRotaVO.setNomeMapa("teste");
		RotaVO rotaVO = new RotaVO();
		rotaVO.setOrigem("origem");
		rotaVO.setDestino("destino");
		rotaVO.setDistancia(new Double(10));		
		cadastraRotaVO.setRotaVO(rotaVO);		
		return cadastraRotaVO;
	}

	@RequestMapping(value="/consultaRota", method = RequestMethod.GET)
	public ConsultaRotaOutputVO consultaRota(@RequestBody ConsultaRotaVO inputVO) {
		ConsultaRotaOutputVO vo = rotaBO.consutlaRota(inputVO);
		return vo;
	}


}
