package com.tarun.rraibackend.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID incidentId;

    private String referenceNumber;
    private String status;
    private String message;

    private String callerName;
    private String callerPhone;
    private String locationDescription;
    private String lga;
    private String emergencyType;
    private String presentingComplaint;
    private int personsAffected;
    private String prefferedLanguage;
    private boolean consentGiven;

    // Required by JPA
    protected Incident() {}

    // Private builder constructor
    private Incident(Builder builder) {
        this.referenceNumber = builder.referenceNumber;
        this.status = builder.status;
        this.message = builder.message;
        this.callerName = builder.callerName;
        this.callerPhone = builder.callerPhone;
        this.locationDescription = builder.locationDescription;
        this.lga = builder.lga;
        this.emergencyType = builder.emergencyType;
        this.presentingComplaint = builder.presentingComplaint;
        this.personsAffected = builder.personsAffected;
        this.prefferedLanguage = builder.prefferedLanguage;
        this.consentGiven = builder.consentGiven;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String referenceNumber;
        private String status = "OPEN";
        private String message;
        private String callerName;
        private String callerPhone;
        private String locationDescription;
        private String lga;
        private String emergencyType;
        private String presentingComplaint;
        private int personsAffected;
        private String prefferedLanguage;
        private boolean consentGiven;

        public Builder referenceNumber(String value) {
            this.referenceNumber = value;
            return this;
        }

        public Builder status(String value) {
            this.status = value;
            return this;
        }

        public Builder message(String value) {
            this.message = value;
            return this;
        }

        public Builder callerName(String value) {
            this.callerName = value;
            return this;
        }

        public Builder callerPhone(String value) {
            this.callerPhone = value;
            return this;
        }

        public Builder locationDescription(String value) {
            this.locationDescription = value;
            return this;
        }

        public Builder lga(String value) {
            this.lga = value;
            return this;
        }

        public Builder emergencyType(String value) {
            this.emergencyType = value;
            return this;
        }

        public Builder presentingComplaint(String value) {
            this.presentingComplaint = value;
            return this;
        }

        public Builder personsAffected(int value) {
            this.personsAffected = value;
            return this;
        }

        public Builder prefferedLanguage(String value) {
            this.prefferedLanguage = value;
            return this;
        }

        public Builder consentGiven(boolean value) {
            this.consentGiven = value;
            return this;
        }

        public Incident build() {
            return new Incident(this);
        }
    }

    // Generate getters for all fields in your IDE

    public UUID getIncidentId() {
        return incidentId;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getCallerName() {
        return callerName;
    }

    public String getCallerPhone() {
        return callerPhone;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public String getLga() {
        return lga;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public String getPresentingComplaint() {
        return presentingComplaint;
    }

    public int getPersonsAffected() {
        return personsAffected;
    }

    public String getPrefferedLanguage() {
        return prefferedLanguage;
    }

    public boolean isConsentGiven() {
        return consentGiven;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
