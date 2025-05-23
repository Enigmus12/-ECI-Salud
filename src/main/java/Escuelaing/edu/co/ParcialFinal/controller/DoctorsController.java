package Escuelaing.edu.co.ParcialFinal.controller;


import Escuelaing.edu.co.ParcialFinal.dto.DoctorsDTO;
import Escuelaing.edu.co.ParcialFinal.model.Doctors;
import Escuelaing.edu.co.ParcialFinal.service.Interfaces.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors-service")
@CrossOrigin(origins = "*")
public class DoctorsController {


    @Autowired
    private DoctorsService doctorsService;

    @PostMapping("/Make")
    public ResponseEntity<?> makeDoctors(@RequestBody DoctorsDTO request) {
        try {
            Doctors doctors = doctorsService.createDoctors(request);
            return ResponseEntity.ok(doctors);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor");
        }
    }

    @GetMapping("/{profesion}")
    public ResponseEntity<List<Doctors>> getDoctors(@PathVariable String profesion) {
        return ResponseEntity.ok(doctorsService.getDoctorsByProfesion(profesion));
    }

    @GetMapping("/All")
    public ResponseEntity<List<Doctors>> getAllDoctors() {
        return ResponseEntity.ok(doctorsService.getAllDoctors());
    }
}
