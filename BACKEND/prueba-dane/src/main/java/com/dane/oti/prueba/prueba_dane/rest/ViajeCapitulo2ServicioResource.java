package com.dane.oti.prueba.prueba_dane.rest;

import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo2ServicioDTO;
import com.dane.oti.prueba.prueba_dane.service.ViajeCapitulo2ServicioService;
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
@RequestMapping(value = "/api/viajeCapitulo2Servicios", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViajeCapitulo2ServicioResource {

    private final ViajeCapitulo2ServicioService viajeCapitulo2ServicioService;

    public ViajeCapitulo2ServicioResource(
            final ViajeCapitulo2ServicioService viajeCapitulo2ServicioService) {
        this.viajeCapitulo2ServicioService = viajeCapitulo2ServicioService;
    }

    @GetMapping
    public ResponseEntity<List<ViajeCapitulo2ServicioDTO>> getAllViajeCapitulo2Servicios() {
        return ResponseEntity.ok(viajeCapitulo2ServicioService.findAll());
    }

    @GetMapping("/{idViajeCapitulo2Servicio}")
    public ResponseEntity<ViajeCapitulo2ServicioDTO> getViajeCapitulo2Servicio(
            @PathVariable final Long idViajeCapitulo2Servicio) {
        return ResponseEntity.ok(viajeCapitulo2ServicioService.get(idViajeCapitulo2Servicio));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createViajeCapitulo2Servicio(
            @RequestBody @Valid final ViajeCapitulo2ServicioDTO viajeCapitulo2ServicioDTO) {
        return new ResponseEntity<>(viajeCapitulo2ServicioService.create(viajeCapitulo2ServicioDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{idViajeCapitulo2Servicio}")
    public ResponseEntity<Void> updateViajeCapitulo2Servicio(
            @PathVariable final Long idViajeCapitulo2Servicio,
            @RequestBody @Valid final ViajeCapitulo2ServicioDTO viajeCapitulo2ServicioDTO) {
        viajeCapitulo2ServicioService.update(idViajeCapitulo2Servicio, viajeCapitulo2ServicioDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idViajeCapitulo2Servicio}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteViajeCapitulo2Servicio(
            @PathVariable final Long idViajeCapitulo2Servicio) {
        viajeCapitulo2ServicioService.delete(idViajeCapitulo2Servicio);
        return ResponseEntity.noContent().build();
    }

}
