package com.gestiondecursoslab14;

public class OnlineCourse extends Course {
    private String plataform;

    public OnlineCourse(String title, int duration, String professor, String plataform) {
        super(title, duration);
        setProfessor(professor);
        this.plataform = plataform;
    }
    @Override
    public String showInformation() {
        String info = "[Online] " + getTitle() + " (" + getDuration() + " hr) - Professor: " + getProfessor() + " - Plataform: " + plataform;
        System.out.println(info);
        return info;
    }

    //Getters y setters
    public String getPlataform() {
        return plataform;
    }
    public void setPlataform(String plataform){
        this.plataform = plataform;
    }
}