package br.com.desafiowallmart.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafiowallmart.DesafioWallmartApplication;
import br.com.desafiowallmart.dao.exception.DadosFaltandoException;
import br.com.desafiowallmart.dao.exception.NaoExisteCaminhoException;
import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;
import br.com.desafiowallmart.vo.RotaVO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DesafioWallmartApplication.class)
@Transactional(readOnly=true)
public class RotaDAOTest {

	@Autowired
	RotaDAO rotaDAO;

	/**
	 * Teste caminho feliz de consulta de rota
	 * @throws DadosFaltandoException
	 * @throws NaoExisteCaminhoException 
	 */
	@Test
	public void consultaRotaTest() throws DadosFaltandoException, NaoExisteCaminhoException {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("E");
		list.add("D");

		ConsultaRotaOutputVO vo = rotaDAO.consutlaMenorRota("A", "D");
		Assert.assertEquals(new Double(8), vo.getDistancia());
		Assert.assertEquals(list, vo.getRota());
	}
	
//	@Test
//	public void cadastraMesmaRotaDuasVezesTest() throws DadosFaltandoException {
//		
//		rotaDAO.cadastraRota("A", "B", new Double(10));
//		ConsultaRotaOutputVO vo = rotaDAO.consutlaMenorRota("A", "D");
//		System.out.println(vo.getDistancia());
//		
//	}
	
	/**
	 * Pepara o banco ara os demais testes
	 */
	@Before
	public void cadastraRota(){
		List<RotaVO> list = new ArrayList<RotaVO>();
		list.add(new RotaVO("A", "B", new Double(1)));
		list.add(new RotaVO("A", "C", new Double(3)));
		
		list.add(new RotaVO("B", "E", new Double(5)));
		list.add(new RotaVO("D", "C", new Double(6)));
		list.add(new RotaVO("E", "D", new Double(2)));
		rotaDAO.cadastraRota(list);
	}

}
