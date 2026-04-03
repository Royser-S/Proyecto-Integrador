package com.sudcom.gestion.backend.repositories;

import com.sudcom.gestion.backend.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
