package constructores;

import java.util.Date;

import LearningPath.LearningPath;
import LearningPath.Tarea;
import Usuarios.Sistema;

public class ConstructorTarea 
{
private Sistema sistema;
	
	public ConstructorTarea() {
		super();
		this.sistema = Sistema.getInstancia();
	}
	public Tarea crearTarea(String descripcion, String objetivo, String id, Date fechaInicio, Date fechaFin, int duracion,
			int dificultad, double rating, String tipoActividad, boolean obligatoria, String learningPath) {
			Tarea tarea= new Tarea(descripcion, objetivo,id,fechaInicio,fechaFin,duracion,dificultad,rating,tipoActividad,obligatoria, learningPath);
			sistema.addActividad(tarea);
			return tarea;
		}
		public void editarTarea(String atributo, Object atributoNuevo, String Idtarea) {
			
			Tarea tarea= (Tarea) sistema.encontrarActividad(Idtarea);
			  if (tarea != null) {
			        if (atributo.equals("descripcion")) {
			        	tarea.setDescripcion((String) atributoNuevo);
			        } else if (atributo.equals("objetivo")) {
			        	tarea.setObjetivo((String) atributoNuevo);
			        } else if (atributo.equals("id")) {
			        	tarea.setId((String) atributoNuevo);
			        } else if (atributo.equals("fechaInicio")) {
			        	tarea.setFechaInicio((Date) atributoNuevo);
			        } else if (atributo.equals("fechaFin")) {
			        	tarea.setFechaFin((Date) atributoNuevo);
			        } else if (atributo.equals("duracion")) {
			        	tarea.setDuracion((Integer) atributoNuevo);
			        } else if (atributo.equals("dificultad")) {
			        	tarea.setDificultad((Integer) atributoNuevo);
			        } else if (atributo.equals("rating")) {
			        	tarea.setRating((Double) atributoNuevo);
			        } else if (atributo.equals("tipoActividad")) {
			        	tarea.setTipoActividad((String) atributoNuevo);
			        } else if (atributo.equals("obligatoria")) {
			        	tarea.setObligatoria((Boolean) atributoNuevo);
			        } else if (atributo.equals("learningPath")) {
			        	tarea.setLearningPath((LearningPath) atributoNuevo);
			        }
			        else {
			            System.out.println("Atributo no reconocido.");
			        }
			    } else {
			        System.out.println("Tarea no encontrada.");
			    }
			sistema.addActividad(tarea);
		}
		
		

	}
