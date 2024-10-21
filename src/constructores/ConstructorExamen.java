package constructores;

import java.util.Date;

import LearningPath.Examen;
import LearningPath.LearningPath;
import Usuarios.Sistema;

public class ConstructorExamen {
	
	private Sistema sistema;
	
	
	
	public ConstructorExamen() {
		super();
		this.sistema = Sistema.getInstancia();
	}
	public Examen crearExamen(String descripcion, String objetivo, String id, Date fechaInicio, Date fechaFin, int duracion,
		int dificultad, double rating, String tipoActividad, boolean obligatoria, String learningPath, int puntajeMaximo) {
		Examen examen= new Examen(descripcion, objetivo,id,fechaInicio,fechaFin,duracion,dificultad,rating,tipoActividad,obligatoria, learningPath,puntajeMaximo);
		sistema.addActividad(examen);
		return examen;
	}
	public void editarExamen(String atributo, Object atributoNuevo, String Idexamen) {
		
		Examen examen= (Examen) sistema.encontrarActividad(Idexamen);
		  if (examen != null) {
		        if (atributo.equals("descripcion")) {
		        	examen.setDescripcion((String) atributoNuevo);
		        } else if (atributo.equals("objetivo")) {
		        	examen.setObjetivo((String) atributoNuevo);
		        } else if (atributo.equals("id")) {
		        	examen.setId((String) atributoNuevo);
		        } else if (atributo.equals("fechaInicio")) {
		        	examen.setFechaInicio((Date) atributoNuevo);
		        } else if (atributo.equals("fechaFin")) {
		        	examen.setFechaFin((Date) atributoNuevo);
		        } else if (atributo.equals("duracion")) {
		        	examen.setDuracion((Integer) atributoNuevo);
		        } else if (atributo.equals("dificultad")) {
		        	examen.setDificultad((Integer) atributoNuevo);
		        } else if (atributo.equals("rating")) {
		        	examen.setRating((Double) atributoNuevo);
		        } else if (atributo.equals("tipoActividad")) {
		        	examen.setTipoActividad((String) atributoNuevo);
		        } else if (atributo.equals("obligatoria")) {
		        	examen.setObligatoria((Boolean) atributoNuevo);
		        } else if (atributo.equals("learningPath")) {
		        	examen.setLearningPath((LearningPath) atributoNuevo);
		        } else if (atributo.equals("puntajeMaximo")) {
		        	examen.setPuntajeMaximo((int) atributoNuevo);
		        } else {
		            System.out.println("Atributo no reconocido.");
		        }
		    } else {
		        System.out.println("Examen no encontrado.");
		    }
		sistema.addActividad(examen);
	}
	
	

}
