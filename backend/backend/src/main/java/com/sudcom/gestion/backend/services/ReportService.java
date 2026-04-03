package com.sudcom.gestion.backend.services;

import com.sudcom.gestion.backend.dtos.requests.ReportRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.ReportResponseDTO;
import java.util.List;

public interface ReportService {
    List<ReportResponseDTO> findAll();
    ReportResponseDTO findById(Long id);
    ReportResponseDTO save(ReportRequestDTO dto);
    void delete(Long id);
}
