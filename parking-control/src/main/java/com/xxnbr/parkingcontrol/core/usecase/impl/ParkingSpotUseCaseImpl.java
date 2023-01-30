package com.xxnbr.parkingcontrol.core.usecase.impl;

import com.xxnbr.parkingcontrol.core.dataprovider.ParkingSpotDataProvider;
import com.xxnbr.parkingcontrol.core.domain.ParkingSpot;
import com.xxnbr.parkingcontrol.core.exceptions.InvalidUUIDException;
import com.xxnbr.parkingcontrol.core.exceptions.RecordNotFoundException;
import com.xxnbr.parkingcontrol.core.usecase.ParkingSpotUseCase;

public class ParkingSpotUseCaseImpl implements ParkingSpotUseCase {

    private final ParkingSpotDataProvider parkingSpotDataProvider;

    public ParkingSpotUseCaseImpl(ParkingSpotDataProvider parkingSpotDataProvider) {
        this.parkingSpotDataProvider = parkingSpotDataProvider;
    }

    @Override
    public void insert(ParkingSpot parkingSpot) {
        parkingSpotDataProvider.insert(parkingSpot);
    }

    @Override
    public void update(ParkingSpot parkingSpot) throws InvalidUUIDException {
        parkingSpotDataProvider.findById(parkingSpot.getId().toString());
        parkingSpotDataProvider.update(parkingSpot);
    }

    @Override
    public ParkingSpot findById(String uuid) throws RecordNotFoundException, InvalidUUIDException {
        return parkingSpotDataProvider.findById(uuid).orElseThrow(() -> new RecordNotFoundException("The parking spot was not found"));
    }
}
