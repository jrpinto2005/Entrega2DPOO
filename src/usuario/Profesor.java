package usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import constructores.ConstructorLearningPath;
import learningPaths.LearningPath;

public class Profesor extends Usuario {

	private List<LearningPath> learningPaths;

	public Profesor(String id, String nombre, String email, String contraseña, String tipo) {
		super(id, nombre, email, contraseña, tipo);
		this.learningPaths = new ArrayList<LearningPath>();
	}

	public String getContrasena() {
		return this.contraseña;

	}

}