package Escuelaing.edu.co.ParcialFinal.service.Interfaces;

import Escuelaing.edu.co.ParcialFinal.dto.AppointmmentDTO;
import Escuelaing.edu.co.ParcialFinal.model.Appointment;


import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(AppointmmentDTO appointmmentDTO);
    List<Appointment> getAppointmentsByName(String name);
    List<Appointment> getAlLAppointments();
    void deleteAppointment(String name);
}
