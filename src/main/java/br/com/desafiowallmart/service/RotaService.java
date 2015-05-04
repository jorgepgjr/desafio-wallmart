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

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiowallmart.service.vo.RotaInputVO;

@RestController
public class RotaService {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}
	
	@RequestMapping(value="/cadastraRota", method = RequestMethod.GET)
	public @ResponseBody String cadastraRota() {		
		return "OK";
	}
	
	@RequestMapping(value="/consultaRota", method = RequestMethod.GET)
	public @ResponseBody RotaInputVO consultaRota(@RequestParam(value="rotaInputVO", required=false) RotaInputVO inputVO) {		
		RotaInputVO vo = new RotaInputVO();
		if (inputVO != null && inputVO.getOrigem() != null) {
			vo = inputVO;
		}
		return vo;
//		return inputVO.getDestino();
	}
	
	@ResponseBody @RequestMapping(value="/consultaRota2", method = RequestMethod.GET)
	public String consultaRota2(RotaInputVO teste) {				
		return teste.getOrigem();
//		return inputVO.getDestino();
	}


}
