package Escuelaing.edu.co.ParcialFinal.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "doctors")
public class Doctors {
    @MongoId
    private String id;
    private String name;
    private String description;
    private String profesion;
    private String located;

    public String getId() {return id; }

    public void setId(String id) {this.id = id;}

    public String getName() {return name; }

    public void setName(String name) {this.name = name;}

    public String getDescription() {return description; }
    public void setDescription(String description) {this.description = description;}

    public String getProfesion() {return profesion; }

    public void setProfesion(String profesion) {this.profesion = profesion; }

    public String getLocated() {return located;}
    public void setLocated(String located) {this.located = located;}
}
