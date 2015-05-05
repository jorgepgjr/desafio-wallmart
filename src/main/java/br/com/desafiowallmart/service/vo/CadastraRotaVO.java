package br.com.desafiowallmart.service.vo;

import java.io.Serializable;

import br.com.desafiowallmart.vo.RotaVO;


public class CadastraRotaVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nomeMapa;
	private RotaVO rotaVO;
	
	public String getNomeMapa() {
		return nomeMapa;
	}
	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
	}
	public RotaVO getRotaVO() {
		return rotaVO;
	}
	public void setRotaVO(RotaVO rotaVO) {
		this.rotaVO = rotaVO;
	}
	
	}
