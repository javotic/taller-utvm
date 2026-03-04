
package mx.com.utvm.taller.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import mx.com.utvm.taller.backend.dto.PersonaDTO;
import mx.com.utvm.taller.backend.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
@CrossOrigin(origins = "*")
@Tag(name = "Directorio de Personas", description = "Endpoints para el CRUD (Crear, Leer, Actualizar, Eliminar) de personas.")
public class PersonaController {

    private final PersonaService service;

    // Inyección de dependencias manual (sin Lombok)
    public PersonaController(PersonaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Listar todas las personas", 
        description = "Devuelve un arreglo con todos los registros de personas existentes en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista recuperada exitosamente")
    public ResponseEntity<List<PersonaDTO>> listar() {
        return ResponseEntity.ok(service.obtenerTodas());
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Buscar persona por ID", 
        description = "Obtiene los detalles de una persona específica a través de su identificador único."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Persona encontrada"),
        @ApiResponse(responseCode = "404", description = "Persona no encontrada", content = @Content)
    })
    public ResponseEntity<PersonaDTO> obtenerPorId(
            @Parameter(description = "Identificador único de la persona", required = true, example = "1") 
            @PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    @Operation(
        summary = "Crear una nueva persona", 
        description = "Guarda un nuevo registro en la base de datos. Validará que el formato sea correcto y que el correo no esté duplicado."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Persona creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos o correo electrónico ya registrado", content = @Content)
    })
    public ResponseEntity<PersonaDTO> crear(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la persona a registrar", required = true)
            @RequestBody PersonaDTO personaDTO) {
        return new ResponseEntity<>(service.guardar(personaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(
        summary = "Actualizar persona existente", 
        description = "Modifica los datos de una persona previamente registrada usando su ID."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Persona actualizada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Persona no encontrada para actualizar", content = @Content)
    })
    public ResponseEntity<PersonaDTO> actualizar(
            @Parameter(description = "Identificador único de la persona a actualizar", required = true, example = "1") 
            @PathVariable Long id, 
            @RequestBody PersonaDTO personaDTO) {
        return ResponseEntity.ok(service.actualizar(id, personaDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Eliminar persona", 
        description = "Borra físicamente el registro de una persona de la base de datos."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Persona eliminada exitosamente (Sin contenido)"),
        @ApiResponse(responseCode = "404", description = "Persona no encontrada", content = @Content)
    })
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "Identificador único de la persona a eliminar", required = true, example = "1") 
            @PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}