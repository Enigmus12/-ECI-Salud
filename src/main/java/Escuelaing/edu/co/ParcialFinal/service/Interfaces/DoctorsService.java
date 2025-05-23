package Escuelaing.edu.co.ParcialFinal.service.Interfaces;

import Escuelaing.edu.co.ParcialFinal.dto.DoctorsDTO;
import Escuelaing.edu.co.ParcialFinal.model.Doctors;

import java.util.List;

public interface DoctorsService {
    Doctors createDoctors(DoctorsDTO doctorsDTO);
    List<Doctors> getDoctorsByProfesion(String profesion);
    List<Doctors> getAllDoctors();
}
