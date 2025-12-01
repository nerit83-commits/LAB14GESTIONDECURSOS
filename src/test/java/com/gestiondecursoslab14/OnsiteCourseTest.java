package com.gestiondecursoslab14;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;


@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
public class OnsiteCourseTest {

    private OnsiteCourse onsiteCourse;

    // CICLO DE VIDA DEL TEST
    @BeforeAll  //Se ejecuta solo una vez antes de todos los test.
    static void beforeAll() {
        System.out.println("Iniciando OnsiteCourseTest...");
    }

    @AfterAll  //Se ejecuta solo una vez después de todos los test.
    static void afterAll() {
        System.out.println("Finalizando OnsiteCourseTest...");
    }

    @BeforeEach
    void setUp() {  //Se ejecuta antes de cada test individual.
        System.out.println("BeforeEach → creando OnsiteCourse");
        onsiteCourse = new OnsiteCourse("Cocina Básica", 6, "A-12", 20); //Se crea una instancia para evitar contaminación entre test.
    }

    @AfterEach  //Se ejecuta después de cada test individual.
    void tearDown() {
        System.out.println("AfterEach = limpiando instancia");
        onsiteCourse = null;  //Se limpira para liberar memoria.
    }

    @Tag ("constructor")
    @Order(2)
    @ParameterizedTest  //Constructor test usando múltiples parámetros.
    @CsvSource({  //Permite definir múltiples conjuntos de datos para el test.
            "Cocina Básica, 6, A-12, 20",
            "Fotografía, 4, B-5, 15",
            "Programación, 10, C-3, 30"
    })
    @DisplayName("Constructor crea correctamente el OnsiteCourse")
    void testOnsiteCourseConstructor(String title, int duration, String classroom, int maxQuota) {
        OnsiteCourse course = new OnsiteCourse(title, duration, classroom, maxQuota);

        assertNotNull(course);  //Verifica que la instancia no sea nula.
        assertEquals(title, course.getTitle());
        assertEquals(duration, course.getDuration());
        assertEquals(classroom, course.getClassroom());
        assertEquals(maxQuota, course.getMaxQuota());
    }

    static Stream<Arguments> onsiteCourseProvider() {  //Provee múltiples conjuntos de datos para el test.
        return Stream.of(  //Cada conjunto de datos es un objeto Arguments.
            Arguments.of("Java Web", 15, "Aula 101", 30),
            Arguments.of("Python Avanzado", 20, "Laboratorio 3", 25),
            Arguments.of("Testing QA", 10, "Sala B", 18)
        );
    }

    @Tag ("constructor")
    @Order(3)
    @ParameterizedTest
    @MethodSource("onsiteCourseProvider")  //Usa el método estático para obtener los datos.
    @DisplayName("Constructor OnsiteCourse probado con múltiples parámetros (MethodSource)")
    void testConstructorParameterized(String title, int duration, String room, int maxQuota) {

        OnsiteCourse course = new OnsiteCourse(title, duration, room, maxQuota);  //Crea la instancia con los parámetros proporcionados.
        assertEquals(title, course.getTitle());
        assertEquals(duration, course.getDuration());
        assertEquals(room, course.getClassroom());
        assertEquals(maxQuota, course.getMaxQuota());
    }

    @Order(4)
    @ParameterizedTest
    @EmptySource  //Proporciona un valor vacío para la prueba.
    @DisplayName("Cambiar aula a valor vacío")
    void testSetClassroomEmpty(String classroom) {
        onsiteCourse.setClassroom(classroom);  //Cambia el aula a un valor vacío.
        assertEquals(classroom, onsiteCourse.getClassroom());  //Verifica que el aula se haya actualizado correctamente.
    }
    @Order(5)
    @ParameterizedTest
    @NullSource  //Proporciona un valor nulo para la prueba.
    @DisplayName("Cambiar aula a valor nulo")
    void testSetClassroomNull(String classroom) {
        onsiteCourse.setClassroom(classroom);  //Cambia el aula a un valor nulo.
        assertEquals(classroom, onsiteCourse.getClassroom());  //Verifica que el aula se haya actualizado correctamente.
    }
    @Order(6)
    @ParameterizedTest
    @NullAndEmptySource  //Proporciona tanto un valor nulo como un valor vacío para la prueba.
    @DisplayName("Cambiar aula a valor nulo o vacío")
    void testSetClassroomNullAndEmpty(String classroom) {
        onsiteCourse.setClassroom(classroom);  //Cambia el aula a un valor nulo o vacío.
        assertEquals(classroom, onsiteCourse.getClassroom());  //Verifica que el aula se haya actualizado correctamente.
    }

    @Order(1)
    @ParameterizedTest
    @CsvSource({
            "10",
            "0",
            "-5"
    })
    @DisplayName("Validación de cupos (maxQuota) con distintos valores")
    void testSetMaxQuota(int cuota) {  //Llama al setter con distintos valores.
        onsiteCourse.setMaxQuota(cuota);

        if (cuota < 0) {  //Si el valor es negativo, lo convierte a 0.
            assertEquals(0, onsiteCourse.getMaxQuota(), "Valores negativos deben convertirse a 0");
        } else {  //Si el valor es válido, debe coincidir.
            assertEquals(cuota, onsiteCourse.getMaxQuota());
        }
    }

}
