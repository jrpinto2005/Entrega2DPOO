  package usuario;

import java.util.HashMap;
import java.util.Map;

import learningPaths.Actividad;
import learningPaths.LearningPath;

public class Sistema {
	private Map<String, LearningPath> learningPaths;
	private Map<String, Actividad> actividades;
	private static Sistema instancia;

	public Sistema() {
		this.learningPaths = new HashMap<>();
		this.actividades = new HashMap<>();
	}

	public LearningPath encontrarLP(String idLP) {
		return learningPaths.get(idLP);
	}

	public Actividad encontrarActividad(String idActividad) {
		return actividades.get(idActividad);
	}

	public void addLP(LearningPath LP) {
		learningPaths.put(LP.getTitulo(), LP);
	}

	public void addActividad(Actividad act) {
		actividades.put(act.getId(), act);
	}

	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}

	public Map<String, LearningPath> getLearningPaths() {
		return learningPaths;
	}

	public Map<String, Actividad> getActividades() {
		return actividades;
	}

}
