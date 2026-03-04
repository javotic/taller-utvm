package mx.com.utvm.taller.backend.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import mx.com.utvm.taller.backend.dto.PersonaDTO;
import mx.com.utvm.taller.backend.model.Persona;
import mx.com.utvm.taller.backend.repository.PersonaRepository;

@Service
public class PersonaService {

    private final PersonaRepository repository;

    public PersonaService(PersonaRepository repository) {
        this.repository = repository;
    }

    public List<PersonaDTO> obtenerTodas() {
        return repository.findAll().stream()
                .map(this::convertirADto)
                .collect(Collectors.toList());
    }

    public PersonaDTO obtenerPorId(Long id) {
        return repository.findById(id)
                .map(this::convertirADto)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + id));
    }

    public PersonaDTO guardar(PersonaDTO dto) {
        Persona persona = convertirAEntidad(dto);
        Persona guardada = repository.save(persona);
        return convertirADto(guardada);
    }

    public PersonaDTO actualizar(Long id, PersonaDTO dto) {
        Persona existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + id));

        existente.setNombre(dto.nombre());
        existente.setApellido(dto.apellido());
        existente.setFechaNacimiento(dto.fechaNacimiento());
        existente.setMail(dto.mail());

        return convertirADto(repository.save(existente));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    // Métodos auxiliares de mapeo (En un proyecto más grande podrías usar MapStruct)
    private PersonaDTO convertirADto(Persona p) {
        return new PersonaDTO(p.getId(), p.getNombre(), p.getApellido(), p.getFechaNacimiento(), p.getMail());
    }

    private Persona convertirAEntidad(PersonaDTO dto) {
        Persona p = new Persona();
        p.setNombre(dto.nombre());
        p.setApellido(dto.apellido());
        p.setFechaNacimiento(dto.fechaNacimiento());
        p.setMail(dto.mail());
        return p;
    }
}
