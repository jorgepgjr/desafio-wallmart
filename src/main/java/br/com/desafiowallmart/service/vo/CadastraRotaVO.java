package br.com.desafiowallmart.service.vo;

import java.util.List;

import br.com.desafiowallmart.vo.RotaVO;

public class CadastraRotaVO {

	private String nomeMapa;
	private List<RotaVO> rotaVO;

	public String getNomeMapa() {
		return nomeMapa;
	}

	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
	}

	public List<RotaVO> getRotaVO() {
		return rotaVO;
	}

	public void setRotaVO(List<RotaVO> rotaVO) {
		this.rotaVO = rotaVO;
	}

}
