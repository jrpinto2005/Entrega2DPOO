package LearningPath;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Envio.PreguntaEncuesta;
import Envio.PreguntaOpcionMultiple;

public class Encuesta extends Actividad
{
	private int puntajeMaximo;
	private Map<String,PreguntaEncuesta> preguntas;
	

	public Encuesta(String descripcion, String objetivo, String nombre, Date fechaInicio, Date fechaFin, int duracion,
			int dificultad, double rating, String tipoActividad, boolean obligatoria, LearningPath learningPath, int puntajeMaximo) {
		super(descripcion, objetivo, nombre, fechaInicio, fechaFin, duracion, dificultad, rating, tipoActividad, obligatoria,
				learningPath);
		this.puntajeMaximo=puntajeMaximo;
		this.preguntas= new HashMap<String,PreguntaEncuesta> ();
		// TODO Auto-generated constructor stub
	}
	public void setPuntajeMaximo(int puntajeMaximo) {
		this.puntajeMaximo = puntajeMaximo;
	}
	public int getPuntajeMaximo() {
		return puntajeMaximo;
	}
}
