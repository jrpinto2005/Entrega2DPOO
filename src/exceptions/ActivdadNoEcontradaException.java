package exceptions;

public class ActivdadNoEcontradaException extends Exception {

	private String id;
	private String learningPath;

	public ActivdadNoEcontradaException(String learningPath, String id) {
		super();
		this.id = id;
		this.learningPath = learningPath;
	}

	@Override
	public String getMessage() {
		return "La actividad de ID " + id + " del learning path " + learningPath + " no existe";
	}

}
