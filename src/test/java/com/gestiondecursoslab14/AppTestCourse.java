package com.gestiondecursoslab14;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;



/*
*CourseTest.java
*Testea constructor, getters, showInformation
*1 test parametrizado 
*1 test normal (test individual)
*1 uso completo del ciclo de vida de JUnit (BeforeAll, AfterAll, BeforEach y AfterEach)
*/

/*
*Parte 2: Tests con valores nulos o vacíos
*Modifica o Agregá al menos un test utilizando alguna de las siguientes anotaciones:
*@EmptySource
*@NullSource
*@NullAndEmptySource
*Si es necesario agregar logica algun metodo de los set para que les soporte un 
*valor nulo, o que el test espere un error. 
*/

/* 
*Parte 3: Orden de ejecución
*Anotá una de las clases de test con @TestMethodOrder .
*Elegí una de las siguientes estrategias:
*OrderAnnotation.class (y usá @Order(n) ), MethodName.class, DisplayName.class
*Asegurate de tener al menos 3 métodos con orden definido.
*Aunque no es buena práctica depender del orden, este ejercicio es útil 
para comprender cómo configurarlo cuando sea necesario.
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

    //TEST @EMPTYSOURCE, @NULLSOURCE o @NULLANDEMPTYSOURCE
    @ParameterizedTest
    @EmptySource  //Provee solo valores vacíos al test.
    @DisplayName("Asignación de títulos vacíos")
    void testSetTitleEmpty(String title) {
        course.setTitle(title);  //Intenta asignar un título vacío.
        assertEquals(title, course.getTitle());  //Verifica que el título se haya asignado correctamente.
    }
    
    @ParameterizedTest
    @NullAndEmptySource  //Provee valores nulos y vacíos al test.
    @DisplayName("Asignación de títulos nulos o vacíos")
    void testSetTitleNullOrEmpty(String title) {
        course.setTitle(title);  //Intenta asignar un título nulo o vacío.
        assertEquals(title, course.getTitle());  //Verifica que el título se haya asignado correctamente.
    }

    @ParameterizedTest
    @NullSource  //Provee solo valores nulos al test.
    @DisplayName("Asignación de títulos nulos")
    void testSetTitleNull(String title) {
        course.setTitle(title);  //Intenta asignar un título nulo.
        assertEquals(title, course.getTitle());  //Verifica que el título se haya asignado correctamente.
    }

    /* 
    //TEST INDIVIDUAL
    @Test
    @DisplayName("Constructor crea correctamente un objeto Course")
    void testCourseNotNull() {
        assertNotNull(course);  //Verifica que el objeto se haya creado.
        assertEquals("Intro a Java", course.getTitle());  //Verifica los valores del constructor.
        assertEquals(8, course.getDuration());
    }
    */

    //TEST PARAMETRIZADO
    @ParameterizedTest
    @ValueSource(strings = {"Python", "Git", "Docker"})
    @DisplayName("Asignación de diferentes títulos de curso")
    void testSetTitle(String title) {
        course.setTitle(title);  //Cambia el título usando valores distintos.
        assertEquals(title, course.getTitle());  //Verifica que el setter actualiza el valor correctamente.
    }
}


