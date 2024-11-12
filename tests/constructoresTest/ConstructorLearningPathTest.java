package constructoresTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import constructores.ConstructorLearningPath;
import exceptions.ActivdadNoEcontradaException;
import learningPaths.Actividad;
import learningPaths.LearningPath;
import learningPaths.RecursoEducativo;
import usuario.Sistema;

class ConstructorLearningPathTest {

    private ConstructorLearningPath constructorLP;
    private Sistema sistema;
    private Date fechaInicio;
	private Date fechaFin;

    @BeforeEach
    void setUp() {
        sistema = Sistema.getInstancia();

        
        constructorLP = new ConstructorLearningPath();
        LearningPath lp1 = constructorLP.crearLP("Java Básico", "Aprende los fundamentos de Java", 1, 40, 5, new Date(), new Date(),
                1, "profesor01", "Objetivos del curso", 0.0);
        sistema.addLP(lp1);

         
        
		RecursoEducativo actividad1 = new RecursoEducativo("video de variables", "Introducir variables", "Tarea1", 
                fechaInicio, fechaFin, 120, 3, 4.5, "Recurso Educativo", true, "Java Básico");
        lp1.agregarActividad(actividad1);
    }

    @Test
    void testCrearLearningPath() {
        
        LearningPath lp2 = constructorLP.crearLP("Python Avanzado", "Curso de Python para expertos", 5, 60, 4, new Date(), new Date(),
                1, "profesor02", "Aprender a programar en Python", 0.0);

         
        assertNotNull(lp2, "El LearningPath debería ser creado.");
        assertEquals("Python Avanzado", lp2.getTitulo(), "El título del LearningPath debería coincidir.");
        assertEquals(5, lp2.getNivelDificultad(), "El nivel de dificultad debería ser 5.");
        assertEquals("profesor02", lp2.getIdCreador(), "El ID del creador debería coincidir.");
        assertEquals(0.0, lp2.getPromedioActividadesCompletadas(), "El promedio de actividades completadas debería ser 0.0.");
    }

    @Test
    void testEditarLearningPath() {
        
        LearningPath lp = sistema.get("Java Básico");
        assertNotNull(lp, "El LearningPath debería existir.");

        
        constructorLP.editarLP(lp, "titulo", "Java Intermedio");

         
        assertEquals("Java Intermedio", lp.getTitulo(), "El título del LearningPath debería haberse actualizado.");
    }

    @Test
    void testClonarActividad() {
         
        LearningPath lp2 = constructorLP.crearLP("Python Avanzado", "Curso de Python para expertos", 5, 60, 4, new Date(), new Date(),
                1, "profesor02", "Objetivos del curso", 0.0);

        
        Actividad actividad1 = sistema.encontrarActividad("Java Básico.1");
        assertNotNull(actividad1, "La actividad debería existir en el LP original.");

        try {
            constructorLP.clonarActividad(lp1, lp2, "1");  
        } catch (ActivdadNoEcontradaException e) {
            fail("La actividad debería haberse clonado correctamente.");
        }

         
        Actividad actividadClonada = lp2.getActividadesOrdenadas().stream()
            .filter(a -> a.getId().equals("Python Avanzado.1"))
            .findFirst()
            .orElse(null);

        assertNotNull(actividadClonada, "La actividad clonada debería existir en el LearningPath destino.");
        assertEquals("Python Avanzado.1", actividadClonada.getId(), "El ID de la actividad clonada debería coincidir.");
    }
}
