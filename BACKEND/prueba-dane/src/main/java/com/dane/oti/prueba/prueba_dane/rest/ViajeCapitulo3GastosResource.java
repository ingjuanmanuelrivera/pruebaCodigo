package com.dane.oti.prueba.prueba_dane.rest;

import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo3GastosDTO;
import com.dane.oti.prueba.prueba_dane.service.ViajeCapitulo3GastosService;
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
@RequestMapping(value = "/api/viajeCapitulo3Gastoss", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViajeCapitulo3GastosResource {

    private final ViajeCapitulo3GastosService viajeCapitulo3GastosService;

    public ViajeCapitulo3GastosResource(
            final ViajeCapitulo3GastosService viajeCapitulo3GastosService) {
        this.viajeCapitulo3GastosService = viajeCapitulo3GastosService;
    }

    @GetMapping
    public ResponseEntity<List<ViajeCapitulo3GastosDTO>> getAllViajeCapitulo3Gastoss() {
        return ResponseEntity.ok(viajeCapitulo3GastosService.findAll());
    }

    @GetMapping("/{idViajeCapitulo3Gastos}")
    public ResponseEntity<ViajeCapitulo3GastosDTO> getViajeCapitulo3Gastos(
            @PathVariable final Long idViajeCapitulo3Gastos) {
        return ResponseEntity.ok(viajeCapitulo3GastosService.get(idViajeCapitulo3Gastos));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createViajeCapitulo3Gastos(
            @RequestBody @Valid final ViajeCapitulo3GastosDTO viajeCapitulo3GastosDTO) {
        return new ResponseEntity<>(viajeCapitulo3GastosService.create(viajeCapitulo3GastosDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{idViajeCapitulo3Gastos}")
    public ResponseEntity<Void> updateViajeCapitulo3Gastos(
            @PathVariable final Long idViajeCapitulo3Gastos,
            @RequestBody @Valid final ViajeCapitulo3GastosDTO viajeCapitulo3GastosDTO) {
        viajeCapitulo3GastosService.update(idViajeCapitulo3Gastos, viajeCapitulo3GastosDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idViajeCapitulo3Gastos}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteViajeCapitulo3Gastos(
            @PathVariable final Long idViajeCapitulo3Gastos) {
        viajeCapitulo3GastosService.delete(idViajeCapitulo3Gastos);
        return ResponseEntity.noContent().build();
    }

}
