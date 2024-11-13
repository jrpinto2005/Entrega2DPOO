package usuario;

import java.util.Collection;
import java.util.Date;

import constructores.ConstructorLearningPath;
import constructores.ConstructorQuiz;
import constructores.ConstructorTarea;
import envios.Opcion;
import envios.PreguntaOpcionMultiple;
import exceptions.ActivdadNoEcontradaException;
import learningPaths.Actividad;
import learningPaths.LearningPath;
import learningPaths.Quiz;

public class MainEditaryClonarLP {
	public static void main(String[] args) throws ActivdadNoEcontradaException {
		// Inicializa el sistema

		Sistema sistema = new Sistema();

		ConstructorLearningPath c = new ConstructorLearningPath();
		ConstructorTarea t = new ConstructorTarea();
		ConstructorQuiz q = new ConstructorQuiz();

		// Crea algunos LearningPaths
		LearningPath lp1 = c.crearLP("Java Básico", "Aprende los fundamentos de Java", 1, 40, 5, new Date(), new Date(),
				1, "profesor01", "Entender lo básico de Java", 0.0);

		LearningPath lp2 = c.crearLP("Java Avanzado", "Conceptos avanzados de Java", 3, 80, 4, new Date(), new Date(),
				1, "profesor02", "Dominar conceptos avanzados de Java", 0.0);

		try {
			// Crear actividades
			Actividad act1 = t.crearTarea("Video variables 1", "Introducir variables", "NombreActividad", new Date(),
					new Date(), 120, 3, 4.5, "Recurso Educativo", true, "Java Básico");
			Quiz act2 = q.crearQuiz("Quiz de transformaciones lineales", "aprender a ....", "Quiz 2", new Date(),
					new Date(), 120, 3, 4.5, "Recurso Educativo", true, "Java Básico", 10);

			Opcion opcionI1 = new Opcion("incorrecto", false, 1);
			Opcion opcionI2 = new Opcion("incorrecto", false, 2);
			Opcion opcionI3 = new Opcion("incorrecto", false, 3);
			Opcion opcionC = new Opcion("correcto", true, 4);

			PreguntaOpcionMultiple p = new PreguntaOpcionMultiple("Pregunta ejemplo", 4);
			p.agregarOpcion(opcionI1);
			p.agregarOpcion(opcionI2);
			p.agregarOpcion(opcionI3);
			p.agregarOpcion(opcionC);

			act2.addPregunta(p);
			Collection<PreguntaOpcionMultiple> preguntas = act2.getPreguntas();
			// agrega las actividades al learning path
			lp1.agregarActividad(act1);
			lp1.agregarActividad(act2);

			// probrar con un profesor creador
			c.editarLP("profesor01", "descripcionGeneral", "variables avanzadas ", "Java Básico");
			// exitoso

			System.out.println(lp1.getDescripcionGeneral());
			// probrar con un profesor no creador
			c.editarLP("Noe Leslie", "descripcionGeneral", "variables avanzadas ", "Java Básico");
			Profesor leslie = new Profesor("Noe Leslie", "profesor03", "nleslie@unaindes.edu.co", "dino087",
					"profesor");

			LearningPath dinosaurios = leslie.crearLearningPath("Dinosaurios", "Dominar conceptos avanzados de Dinos",
					3, 80, 4, new Date(), new Date(), 1, "profesor03", null, 0.0);

			System.out.println(act2.getId());
			lp1.clonarActividad(dinosaurios, act2.getId());

			System.out.println("Actividades en el Learning Path Clonado (" + dinosaurios.getTitulo() + "):");
			for (Actividad actividad : dinosaurios.getActividadesOrdenadas()) {
				System.out.println("- " + actividad.getId());
			}

		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
