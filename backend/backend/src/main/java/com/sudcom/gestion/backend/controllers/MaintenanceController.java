package com.sudcom.gestion.backend.controllers;

import com.sudcom.gestion.backend.dtos.requests.MaintenanceRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.MaintenanceResponseDTO;
import com.sudcom.gestion.backend.services.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mantenimientos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @GetMapping
    public List<MaintenanceResponseDTO> getAll() {
        return maintenanceService.findAll();
    }

    @PostMapping
    public ResponseEntity<MaintenanceResponseDTO> create(@RequestBody MaintenanceRequestDTO dto) {
        return ResponseEntity.ok(maintenanceService.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceResponseDTO> getById(@PathVariable Long id) {
        MaintenanceResponseDTO dto = maintenanceService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        maintenanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
