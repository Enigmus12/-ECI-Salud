package Escuelaing.edu.co.ParcialFinal.service.Impl;

import Escuelaing.edu.co.ParcialFinal.dto.DoctorsDTO;
import Escuelaing.edu.co.ParcialFinal.model.Doctors;
import Escuelaing.edu.co.ParcialFinal.service.Interfaces.DoctorsRepository;
import Escuelaing.edu.co.ParcialFinal.service.Interfaces.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DoctorsServiceImpl implements DoctorsService {

    @Autowired
    private DoctorsRepository doctorsRepository;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public Doctors createDoctors(DoctorsDTO doctorsDTO) {

        validateDoctorsRequest(doctorsDTO);

        Doctors doctors = new Doctors();
        doctors.setName(doctorsDTO.getName());
        doctors.setDescription(doctorsDTO.getDescription());
        doctors.setProfesion(doctorsDTO.getProfesion());
        doctors.setLocated(doctorsDTO.getLocated());

        return doctorsRepository.save(doctors);
    }

    private void validateDoctorsRequest(DoctorsDTO doctorsDTO) {
        // Validar name
        if (doctorsDTO.getName() == null || doctorsDTO.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("El Nombre del Doctor es requerido");
        }

        // Validar description
        if (doctorsDTO.getDescription() == null || doctorsDTO.getDescription().isEmpty()) {
            throw new IllegalArgumentException("La descripcion del Doctor es requerida");
        }

        // Validar profesion
        if (doctorsDTO.getProfesion() == null || doctorsDTO.getProfesion().trim().isEmpty()) {
            throw new IllegalArgumentException("La Profesion del Doctor debe de ser requerida");
        }

        // Validar located
        if (doctorsDTO.getLocated() == null || doctorsDTO.getLocated().trim().isEmpty()) {
            throw new IllegalArgumentException("La Ubicacion es requerida");
        }
    }

    @Override
    public List<Doctors> getDoctorsByProfesion(String profesion) {
        return doctorsRepository.findByProfesion(profesion);
    }

    @Override
    public List<Doctors> getAllDoctors() {
        return doctorsRepository.findAll();
    }
}
