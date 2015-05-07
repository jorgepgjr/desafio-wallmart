package br.com.desafiowallmart.dao.exception;

/**
 * Exception de dados faltando
 * @author jorge
 *
 */
public class DadosFaltandoException extends Exception{
	private static final long serialVersionUID = 1L;

    /**
     * Construtor
     * @param erroMsg
     */
    public DadosFaltandoException(String erroMsg) {
    	super(erroMsg);
    }

}
