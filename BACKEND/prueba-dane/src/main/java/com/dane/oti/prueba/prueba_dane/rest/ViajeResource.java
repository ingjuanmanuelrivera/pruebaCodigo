package com.dane.oti.prueba.prueba_dane.rest;

import com.dane.oti.prueba.prueba_dane.model.ViajeDTO;
import com.dane.oti.prueba.prueba_dane.service.ViajeService;
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
@RequestMapping(value = "/api/viajes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViajeResource {

    private final ViajeService viajeService;

    public ViajeResource(final ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping
    public ResponseEntity<List<ViajeDTO>> getAllViajes() {
        return ResponseEntity.ok(viajeService.findAll());
    }

    @GetMapping("/{idViaje}")
    public ResponseEntity<ViajeDTO> getViaje(@PathVariable final Long idViaje) {
        return ResponseEntity.ok(viajeService.get(idViaje));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createViaje(@RequestBody @Valid final ViajeDTO viajeDTO) {
        return new ResponseEntity<>(viajeService.create(viajeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{idViaje}")
    public ResponseEntity<Void> updateViaje(@PathVariable final Long idViaje,
            @RequestBody @Valid final ViajeDTO viajeDTO) {
        viajeService.update(idViaje, viajeDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idViaje}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteViaje(@PathVariable final Long idViaje) {
        viajeService.delete(idViaje);
        return ResponseEntity.noContent().build();
    }

}
