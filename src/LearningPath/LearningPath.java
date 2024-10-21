package LearningPath;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Envio.EnvioExamen;
import exceptions.ActivdadNoEcontradaException;
import LearningPath.Actividad;
import Usuarios.Estudiante;
import Usuarios.Profesor;
import Usuarios.Sistema;

public class LearningPath {
		private String titulo;
		private String descripcionGeneral;
		private int nivelDificutad;
		private int duracion;
		private int rating;
		private Date fechaDuracion;
		private Date fechaModificacion;
		private int version;
		private String idCreador;
		private String objetivos;
		private double promedioActividadesCompletadas;
		private LinkedList<Integer> estudiante;
		private List<EnvioExamen>enviosPorCalificar;
		private List<EnvioExamen>examenesCalificados;
		private ArrayList<Actividad>actividadesOrdenadas;
		private Sistema sistema;
		
		
		public LearningPath(String titulo, String descripcionGeneral, int nivelDificutad, int duracion, int rating,
				Date fechaDuracion, Date fechaModificacion, int version, String idCreador, String objetivos,
				double promedioActividadesCompletadas) {
			super();
			this.titulo = titulo;
			this.descripcionGeneral = descripcionGeneral;
			this.nivelDificutad = nivelDificutad;
			this.duracion = duracion;
			this.rating = rating;
			this.fechaDuracion = fechaDuracion;
			this.fechaModificacion = fechaModificacion;
			this.version = version;
			this.idCreador = idCreador;
			this.objetivos = objetivos;
			this.promedioActividadesCompletadas = promedioActividadesCompletadas;
			this.estudiante = new LinkedList<Integer>();
			this.enviosPorCalificar = new LinkedList<EnvioExamen>();
			this.examenesCalificados = new LinkedList<EnvioExamen>();
			this.actividadesOrdenadas = new ArrayList<Actividad>();
			this.sistema = Sistema.getInstancia();
		}


		public String getTitulo() {
			return titulo;
		}


		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}


		public String getDescripcionGeneral() {
			return descripcionGeneral;
		}


		public void setDescripcionGeneral(String descripcionGeneral) {
			this.descripcionGeneral = descripcionGeneral;
		}


		public int getNivelDificutad() {
			return nivelDificutad;
		}


		public void setNivelDificutad(int nivelDificutad) {
			this.nivelDificutad = nivelDificutad;
		}


		public int getDuracion() {
			return duracion;
		}


		public void setDuracion(int duracion) {
			this.duracion = duracion;
		}


		public int getRating() {
			return rating;
		}


		public void setRating(int rating) {
			this.rating = rating;
		}


		public Date getFechaDuracion() {
			return fechaDuracion;
		}


		public void setFechaDuracion(Date fechaDuracion) {
			this.fechaDuracion = fechaDuracion;
		}


		public Date getFechaModificacion() {
			return fechaModificacion;
		}


		public void setFechaModificacion(Date fechaModificacion) {
			this.fechaModificacion = fechaModificacion;
		}


		public int getVersion() {
			return version;
		}


		public void setVersion(int version) {
			this.version = version;
		}


		public String getIdCreador() {
			return idCreador;
		}


		public void setIdCreador(String idCreador) {
			this.idCreador = idCreador;
		}


		public String getObjetivos() {
			return objetivos;
		}


		public void setObjetivos(String objetivos) {
			this.objetivos = objetivos;
		}


		public double getPromedioActividadesCompletadas() {
			return promedioActividadesCompletadas;
		}


		public void setPromedioActividadesCompletadas(double promedioActividadesCompletadas) {
			this.promedioActividadesCompletadas = promedioActividadesCompletadas;
		}


		public LinkedList<Integer> getEstudiante() {
			return estudiante;
		}


		public void setEstudiante(LinkedList<Integer> estudiante) {
			this.estudiante = estudiante;
		}


		public List<EnvioExamen> getEnviosPorCalificar() {
			return enviosPorCalificar;
		}


		public void setEnviosPorCalificar(List<EnvioExamen> enviosPorCalificar) {
			this.enviosPorCalificar = enviosPorCalificar;
		}


		public List<EnvioExamen> getExamenesCalificados() {
			return examenesCalificados;
		}


		public void setExamenesCalificados(List<EnvioExamen> examenesCalificados) {
			this.examenesCalificados = examenesCalificados;
		}


		public ArrayList<Actividad> getActividadesOrdenadas() {
			return actividadesOrdenadas;
		}


		public void setActividadesOrdenadas(ArrayList<Actividad> actividadesOrdenadas) {
			this.actividadesOrdenadas = actividadesOrdenadas;
		}
		
		public boolean esElDueño() {
		    if (Profesor.getId().equals(this.idCreador)) {
		        return true;
		    }
		    return false;

		}
		
		public void agregarActividad (Actividad actividad)
		{
			
			this.actividadesOrdenadas.add(actividad);
			
		}
		
		public void clonarActividad(LearningPath destino, String id) throws ActivdadNoEcontradaException{
			Actividad actividad= null;
			for (Actividad elemento:actividadesOrdenadas) {
				if(elemento.getId().equals(id)) { 
					actividad= elemento;
				}
			if (actividad == null) {
				throw new ActivdadNoEcontradaException(id,this.titulo);
			}
			else
			{
				actividad.setLearningPath(destino);
				actividad.setId(destino.getTitulo() + actividad.getId());
				destino.agregarActividad(actividad);
				sistema.addActividad(actividad);
				System.out.println("Actividad clonada y añadida con exito");
			}
				
			}
			
		
			
			
		} 
		
		
	
}
