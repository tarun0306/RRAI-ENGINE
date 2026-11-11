package com.tarun.rraibackend.controllers;
import com.tarun.rraibackend.DTO.IncidentRequestDto;
import com.tarun.rraibackend.DTO.IncidentResponseDto;
import com.tarun.rraibackend.model.Incident;
import com.tarun.rraibackend.repo.IncidentRepo;
import com.tarun.rraibackend.service.IncidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class IncidentPortal {
    private final IncidentRepo incidentRepo;
    private final IncidentService incidentService;
    public IncidentPortal(IncidentRepo incidentRepo, IncidentService incidentService) {
        this.incidentRepo = incidentRepo;
        this.incidentService = incidentService;
    }
    @PostMapping("/incidents")
    public ResponseEntity<IncidentResponseDto> postIncident(@RequestBody IncidentRequestDto incidentRequestDto){
           Incident inc =  incidentService.createIncident(incidentRequestDto);
           IncidentResponseDto incResponse = new IncidentResponseDto(inc.getIncidentId()
                   ,inc.getReferenceNumber(),
                   inc.getStatus(),
                   inc.getMessage());
           return ResponseEntity.status(HttpStatus.CREATED)
                   .body(incResponse);
    }
    @GetMapping("/incidents")
    public ResponseEntity<List<Incident>> getIncidents(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(incidentService.getIncidents());
    }
    @GetMapping("/incidents/{refnumber}")
    public ResponseEntity<Incident> getIncident(@PathVariable String refnumber){
        System.out.println("RefNumber : " + refnumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(incidentService
                        .getIncidentByReference(refnumber));
    }
    @PatchMapping("/incidents/{refnumber}")
    public ResponseEntity<Incident> updateIncidentStatus(@RequestBody String status,@PathVariable String refnumber){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(incidentService.updateIncidentStatus(refnumber,status));
    }
}
