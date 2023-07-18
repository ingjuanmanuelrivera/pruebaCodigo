package com.dane.oti.prueba.prueba_dane.rest;

import com.dane.oti.prueba.prueba_dane.model.ViajeCapitulo2DTO;
import com.dane.oti.prueba.prueba_dane.service.ViajeCapitulo2Service;
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
@RequestMapping(value = "/api/viajeCapitulo2s", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViajeCapitulo2Resource {

    private final ViajeCapitulo2Service viajeCapitulo2Service;

    public ViajeCapitulo2Resource(final ViajeCapitulo2Service viajeCapitulo2Service) {
        this.viajeCapitulo2Service = viajeCapitulo2Service;
    }

    @GetMapping
    public ResponseEntity<List<ViajeCapitulo2DTO>> getAllViajeCapitulo2s() {
        return ResponseEntity.ok(viajeCapitulo2Service.findAll());
    }

    @GetMapping("/{idCapitulo2}")
    public ResponseEntity<ViajeCapitulo2DTO> getViajeCapitulo2(
            @PathVariable final Long idCapitulo2) {
        return ResponseEntity.ok(viajeCapitulo2Service.get(idCapitulo2));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createViajeCapitulo2(
            @RequestBody @Valid final ViajeCapitulo2DTO viajeCapitulo2DTO) {
        return new ResponseEntity<>(viajeCapitulo2Service.create(viajeCapitulo2DTO), HttpStatus.CREATED);
    }

    @PutMapping("/{idCapitulo2}")
    public ResponseEntity<Void> updateViajeCapitulo2(@PathVariable final Long idCapitulo2,
            @RequestBody @Valid final ViajeCapitulo2DTO viajeCapitulo2DTO) {
        viajeCapitulo2Service.update(idCapitulo2, viajeCapitulo2DTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idCapitulo2}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteViajeCapitulo2(@PathVariable final Long idCapitulo2) {
        viajeCapitulo2Service.delete(idCapitulo2);
        return ResponseEntity.noContent().build();
    }

}
