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

	public EnvioExamen hacerExamen(String idExamen) {
		Examen examen = (Examen) sistema.encontrarActividad(idExamen);
		Collection<PreguntaAbierta> preguntas = examen.getPreguntas();
		List<RespuestaAbierta> respuestas = new ArrayList<RespuestaAbierta>();
		for (PreguntaAbierta pregunta : preguntas) {
			// estudiante digita respuesta
			RespuestaAbierta respuesta = new RespuestaAbierta(0, "", pregunta.getValorPregunta(), pregunta);
			respuestas.add(respuesta);
		}
		EnvioExamen envio = new EnvioExamen(examen, this.id, examen.getLearningPath().getTitulo(), false, 0,
				examen.getPuntajeMaximo(), 0, respuestas);
		return envio;
	}

	public EnvioQuiz hacerQuiz(String idQuiz) {
		Quiz quiz = (Quiz) sistema.encontrarActividad(idQuiz);
		Collection<PreguntaOpcionMultiple> preguntas = quiz.getPreguntas();
		List<RespuestaMultiple> respuestas = new ArrayList<RespuestaMultiple>();
		for (PreguntaOpcionMultiple pregunta : preguntas) {
			for (Opcion opcion : pregunta.getOpciones()) {
				// se muestran las opciones al usuario
			}
			// estudiante digita respuesta
			int x = 1; // esto va a ser lo que digite el estudiante lo vamos a poner en 1 mientras
						// hacemos la consola
			RespuestaMultiple respuesta = new RespuestaMultiple(0, x, pregunta);
			respuestas.add(respuesta);
		}
		EnvioQuiz envio = new EnvioQuiz(quiz, this.id, quiz.getLearningPath().getTitulo(), false, 0,
				quiz.getPuntajeMaximo(), 0, respuestas);
		return envio;
	}

	public EnvioEncuesta hacerEncuesta(String idEncuesta) {
		Encuesta encuesta = (Encuesta) sistema.encontrarActividad(idEncuesta);
		Collection<PreguntaEncuesta> preguntas = encuesta.getPreguntas();
		List<RespuestaEncuesta> respuestas = new ArrayList<RespuestaEncuesta>();
		for (PreguntaEncuesta pregunta : preguntas) {
			// estudiante digita respuesta que es un número de uno a 5
			int x = 1; // esto va a ser lo que digite el estudiante lo vamos a poner en 1 mientras
						// hacemos la consola
			RespuestaEncuesta respuesta = new RespuestaEncuesta(x, pregunta);
			respuestas.add(respuesta);
		}
		EnvioEncuesta envio = new EnvioEncuesta(encuesta, this.id, encuesta.getLearningPath().getTitulo(), true, 0,
				encuesta.getPuntajeMaximo(), 0, respuestas);
		return envio;
	}

	public EnvioTarea hacerTarea(String idTarea) {
		Tarea tarea = (Tarea) sistema.encontrarActividad(idTarea);
		EnvioTarea envio = new EnvioTarea(tarea, this.id, tarea.getLearningPath().getTitulo(), true);
		return envio;
	}

	public EnvioRecurso hacerRecurso(String idRecurso) {
		RecursoEducativo recurso = (RecursoEducativo) sistema.encontrarActividad(idRecurso);
		EnvioRecurso envio = new EnvioRecurso(recurso, this.id, recurso.getLearningPath().getTitulo(), true);
		return envio;
	}

}
