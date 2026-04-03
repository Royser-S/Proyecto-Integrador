package com.sudcom.gestion.backend.services;

import com.sudcom.gestion.backend.dtos.requests.EquipmentRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.EquipmentResponseDTO;
import java.util.List;

public interface EquipmentService {
    List<EquipmentResponseDTO> findAll();
    EquipmentResponseDTO findById(Long id);
    EquipmentResponseDTO save(EquipmentRequestDTO equipmentDTO);
    EquipmentResponseDTO update(Long id, EquipmentRequestDTO equipmentDTO);
    void delete(Long id);
}
