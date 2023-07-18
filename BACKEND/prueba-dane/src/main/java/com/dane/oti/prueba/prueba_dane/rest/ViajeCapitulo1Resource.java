package com.dane.oti.prueba.prueba_dane.rest;

import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo1DTO;
import com.dane.oti.prueba.prueba_dane.service.ViajeCapitulo1Service;
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
@RequestMapping(value = "/api/viajeCapitulo1s", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViajeCapitulo1Resource {

    private final ViajeCapitulo1Service viajeCapitulo1Service;

    public ViajeCapitulo1Resource(final ViajeCapitulo1Service viajeCapitulo1Service) {
        this.viajeCapitulo1Service = viajeCapitulo1Service;
    }

    @GetMapping
    public ResponseEntity<List<ViajeCapitulo1DTO>> getAllViajeCapitulo1s() {
        return ResponseEntity.ok(viajeCapitulo1Service.findAll());
    }

    @GetMapping("/{idViajeCapitulo1}")
    public ResponseEntity<ViajeCapitulo1DTO> getViajeCapitulo1(
            @PathVariable final Long idViajeCapitulo1) {
        return ResponseEntity.ok(viajeCapitulo1Service.get(idViajeCapitulo1));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createViajeCapitulo1(
            @RequestBody @Valid final ViajeCapitulo1DTO viajeCapitulo1DTO) {
        return new ResponseEntity<>(viajeCapitulo1Service.create(viajeCapitulo1DTO), HttpStatus.CREATED);
    }

    @PutMapping("/{idViajeCapitulo1}")
    public ResponseEntity<Void> updateViajeCapitulo1(@PathVariable final Long idViajeCapitulo1,
            @RequestBody @Valid final ViajeCapitulo1DTO viajeCapitulo1DTO) {
        viajeCapitulo1Service.update(idViajeCapitulo1, viajeCapitulo1DTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idViajeCapitulo1}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteViajeCapitulo1(@PathVariable final Long idViajeCapitulo1) {
        viajeCapitulo1Service.delete(idViajeCapitulo1);
        return ResponseEntity.noContent().build();
    }

}
