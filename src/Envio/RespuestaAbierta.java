package Envio;

public class RespuestaAbierta 
{
	private int puntaje;
	private String contenido;
	private int valor;
	
	public RespuestaAbierta(int puntaje, String contenido, int valor) {
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
