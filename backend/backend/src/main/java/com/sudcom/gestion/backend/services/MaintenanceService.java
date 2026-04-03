package com.sudcom.gestion.backend.services;

import com.sudcom.gestion.backend.dtos.requests.MaintenanceRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.MaintenanceResponseDTO;
import java.util.List;

public interface MaintenanceService {
    List<MaintenanceResponseDTO> findAll();
    MaintenanceResponseDTO findById(Long id);
    MaintenanceResponseDTO save(MaintenanceRequestDTO dto);
    void delete(Long id);
}
