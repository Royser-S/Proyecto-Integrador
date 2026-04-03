package com.sudcom.gestion.backend.services.impl;

import com.sudcom.gestion.backend.dtos.requests.FailureRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.FailureResponseDTO;
import com.sudcom.gestion.backend.entities.Equipment;
import com.sudcom.gestion.backend.entities.Failure;
import com.sudcom.gestion.backend.repositories.EquipmentRepository;
import com.sudcom.gestion.backend.repositories.FailureRepository;
import com.sudcom.gestion.backend.services.FailureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FailureServiceImpl implements FailureService {

    private final FailureRepository failureRepository;
    private final EquipmentRepository equipmentRepository;

    @Override
    public List<FailureResponseDTO> findAll() {
        return failureRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FailureResponseDTO findById(Long id) {
        return failureRepository.findById(id).map(this::toResponseDTO).orElse(null);
    }

    @Override
    public FailureResponseDTO save(FailureRequestDTO dto) {
        Failure entity = toEntity(dto);
        Failure saved = failureRepository.save(entity);
        return toResponseDTO(saved);
    }

    @Override
    public void delete(Long id) {
        failureRepository.deleteById(id);
    }

    private FailureResponseDTO toResponseDTO(Failure entity) {
        return new FailureResponseDTO(
                entity.getId(),
                entity.getEquipment() != null ? entity.getEquipment().getId() : null,
                entity.getEquipment() != null ? entity.getEquipment().getNombre() : null,
                entity.getFechaReporte(),
                entity.getDescripcion(),
                entity.getEstado() // Already a String
        );
    }

    private Failure toEntity(FailureRequestDTO dto) {
        Failure entity = new Failure();
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado()); // Already a String
        entity.setFechaReporte(dto.getFechaReporte());
        
        if (dto.getIdEquipo() != null) {
            Equipment eq = equipmentRepository.findById(dto.getIdEquipo()).orElse(null);
            entity.setEquipment(eq);
        }
        return entity;
    }
}
