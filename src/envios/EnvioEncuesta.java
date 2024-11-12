package envios;

import java.util.List;

import learningPaths.Actividad;

public class EnvioEncuesta extends Envio {
	private double puntaje;
	private int puntajeMaximo;
	private double rating;
	private List<RespuestaEncuesta> respuestas;

	public EnvioEncuesta(Actividad actividad, String idEstudiante, String tituloLp, boolean completado, double puntaje,
			int puntajeMaximo, double rating, List<RespuestaEncuesta> respuestas) {
		super(actividad, idEstudiante, tituloLp, completado);
		// TODO Auto-generated constructor stub

		this.puntaje = puntaje;
		this.puntajeMaximo = puntajeMaximo;
		this.rating = rating;
		this.respuestas = respuestas;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	public void setPuntajeMaximo(int puntajeMaximo) {
		this.puntajeMaximo = puntajeMaximo;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
