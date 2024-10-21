package Usuarios;

import constructores.ConstructorLearningPath;

public class Profesor extends Usuario{

	public Profesor(String id, String nombre, String email, String contraseña, String tipo) {
		super(id, nombre, email, contraseña, tipo);
		// TODO Auto-generated constructor stub
	}

	public String getContrasena() {
		return this.contraseña;
		
	}
	
	public void editarLearningPath()
	{
	//profesor entra por consola que atributo quiere cambiar, porque lo quiere cambiar y el Id del learningPath
	//para empezar olo vamos de dejar estos valores en cosas conocidas
	String atributo="nivelDificultad";
	Object nuevoAtributo=4;
	String id="IP";
	ConstructorLearningPath constructor=new ConstructorLearningPath();
	constructor.editarLP(this.id, atributo, nuevoAtributo, id);

}
	public void crearLearningPath()
	{
	//profesor entra por consola atributos para crear LP
	//para empezar solo vamos de dejar estos valores en cosas conocidas
	Object nuevoAtributo=4;
	ConstructorLearningPath constructor=new ConstructorLearningPath();
	constructor.crearLP("IP", "",(int) nuevoAtributo, 0, 0, null, null, 0, this.id, "", 0);

}
	
}