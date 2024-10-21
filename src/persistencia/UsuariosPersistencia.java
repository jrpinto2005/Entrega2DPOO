package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import LearningPath.LearningPath;
import Usuarios.ControladorUsuarios;
import Usuarios.Estudiante;
import Usuarios.Profesor;

public class UsuariosPersistencia {
	private static ControladorUsuarios controlador;

	public UsuariosPersistencia() {
		super();
		controlador = new ControladorUsuarios();
	}
	public static void cargarSistema(File archivo) throws FileNotFoundException, IOException, NumberFormatException, ParseException
	{
		BufferedReader br = new BufferedReader( new FileReader( archivo ) );
		String line = br.readLine( );
		//se prepara todo para empezar a leer el archivo
		while( line != null )
			//recorre el archivo hasta la ultima linea
		{
			String[] partes = line.split( "," );
			//separa las filas por comas y cada palabra entre comas la guarda en una pos de lista
			if( partes [0].equals("Profesor")) 
			{
				Profesor profe= new Profesor(partes[2],partes[1],partes[3],partes[4],"Profesor");
				controlador.agregarProfesor(profe);
				//agrega al profesor al controlador de usuarios
			}
			else if (partes[0].equals("Estudiante"))
			{
				Estudiante estu = new Estudiante(partes[2],partes[1],partes[3],partes[4],"Estudiante");
				controlador.agregarEstudiante(estu);
				//agrega el perfil del estudiante al controlador de estudiantes
			}
			line= br.readLine();
			//siguiente linea
		}
		br.close();
		//se cierra
	}
	public static void guardarSistema(File archivo) throws IOException {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            
            // Escribir LearningPaths
            Map<String,Profesor> profesores = controlador.getProfesores();
            for (String profe : profesores.keySet()) {
            	Profesor temp=profesores.get(profe);
                bw.write("Profesor,");
                bw.write(temp.getNombre()+",");
                bw.write(temp.getId()+",");
                bw.write(temp.getEmail()+",");
                bw.write(temp.getContrasena());
                bw.newLine();
            }
            Map<String,Estudiante> estudiantes = controlador.getEstudiantes();
            for (String estu : estudiantes.keySet()) {
            	Profesor temp=profesores.get(estu);
                bw.write("Estudiante,");
                bw.write(temp.getNombre()+",");
                bw.write(temp.getId()+",");
                bw.write(temp.getEmail()+",");
                bw.write(temp.getContrasena());
                bw.newLine();
            }
            bw.close();
	
	

}}}
