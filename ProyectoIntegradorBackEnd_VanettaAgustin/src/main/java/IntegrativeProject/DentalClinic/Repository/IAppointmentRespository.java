package IntegrativeProject.DentalClinic.Repository;

import IntegrativeProject.DentalClinic.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRespository extends JpaRepository<Appointment, Integer> {
}
