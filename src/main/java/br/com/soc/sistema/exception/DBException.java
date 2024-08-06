package br.com.soc.sistema.exception;

public class DBException extends RuntimeException{
	public DBException(String mensagem) {
		super(mensagem);
	}

}
