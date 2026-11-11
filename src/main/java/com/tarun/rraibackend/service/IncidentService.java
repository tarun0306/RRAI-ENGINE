package com.tarun.rraibackend.service;

import com.tarun.rraibackend.DTO.IncidentRequestDto;
import com.tarun.rraibackend.model.Incident;
import com.tarun.rraibackend.repo.IncidentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IncidentService {
    private final IncidentRepo incidentRepo;

    public IncidentService(IncidentRepo incidentRepo) {
        this.incidentRepo = incidentRepo;
    }

    public Incident createIncident(IncidentRequestDto request){
        Incident incident = Incident.builder()
                .callerName(request.getCallerName())
                .callerPhone(request.getCallerPhone())
                .locationDescription(request.getLocationDescription())
                .lga(request.getLga())
                .emergencyType(request.getEmergencyType())
                .presentingComplaint(request.getPresentingComplaint())
                .personsAffected(request.getPersonsAffected())
                .consentGiven(request.isConsentGiven())
                .referenceNumber(
                        "RRAI-" + UUID.randomUUID()
                                .toString()
                                .substring(0,8)
                                .toUpperCase()
                )
                .status("OPEN")
                .message("Incident reported Successfully")
                .build();
        return incidentRepo.save(incident);
    }
    public List<Incident> getIncidents(){
        List<Incident> listOfIncident = new ArrayList<>();
        listOfIncident = incidentRepo.findAll();
        return listOfIncident;
    }

    public Incident getIncidentByReference(String referenceNumber){
        Optional<Incident> inc = incidentRepo.findByReferenceNumber(referenceNumber);
        return inc.orElseThrow();
    }

    public Incident updateIncidentStatus(String referenceNumber,String status){
        Optional<Incident> inc = incidentRepo.findByReferenceNumber(referenceNumber);
        Incident updateInc = inc.orElseThrow();
        updateInc.setStatus(status);
        return incidentRepo.save(updateInc);
    }
}
