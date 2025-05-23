package Escuelaing.edu.co.ParcialFinal.service.Impl;

import Escuelaing.edu.co.ParcialFinal.dto.AppointmmentDTO;
import Escuelaing.edu.co.ParcialFinal.model.Appointment;
import Escuelaing.edu.co.ParcialFinal.model.Doctors;
import Escuelaing.edu.co.ParcialFinal.service.Interfaces.AppointmentRepository;
import Escuelaing.edu.co.ParcialFinal.service.Interfaces.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppointmenServicetImpl implements AppointmentService {


    @Autowired
    private AppointmentRepository appointmentRepository ;

    @Override
    public Appointment createAppointment(AppointmmentDTO appointmmentDTO) {

        validateAppointmentRequest(appointmmentDTO);

        Appointment appointment = new Appointment();
        appointment.setName(appointmmentDTO.getName());
        appointment.setIdentificacion(appointmmentDTO.getIdentificacion());
        appointment.setEmail(appointmmentDTO.getEmail());
        appointment.setDate(appointmmentDTO.getDate());

        return appointmentRepository.save(appointment);
    }

    private void validateAppointmentRequest(AppointmmentDTO appointmmentDTO) {
        // Validar name
        if (appointmmentDTO.getName() == null || appointmmentDTO.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("El Nombre del Doctor es requerido");
        }

        // Validar description
        if (appointmmentDTO.getIdentificacion() == null || appointmmentDTO.getIdentificacion() <= 0) {
            throw new IllegalArgumentException("La identificacion debe tener valores");
        }

        // Validar profesion
        if (appointmmentDTO.getEmail() == null || appointmmentDTO.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("La Profesion del Doctor debe de ser requerida");
        }
    }

    @Override
    public List<Appointment> getAppointmentsByName(String name) {
        return appointmentRepository.findByName(name);
    }

    @Override
    public List<Appointment> getAlLAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void deleteAppointment(String name){
        appointmentRepository.deleteByName(name);
    }
}
