package learningPaths;

import java.util.Date;

public class RecursoEducativo extends Actividad {
	private String titulo;

	public RecursoEducativo(String descripcion, String objetivo, String nombre, Date fechaInicio, Date fechaFin,
			int duracion, int dificultad, double rating, String tipoActividad, boolean obligatoria,
			String learningPath) {
		super(descripcion, objetivo, nombre, fechaInicio, fechaFin, duracion, dificultad, rating, tipoActividad,
				obligatoria, learningPath);
		// TODO Auto-generated constructor stub
	}

}