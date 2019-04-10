package challenge;

public class EstacionamentoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public EstacionamentoException() {
		super("ERRO no estacionamento!");
	}
}
