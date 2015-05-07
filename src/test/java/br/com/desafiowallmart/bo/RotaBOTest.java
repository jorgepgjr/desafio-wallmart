package br.com.desafiowallmart.bo;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.desafiowallmart.bo.impl.RotaBOImpl;
import br.com.desafiowallmart.dao.RotaDAO;
import br.com.desafiowallmart.dao.exception.DadosFaltandoException;
import br.com.desafiowallmart.service.vo.ConsultaRotaVO;
import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;
import br.com.desafiowallmart.vo.RotaVO;

@RunWith(MockitoJUnitRunner.class)
public class RotaBOTest {

	@Mock
	RotaDAO rotaDAO;
	@InjectMocks
	RotaBO rotaBO = new RotaBOImpl();
	
	@Test(expected=DadosFaltandoException.class)
	public void cadastraRotaTest() throws DadosFaltandoException{	
		rotaBO.cadastraRota(new RotaVO());	
	}
	
	/**
	 * Teste de consulta de Rota
	 * cadastra uma rota mockada e verifica se o gasto está de acordo com o esperado
	 * @throws DadosFaltandoException 
	 */
	@Test
	public void consultaRotaTest() throws DadosFaltandoException{
		final ConsultaRotaVO consultaRotaVO = new ConsultaRotaVO();
		final ConsultaRotaOutputVO outputVO = new ConsultaRotaOutputVO();

		consultaRotaVO.setDestino("B");
		consultaRotaVO.setOrigem("A");
		consultaRotaVO.setValorCombustivel(new Double(10));
		consultaRotaVO.setAutonomia(new Double(2));
		outputVO.setDistancia(new Double(5));
		
		final Double gasto = ( outputVO.getDistancia() / consultaRotaVO.getAutonomia()) * consultaRotaVO.getValorCombustivel();		
		when(rotaDAO.consutlaMenorRota(consultaRotaVO.getOrigem(), consultaRotaVO.getDestino())).thenReturn(outputVO);		
		
		final ConsultaRotaOutputVO retorno = rotaBO.consutlaRota(consultaRotaVO);
		
		Assert.assertEquals(gasto, retorno.getGasto());
	}
	
}
