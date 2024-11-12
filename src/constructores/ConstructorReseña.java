package constructores;

import java.util.Date;

import envios.Reseña;
import learningPaths.Actividad;
import usuario.Sistema;

public class ConstructorReseña {
	
	
	public void hacerReseña(String idReseña, String comentario, int rating, Date fecha, String idActividad) {
		
		Reseña nuevaReseña = new Reseña(idReseña,  comentario,  rating,  fecha,  idActividad);
		Actividad actividad = Sistema.getInstancia().encontrarActividad(idActividad);
		actividad.agregarReseña(nuevaReseña);
		Sistema.getInstancia().addActividad(actividad);
	}

}
