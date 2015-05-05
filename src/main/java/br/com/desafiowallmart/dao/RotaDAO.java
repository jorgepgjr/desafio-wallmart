package br.com.desafiowallmart.dao;

import org.springframework.stereotype.Service;

import br.com.desafiowallmart.vo.RotaVO;

@Service
public interface RotaDAO {

	public void cadastraRota(RotaVO rotaVO);
}
