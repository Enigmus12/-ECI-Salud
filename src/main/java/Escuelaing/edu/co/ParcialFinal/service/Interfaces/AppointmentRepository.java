package Escuelaing.edu.co.ParcialFinal.service.Interfaces;

import Escuelaing.edu.co.ParcialFinal.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment,String> {
    List<Appointment> findByName(String name);
    void deleteByName(String name);
}
