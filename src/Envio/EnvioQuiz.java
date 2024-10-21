package Envio;

import java.util.List;

import LearningPath.Actividad;

public class EnvioQuiz extends Envio
{
	private double puntaje;
	private int puntajeMaximo;
	private double notaPorcentaje;
	private List<RespuestaMultiple> respuestas;
	
	public EnvioQuiz(Actividad actividad, String idEstudiante, String tituloLP, boolean completado, double puntaje, int puntajeMaximo, double notaPorcentaje, List<RespuestaMultiple> respuestas) {
		super(actividad, idEstudiante, tituloLP, completado);
		this.puntaje = puntaje;
		this.puntajeMaximo = puntajeMaximo;
		this.notaPorcentaje = notaPorcentaje;
		this.respuestas=respuestas;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje=puntaje;
	}

	public void setPuntajeMaximo(int puntajeMax) {
		this.puntajeMaximo=puntajeMax;
	}

	public void setNotaPorcentaje(double nota) {
		this.notaPorcentaje=nota;
	}
	
	

}

