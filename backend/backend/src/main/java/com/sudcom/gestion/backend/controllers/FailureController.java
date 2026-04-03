package com.sudcom.gestion.backend.controllers;

import com.sudcom.gestion.backend.dtos.requests.FailureRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.FailureResponseDTO;
import com.sudcom.gestion.backend.services.FailureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fallas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class FailureController {

    private final FailureService failureService;

    @GetMapping
    public List<FailureResponseDTO> getAll() {
        return failureService.findAll();
    }

    @PostMapping
    public ResponseEntity<FailureResponseDTO> create(@RequestBody FailureRequestDTO dto) {
        return ResponseEntity.ok(failureService.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FailureResponseDTO> getById(@PathVariable Long id) {
        FailureResponseDTO dto = failureService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        failureService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
