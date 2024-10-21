package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import LearningPath.Encuesta;
import LearningPath.SitioWeb;
import LearningPath.Video;
import LearningPath.Examen;
import LearningPath.LearningPath;
import LearningPath.Lectura;
import LearningPath.Quiz;
import Usuarios.Sistema;

public class CentralPersistencia {
	private static Sistema sistema;
	
	
	public CentralPersistencia() {
		super();
		sistema = new Sistema();
	}


	public static void cargarSistema(File archivo) throws FileNotFoundException, IOException, NumberFormatException, ParseException
	{
		BufferedReader br = new BufferedReader( new FileReader( archivo ) );
		String line = br.readLine( );
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		while( line != null )
		{
			String[] partes = line.split( "," );
			
			if( partes[ 0 ].equals( "lp" ) )
			{
				LearningPath lptemp=new LearningPath(partes[1], partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]), Integer.parseInt(partes[5]), formato.parse(partes[6]), formato.parse(partes[7]), Integer.parseInt(partes[8]), partes[9], partes[10],Integer.parseInt(partes[11])); 
				sistema.addLP(lptemp);
			}
			else if (partes[0].equals("quiz"))
			{
				Quiz quiztemp=new Quiz(partes[1], partes[2], partes[3], formato.parse(partes[4]), formato.parse(partes[5]), Integer.parseInt(partes[6]), Integer.parseInt(partes[7]), Double.parseDouble(partes[8]), "Quiz", Boolean.parseBoolean(partes[9]), partes[10], Integer.parseInt(partes[11]));
				sistema.addActividad(quiztemp);
			}
			else if (partes[0].equals("examen"))
			{
				Examen examentemp=new Examen(partes[1], partes[2], partes[3], formato.parse(partes[4]), formato.parse(partes[5]), Integer.parseInt(partes[6]), Integer.parseInt(partes[7]), Double.parseDouble(partes[8]), "Examen", Boolean.parseBoolean(partes[9]), partes[10], Integer.parseInt(partes[11]));
			    sistema.addActividad(examentemp);
			}
			else if (partes[0].equals("encuesta"))
			{
				Encuesta encuestatemp = new Encuesta(partes[1], partes[2], partes[3], formato.parse(partes[4]), formato.parse(partes[5]), Integer.parseInt(partes[6]), Integer.parseInt(partes[7]), Double.parseDouble(partes[8]), "Encuesta", Boolean.parseBoolean(partes[9]), partes[10], Integer.parseInt(partes[11]));
			    sistema.addActividad(encuestatemp);
			
		}
			else if (partes[0].equals("web"))
			{
				SitioWeb webtemp=new SitioWeb(partes[1], partes[2], partes[3], formato.parse(partes[4]), formato.parse(partes[5]), Integer.parseInt(partes[6]), Integer.parseInt(partes[7]), Double.parseDouble(partes[8]), "SitioWeb", Boolean.parseBoolean(partes[9]), partes[10], partes[11]);
			    sistema.addActividad(webtemp);
		
	}
			else if (partes[0].equals("video"))
			{
				Video vidtemp=new Video(partes[1], partes[2], partes[3], formato.parse(partes[4]), formato.parse(partes[5]), Integer.parseInt(partes[6]), Integer.parseInt(partes[7]), Double.parseDouble(partes[8]), "Video", Boolean.parseBoolean(partes[9]), partes[10], Integer.parseInt(partes[11]));
			    sistema.addActividad(vidtemp);
			
		
	}
			else if (partes[0].equals("lectura"))
			{
				Lectura lecttemp=new Lectura(partes[1], partes[2], partes[3], formato.parse(partes[4]), formato.parse(partes[5]), Integer.parseInt(partes[6]), Integer.parseInt(partes[7]), Double.parseDouble(partes[8]), "Lectura", Boolean.parseBoolean(partes[9]), partes[10]);
			    sistema.addActividad(lecttemp);
			
		
	}
			line= br.readLine();
		}
		br.close();
	

}}
