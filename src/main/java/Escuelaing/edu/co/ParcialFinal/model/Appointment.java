package Escuelaing.edu.co.ParcialFinal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "appointment")
public class Appointment {
    private String id;
    private String name;
    private Integer Identificacion;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    public String getId() {return id; }
    public void setId(String id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Integer getIdentificacion() {return Identificacion; }
    public void setIdentificacion(Integer identificacion) {this.Identificacion = identificacion; }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public LocalDate getDate() {return date; }
    public void setDate(LocalDate date) {this.date = date;}
}
