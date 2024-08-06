package com.de.clinicazombieland.service;

import com.de.clinicazombieland.entity.Paciente;
import com.de.clinicazombieland.repository.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PacienteService {
    private static final Logger logger = LoggerFactory.getLogger(PacienteService.class);
    @Autowired
    private PacienteRepository pacienteRepository;
    // read
    public List<Paciente> getAllPacientes() {
        logger.info("Listando todos los pacientes");
        return pacienteRepository.findAll();
    }
    // read by id
    public Optional<Paciente> getPacienteById(Long id) {
        logger.info("Buscando paciente com ID {}", id);
        return pacienteRepository.findById(id);
    }
    // create
    public Paciente savePaciente(Paciente paciente) {
        logger.info("Guardando paciente: {}", paciente.getNombre());
        return pacienteRepository.save(paciente);
    }
    // update
    public Paciente updatePaciente(Long id, Paciente pacienteDetails) {
        logger.info("Actualizando paciente: {}", pacienteDetails.getNombre());
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
        paciente.setNombre(pacienteDetails.getNombre());
        paciente.setCedula(pacienteDetails.getCedula());
        paciente.setDireccion(pacienteDetails.getCedula());
        paciente.setPrevision(pacienteDetails.getPrevision());
        paciente.setContacto(pacienteDetails.getContacto());
        return pacienteRepository.save(paciente);
    }
    // delete
    public void deletePaciente(Long id) {
        logger.info("Eliminando paciente: {}", id);
        pacienteRepository.deleteById(id);
    }
}
