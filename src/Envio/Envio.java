package Envio;

import LearningPath.Actividad;

public abstract class Envio 
{
	private String idEstudiante;
	private String tituloLp;
	protected boolean completado;
	private Actividad actividad;
	
	public Envio(Actividad actividad, String idEstudiante, String tituloLp, boolean completado) {
		super();
		this.actividad=actividad;
		this.idEstudiante = idEstudiante;
		this.tituloLp = tituloLp;
		this.completado = completado;
	}

	public String getIdEstudiante() {
		return idEstudiante;
	}

	public String getTituloLp() {
		return tituloLp;
	}

	public boolean isCompletado() {
		return completado;
	}

	public Actividad getActividad() {
		return actividad;
	}
	
	
	
	
	
}
