package com.xxnbr.parkingcontrol.entrypoint.rest.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class ParkingSpotResponse {
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
}
