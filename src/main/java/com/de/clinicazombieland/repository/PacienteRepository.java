package com.de.clinicazombieland.repository;
import com.de.clinicazombieland.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
