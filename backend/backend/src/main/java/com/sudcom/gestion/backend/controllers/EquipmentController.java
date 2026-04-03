package com.sudcom.gestion.backend.controllers;

import com.sudcom.gestion.backend.dtos.requests.EquipmentRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.EquipmentResponseDTO;
import com.sudcom.gestion.backend.services.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public List<EquipmentResponseDTO> getAll() {
        return equipmentService.findAll();
    }

    @PostMapping
    public ResponseEntity<EquipmentResponseDTO> create(@RequestBody EquipmentRequestDTO dto) {
        return ResponseEntity.ok(equipmentService.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentResponseDTO> getById(@PathVariable Long id) {
        EquipmentResponseDTO dto = equipmentService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipmentResponseDTO> update(@PathVariable Long id, @RequestBody EquipmentRequestDTO dto) {
        EquipmentResponseDTO updated = equipmentService.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        equipmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
