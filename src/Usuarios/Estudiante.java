package Usuarios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Envio.Envio;
import Envio.EnvioExamen;
import Envio.PreguntaAbierta;
import Envio.RespuestaAbierta;
import LearningPath.Examen;
import LearningPath.LearningPath;

public class Estudiante extends Usuario {
	private List<LearningPath> learningPaths;
	private List<Envio> envios;
	private Sistema sistema;

	public Estudiante(String id, String nombre, String email, String contraseña, String tipo) {
		super(id, nombre, email, contraseña, tipo);
		this.learningPaths = new ArrayList<LearningPath>();
		this.envios = new ArrayList<Envio>();
		this.sistema=Sistema.getInstancia();
	}

	public String getContrasena() {
		return this.contraseña;

	}

	public void inscribirseEnLearningPath(LearningPath learningPath) {
		learningPaths.add(learningPath);
	}

	public List<LearningPath> consultarLearningPaths() {
		return learningPaths;
	}

	public String verProgreso() {
		// Implementar lógica para calcular el progreso
		return "Progreso actual: X%";
	}
	
	public EnvioExamen hacerExamen(String idExamen)
	{
		Examen examen=(Examen) sistema.encontrarActividad(idExamen);
		Collection<PreguntaAbierta> preguntas = examen.getPreguntas();
		List<RespuestaAbierta> respuestas=new ArrayList<RespuestaAbierta>();
		for (PreguntaAbierta pregunta:preguntas)
		{
			//estudiante digita respuesta 
			RespuestaAbierta respuesta=new RespuestaAbierta(0, "", pregunta.getValorPregunta());
			respuestas.add(respuesta);
		}
		EnvioExamen envio=new EnvioExamen(this.id, examen.getLearningPath().getTitulo(), false, 0, examen.getPuntajeMaximo(),0, respuestas);
		return envio
	}
}
