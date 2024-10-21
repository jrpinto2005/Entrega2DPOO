package Usuarios;

public class Profesor extends Usuario{

	public Profesor(String id, String nombre, String email, String contraseña, String tipo) {
		super(id, nombre, email, contraseña, tipo);
		// TODO Auto-generated constructor stub
	}

	public String getContrasena() {
		return this.contraseña;
		
	}

}
