package LearningPath;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Envio.PreguntaAbierta;

public class Examen extends Actividad
{
	private int puntajeMaximo;
	private Map<String,PreguntaAbierta> preguntas;
	
	public Examen(String descripcion, String objetivo, String nombre, Date fechaInicio, Date fechaFin, int duracion,
			int dificultad, double rating, String tipoActividad, boolean obligatoria, LearningPath learningPath, int puntajeMaximo) {
		super(descripcion, objetivo, nombre, fechaInicio, fechaFin, duracion, dificultad, rating, tipoActividad, obligatoria,
				learningPath);
		this.puntajeMaximo=puntajeMaximo;
		this.preguntas= new HashMap<String,PreguntaAbierta> ();
	}
	public void setPuntajeMaximo(int puntajeMaximo) {
		this.puntajeMaximo = puntajeMaximo;
	}
}
