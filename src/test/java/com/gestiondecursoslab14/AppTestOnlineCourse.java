package com.gestiondecursoslab14;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;


/*
*Identificar 1 test y Reescribilor usando @ParameterizedTest con:
*@MethodSource (idealmente uno que necesite múltiples parámetros o lógica 
personalizada)
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

    
    // TEST INDIVIDUAL QUE SE PUEDE PARAMETRIZAR
   
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

    /* 
    @Test
    @DisplayName("Verifica que OnlineCourse se crea correctamente")
    void testConstructor() {
        assertNotNull(onlineCourse);  //Verifica que la instancia exista.
        assertEquals("Java Web", onlineCourse.getTitle());
        assertEquals(12, onlineCourse.getDuration());
        assertEquals("Mario Pérez", onlineCourse.getProfessor());
        assertEquals("Udemy", onlineCourse.getPlataform());
    }
    */
   

    //TEST @EMPTYSOURCE, @NULLSOURCE o @NULLANDEMPTYSOURCE
    @ParameterizedTest
    @EmptySource  //Proporciona un valor vacío para la prueba.
    @DisplayName("Cambiar plataforma a valor vacío")
    void testSetPlataformEmpty(String plataforma) {
        onlineCourse.setPlataform(plataforma);  //Cambia la plataforma a un valor vacío.
        assertEquals(plataforma, onlineCourse.getPlataform());  //Verifica que el cambio se aplicó correctamente.
    }

    @ParameterizedTest
    @NullSource  //Proporciona un valor nulo para la prueba.
    @DisplayName("Cambiar plataforma a valor nulo")
    void testSetPlataformNull(String plataforma) {
        onlineCourse.setPlataform(plataforma);  //Cambia la plataforma a un valor nulo.
        assertEquals(plataforma, onlineCourse.getPlataform());  //Verifica que el cambio se aplicó correctamente.
    }

    @ParameterizedTest
    @NullAndEmptySource  //Proporciona tanto un valor nulo como un valor vacío para la prueba.
    @DisplayName("Cambiar plataforma a valor nulo o vacío")
    void testSetPlataformNullAndEmpty(String plataforma) {
        onlineCourse.setPlataform(plataforma);  //Cambia la plataforma a un valor nulo o vacío.
        assertEquals(plataforma, onlineCourse.getPlataform());  //Verifica que el cambio se aplicó correctamente.
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
