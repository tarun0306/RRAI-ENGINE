package com.tarun.rraibackend.repo;

import com.tarun.rraibackend.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IncidentRepo extends JpaRepository<Incident,UUID> {

    Optional<Incident> findByReferenceNumber(String referenceNumber);
}
