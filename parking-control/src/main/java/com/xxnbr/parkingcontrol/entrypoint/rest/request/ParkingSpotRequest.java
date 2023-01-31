package com.xxnbr.parkingcontrol.entrypoint.rest.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
public class ParkingSpotRequest {

    @NotBlank
    @Size(max = 10)
    private String parkingSpotNumber;

    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;

    @NotBlank
    @Size(max = 70)
    private String brandCard;

    @NotBlank
    @Size(max = 70)
    private String modelCar;

    @NotBlank
    @Size(max = 70)
    private String colorCar;

    @NotBlank
    @Size(max = 130)
    private String responsibleName;

    @NotBlank
    @Size(max = 30)
    private String apartament;

    @NotBlank
    @Size(max = 30)
    private String block;

}
