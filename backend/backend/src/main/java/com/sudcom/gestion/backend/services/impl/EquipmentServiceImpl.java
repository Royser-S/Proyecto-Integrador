package com.sudcom.gestion.backend.services.impl;

import com.sudcom.gestion.backend.dtos.requests.EquipmentRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.EquipmentResponseDTO;
import com.sudcom.gestion.backend.entities.Equipment;
import com.sudcom.gestion.backend.repositories.EquipmentRepository;
import com.sudcom.gestion.backend.services.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Override
    public List<EquipmentResponseDTO> findAll() {
        return equipmentRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EquipmentResponseDTO findById(Long id) {
        return equipmentRepository.findById(id)
                .map(this::toResponseDTO)
                .orElse(null);
    }

    @Override
    public EquipmentResponseDTO save(EquipmentRequestDTO dto) {
        Equipment entity = toEntity(dto);
        Equipment saved = equipmentRepository.save(entity);
        return toResponseDTO(saved);
    }

    @Override
    public EquipmentResponseDTO update(Long id, EquipmentRequestDTO dto) {
        return equipmentRepository.findById(id).map(entity -> {
            entity.setNombre(dto.getNombre());
            entity.setCodigo(dto.getCodigo());
            entity.setUbicacion(dto.getUbicacion());
            entity.setEstado(dto.getEstado()); // Already a String
            entity.setMarca(dto.getMarca());
            entity.setModelo(dto.getModelo());
            entity.setFechaAdquisicion(dto.getFechaAdquisicion());
            return toResponseDTO(equipmentRepository.save(entity));
        }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }

    private EquipmentResponseDTO toResponseDTO(Equipment entity) {
        return new EquipmentResponseDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getCodigo(),
                entity.getUbicacion(),
                entity.getEstado(), // Already a String
                entity.getMarca(),
                entity.getModelo(),
                entity.getFechaAdquisicion()
        );
    }

    private Equipment toEntity(EquipmentRequestDTO dto) {
        Equipment entity = new Equipment();
        entity.setNombre(dto.getNombre());
        entity.setCodigo(dto.getCodigo());
        entity.setUbicacion(dto.getUbicacion());
        entity.setEstado(dto.getEstado()); // Already a String
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());
        entity.setFechaAdquisicion(dto.getFechaAdquisicion());
        return entity;
    }
}
