package Usuarios;


import java.util.HashMap;
import java.util.Map;

public class ControladorUsuarios {
    private Map<String, Estudiante> estudiantes;  
    private Map<String, Profesor> profesores;   
	private static ControladorUsuarios instancia;
    public ControladorUsuarios() {
        estudiantes = new HashMap<>();
        profesores = new HashMap<>();
    }
    
    public static ControladorUsuarios getInstancia() {
		if (instancia == null) {
			instancia = new ControladorUsuarios();
		}
		return instancia;
	}
    
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getId(), estudiante);
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.put(profesor.getId(), profesor);
    }


    public Estudiante encontrarEstudiante(String id) {
        return estudiantes.get(id);
    }


    public Profesor encontrarProfesor(String id) {
        return profesores.get(id);
    }


    public void eliminarEstudiante(String id) {
        estudiantes.remove(id);
    }

    public void eliminarProfesor(String id) {
        profesores.remove(id);
    }
    public void editarPerfil(String id, String nuevoNombre, String nuevoEmail) {
    	if (profesores.containsKey(id))
    	{
    		Usuario p=(Usuario) profesores.get(id);
    		p.setEmail(nuevoEmail);
    		p.setNombre(nuevoNombre);
    		profesores.put(id, (Profesor) p);
    	}
    	else if (estudiantes.containsKey(id))
    	{
    		Usuario e=(Usuario)estudiantes.get(id);
    		e.setEmail(nuevoEmail);
    		e.setNombre(nuevoNombre);
    		estudiantes.put(id, (Estudiante) e);
    	}
    }
    
    public boolean iniciarSesion(String id, String contrasena) {
        if (estudiantes.containsKey(id)) {
            Estudiante estudiante = estudiantes.get(id);
            if (estudiante.getContrasena().equals(contrasena)) {
                return true;  
            } else {
                System.out.println("Contraseña incorrecta para estudiante.");
                return false;
            }
        }

        
        else if (profesores.containsKey(id)) {
            Profesor profesor = profesores.get(id);
            if (profesor.getContrasena().equals(contrasena)) {
                return true;  
            } else {
                System.out.println("Contraseña incorrecta para profesor.");
                return false;
            }
        }

        
        System.out.println("Usuario no encontrado.");
        return false;
    }
}

