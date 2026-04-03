package com.sudcom.gestion.backend.controllers;

import com.sudcom.gestion.backend.dtos.requests.ReportRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.ReportResponseDTO;
import com.sudcom.gestion.backend.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    public List<ReportResponseDTO> getAll() {
        return reportService.findAll();
    }

    @PostMapping
    public ResponseEntity<ReportResponseDTO> create(@RequestBody ReportRequestDTO dto) {
        return ResponseEntity.ok(reportService.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportResponseDTO> getById(@PathVariable Long id) {
        ReportResponseDTO dto = reportService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
