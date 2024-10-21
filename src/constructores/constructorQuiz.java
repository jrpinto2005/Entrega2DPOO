package constructores;

import java.util.Date;

import LearningPath.LearningPath;
import LearningPath.Quiz;
import Usuarios.Sistema;


public class constructorQuiz {
	
	private Sistema sistema;
	
	
	
	public constructorQuiz(Sistema sistema) {
		super();
		this.sistema = Sistema.getInstancia();
	}
	public Quiz crearQuiz(String descripcion, String objetivo, String id, Date fechaInicio, Date fechaFin, int duracion,
		int dificultad, double rating, String tipoActividad, boolean obligatoria, String learningPath, int puntajeMaximo) {
		Quiz quiz= new Quiz(descripcion, objetivo,id,fechaInicio,fechaFin,duracion,dificultad,rating,tipoActividad,obligatoria, learningPath,puntajeMaximo);
		sistema.addActividad(quiz);
		return quiz;
	}
	public void editarQuiz(String atributo, Object atributoNuevo, String Idquiz) {
		
		Quiz quiz= (Quiz) sistema.encontrarActividad(Idquiz);
		  if (quiz != null) {
		        if (atributo.equals("descripcion")) {
		            quiz.setDescripcion((String) atributoNuevo);
		        } else if (atributo.equals("objetivo")) {
		            quiz.setObjetivo((String) atributoNuevo);
		        } else if (atributo.equals("id")) {
		            quiz.setId((String) atributoNuevo);
		        } else if (atributo.equals("fechaInicio")) {
		            quiz.setFechaInicio((Date) atributoNuevo);
		        } else if (atributo.equals("fechaFin")) {
		            quiz.setFechaFin((Date) atributoNuevo);
		        } else if (atributo.equals("duracion")) {
		            quiz.setDuracion((Integer) atributoNuevo);
		        } else if (atributo.equals("dificultad")) {
		            quiz.setDificultad((Integer) atributoNuevo);
		        } else if (atributo.equals("rating")) {
		            quiz.setRating((Double) atributoNuevo);
		        } else if (atributo.equals("tipoActividad")) {
		            quiz.setTipoActividad((String) atributoNuevo);
		        } else if (atributo.equals("obligatoria")) {
		            quiz.setObligatoria((Boolean) atributoNuevo);
		        } else if (atributo.equals("learningPath")) {
		            quiz.setLearningPath((LearningPath) atributoNuevo);
		        } else if (atributo.equals("puntajeMaximo")) {
		            quiz.setPuntajeMaximo((int) atributoNuevo);
		        } else {
		            System.out.println("Atributo no reconocido.");
		        }
		    } else {
		        System.out.println("Quiz no encontrado.");
		    }
		sistema.addActividad(quiz);
	}
	
	

}
