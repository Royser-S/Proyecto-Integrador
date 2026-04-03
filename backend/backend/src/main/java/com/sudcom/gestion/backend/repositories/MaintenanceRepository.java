package com.sudcom.gestion.backend.repositories;

import com.sudcom.gestion.backend.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}
