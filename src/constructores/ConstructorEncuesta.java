package constructores;

import java.util.Date;

import LearningPath.Encuesta;
import LearningPath.LearningPath;
import Usuarios.Sistema;

public class ConstructorEncuesta {
	
	private Sistema sistema;
	
	
	
	public ConstructorEncuesta(Sistema sistema) {
		super();
		this.sistema = Sistema.getInstancia();
	}
	public Encuesta crearEncuesta(String descripcion, String objetivo, String id, Date fechaInicio, Date fechaFin, int duracion,
		int dificultad, double rating, String tipoActividad, boolean obligatoria, LearningPath learningPath, int puntajeMaximo) {
		Encuesta encuesta= new Encuesta(descripcion, objetivo,id,fechaInicio,fechaFin,duracion,dificultad,rating,tipoActividad,obligatoria, learningPath,puntajeMaximo);
		sistema.addActividad(encuesta);
		return encuesta;
	}
	public void editarEncuesta(String atributo, Object atributoNuevo, String Idencuesta) {
		
		Encuesta encuesta= (Encuesta) sistema.encontrarActividad(Idencuesta);
		  if (encuesta != null) {
		        if (atributo.equals("descripcion")) {
		        	encuesta.setDescripcion((String) atributoNuevo);
		        } else if (atributo.equals("objetivo")) {
		        	encuesta.setObjetivo((String) atributoNuevo);
		        } else if (atributo.equals("id")) {
		        	encuesta.setId((String) atributoNuevo);
		        } else if (atributo.equals("fechaInicio")) {
		        	encuesta.setFechaInicio((Date) atributoNuevo);
		        } else if (atributo.equals("fechaFin")) {
		        	encuesta.setFechaFin((Date) atributoNuevo);
		        } else if (atributo.equals("duracion")) {
		        	encuesta.setDuracion((Integer) atributoNuevo);
		        } else if (atributo.equals("dificultad")) {
		        	encuesta.setDificultad((Integer) atributoNuevo);
		        } else if (atributo.equals("rating")) {
		        	encuesta.setRating((Double) atributoNuevo);
		        } else if (atributo.equals("tipoActividad")) {
		        	encuesta.setTipoActividad((String) atributoNuevo);
		        } else if (atributo.equals("obligatoria")) {
		        	encuesta.setObligatoria((Boolean) atributoNuevo);
		        } else if (atributo.equals("learningPath")) {
		        	encuesta.setLearningPath((LearningPath) atributoNuevo);
		        } else if (atributo.equals("puntajeMaximo")) {
		        	encuesta.setPuntajeMaximo((int) atributoNuevo);
		        } else {
		            System.out.println("Atributo no reconocido.");
		        }
		    } else {
		        System.out.println("Encuesta no encontrado.");
		    }
		
	}
	
	

}
