package com.sudcom.gestion.backend.services.impl;

import com.sudcom.gestion.backend.dtos.requests.MaintenanceRequestDTO;
import com.sudcom.gestion.backend.dtos.responses.MaintenanceResponseDTO;
import com.sudcom.gestion.backend.entities.Equipment;
import com.sudcom.gestion.backend.entities.Maintenance;
import com.sudcom.gestion.backend.repositories.EquipmentRepository;
import com.sudcom.gestion.backend.repositories.MaintenanceRepository;
import com.sudcom.gestion.backend.services.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final EquipmentRepository equipmentRepository;

    @Override
    public List<MaintenanceResponseDTO> findAll() {
        return maintenanceRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MaintenanceResponseDTO findById(Long id) {
        return maintenanceRepository.findById(id).map(this::toResponseDTO).orElse(null);
    }

    @Override
    public MaintenanceResponseDTO save(MaintenanceRequestDTO dto) {
        Maintenance entity = toEntity(dto);
        Maintenance saved = maintenanceRepository.save(entity);
        return toResponseDTO(saved);
    }

    @Override
    public void delete(Long id) {
        maintenanceRepository.deleteById(id);
    }

    private MaintenanceResponseDTO toResponseDTO(Maintenance entity) {
        return new MaintenanceResponseDTO(
                entity.getId(),
                entity.getEquipment() != null ? entity.getEquipment().getId() : null,
                entity.getEquipment() != null ? entity.getEquipment().getNombre() : null,
                entity.getFecha(),
                entity.getDescripcion(),
                entity.getTipoMantenimiento(),
                entity.getResponsable(),
                entity.getEstado()
        );
    }

    private Maintenance toEntity(MaintenanceRequestDTO dto) {
        Maintenance entity = new Maintenance();
        entity.setFecha(dto.getFecha());
        entity.setDescripcion(dto.getDescripcion());
        entity.setTipoMantenimiento(dto.getTipoMantenimiento() != null ? dto.getTipoMantenimiento() : "PREVENTIVO");
        entity.setEstado(dto.getEstado() != null ? dto.getEstado() : "PENDIENTE");
        entity.setResponsable(dto.getResponsable());

        if (dto.getIdEquipo() != null) {
            Equipment eq = equipmentRepository.findById(dto.getIdEquipo()).orElse(null);
            entity.setEquipment(eq);
        }
        return entity;
    }
}
