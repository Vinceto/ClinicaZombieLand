package com.de.clinicazombieland.controller;
import com.de.clinicazombieland.entity.Paciente;
import com.de.clinicazombieland.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public String listPacientes(Model model) {
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        model.addAttribute("pacientes", pacientes);
        return "pacientes/list";
    }

    @GetMapping("/nuevo")
    public String showNuevoForm(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "pacientes/form";
    }

    @PostMapping
    public String savePaciente(@ModelAttribute Paciente paciente) {
        pacienteService.savePaciente(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteService.getPacienteById(id).orElse(null);
        model.addAttribute("paciente", paciente);
        return "pacientes/form";
    }

    @PostMapping("/actualizar/{id}")
    public String updatePaciente(@PathVariable Long id, @ModelAttribute Paciente paciente) {
        pacienteService.updatePaciente(id, paciente);
        return "redirect:/pacientes";
    }

    @GetMapping("/eliminar/{id}")
    public String deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return "redirect:/pacientes";
    }
}
