package Usuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import LearningPath.LearningPath;
import constructores.ConstructorLearningPath;

public class Profesor extends Usuario{
	
	private List<LearningPath> learningPaths;
	
	
	public Profesor(String id, String nombre, String email, String contraseña, String tipo) {
		super(id, nombre, email, contraseña, tipo);
		this.learningPaths = new ArrayList<LearningPath>();
	}

	public String getContrasena() {
		return this.contraseña;
		
	}
	
	public void editarLearningPath(String atributo, Object atributoNuevo, String tituloLP)
	{
	//profesor entra por consola que atributo quiere cambiar, por que otro atributo lo quieres cambiar y el Id del learningPath
	ConstructorLearningPath constructor=new ConstructorLearningPath();
	constructor.editarLP(this.id, atributo, atributoNuevo, tituloLP);

}
	public void crearLearningPath(String titulo, String descripcionGeneral, int nivelDificultad, int duracion, int rating,
			Date fechaDuracion, Date fechaModificacion, int version, String idCreador, String objetivos,
			double promedioActividadesCompletadas)
	{
		
	//profesor entra por consola atributos para crear LP
	ConstructorLearningPath constructor=new ConstructorLearningPath();
	LearningPath LP= constructor.crearLP(titulo,descripcionGeneral,nivelDificultad,duracion,rating,fechaDuracion,fechaModificacion,version,idCreador,objetivos,promedioActividadesCompletadas);
	learningPaths.add(LP);
}
	
}