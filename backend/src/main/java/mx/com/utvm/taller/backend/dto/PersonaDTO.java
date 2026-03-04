
package mx.com.utvm.taller.backend.dto;

import java.time.LocalDate;

public record PersonaDTO(
    Long id, 
    String nombre, 
    String apellido, 
    LocalDate fechaNacimiento, 
    String mail
) {}