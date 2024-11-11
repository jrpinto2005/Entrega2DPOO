package constructores;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import learningPaths.LearningPath;
import usuario.Sistema;

public class ConstructorLearningPath {
	private Sistema sistema;

	public ConstructorLearningPath() {
		super();
		this.sistema = Sistema.getInstancia();
	}

	public LearningPath crearLP(String titulo, String descripcionGeneral, int nivelDificultad, int duracion, int rating,
			Date fechaDuracion, Date fechaModificacion, int version, String idCreador, String objetivos,
			double promedioActividadesCompletadas) {
		LearningPath LP = new LearningPath(titulo, descripcionGeneral, nivelDificultad, duracion, rating, fechaDuracion,
				fechaModificacion, version, idCreador, objetivos, promedioActividadesCompletadas);
		sistema.addLP(LP);
		return LP;
	}

	public void editarLP(LearningPath lp, String atributo, Object valorNuevo) {
	    try {
	        String setter = "set" + atributo.substring(0, 1).toUpperCase() + atributo.substring(1);
	        Class<?> valorClase = valorNuevo.getClass();
	        Method metodoSetter = lp.getClass().getMethod(setter, valorClase);
	        metodoSetter.invoke(lp, valorNuevo);
	    } catch (NoSuchMethodException e) {
	        System.out.println("Error: El método no existe. Revisa el nombre del atributo.");
	        e.printStackTrace();
	    } catch (SecurityException e) {
	        System.out.println("Error de seguridad al acceder al método.");
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        System.out.println("Error: No se tiene acceso al método.");
	        e.printStackTrace();
	    } catch (InvocationTargetException e) {
	        System.out.println("Error: Fallo al invocar el método.");
	        e.printStackTrace();
	    }
	}

}
