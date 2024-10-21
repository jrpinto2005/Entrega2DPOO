package LearningPath;

import java.util.Date;

public class RecursoEducativo extends Actividad{
	private String titulo;

	public RecursoEducativo(String descripcion, String objetivo, String nombre, Date fechaInicio, Date fechaFin,
			int duracion, int dificultad, double rating, String tipoActividad, boolean obligatoria,
			LearningPath learningPath, String titulo) {
		super(descripcion, objetivo, nombre, fechaInicio, fechaFin, duracion, dificultad, rating, tipoActividad, obligatoria,
				learningPath);
		this.setTitulo(titulo);
		// TODO Auto-generated constructor stub
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	

}
