package br.com.desafiowallmart.dao.exception;

/**
 * Exception de dados não encontrados
 * @author jorge
 *
 */
public class RotasNaoEncontradasException extends Exception{
	private static final long serialVersionUID = 1L;

    /**
     * Construtor
     * @param erroMsg
     */
    public RotasNaoEncontradasException(String erroMsg) {
    	super(erroMsg);
    }

}
