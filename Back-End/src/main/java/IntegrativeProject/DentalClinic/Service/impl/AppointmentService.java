package IntegrativeProject.DentalClinic.Service.impl;

import IntegrativeProject.DentalClinic.DTO.AppointmentDTO;
import IntegrativeProject.DentalClinic.Entities.Appointment;
import IntegrativeProject.DentalClinic.Repository.IAppointmentRespository;
import IntegrativeProject.DentalClinic.Service.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private IAppointmentRespository appointmentRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public AppointmentDTO findById(Integer id) {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDTO appointmentDTO = null;
        if(appointment.isPresent())
            appointmentDTO = objectMapper.convertValue(appointment, AppointmentDTO.class);
        return appointmentDTO;
    }

    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        Appointment appointment = objectMapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
        return appointmentDTO;
    }

    @Override
    public void deleteById(Integer id) {
        appointmentRepository.deleteById(id);

    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        Appointment appointment = objectMapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
        return appointmentDTO;
    }

    @Override
    public Set<AppointmentDTO> findAll() {
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        List<Appointment> appointments = appointmentRepository.findAll();
        Set<AppointmentDTO> appointmentDTOS = new HashSet<>();
        for (Appointment appointment : appointments) {
            appointmentDTOS.add(objectMapper.convertValue(appointment, AppointmentDTO.class));
        }
        return appointmentDTOS;
    }
}
