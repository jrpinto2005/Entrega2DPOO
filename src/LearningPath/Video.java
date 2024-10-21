package LearningPath;

import java.util.Date;

public class Video extends RecursoEducativo{
	private int duracion;

	public Video(String descripcion, String objetivo, String nombre, Date fechaInicio, Date fechaFin, int duracion,
			int dificultad, double rating, String tipoActividad, boolean obligatoria, LearningPath learningPath,
			String titulo, int duracionV) {
		super(descripcion, objetivo, nombre, fechaInicio, fechaFin, duracion, dificultad, rating, tipoActividad, obligatoria,
				learningPath, titulo);
		this.duracion=duracionV;
		// TODO Auto-generated constructor stub
	}
	public int getDuracion() {
		return duracion;
	}
	public void setUrl(int duracionV) {
		this.duracion = duracionV;
	}

}
