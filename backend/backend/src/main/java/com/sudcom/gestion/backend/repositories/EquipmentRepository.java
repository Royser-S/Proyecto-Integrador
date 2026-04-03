package com.sudcom.gestion.backend.repositories;

import com.sudcom.gestion.backend.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    Optional<Equipment> findByCodigo(String codigo);
}
