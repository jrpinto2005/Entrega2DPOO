package main;

import exceptions.ActivdadNoEcontradaException;
import LearningPath.Actividad;
import Usuarios.Estudiante;
import LearningPath.LearningPath;
import Usuarios.Profesor;
import Usuarios.Sistema;

public class main {

    public static void main(String[] args) {
    	
 
        Sistema sistema = Sistema.getInstancia();
        testEstudiante(sistema);

        // Probamos acciones del profesor
        testProfesor(sistema);
    }

    private static void testEstudiante(Sistema sistema) {
        System.out.println("Iniciando pruebas para el Estudiante...");

        // Crear un estudiante y un Learning Path con actividades
        Estudiante estudiante1 = new Estudiante("E001", "Juan Pérez", "juanperez@mail.com", "1234", "Estudiante");
        Estudiante estudiante2 = new Estudiante("E002", "Laura Gomez", "lauragomez@mail.com", "5678", "Estudiante");
        
        sistema.registrarUsuario(estudiante1);

        LearningPath learningPath = new LearningPath("Ciencia", "Aprender conceptos básicos de ciencia", 1, 5, 5, new Date(), new Date(), 1, "profesor1", "Entender principios básicos", 0.0);
        learningPath.agregarActividad(new Actividad("Actividad 1", "Completa el experimento", 10));
        learningPath.agregarActividad(new Actividad("Actividad 2", "Lee el artículo", 5));
        sistema.agregarLearningPath(learningPath);

        // Simular inicio de sesión del estudiante
        if (sistema.login(estudiante.getNombreUsuario(), "password123")) {
            System.out.println("Login de estudiante exitoso.");
        } else {
            System.out.println("Error en el login del estudiante.");
        }

        // Simular acceso a un Learning Path
        LearningPath path = sistema.buscarLearningPath("Ciencia");
        if (path != null) {
            System.out.println("Acceso al Learning Path 'Ciencia' exitoso.");
        } else {
            System.out.println("Error al acceder al Learning Path 'Ciencia'.");
        }

        // Simular que el estudiante completa todas las actividades
        for (Actividad actividad : path.getActividadesOrdenadas()) {
            if (estudiante.completarActividad(actividad)) {
                System.out.println("Actividad " + actividad.getTitulo() + " completada.");
            } else {
                System.out.println("Error al completar la actividad " + actividad.getTitulo() + ".");
            }
        }

        System.out.println("Pruebas para el Estudiante finalizadas.\n");
    }

    private static void testProfesor(Sistema sistema) {
        System.out.println("Iniciando pruebas para el Profesor...");

        // Crear un profesor y registrar en el sistema
        Profesor profesor = new Profesor("profesor1", "password123");
        sistema.registrarUsuario(profesor);

        // Simular inicio de sesión del profesor
        if (sistema.login(profesor.getNombreUsuario(), "password123")) {
            System.out.println("Login de profesor exitoso.");
        } else {
            System.out.println("Error en el login del profesor.");
        }

        // Simular creación de un nuevo Learning Path por el profesor
        profesor.crearLearningPath("Física");
        LearningPath nuevoPath = sistema.buscarLearningPath("Física");
        if (nuevoPath != null) {
            System.out.println("Learning Path 'Física' creado exitosamente.");
        } else {
            System.out.println("Error al crear el Learning Path 'Física'.");
        }

        // Simular la adición de actividades al Learning Path
        LearningPath quimicaPath = new LearningPath("Química", "Conceptos básicos de Química", 2, 10, 4, new Date(), new Date(), 1, profesor.getNombreUsuario(), "Entender conceptos de química", 0.0);
        Actividad examen = new Actividad("Examen Química", "Examen final de Química", 20);
        Actividad quiz = new Actividad("Quiz Química", "Autoevaluación de Química", 10);
        quimicaPath.agregarActividad(examen);
        quimicaPath.agregarActividad(quiz);
        sistema.agregarLearningPath(quimicaPath);

        if (quimicaPath.getActividadesOrdenadas().size() == 2) {
            System.out.println("Actividades añadidas al Learning Path 'Química' exitosamente.");
        } else {
            System.out.println("Error al añadir actividades al Learning Path 'Química'.");
        }

        // Simular clonación de un Learning Path existente
        try {
            profesor.clonarLearningPath(nuevoPath, quimicaPath);
            System.out.println("Learning Path clonado exitosamente.");
        } catch (ActivdadNoEcontradaException e) {
            System.out.println("Error al clonar el Learning Path: " + e.getMessage());
        }

        System.out.println("Pruebas para el Profesor finalizadas.\n");
    }
}
