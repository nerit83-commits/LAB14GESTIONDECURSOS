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
 * Tests para la clase OnlineCourse:
 *Prueba del constructor.
 *Prueba de getters heredados (title, duration, professor).
 *Prueba del getter/setter propio: platform.
 *Incluye test individual y test parametrizado.
 *Ciclo de vida completo de JUnit: BeforeAll, AfterAll, BeforeEach y AfterEach.
 */


public class AppTestOnlineCourse {

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

    
    // TEST INDIVIDUAL
   
    @Test
    @DisplayName("Verifica que OnlineCourse se crea correctamente")
    void testConstructor() {
        assertNotNull(onlineCourse);  //Verifica que la instancia exista.
        assertEquals("Java Web", onlineCourse.getTitle());
        assertEquals(12, onlineCourse.getDuration());
        assertEquals("Mario Pérez", onlineCourse.getProfessor());
        assertEquals("Udemy", onlineCourse.getPlataform());
    }

   

    // TEST PARAMETRIZADO
   
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
