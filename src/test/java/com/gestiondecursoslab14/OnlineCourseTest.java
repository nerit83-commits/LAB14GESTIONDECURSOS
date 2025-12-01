package com.gestiondecursoslab14;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;


@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
public class OnlineCourseTest {

    private OnlineCourse onlineCourse;   //Objeto que se usará en cada prueba.

    // CICLO DE VIDA
   
    @BeforeAll  //Se ejecuta solo una vez antes de todos los test.
    static void beforeAll() {
        System.out.println("Iniciando OnlineCourseTest...");
    }

    @AfterAll  //Se ejecuta solo una vez después de todos los test.
    static void afterAll() {
        System.out.println("Finalizando OnlineCourseTest...");
    }

    @BeforeEach  //Se ejecuta antes de cada test y crea una nueva instancia para evitar interferencias.
    void setUp() {
        System.out.println("BeforeEach → creando OnlineCourse");
        onlineCourse = new OnlineCourse("Java Web", 12, "Mario Pérez", "Udemy");
    }

    @AfterEach  //Se ejecuta después de cada test.
    void tearDown() {
        System.out.println("AfterEach → limpiando instancia");
        onlineCourse = null;  //Con el null se libera la referencia para el próximo test.
    }

    @Tag ("constructor")
    @ParameterizedTest
    @CsvSource({
            "Java Web, 12, Mario Pérez, Udemy",
            "Python Básico, 8, Ana Gómez, Coursera",
            "Desarrollo Móvil, 10, Luis Martínez, edX"
    })
    @DisplayName("Constructor crea correctamente el OnlineCourse")
    void testOnlineCourseConstructor(String title, int duration, String professor, String platform) {
        OnlineCourse course = new OnlineCourse(title, duration, professor, platform);
        assertNotNull(course);  //Verifica que la instancia exista.
        assertEquals(title, course.getTitle());
        assertEquals(duration, course.getDuration());
        assertEquals(professor, course.getProfessor());
        assertEquals(platform, course.getPlataform());
    }

    static Stream<Arguments> onlineCourseProvider() { //Nombre del método proveedor.
        return Stream.of(  //Proporciona múltiples conjuntos de argumentos para el test.
            Arguments.of("Java Web", 12, "Mario Pérez", "Udemy"),
            Arguments.of("Python Básico", 8, "Ana Gómez", "Coursera"),
            Arguments.of("Testing QA", 10, "Luis Martínez", "edX")
        );
    }

    @Order(2)
    @Tag ("constructor")    
    @ParameterizedTest
    @MethodSource("onlineCourseProvider")  //Referencia al método proveedor de datos.
    @DisplayName("Constructor OnlineCourse probado con múltiples parámetros (MethodSource)")
    void testConstructorParameterized(String title, int duration, String professor, String platform) {  

        OnlineCourse course = new OnlineCourse(title, duration, professor, platform); //Crea una nueva instancia con los parámetros proporcionados.

        assertEquals(title, course.getTitle());
        assertEquals(duration, course.getDuration());
        assertEquals(professor, course.getProfessor());
        assertEquals(platform, course.getPlataform());
    }

    @Order(3)
    @ParameterizedTest
    @EmptySource  //Proporciona un valor vacío para la prueba.
    @DisplayName("Cambiar plataforma a valor vacío")
    void testSetPlataformEmpty(String plataforma) {
        onlineCourse.setPlataform(plataforma);  //Cambia la plataforma a un valor vacío.
        assertEquals(plataforma, onlineCourse.getPlataform());  //Verifica que el cambio se aplicó correctamente.
    }

    @Order(2)
    @ParameterizedTest
    @NullSource  //Proporciona un valor nulo para la prueba.
    @DisplayName("Cambiar plataforma a valor nulo")
    void testSetPlataformNull(String plataforma) {
        onlineCourse.setPlataform(plataforma);  //Cambia la plataforma a un valor nulo.
        assertEquals(plataforma, onlineCourse.getPlataform());  //Verifica que el cambio se aplicó correctamente.
    }

    @Order(1)
    @ParameterizedTest
    @NullAndEmptySource  //Proporciona tanto un valor nulo como un valor vacío para la prueba.
    @DisplayName("Cambiar plataforma a valor nulo o vacío")
    void testSetPlataformNullAndEmpty(String plataforma) {
        onlineCourse.setPlataform(plataforma);  //Cambia la plataforma a un valor nulo o vacío.
        assertEquals(plataforma, onlineCourse.getPlataform());  //Verifica que el cambio se aplicó correctamente.
    }

    @Tag ("setTitle")
    @Order(4)
    @ParameterizedTest
    @CsvSource({
            "Plataforma1",
            "Plataforma2",
            "Plataforma3"
    })
    @DisplayName("Cambiar plataforma con distintos valores")
    void testSetPlataform(String plataforma) {
        onlineCourse.setPlataform(plataforma);  //Cambia la plataforma con diferentes valores.
        assertEquals(plataforma, onlineCourse.getPlataform());  //Verifica que el cambio se aplicó correctamente.
    }
}
