package ls05.aufgaben.mitarbeiter.util.exceptions;

public class MissingArgumentException extends RuntimeException {
	private static final long serialVersionUID = -7787222555720146238L;

	public MissingArgumentException(String s) {
		super(s);
	}
}
