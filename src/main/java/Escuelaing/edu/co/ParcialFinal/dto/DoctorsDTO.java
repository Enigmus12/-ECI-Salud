package Escuelaing.edu.co.ParcialFinal.dto;

import lombok.Data;

@Data
public class DoctorsDTO {
    private String name;
    private String description;
    private String profesion;
    private String located;

    public String getName() {return name; }

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description; }
    public void setDescription(String description) {this.description = description;}

    public String getProfesion() {return profesion; }

    public void setProfesion(String profesion) {this.profesion = profesion; }

    public String getLocated() {return located;}
    public void setLocated(String located) {this.located = located;}

}
