package excecaoModelo;

public class excecaoDominio extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public excecaoDominio(String msg) {
		super(msg);
	}
}
