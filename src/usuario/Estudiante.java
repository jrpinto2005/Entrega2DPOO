package usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import envios.Envio;
import envios.EnvioEncuesta;
import envios.EnvioExamen;
import envios.EnvioQuiz;
import envios.EnvioRecurso;
import envios.EnvioTarea;
import envios.Opcion;
import envios.PreguntaAbierta;
import envios.PreguntaEncuesta;
import envios.PreguntaOpcionMultiple;
import envios.RespuestaAbierta;
import envios.RespuestaEncuesta;
import envios.RespuestaMultiple;
import learningPaths.Encuesta;
import learningPaths.Examen;
import learningPaths.LearningPath;
import learningPaths.Quiz;
import learningPaths.RecursoEducativo;
import learningPaths.Tarea;

public class Estudiante extends Usuario {
	private List<LearningPath> learningPaths;
	private List<Envio> envios;
	private Sistema sistema;

	public Estudiante(String id, String nombre, String email, String contraseña, String tipo) {
		super(id, nombre, email, contraseña, tipo);
		this.learningPaths = new ArrayList<LearningPath>();
		this.envios = new ArrayList<Envio>();
		this.sistema = Sistema.getInstancia();
	}

	public String getContrasena() {
		return this.contraseña;

	}

	public List<Envio> getEnvios() {
		return envios;
	}

	public void inscribirseEnLearningPath(LearningPath learningPath) {
		learningPaths.add(learningPath);
	}

	public List<LearningPath> getLearningPaths() {
		return learningPaths;
	}

	public double verProgreso() {
		int cantidadTotal = envios.size();
		int cantidad = 0;
		for (Envio envio : this.envios) {
			if (envio.isCompletado() == true) {
				cantidad += 1;
			}
		}
		return cantidad / cantidadTotal;
	}
}
