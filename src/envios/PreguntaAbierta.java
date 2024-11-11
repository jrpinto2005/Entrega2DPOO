package envios;

public class PreguntaAbierta extends Pregunta {

	public int valorPregunta;

	public PreguntaAbierta(String textoPregunta, int idPregunta, int valorPregunta) {
		super(textoPregunta, idPregunta);
		this.valorPregunta = valorPregunta;
		 
	}

	public int getValorPregunta() {
		return valorPregunta;
	}

}
