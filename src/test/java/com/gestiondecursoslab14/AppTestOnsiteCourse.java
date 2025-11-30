package com.gestiondecursoslab14;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


/*
*Test individual: crea OnsiteCourse y verifica título, duración, aula y cupo → OK
*Test parametrizado: prueba cupos: 10, 0 y -5, Verifica comportamiento especial para cupos negativos (tu clase los pone en 0)
*Ciclo de vida del test: BeforeAll (mensaje inicial), AfterAll (mensaje final), BeforeEach (crea una instancia nueva) y 
*AfterEach (limpia la instancia)
*/



public class AppTestOnsiteCourse {

    private OnsiteCourse onsiteCourse;

    // CICLO DE VIDA

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

    
    // TEST INDIVIDUAL

    @Test
    @DisplayName("Constructor crea correctamente el OnsiteCourse")
    void testConstructor() {
        assertNotNull(onsiteCourse);  //Verifica que la instancia no sea nula.

        assertEquals("Cocina Básica", onsiteCourse.getTitle());
        assertEquals(6, onsiteCourse.getDuration());
        assertEquals("A-12", onsiteCourse.getClassroom());
        assertEquals(20, onsiteCourse.getMaxQuota());
    }

 
    // TEST PARAMETRIZADO

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
