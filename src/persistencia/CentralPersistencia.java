package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import LearningPath.LearningPath;
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
				LearningPath lptemp=new LearningPath(partes[1], partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]), Integer.parseInt(partes[5]), formato.parse(partes[6]), formato.parse(partes[7]), Integer.parseInt(partes[8]), partes[9], partes[10], Integer.parseInt(partes[11]), null, null, null, null); 
				sistema.addLP(lptemp);
			}
		}
		
	}
	

}
