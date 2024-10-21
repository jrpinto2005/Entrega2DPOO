package Envio;

public class RespuestaAbierta 
{
	private int puntaje;
	private String contenido;
	private int valor;
	private PreguntaAbierta pregunta;
	
	public RespuestaAbierta(int puntaje, String contenido, int valor, PreguntaAbierta pregunta) {
		super();
		this.puntaje = puntaje;
		this.contenido = contenido;
		this.valor = valor;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public String getContenido() {
		return contenido;
	}

	public int getValor() {
		return valor;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	
}
