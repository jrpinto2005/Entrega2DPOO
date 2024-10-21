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

import LearningPath.Actividad;
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
		//creamos el sistema
	}


	public static void cargarSistema(File archivo) throws FileNotFoundException, IOException, NumberFormatException, ParseException
	{
		BufferedReader br = new BufferedReader( new FileReader( archivo ) );
		String line = br.readLine( );
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		//se prepara todo para empezar a leer el archivo
		while( line != null )
			//recorre el archivo hasta la ultima linea
		{
			String[] partes = line.split( "," );
			//separa las filas por comas y cada palabra entre comas la guarda en una pos de lista
			
			if( partes[ 0 ].equals( "lp" ) )
				//si la primera palabra de la fila eslp sabemos que esto es un learning path
				
			{
				LearningPath lptemp=new LearningPath(partes[1], partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]), Integer.parseInt(partes[5]), formato.parse(partes[6]), formato.parse(partes[7]), Integer.parseInt(partes[8]), partes[9], partes[10],Integer.parseInt(partes[11])); 
				sistema.addLP(lptemp);
				//creamos un learning path y lo agregamos al sistema
			}
			else if (partes[0].equals("quiz"))
			{
				//si la primera palbra es quiz sabemos que es quiz
				Quiz quiztemp=new Quiz(partes[1], partes[2], partes[3], formato.parse(partes[4]), formato.parse(partes[5]), Integer.parseInt(partes[6]), Integer.parseInt(partes[7]), Double.parseDouble(partes[8]), "Quiz", Boolean.parseBoolean(partes[9]), partes[10], Integer.parseInt(partes[11]));
				sistema.addActividad(quiztemp);
				//creamos un quisz y lo agregamos al sistema
				//lo mismo se hara con todas las actividades invocando a su constructor
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
			//siguiente linea
		}
		br.close();
		//se cierra
		}
	
		public static void guardarSistema(File archivo) throws IOException {
	        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	        
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
	            
	            // Escribir LearningPaths
	            Map<String,LearningPath> lps = sistema.getLearningPaths();
	            for (String lp : lps.keySet()) {
	            	LearningPath temp=lps.get(lp);
	                String lpLine = String.format("lp,%s,%d,%d,%d,%s,%s,%d,%s,%s,%s,%.2f",
	                    lp, temp.getDescripcionGeneral(), temp.getNivelDificutad(), temp.getDuracion(), temp.getRating(), formato.format(temp.getFechaDuracion()),formato.format(temp.getFechaModificacion()), temp.getVersion(),
	                    temp.getIdCreador(), temp.getObjetivos(),temp.getPromedioActividadesCompletadas());
	                bw.write(lpLine);
	                bw.newLine();
	            }

	            // Escribir otras actividades (quiz, examen, encuesta, web, video, lectura)
	            Map<String,Actividad> actividades = sistema.getActividades();
	            for (String act : actividades.keySet()) {
	            	Actividad acttemp=actividades.get(act);
	                if (acttemp instanceof Quiz) {
	                    
	                    String quizLine = String.format("quiz,%s,%s,%s,%s,%s,%d,%d,%.2f,%b,%s,%d",
	                        "quiz" , acttemp.getDescripcion(), acttemp.getObjetivo(), act, formato.format(acttemp.getFechaInicio()),formato.format(acttemp.getFechaFin()),
	                        		acttemp.getDuracion(), acttemp.getDificultad(), acttemp.getRating(), acttemp.isObligatoria(), acttemp.getLearningPath().getTitulo(),((Quiz) acttemp).getPuntajeMaximo());
	                    bw.write(quizLine);
	                    bw.newLine();
	                } else if (acttemp instanceof Examen) {
	                    String examenLine = String.format("examen,%s,%s,%s,%s,%s,%d,%d,%.2f,%b,%s,%d",
		                        "examen" , acttemp.getDescripcion(), acttemp.getObjetivo(), act, formato.format(acttemp.getFechaInicio()),formato.format(acttemp.getFechaFin()),
                        		acttemp.getDuracion(), acttemp.getDificultad(), acttemp.getRating(), acttemp.isObligatoria(), acttemp.getLearningPath().getTitulo(),((Examen) acttemp).getPuntajeMaximo());
                    bw.write(examenLine);
	                    bw.write(examenLine);
	                    bw.newLine();
	                } else if (acttemp instanceof Encuesta) {
	                    String encuestaLine = String.format("encuesta,%s,%s,%s,%s,%s,%d,%d,%.2f,%b,%s",
		                        "encuesta" , acttemp.getDescripcion(), acttemp.getObjetivo(), act, formato.format(acttemp.getFechaInicio()),formato.format(acttemp.getFechaFin()),
                        		acttemp.getDuracion(), acttemp.getDificultad(), acttemp.getRating(), acttemp.isObligatoria());
	                    bw.write(encuestaLine);
	                    bw.newLine();
	                } else if (acttemp instanceof SitioWeb) {
	                    String webLine  = String.format("web,%s,%s,%s,%s,%s,%d,%d,%.2f,%b,%s,%s",
		                        "web" , acttemp.getDescripcion(), acttemp.getObjetivo(), act, formato.format(acttemp.getFechaInicio()),formato.format(acttemp.getFechaFin()),
                        		acttemp.getDuracion(), acttemp.getDificultad(), acttemp.getRating(), acttemp.isObligatoria(),((SitioWeb) acttemp).getUrl());
	                    bw.write(webLine);
	                    bw.newLine();
	                } else if (acttemp instanceof Video) {
	                    String videoLine = String.format("video,%s,%s,%s,%s,%s,%d,%d,%.2f,%b,%s,%d",
		                        "video" , acttemp.getDescripcion(), acttemp.getObjetivo(), act, formato.format(acttemp.getFechaInicio()),formato.format(acttemp.getFechaFin()),
                        		acttemp.getDuracion(), acttemp.getDificultad(), acttemp.getRating(), acttemp.isObligatoria(), ((Video) acttemp).getDuracionV());
	                    bw.write(videoLine);
	                    bw.newLine();
	                } else if (acttemp instanceof Lectura) {
	                    String lecturaLine = String.format("Encuesta,%s,%s,%s,%s,%s,%d,%d,%.2f,%b,%s",
		                        "Encuesta" , acttemp.getDescripcion(), acttemp.getObjetivo(), act, formato.format(acttemp.getFechaInicio()),formato.format(acttemp.getFechaFin()),
                        		acttemp.getDuracion(), acttemp.getDificultad(), acttemp.getRating(), acttemp.isObligatoria());
	                    bw.write(lecturaLine);
	                    bw.newLine();
	                }
	                bw.close();
	            }
	        }
	   
	

}}
