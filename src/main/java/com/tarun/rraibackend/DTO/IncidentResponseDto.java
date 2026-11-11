package com.tarun.rraibackend.DTO;

import java.util.UUID;

public class IncidentResponseDto {

    private UUID incidentId;
    private String referenceNumber;
    private  String status;
    private String message;


    public IncidentResponseDto(UUID incidentId, String referenceNumber, String status, String message) {
        this.incidentId = incidentId;
        this.referenceNumber = referenceNumber;
        this.status = status;
        this.message = message;
    }

    public UUID getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(UUID incidentId) {
        this.incidentId = incidentId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
