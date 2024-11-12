package usuario;

import constructores.ConstructorLearningPath;
import constructores.ConstructorQuiz;
import constructores.ConstructorTarea;
import envios.Opcion;
import envios.PreguntaOpcionMultiple;
import exceptions.ActivdadNoEcontradaException;
import learningPaths.Actividad;
import learningPaths.LearningPath;
import learningPaths.Quiz;
import usuario.Estudiante;
import usuario.Sistema;

import java.util.Collection;
import java.util.Date;

public class MainCreacionLPyActividades {
	public static void main(String[] args) {
		// Inicializa el sistema

		Sistema sistema = new Sistema();

		ConstructorLearningPath c = new ConstructorLearningPath();
		ConstructorTarea t = new ConstructorTarea();
		ConstructorQuiz q = new ConstructorQuiz();

		// Crea LearningPaths
		LearningPath lp1 = c.crearLP("Java Básico", "Aprende los fundamentos de Java", 1, 40, 5, new Date(), new Date(),
				1, "profesor01", "Entender lo básico de Java", 0.0);

		LearningPath lp2 = c.crearLP("Java Avanzado", "Conceptos avanzados de Java", 3, 80, 4, new Date(), new Date(),
				1, "profesor02", "Dominar conceptos avanzados de Java", 0.0);

		try {
			// Crea actividades
			Actividad act1 = t.crearTarea("Video variables 1", "Introducir variables", "Tarea1", new Date(), new Date(),
					120, 3, 4.5, "Recurso Educativo", true, "Java Básico");
			Quiz act2 = q.crearQuiz("Quiz de transformaciones lineales", "aprender a ....", "Quiz 2", new Date(),
					new Date(), 120, 3, 4.5, "Recurso Educativo", true, "Java Básico", 10);
			System.out.println(act1.getDescripcion());
			System.out.println(act2.getDescripcion());
			// crea las opciones
			Opcion opcionI1 = new Opcion("incorrecto", false, 1);
			Opcion opcionI2 = new Opcion("incorrecto", false, 2);
			Opcion opcionI3 = new Opcion("incorrecto", false, 3);
			Opcion opcionC = new Opcion("correcto", true, 4);
			// crea la pregunta
			PreguntaOpcionMultiple p = new PreguntaOpcionMultiple("Pregunta ejemplo", 4);
			p.agregarOpcion(opcionI1);
			p.agregarOpcion(opcionI2);
			p.agregarOpcion(opcionI3);
			p.agregarOpcion(opcionC);

			act2.addPregunta(p);
			Collection<PreguntaOpcionMultiple> preguntas = act2.getPreguntas();
			for (PreguntaOpcionMultiple pregunta : preguntas) {
				pregunta.displayOpciones();
			}

			lp1.agregarActividad(act1);

		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

		// Imprimir las actividades del Learning Path 1
		System.out.println("Actividades en el Learning Path 1 (" + lp1.getTitulo() + "):");
		for (Actividad actividad : lp1.getActividadesOrdenadas()) {
			System.out.println("- " + actividad.getId());
		}

	}
}
