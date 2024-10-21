package LearningPath;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Envio.PreguntaOpcionMultiple;

public class Quiz extends Actividad {
	private int puntajeMaximo;
	private Map<String,PreguntaOpcionMultiple> preguntas;
	

	public Quiz(String descripcion, String objetivo, String id, Date fechaInicio, Date fechaFin, int duracion,
			int dificultad, double rating, String tipoActividad, boolean obligatoria, String idlearningPath, int puntajeMaximo) {
		super(descripcion, objetivo, id, fechaInicio, fechaFin, duracion, dificultad, rating, tipoActividad, obligatoria,
				idlearningPath);
		this.puntajeMaximo=puntajeMaximo;
		this.preguntas= new HashMap<String,PreguntaOpcionMultiple> ();
		// TODO Auto-generated constructor stub
	}


	public void setPuntajeMaximo(int puntajeMaximo) {
		this.puntajeMaximo = puntajeMaximo;
	}
	public int getPuntajeMaximo() {
		return puntajeMaximo;
	}


	public Collection<PreguntaOpcionMultiple> getPreguntas() 
	{
		return preguntas.values();
	}
	
}
