package constructores;

import java.util.Date;

import LearningPath.LearningPath;
import LearningPath.RecursoEducativo;
import Usuarios.Sistema;

public class ConstructorRecursoEducativo
{
private Sistema sistema;
	
	
	
	public ConstructorRecursoEducativo(Sistema sistema) {
		super();
		this.sistema = Sistema.getInstancia();
	}
	public RecursoEducativo crearRecursoEducativo(String descripcion, String objetivo, String id, Date fechaInicio, Date fechaFin, int duracion,
			int dificultad, double rating, String tipoActividad, boolean obligatoria, String learningPath) {
			RecursoEducativo recurso= new RecursoEducativo(descripcion, objetivo,id,fechaInicio,fechaFin,duracion,dificultad,rating,tipoActividad,obligatoria, learningPath);
			sistema.addActividad(recurso);
			return recurso;
		}
		public void editarRecursoEducativo(String atributo, Object atributoNuevo, String Idrecurso) {
			
			RecursoEducativo recurso= (RecursoEducativo) sistema.encontrarActividad(Idrecurso);
			  if (recurso != null) {
			        if (atributo.equals("descripcion")) {
			        	recurso.setDescripcion((String) atributoNuevo);
			        } else if (atributo.equals("objetivo")) {
			        	recurso.setObjetivo((String) atributoNuevo);
			        } else if (atributo.equals("id")) {
			        	recurso.setId((String) atributoNuevo);
			        } else if (atributo.equals("fechaInicio")) {
			        	recurso.setFechaInicio((Date) atributoNuevo);
			        } else if (atributo.equals("fechaFin")) {
			        	recurso.setFechaFin((Date) atributoNuevo);
			        } else if (atributo.equals("duracion")) {
			        	recurso.setDuracion((Integer) atributoNuevo);
			        } else if (atributo.equals("dificultad")) {
			        	recurso.setDificultad((Integer) atributoNuevo);
			        } else if (atributo.equals("rating")) {
			        	recurso.setRating((Double) atributoNuevo);
			        } else if (atributo.equals("tipoActividad")) {
			        	recurso.setTipoActividad((String) atributoNuevo);
			        } else if (atributo.equals("obligatoria")) {
			        	recurso.setObligatoria((Boolean) atributoNuevo);
			        } else if (atributo.equals("learningPath")) {
			        	recurso.setLearningPath((LearningPath) atributoNuevo);
			        } 
			        else {
			            System.out.println("Atributo no reconocido.");
			        }
			    } else {
			        System.out.println("Tarea no encontrada.");
			    }
			sistema.addActividad(recurso);
		}
		
		

	}



