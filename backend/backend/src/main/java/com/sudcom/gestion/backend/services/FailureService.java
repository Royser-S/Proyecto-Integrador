package com.sudcom.gestion.backend.services;

import com.sudcom.gestion.backend.dtos.requests.FailureRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.FailureResponseDTO;
import java.util.List;

public interface FailureService {
    List<FailureResponseDTO> findAll();
    FailureResponseDTO findById(Long id);
    FailureResponseDTO save(FailureRequestDTO dto);
    void delete(Long id);
}
