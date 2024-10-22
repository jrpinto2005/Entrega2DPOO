package Envio;

public class PreguntaAbierta extends Pregunta {

	public int valorPregunta;
	
	public PreguntaAbierta(String textoPregunta, int idPregunta, int valorPregunta) {
		super(textoPregunta, idPregunta);
		this.valorPregunta=valorPregunta;
		// TODO Auto-generated constructor stub
	}
	public int getValorPregunta()
	{return valorPregunta;}

}
