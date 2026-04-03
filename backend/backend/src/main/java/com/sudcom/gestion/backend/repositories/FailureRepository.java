package com.sudcom.gestion.backend.repositories;

import com.sudcom.gestion.backend.entities.Failure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FailureRepository extends JpaRepository<Failure, Long> {
}
