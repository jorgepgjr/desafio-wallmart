package br.com.desafiowallmart.dao.exception;

/**
 * Exception para quando não conseguios uma rota entre dois pontos
 * @author jorge
 *
 */
public class NaoExisteCaminhoException extends Exception {

	private static final long serialVersionUID = 1L;

    /**
     * Construtor
     * @param erroMsg
     */
    public NaoExisteCaminhoException(String erroMsg) {
    	super(erroMsg);
    }
}
