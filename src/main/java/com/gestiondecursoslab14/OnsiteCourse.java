package com.gestiondecursoslab14;

public class OnsiteCourse extends Course{
    private String classroom;
    private int maxQuota;

    public OnsiteCourse(String title, int duration, String classroom, int maxQuota) {
        super(title, duration);
        this.classroom = classroom;
        setMaxQuota(maxQuota);
    }

    @Override
    public String showInformation() {
        String info = "[Onsite] " + getTitle() + " (" + getDuration() + " hr) - Room: " + classroom + ", MaxQuota: " + maxQuota;
        System.out.println(info);
        return info;
    }

    //Getters y setters.
    public String getClassroom() {
        return classroom;
    }
    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int getMaxQuota() {
        return maxQuota;
    }
    public void setMaxQuota(int maxQuota) {
        if (maxQuota < 0) {
            System.out.println( "El cupo no puede ser negatio. Se establecerá en 0.");
            this.maxQuota = 0;
        } else {
            this.maxQuota = maxQuota;
        }
    }
}
