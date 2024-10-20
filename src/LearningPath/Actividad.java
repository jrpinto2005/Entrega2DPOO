package LearningPath;

import java.util.Date;

public class Actividad {
private String descripcion;
private String objetivo;
private String id;
private Date fechaInicio;
private Date fechaFin;
private int duracion;
private int dificultad;
private double rating;
private String tipoActividad;
private boolean obligatoria;
private LearningPath learningPath;

public Actividad(String descripcion, String objetivo, String id, Date fechaInicio, Date fechaFin, int duracion,
		int dificultad, double rating, String tipoActividad, boolean obligatoria, LearningPath learningPath) {
	super();
	this.descripcion = descripcion;
	this.objetivo = objetivo;
	this.id = id;
	this.fechaInicio = fechaInicio;
	this.fechaFin = fechaFin;
	this.duracion = duracion;
	this.dificultad = dificultad;
	this.rating = rating;
	this.tipoActividad = tipoActividad;
	this.obligatoria = obligatoria;
	this.learningPath = learningPath;
}


public String getDescripcion() {
	return descripcion;
}


public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


public String getObjetivo() {
	return objetivo;
}


public void setObjetivo(String objetivo) {
	this.objetivo = objetivo;
}


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public Date getFechaInicio() {
	return fechaInicio;
}


public void setFechaInicio(Date fechaInicio) {
	this.fechaInicio = fechaInicio;
}


public Date getFechaFin() {
	return fechaFin;
}


public void setFechaFin(Date fechaFin) {
	this.fechaFin = fechaFin;
}


public int getDuracion() {
	return duracion;
}


public void setDuracion(int duracion) {
	this.duracion = duracion;
}


public int getDificultad() {
	return dificultad;
}


public void setDificultad(int dificultad) {
	this.dificultad = dificultad;
}


public double getRating() {
	return rating;
}


public void setRating(double rating) {
	this.rating = rating;
}


public String getTipoActividad() {
	return tipoActividad;
}


public void setTipoActividad(String tipoActividad) {
	this.tipoActividad = tipoActividad;
}


public boolean isObligatoria() {
	return obligatoria;
}


public void setObligatoria(boolean obligatoria) {
	this.obligatoria = obligatoria;
}


public LearningPath getLearningPath() {
	return learningPath;
}


public void setLearningPath(LearningPath learningPath) {
	this.learningPath = learningPath;
}

public boolean sePuedeEmpezar() {
	
	this.learningPath.
	
}


}
