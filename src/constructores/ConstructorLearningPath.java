package constructores;

import java.util.Date;

import LearningPath.LearningPath;
import Usuarios.Sistema;

public class ConstructorLearningPath {
	private Sistema sistema;
	
	
	
	public ConstructorLearningPath() {
		super();
		this.sistema = Sistema.getInstancia();
	}
	public LearningPath crearLP(String titulo, String descripcionGeneral, int nivelDificultad, int duracion, int rating,
			Date fechaDuracion, Date fechaModificacion, int version, String idCreador, String objetivos,
			double promedioActividadesCompletadas) {
		LearningPath LP= new LearningPath(titulo,descripcionGeneral, nivelDificultad,duracion,rating,fechaDuracion,fechaModificacion,
				version,idCreador,objetivos, promedioActividadesCompletadas);
		sistema.addLP(LP);
		return LP;
	}
	public void editarLP(String idprofesor, String atributo, Object atributoNuevo, String Id) {
		
		LearningPath LP= sistema.encontrarLP(Id);
		  if (LP != null) {
			  if (idprofesor.equals(LP.getIdCreador())) {
		            if (atributo.equals("titulo")) {
		                LP.setTitulo((String) atributoNuevo);
		                System.out.println("Título actualizado a: " + (String) atributoNuevo);
		            } else if (atributo.equals("descripcionGeneral")) {
		            	LP.setDescripcionGeneral((String) atributoNuevo);
		                System.out.println("Descripción general actualizada a: " + (String) atributoNuevo);
		            } else if (atributo.equals("nivelDificultad")) {
		            	LP.setNivelDificutad((int) atributoNuevo);
		                System.out.println("Nivel de dificultad actualizado a: " + (int) atributoNuevo);
		            } else if (atributo.equals("duracion")) {
		            	LP.setDuracion((int) atributoNuevo);
		                System.out.println("Duración actualizada a: " + (int) atributoNuevo);
		            } else if (atributo.equals("rating")) {
		            	LP.setRating((int) atributoNuevo);
		            	 System.out.println("Rating actualizado a: " + (int) atributoNuevo);
		            } else if (atributo.equals("fechaDuracion")) {
		            	LP.setFechaDuracion((Date) atributoNuevo);
		                System.out.println("Fecha de duración actualizada a: " + (Date) atributoNuevo);
		            } else if (atributo.equals("fechaModificacion")) {
		            	LP.setFechaModificacion((Date) atributoNuevo);
		                System.out.println("Fecha de modificación actualizada a: " + (Date) atributoNuevo);
		            } else if (atributo.equals("version")) {
		            	LP.setVersion((int) atributoNuevo);
		                System.out.println("Versión actualizada a: " + (int) atributoNuevo);
		            } else if (atributo.equals("idCreador")) {
		            	LP.setIdCreador((String) atributoNuevo);
		                System.out.println("ID del creador actualizado a: " + (String) atributoNuevo);
		            } else if (atributo.equals("objetivos")) {
		            	LP.setObjetivos((String) atributoNuevo);
		                System.out.println("Objetivos actualizados a: "+ (String) atributoNuevo);
		            } else if (atributo.equals("promedioActividadesCompletadas")) {
		            	LP.setPromedioActividadesCompletadas((double) atributoNuevo);
		                System.out.println("Promedio de actividades completadas actualizado a: "+ (double) atributoNuevo);
		            } else {
		                System.out.println("Atributo no reconocido.");
		            }
		        } else {
		            System.out.println("ID no válido. No se pueden hacer cambios.");
		        }
		    }
		 sistema.addLP(LP);
		
	}
	
	

}
