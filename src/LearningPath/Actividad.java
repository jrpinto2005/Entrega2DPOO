package LearningPath;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Envio.Envio;
import Envio.Reseña;
import Usuarios.ControladorUsuarios;
import Usuarios.Estudiante;
import Usuarios.Sistema;

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
private String nombre;
private Sistema sistema;
private ControladorUsuarios cu;
private List<Reseña> reseñas;
private List<Actividad> actividadesRecomendadas;

public Actividad(String descripcion, String objetivo, String nombre, Date fechaInicio, Date fechaFin, int duracion,
		int dificultad, double rating, String tipoActividad, boolean obligatoria, String idLearningPath) {
	super();
	LearningPath LP=sistema.encontrarLP(idLearningPath);
	this.descripcion = descripcion;
	this.objetivo = objetivo;
	this.id = LP.getTitulo()+"."+ nombre;
	this.fechaInicio = fechaInicio;
	this.fechaFin = fechaFin;
	this.duracion = duracion;
	this.dificultad = dificultad;
	this.rating = rating;
	this.tipoActividad = tipoActividad;
	this.obligatoria = obligatoria;
	this.learningPath = LP;
	this.sistema=Sistema.getInstancia();
	this.cu=ControladorUsuarios.getInstancia();
	this.reseñas=new ArrayList<Reseña>();
	this.actividadesRecomendadas=new ArrayList<Actividad>();
	
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
public void agregarReseña(Reseña r)
{
	this.reseñas.add(r);
}
public void agregarActividadRecomendada(Actividad a)
{
	this.actividadesRecomendadas.add(a);
}
public boolean esBuenaIdeaHacerActividad(String idEstudiante) {
	Estudiante estudiante=this.cu.encontrarEstudiante(idEstudiante);
	List<Envio> envios=estudiante.getEnvios();
	int contador=this.actividadesRecomendadas.size();
	int cantidad=0;
	for (Actividad actividad: this.actividadesRecomendadas)
	{
		for (Envio envio: envios)
		{
			Actividad act=envio.getActividad();
			if (actividad.getId().equals(act.getId()) && envio.isCompletado())
			{
				cantidad+=1;
			}
		}
	}
	if (cantidad!=contador)
	{
		System.out.println("No es recomendasble hacer la actividad debido a que hay catividades previas recomendadas que no has hecho");
		return false;
	}
	else
	{
		return true;
	}
	
}


}
