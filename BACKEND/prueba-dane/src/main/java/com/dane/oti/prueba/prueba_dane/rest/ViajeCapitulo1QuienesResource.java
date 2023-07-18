package com.dane.oti.prueba.prueba_dane.rest;

import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo1QuienesDTO;
import com.dane.oti.prueba.prueba_dane.service.ViajeCapitulo1QuienesService;
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
@RequestMapping(value = "/api/viajeCapitulo1Quieness", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViajeCapitulo1QuienesResource {

    private final ViajeCapitulo1QuienesService viajeCapitulo1QuienesService;

    public ViajeCapitulo1QuienesResource(
            final ViajeCapitulo1QuienesService viajeCapitulo1QuienesService) {
        this.viajeCapitulo1QuienesService = viajeCapitulo1QuienesService;
    }

    @GetMapping
    public ResponseEntity<List<ViajeCapitulo1QuienesDTO>> getAllViajeCapitulo1Quieness() {
        return ResponseEntity.ok(viajeCapitulo1QuienesService.findAll());
    }

    @GetMapping("/{idCapitulo1Quines}")
    public ResponseEntity<ViajeCapitulo1QuienesDTO> getViajeCapitulo1Quienes(
            @PathVariable final Long idCapitulo1Quines) {
        return ResponseEntity.ok(viajeCapitulo1QuienesService.get(idCapitulo1Quines));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createViajeCapitulo1Quienes(
            @RequestBody @Valid final ViajeCapitulo1QuienesDTO viajeCapitulo1QuienesDTO) {
        return new ResponseEntity<>(viajeCapitulo1QuienesService.create(viajeCapitulo1QuienesDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{idCapitulo1Quines}")
    public ResponseEntity<Void> updateViajeCapitulo1Quienes(
            @PathVariable final Long idCapitulo1Quines,
            @RequestBody @Valid final ViajeCapitulo1QuienesDTO viajeCapitulo1QuienesDTO) {
        viajeCapitulo1QuienesService.update(idCapitulo1Quines, viajeCapitulo1QuienesDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idCapitulo1Quines}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteViajeCapitulo1Quienes(
            @PathVariable final Long idCapitulo1Quines) {
        viajeCapitulo1QuienesService.delete(idCapitulo1Quines);
        return ResponseEntity.noContent().build();
    }

}
