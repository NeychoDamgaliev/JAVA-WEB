package residentevil.web.domain.models.service;

import residentevil.web.domain.enums.Magnitude;

import java.time.LocalDate;

/**
 * Created by Neycho Damgaliev on 3/17/2019.
 */
public class VirusShowServiceModel {

    private String id;
    private String name;
    private Magnitude magnitude;
    private LocalDate releasedOn;

    public VirusShowServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    public LocalDate getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(LocalDate releasedOn) {
        this.releasedOn = releasedOn;
    }
}
