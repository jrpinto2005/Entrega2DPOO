package constructores;

import envios.*;
import learningPaths.*;
import usuario.Estudiante;
import usuario.Sistema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControladorEnvios {

    private Sistema sistema;
    

    public ControladorEnvios() {
        this.sistema = Sistema.getInstancia();
    }
    
    public boolean esBuenaIdeaHacerActividad(Estudiante estudiante, Actividad actividad) {
		List<Envio> envios = estudiante.getEnvios();
		int contador = actividad.getActividadesRecomendadas().size();
		int cantidad = 0;
		for (Actividad actividades : actividad.getActividadesRecomendadas()) {
			for (Envio envio : envios) {
				Actividad act = envio.getActividad();
				if (actividades.getId().equals(act.getId()) && envio.isCompletado()) {
					cantidad += 1;
				}
			}
		}
		if (cantidad != contador) {
			return false;
		} else {
			return true;
		}

	}

    public EnvioExamen hacerExamen(Estudiante estudiante, String idExamen, List<String> respuestasUsuario) {
        Examen examen = (Examen) sistema.encontrarActividad(idExamen);
        boolean recomendado = esBuenaIdeaHacerActividad(estudiante, examen);
        
        if (!recomendado) {
            System.out.println("Te recomendamos hacer las actividades recomendadas antes de hacer este examen");
        }

        Collection<PreguntaAbierta> preguntas = examen.getPreguntas();
        List<RespuestaAbierta> respuestas = new ArrayList<>();
        
        int index = 0;
        for (int i = 0; i < preguntas.size(); i++) {
            String respuestaTexto = respuestasUsuario(i);
            RespuestaAbierta respuesta = new RespuestaAbierta(0, respuestaTexto, pregunta.getValorPregunta(), preguntas(i));
            respuestas.add(respuesta);
        }
        
        EnvioExamen envio = new EnvioExamen(examen, estudiante.getId(), examen.getLearningPath().getTitulo(), 
                                            false, 0, examen.getPuntajeMaximo(), 0, respuestas);
        estudiante.getEnvios().add(envio);
        
        return envio;
    }


    public EnvioQuiz hacerQuiz(Estudiante estudiante, String idQuiz, List<Integer> respuestasIngresadas) {
        Quiz quiz = (Quiz) sistema.encontrarActividad(idQuiz);
        boolean recomendado= esBuenaIdeaHacerActividad(estudiante,quiz);
        if(recomendado==false) {System.out.println("Te recomendamos hacer las actividades recomendadas antes de hacer este quiz");	
        }
        Collection<PreguntaOpcionMultiple> preguntas = quiz.getPreguntas();
        List<RespuestaMultiple> respuestas = new ArrayList<>();
        for (int i = 0; i < preguntas.size(); i++) {
            int respuestaSeleccionada = respuestasIngresadas(i);  
            RespuestaMultiple respuesta = new RespuestaMultiple(0, respuestaSeleccionada, pregunta);
            respuestas.add(respuesta);
        }
        EnvioQuiz envio = new EnvioQuiz(quiz, estudiante.getId(), quiz.getLearningPath().getTitulo(), false, 0, quiz.getPuntajeMaximo(), 0, respuestas);
        estudiante.getEnvios().add(envio);
        return envio;
    }


    public EnvioEncuesta hacerEncuesta(Estudiante estudiante, String idEncuesta, List<Integer> respuestasIngresadas) {
        Encuesta encuesta = (Encuesta) sistema.encontrarActividad(idEncuesta);
        boolean recomendado= esBuenaIdeaHacerActividad(estudiante,encuesta);
        if(recomendado==false) {System.out.println("Te recomendamos hacer las actividades recomendadas antes de hacer esta encuesta");	
        }
        Collection<PreguntaEncuesta> preguntas = encuesta.getPreguntas();
        List<RespuestaEncuesta> respuestas = new ArrayList<>();
        for (int i = 0; i < preguntas.size(); i++) {
            int respuestaSeleccionada = respuestasIngresadas(i); 
            RespuestaEncuesta respuesta = new RespuestaEncuesta(respuestaSeleccionada, pregunta);
            respuestas.add(respuesta);
        }
        EnvioEncuesta envio = new EnvioEncuesta(encuesta, estudiante.getId(), encuesta.getLearningPath().getTitulo(), true, 0, encuesta.getPuntajeMaximo(), 0, respuestas);
        estudiante.getEnvios().add(envio);
        return envio;
    }
    
    public EnvioTarea hacerTarea(Estudiante estudiante, String idTarea) {
        Tarea tarea = (Tarea) sistema.encontrarActividad(idTarea);
        boolean recomendado= esBuenaIdeaHacerActividad(estudiante,tarea);
        if(recomendado==false) {System.out.println("Te recomendamos hacer las actividades recomendadas antes de hacer esta tarea");	
        }
        EnvioTarea envio = new EnvioTarea(tarea, estudiante.getId(), tarea.getLearningPath().getTitulo(), true);
        estudiante.getEnvios().add(envio);
        return envio;
    }

    public EnvioRecurso hacerRecurso(Estudiante estudiante, String idRecurso) {
        RecursoEducativo recurso = (RecursoEducativo) sistema.encontrarActividad(idRecurso);
        boolean recomendado= esBuenaIdeaHacerActividad(estudiante,recurso);
        if(recomendado==false) {System.out.println("Te recomendamos hacer las actividades recomendadas antes de hacer este recurso");	
        }
        EnvioRecurso envio = new EnvioRecurso(recurso, estudiante.getId(), recurso.getLearningPath().getTitulo(), true);
        estudiante.getEnvios().add(envio);
        return envio;
    }
}
