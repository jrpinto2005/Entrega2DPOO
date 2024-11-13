package consola;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import exceptions.IdUsuarioYaExisteException;
import exceptions.UsuarioContraseñaIncorrectoException;
import learningPaths.Actividad;
import learningPaths.LearningPath;
import persistencia.CentralPersistencia;
import persistencia.UsuariosPersistencia;
import usuario.ControladorUsuarios;
import usuario.Estudiante;
import usuario.Profesor;
import usuario.Sistema;
import usuario.Usuario;

public class ConsolaPrincipal extends ConsolaBasica{
	
	private final String[] opcionesCarga = new String[] {"Cargar informacion", "Continuar", "Salir"};
	private final String[] opcionesAutenticacion = new String[]{ "Ingresar","Crear Usuario","Salir" };
	private final String[] opcionesMenuPrincipalEstudiante = new String[]{ "Consultar progreso LP", "Actividades sugeridas LP",  "Inscribir LP", "Hacer actividad","Salir" };
	private final String[] opcionesMenuPrincipalProfesor = new String[]{ "Crear LP", "Editar LP", "Clonar LP", "Salir" };
	private final String[] crearUsuario = new String [] {"Estudiante", "Profesor"};
	private boolean esProfesor;
	private Usuario usuario;
	private static int intentos;
	
	
	
	private void primeraConsola() throws NumberFormatException, FileNotFoundException, IOException, ParseException, UsuarioContraseñaIncorrectoException
	{
		int opcionSeleccionada = mostrarMenu( "Menú carga", opcionesCarga );
		if ( opcionSeleccionada == 1)
		{
			System.out.println("Ingrese el nombre del archivo de lp y actividades a cargar: ");
			BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
			CentralPersistencia centralPersitencia= new CentralPersistencia();
			String line = reader.readLine();
			File archivo = new File("datos/"+ line);
			CentralPersistencia.cargarSistema(archivo);
			System.out.println("Ingrese el nombre del archivo de usuarios a cargar: ");
			BufferedReader reader2 = new BufferedReader( new InputStreamReader( System.in));
			UsuariosPersistencia usuarios = new UsuariosPersistencia();
			String line2= reader2.readLine();
			File archivo2 = new File("datos/"+ line2);
			UsuariosPersistencia.cargarSistema(archivo2);
		}
		else if ( opcionSeleccionada == 2)
		{
			try {
				mostrarLogin();
			} catch (IOException | UsuarioContraseñaIncorrectoException | IdUsuarioYaExisteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if( opcionSeleccionada == 3 ) {
        	System.out.println( "Saliendo ..." );
        System.exit( 0 );
        }
		primeraConsola();		
	}
	private void mostrarLogin( ) throws IOException, UsuarioContraseñaIncorrectoException, IdUsuarioYaExisteException
    {
		intentos++;
		usuario = null;
		esProfesor = false;
        int opcionSeleccionada = mostrarMenu( "Menú login", opcionesAutenticacion );
        if( opcionSeleccionada == 1 )
        {
        	System.out.println("Ingrese su nombre de usuario: ");
			BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
			String id = reader.readLine();
			System.out.println("Ingrese su contraseña: ");
			BufferedReader reader2 = new BufferedReader( new InputStreamReader( System.in));
			String contrasena = reader2.readLine();
			ControladorUsuarios c= new ControladorUsuarios();
            try {
				usuario=ControladorUsuarios.getInstancia().iniciarSesion(id, contrasena);
				} 
            catch (UsuarioContraseñaIncorrectoException e) 
            {
				// TODO Auto-generated catch block
				System.out.println("Este es su intento numero" + String.valueOf(intentos) );
				if (intentos<3) 
					mostrarLogin();
				else {
					System.out.println( "Saliendo ..." );
		        System.exit( 0 );
				}
			}
            
            if (usuario.getTipoUsuario().equals("estudiante"))
            		{
            			menuEstudiantes((Estudiante) usuario);
            		}
            else 
            {
            	System.out.println(":(");
            	
            }
            }
            		

        else if (opcionSeleccionada == 2)
        {
        	opcionSeleccionada = mostrarMenu( "Menú carga", crearUsuario );
        	if (opcionSeleccionada==1)
        	{
        		System.out.println("ID: ");
        		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
        		String id = reader.readLine();
        		System.out.println("Nombre: ");
        		BufferedReader reader2 = new BufferedReader( new InputStreamReader( System.in));
        		String nombre= reader2.readLine();
        		System.out.println("Correo: ");
        		BufferedReader reader3 = new BufferedReader( new InputStreamReader( System.in));
        		String correo= reader3.readLine();
        		System.out.println("Contraseña: ");
        		BufferedReader reader4 = new BufferedReader( new InputStreamReader( System.in));
        		String contrasena= reader4.readLine();
        		usuario = new Estudiante (id,nombre,correo,contrasena,"estudiante");
        		ControladorUsuarios.getInstancia().registrarEstudiante(id, nombre, correo, contrasena, "estudiante");
        		System.out.println("Creado con exito");
        		intentos--;
        	}
        	else if (opcionSeleccionada==2)
        	{
        		System.out.println("ID: ");
        		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
        		String id = reader.readLine();
        		System.out.println("Nombre: ");
        		BufferedReader reader2 = new BufferedReader( new InputStreamReader( System.in));
        		String nombre= reader2.readLine();
        		System.out.println("Correo: ");
        		BufferedReader reader3 = new BufferedReader( new InputStreamReader( System.in));
        		String correo= reader3.readLine();
        		System.out.println("Contraseña: ");
        		BufferedReader reader4 = new BufferedReader( new InputStreamReader( System.in));
        		String contrasena= reader4.readLine();
        		usuario = new Profesor (id,nombre,correo,contrasena,"profesor");
        		ControladorUsuarios.getInstancia().registrarProfesor(id, nombre, correo, contrasena, "profesor");
        		System.out.println("Creado con exito");
        		intentos--;
        	}
        	
        	mostrarLogin();
        }
        else if( opcionSeleccionada == 3 ) {
        	System.out.println( "Saliendo ..." );
        System.exit( 0 );
        }
        mostrarLogin();
    }
    private void menuEstudiantes(Estudiante estudiante) throws IOException
    {
    	ConsolaEstudiantes c = new ConsolaEstudiantes();
    	int opcionSeleccionada = mostrarMenu ("Menu de estudiantes", opcionesMenuPrincipalEstudiante);
    	if (opcionSeleccionada == 1)
    	{
			c.consultarProgrespLP(estudiante);
    	}
    	else if (opcionSeleccionada == 2)
    	{
    		System.out.println("Que actividad desea consultar: ");
    		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
    		String actividad = reader.readLine();
    		Actividad acti = Sistema.getInstancia().encontrarActividad(actividad);
    		c.actividadesSugeridasLP(acti);
    	}
    	else if (opcionSeleccionada==3)
    	{
    		System.out.println("Que LP desea inscribir?: ");
    		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
    		String lp = reader.readLine();
    		LearningPath lepa = Sistema.getInstancia().encontrarLP(lp);	
    		c.inscribirLP(estudiante, lepa);
    	}
    	else if (opcionSeleccionada==4)
    	{
    		System.out.println("Que actividad desea empezar: ");
    		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
    		String actividad = reader.readLine();
    		c.hacerActividad(actividad, estudiante);
    	}
    	else if (opcionSeleccionada== 5)
    	{
    		System.out.println( "Saliendo ..." );
    		System.exit(0);
    	}
    	menuEstudiantes(estudiante);
    		
    	}
    	
    private void menuProfesores()
    {
    	int opcionSeleccionada = mostrarMenu( "Menú login", opcionesMenuPrincipalProfesor );
    	if (opcionSeleccionada == 1)
    	{
    		//El controlador que crea el LP
    		//Retorna true o error
    	}
    	else if (opcionSeleccionada == 2)
    	{
    		//El controlador que edita el LP
    		//Retorna True o error
    		
    	}
    	else if (opcionSeleccionada == 3)
    	{
    		//Clona el LP y retorna el ID
    	}
    	else if (opcionSeleccionada== 4)
    	{
    		System.out.println( "Saliendo ..." );
    		System.exit(0);
    	}
    	menuProfesores();
    	
    }
    //private void TipoUsuario 
    public static void main( String[] args ) throws NumberFormatException, FileNotFoundException, IOException, ParseException, UsuarioContraseñaIncorrectoException
    {
        ConsolaPrincipal c = new ConsolaPrincipal( );
        c.primeraConsola( );
    }
    
    
}


        
	
	


	

