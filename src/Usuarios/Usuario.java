package Usuarios;

public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected String email;
    protected String contraseña;
    protected String tipo;

    public Usuario(String id, String nombre, String email, String contraseña, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña=contraseña;
        this.tipo=tipo;
    }

    
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
    

    public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setEmail(String email) {
		this.email = email;
	}

    public String getTipoUsuario()
    {
    	return this.tipo;
    }


    public String verPerfil() {
        return "ID: " + id + "\nNombre: " + nombre + "\nEmail: " + email + "\nTipo: " + getTipoUsuario();
    }
}
