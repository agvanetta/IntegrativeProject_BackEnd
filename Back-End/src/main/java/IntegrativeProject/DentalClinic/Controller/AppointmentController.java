package IntegrativeProject.DentalClinic.Controller;

import IntegrativeProject.DentalClinic.Dto.AppointmentDTO;
import IntegrativeProject.DentalClinic.Service.impl.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO appointment = appointmentService.create(appointmentDTO);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<AppointmentDTO>  findAppointmentById(@PathVariable Integer id) {
        AppointmentDTO appointmentDTO = appointmentService.findById(id);
        return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AppointmentDTO appointmentDTO) {
        appointmentService.update(appointmentDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        appointmentService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<Collection<AppointmentDTO>> findAll() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

}
