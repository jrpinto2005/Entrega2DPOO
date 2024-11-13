package usuario;

import java.util.ArrayList;
import java.util.List;

import learningPaths.LearningPath;

public class Profesor extends Usuario {

	private List<LearningPath> learningPaths;

	public Profesor(String id, String nombre, String email, String contraseña, String tipo) {
		super(id, nombre, email, contraseña, tipo);
		this.learningPaths = new ArrayList<>();
	}

	public String getContrasena() {
		return this.contraseña;

	}

}