package br.com.desafiowallmart.dao;

import org.springframework.stereotype.Service;

@Service
public interface RotaDAO {

	public void cadastraRota(String origem, String destino, Double distancia);
}
