package com.xxnbr.parkingcontrol.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingSpot {
    private UUID id;
    private String parkingSpotNumber;
    private String licensePlateCar;
    private String brandCard;
    private String modelCar;
    private String colorCar;
    private LocalDateTime registrationDate;
    private String responsibleName;
    private String apartament;
    private String block;

    public ParkingSpot() {
    }

    public ParkingSpot(UUID id, String parkingSpotNumber, String licensePlateCar, String brandCard, String modelCar, String colorCar, LocalDateTime registrationDate, String responsibleName, String apartament, String block) {
        this.id = id;
        this.parkingSpotNumber = parkingSpotNumber;
        this.licensePlateCar = licensePlateCar;
        this.brandCard = brandCard;
        this.modelCar = modelCar;
        this.colorCar = colorCar;
        this.registrationDate = registrationDate;
        this.responsibleName = responsibleName;
        this.apartament = apartament;
        this.block = block;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandCard() {
        return brandCard;
    }

    public void setBrandCard(String brandCard) {
        this.brandCard = brandCard;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartament() {
        return apartament;
    }

    public void setApartament(String apartament) {
        this.apartament = apartament;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
