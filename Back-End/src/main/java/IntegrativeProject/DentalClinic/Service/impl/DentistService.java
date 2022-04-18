package IntegrativeProject.DentalClinic.Service.impl;

import IntegrativeProject.DentalClinic.Dto.DentistDTO;
import IntegrativeProject.DentalClinic.Entities.Dentist;
import IntegrativeProject.DentalClinic.Repository.IDentistRepository;
import IntegrativeProject.DentalClinic.Service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistService implements IDentistService {

    @Autowired
    private IDentistRepository dentistRepository;
    @Autowired
    ObjectMapper objectMapper;


    @Override
    public DentistDTO findById(Integer id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDTO dentistDTO = null;
        if(dentist.isPresent())
            dentistDTO = objectMapper.convertValue(dentist, DentistDTO.class);
        return dentistDTO;
    }

    @Override
    public DentistDTO create(DentistDTO dentistDTO) {
       Dentist dentist = objectMapper.convertValue(dentistDTO, Dentist.class);
       dentist = dentistRepository.save(dentist);
       return dentistDTO;
    }

    @Override
    public void deleteById(Integer id) {
dentistRepository.deleteById(id);
    }

    @Override
    public DentistDTO update(DentistDTO dentistDTO) {
        Dentist dentist = objectMapper.convertValue(dentistDTO, Dentist.class);
        dentist = dentistRepository.save(dentist);
        return dentistDTO;
    }

    @Override
    public Set<DentistDTO> findAll() {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<DentistDTO> dentistDTOS = new HashSet<>();
        for (Dentist dentist : dentists) {
            dentistDTOS.add(objectMapper.convertValue(dentist, DentistDTO.class));
        }
        return dentistDTOS;
    }
}
