PROBLEMAS ENCONTRADOS EN EL DESARROLLO DEL LAB 14:

"NO SE MOSTRABAN LOS TEST CORRIDOS EN MAVEN, CLEAN OK, COMPILE OK, PERO TEST NADA"
Maven Surefire por defecto detecta tests con patrones específicos. Tenía clases llamadas AppTestCourse (por ejemplo), que no se ajustan al patrón por defecto. Por eso no se mostraban.
Se crearon las clases test correctamente con nombres *Test.java (naming estándar).Por ejemplo OnlineCourseTest.java
Se eliminaron los archivos antiguos para no tener doble ejecución/ambigüedad.
También copilot sugirió usar Surefire 3.0.0 recomendable con JUnit 5 (Jupiter) moderno.

ACCIONES:
Eliminé las clases antiguas de pruebas:
AppTestCourse.java
AppTestOnlineCourse.java
AppTestOnsiteCourse.java
Creé las pruebas con nombres estándar de Surefire:
CourseTest.java
OnlineCourseTest.java
OnsiteCourseTest.java
Actualicé pom.xml:
Añadí maven-surefire-plugin 3.0.0 en <build><plugins>.
Ajusté includes para usar los patrones por defecto **/*Test.java, **/*Tests.java, **/*TestCase.java, **/Test*.java.
Retiré **/AppTest*.java del patrón para evitar que los tests viejos (si existiesen) se ejecutaran.
