package com.gestiondecursoslab14;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


/*
*CourseTest.java
*Testea constructor, getters, showInformation
*1 test parametrizado 
*1 test normal (test individual)
*1 uso completo del ciclo de vida de JUnit (BeforeAll, AfterAll, BeforEach y AfterEach)
*/

public class AppTestCourse { 
 
    private Course course;

    //CICLO DE VIDA

    @BeforeAll  //Se ejecuta solo una vez antes de todos los test.
    static void beforeAll() {
        System.out.println("Iniciando AppTest...");
    }

    @AfterAll  ////Se ejecuta solo una vez después de todos los test.
    static void afterAll() {
        System.out.println("Finalizando AppTest...");
    }

    @BeforeEach  //Se ejecuta antes de cada test y sirve para iniciar una instancia fresca.
    void setUp() {
        System.out.println("BeforeEach → creando instancia de Course");
        course = new Course("Intro a Java", 8);
    }

    @AfterEach //Se ejecuta después de cada test y evita interferencia entre pruebas.
    void tearDown() {
        System.out.println("AfterEach → limpiando instancia");
        course = null;
    }

    //TEST INDIVIDUAL
    @Test
    @DisplayName("Constructor crea correctamente un objeto Course")
    void testCourseNotNull() {
        assertNotNull(course);  //Verifica que el objeto se haya creado.
        assertEquals("Intro a Java", course.getTitle());  //Verifica los valores del constructor.
        assertEquals(8, course.getDuration());
    }


    //TEST PARAMETRIZADO
    @ParameterizedTest
    @ValueSource(strings = {"Python", "Git", "Docker"})
    @DisplayName("Asignación de diferentes títulos de curso")
    void testSetTitle(String title) {
        course.setTitle(title);  //Cambia el título usando valores distintos.
        assertEquals(title, course.getTitle());  //Verifica que el setter actualiza el valor correctamente.
    }
}


