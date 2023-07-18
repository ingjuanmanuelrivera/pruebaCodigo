package com.dane.oti.prueba.prueba_dane.rest;

import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo3VisitaDTO;
import com.dane.oti.prueba.prueba_dane.service.ViajeCapitulo3VisitaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/viajeCapitulo3Visitas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViajeCapitulo3VisitaResource {

    private final ViajeCapitulo3VisitaService viajeCapitulo3VisitaService;

    public ViajeCapitulo3VisitaResource(
            final ViajeCapitulo3VisitaService viajeCapitulo3VisitaService) {
        this.viajeCapitulo3VisitaService = viajeCapitulo3VisitaService;
    }

    @GetMapping
    public ResponseEntity<List<ViajeCapitulo3VisitaDTO>> getAllViajeCapitulo3Visitas() {
        return ResponseEntity.ok(viajeCapitulo3VisitaService.findAll());
    }

    @GetMapping("/{idViajeCapitulo3Visita}")
    public ResponseEntity<ViajeCapitulo3VisitaDTO> getViajeCapitulo3Visita(
            @PathVariable final Long idViajeCapitulo3Visita) {
        return ResponseEntity.ok(viajeCapitulo3VisitaService.get(idViajeCapitulo3Visita));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createViajeCapitulo3Visita(
            @RequestBody @Valid final ViajeCapitulo3VisitaDTO viajeCapitulo3VisitaDTO) {
        return new ResponseEntity<>(viajeCapitulo3VisitaService.create(viajeCapitulo3VisitaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{idViajeCapitulo3Visita}")
    public ResponseEntity<Void> updateViajeCapitulo3Visita(
            @PathVariable final Long idViajeCapitulo3Visita,
            @RequestBody @Valid final ViajeCapitulo3VisitaDTO viajeCapitulo3VisitaDTO) {
        viajeCapitulo3VisitaService.update(idViajeCapitulo3Visita, viajeCapitulo3VisitaDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idViajeCapitulo3Visita}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteViajeCapitulo3Visita(
            @PathVariable final Long idViajeCapitulo3Visita) {
        viajeCapitulo3VisitaService.delete(idViajeCapitulo3Visita);
        return ResponseEntity.noContent().build();
    }

}
