package com.tarun.rraibackend.DTO;

public class IncidentRequestDto {

    private String callerName;
    private String callerPhone;
    private String locationDescription;
    private String lga;
    private String emergencyType;
    private String presentingComplaint;
    private int personsAffected;
    private String prefferedLanguage;
    private boolean consentGiven;


    public IncidentRequestDto(String callerName, String callerPhone, String locationDescription, String lga, String emergencyType, String presentingComplaint, int personsAffected, String prefferedLanguage, boolean consentGiven) {
        this.callerName = callerName;
        this.callerPhone = callerPhone;
        this.locationDescription = locationDescription;
        this.lga = lga;
        this.emergencyType = emergencyType;
        this.presentingComplaint = presentingComplaint;
        this.personsAffected = personsAffected;
        this.prefferedLanguage = prefferedLanguage;
        this.consentGiven = consentGiven;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public String getCallerPhone() {
        return callerPhone;
    }

    public void setCallerPhone(String callerPhone) {
        this.callerPhone = callerPhone;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getPresentingComplaint() {
        return presentingComplaint;
    }

    public void setPresentingComplaint(String presentingComplaint) {
        this.presentingComplaint = presentingComplaint;
    }

    public int getPersonsAffected() {
        return personsAffected;
    }

    public void setPersonsAffected(int personsAffected) {
        this.personsAffected = personsAffected;
    }

    public String getPrefferedLanguage() {
        return prefferedLanguage;
    }

    public void setPrefferedLanguage(String prefferedLanguage) {
        this.prefferedLanguage = prefferedLanguage;
    }

    public boolean isConsentGiven() {
        return consentGiven;
    }

    public void setConsentGiven(boolean consentGiven) {
        this.consentGiven = consentGiven;
    }
}

