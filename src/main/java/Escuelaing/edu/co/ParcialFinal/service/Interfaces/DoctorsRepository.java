package Escuelaing.edu.co.ParcialFinal.service.Interfaces;

import Escuelaing.edu.co.ParcialFinal.model.Doctors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  DoctorsRepository extends MongoRepository<Doctors,String> {
    List<Doctors> findByProfesion(String profesion);
}
