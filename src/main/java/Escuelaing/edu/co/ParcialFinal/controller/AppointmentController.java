package Escuelaing.edu.co.ParcialFinal.controller;

import Escuelaing.edu.co.ParcialFinal.dto.AppointmmentDTO;

import Escuelaing.edu.co.ParcialFinal.model.Appointment;
import Escuelaing.edu.co.ParcialFinal.service.Interfaces.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointement-service")
@CrossOrigin(origins = "*")
public class AppointmentController {


    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/Make")
    public ResponseEntity<?> makeAppointment(@RequestBody AppointmmentDTO request) {
        try {
            Appointment appointment = appointmentService.createAppointment(request);
            return ResponseEntity.ok(appointment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor");
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Appointment>> getAppointments(@PathVariable String name) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByName(name));
    }

    @GetMapping("/All")
    public ResponseEntity<List<Appointment>> getAllAppointment() {
        return ResponseEntity.ok(appointmentService.getAlLAppointments());
    }

    @DeleteMapping("/delete/{name}")
    public List<Appointment> deleteAppointment(@PathVariable String name) {
        appointmentService.deleteAppointment(name);
        return appointmentService.getAlLAppointments();
    }

}
