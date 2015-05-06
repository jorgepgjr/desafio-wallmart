package br.com.desafiowallmart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafiowallmart.DesafioWallmartApplication;
import br.com.desafiowallmart.dao.RotaDAO;
import br.com.desafiowallmart.vo.ConsultaRotaOutputVO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DesafioWallmartApplication.class)
@Transactional(readOnly=true)
public class RotaDAOTest {

	@Resource
	RotaDAO rotaDAO;

	@Test
	public void consultaRotaTest() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("E");
		list.add("D");

		ConsultaRotaOutputVO vo = rotaDAO.consutlaMenorRota("A", "D");
		Assert.assertEquals(new Double(8), vo.getDistancia());
		Assert.assertEquals(list, vo.getRota());
	}
	
	@Before
	public void cadastraRota(){
		rotaDAO.cadastraRota("A", "B", new Double(1));
		rotaDAO.cadastraRota("A", "C", new Double(3));

		rotaDAO.cadastraRota("B", "E", new Double(5));
		rotaDAO.cadastraRota("D", "C", new Double(6));
		rotaDAO.cadastraRota("E", "D", new Double(2));
	}

}
