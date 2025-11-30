package com.gestiondecursoslab14;

/*Academia con cursos online y onsite.

 * Atributos generales: 
 * - tipo de curso (online u Onsite)
 * - título del curso
 * - duración en horas
 * - profesor
 * 
 * Atributos específicos:
 * - plataforma online
 * - aula y cupo maximo para onsite
 * 
 * Guardar cada curso en una lista con arraylist
 * Curso [] cursos = new
 * Curso [cantidad];
 * 
 * Imprimir información de todos los cursos 
 * usando for each en la lista de cursos. 
 */

public class Course {
    
    private String title; 
    private int duration;
    private String professor;
    private String plataform;
    private int room;
    private int maxQuota;


    //Constructor con atributos generales sin profesor.
    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
        this.professor = "unassigned";
    }

    //Constructor con atributos completo.
    public Course(String title, int duration, String professor, String plataform, int room, int maxQuota) {
        this.title = title;
        this.duration = duration;
        this.professor = professor; //ver tiene que ser "unassigned"
        this.plataform = plataform;
        this.room = room;
        this.maxQuota = maxQuota;
    }

    //Método que se sobreescribirá.
    public String showInformation() {
        String info = "[Course] " + title + " (" + duration + " hr) - Professor: " + professor;
        System.out.println(info);
        return info;
    }

    //Definir getter y settter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
   
    public String getProfessor() {
        return professor;
    }
    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
    public String getPlataform() {
        return plataform;
    }
    public void setPlataform(String plataform) {
        this.plataform = plataform;
    }
   
    public int getRoom() {
        return room;
    }
    public void setRoom(int room) {
        this.room = room;
    }
   
    public int getMaxQuota() {
        return maxQuota;
    }
    public void setMaxQuota(int maxQuota) {
        this.maxQuota = maxQuota;
    }
   
    
    
}
