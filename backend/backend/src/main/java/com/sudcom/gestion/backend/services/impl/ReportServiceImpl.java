package com.sudcom.gestion.backend.services.impl;

import com.sudcom.gestion.backend.dtos.requests.ReportRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.ReportResponseDTO;
import com.sudcom.gestion.backend.entities.Report;
import com.sudcom.gestion.backend.entities.User;
import com.sudcom.gestion.backend.repositories.ReportRepository;
import com.sudcom.gestion.backend.repositories.UserRepository;
import com.sudcom.gestion.backend.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    @Override
    public List<ReportResponseDTO> findAll() {
        return reportRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReportResponseDTO findById(Long id) {
        return reportRepository.findById(id).map(this::toResponseDTO).orElse(null);
    }

    @Override
    public ReportResponseDTO save(ReportRequestDTO dto) {
        Report entity = toEntity(dto);
        Report saved = reportRepository.save(entity);
        return toResponseDTO(saved);
    }

    @Override
    public void delete(Long id) {
        reportRepository.deleteById(id);
    }

    private ReportResponseDTO toResponseDTO(Report entity) {
        return new ReportResponseDTO(
                entity.getId(),
                entity.getUser() != null ? entity.getUser().getId() : null,
                entity.getUser() != null ? entity.getUser().getNombre() : null,
                entity.getTitulo(),
                entity.getTipo(),
                entity.getFechaGeneracion(),
                entity.getContenido()
        );
    }

    private Report toEntity(ReportRequestDTO dto) {
        Report entity = Report.builder()
                .titulo(dto.getTitulo())
                .tipo(dto.getTipoReporte())
                .contenido(dto.getContenido())
                .fechaGeneracion(dto.getFechaGeneracion() != null ? dto.getFechaGeneracion() : java.time.LocalDate.now())
                .build();
        
        if (dto.getIdUsuario() != null) {
            User user = userRepository.findById(dto.getIdUsuario()).orElse(null);
            entity.setUser(user);
        }
        return entity;
    }
}
