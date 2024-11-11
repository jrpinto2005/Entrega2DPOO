package consola;

public class ConsolaPrincipal extends ConsolaBasica{
	
	
	private final String[] opcionesAutenticacion = new String[]{ "Ingresar", "Salir" };
	private final String[] opcionesMenuPrincipalEstudiante = new String[]{ "Consultar progreso LP", "Actividades sugeridas LP",  "Inscribir LP", "Hacer actividad","Salir" };
	private final String[] opcionesMenuPrincipalProfesor = new String[]{ "Crear LP", "Editar LP", "Clonar LP", "Salir" };
	private boolean esProfesor;
	
	private void mostrarLogin( )
    {
        int opcionSeleccionada = mostrarMenu( "Menú login", opcionesAutenticacion );
        if( opcionSeleccionada == 1 )
        {
            //Login en usuarios
        	//Encontrar forma de redirigir a menu de estudiante o profesor
        }
        else if( opcionSeleccionada == 2 ) {
        	System.out.println( "Saliendo ..." );
        System.exit( 0 );
        }
        mostrarLogin();
    }
    private void menuEstudiantes()
    {
    	int opcionSeleccionada = mostrarMenu ("Menu estudiantes", opcionesMenuPrincipalEstudiante);
    	if (opcionSeleccionada == 1)
    	{
    		//El controlador que consulta el progreso
    	}
    	else if (opcionSeleccionada == 2)
    	{
    		//get las actividades sugeridas y tabularlas
    		// System.out.println(tabulador)
    	}
    	else if (opcionSeleccionada==3)
    	{
    	//Verifica si esta inscrito en un lp, si no esta se inscribe a uno nuevo	
    	}
    	else if (opcionSeleccionada==4)
    	{
    		//Verifica tipo de actividad y lo redirge a donde deba
    	}
    	else if (opcionSeleccionada== 5)
    	{
    		System.exit(0);
    	}
    	menuEstudiantes();
    		
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
    		System.exit(0);
    	}
    	menuProfesores();
    	
    }
    }
        
	
	


	

