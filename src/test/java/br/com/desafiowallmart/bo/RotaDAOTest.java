package br.com.desafiowallmart.bo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.desafiowallmart.DesafioWallmartApplication;
import br.com.desafiowallmart.dao.RotaDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DesafioWallmartApplication.class)
public class RotaDAOTest {

	@Resource RotaDAO rotaDAO;
	
	@Test
	public void cadastraRota(){
		rotaDAO.cadastraRota("origem", "destino", new Double(10));
	}
	
}
