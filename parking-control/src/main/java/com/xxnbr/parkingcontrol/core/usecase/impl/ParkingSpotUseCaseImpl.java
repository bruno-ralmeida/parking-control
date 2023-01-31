package com.xxnbr.parkingcontrol.core.usecase.impl;

import com.xxnbr.parkingcontrol.core.dataprovider.ParkingSpotDataProvider;
import com.xxnbr.parkingcontrol.core.domain.ParkingSpot;
import com.xxnbr.parkingcontrol.core.exceptions.DuplicateRecordException;
import com.xxnbr.parkingcontrol.core.exceptions.InvalidUUIDException;
import com.xxnbr.parkingcontrol.core.exceptions.RecordNotFoundException;
import com.xxnbr.parkingcontrol.core.usecase.ParkingSpotUseCase;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.UUID;

public class ParkingSpotUseCaseImpl implements ParkingSpotUseCase {

    private final ParkingSpotDataProvider parkingSpotDataProvider;

    public ParkingSpotUseCaseImpl(ParkingSpotDataProvider parkingSpotDataProvider) {
        this.parkingSpotDataProvider = parkingSpotDataProvider;
    }

    @Override
    public ParkingSpot insert(ParkingSpot parkingSpot) throws DuplicateRecordException {
        try {

            if(parkingSpotDataProvider.existsByLicensePlateCar(parkingSpot.getLicensePlateCar())) throw new DuplicateRecordException("Conflict: License Plate Car is already in use!");
            if(parkingSpotDataProvider.existsByParkingSpotNumber(parkingSpot.getParkingSpotNumber())) throw new DuplicateRecordException("Conflict: Parking Spot is already in use!");
            if(parkingSpotDataProvider.existsByApartamentAndBlock(parkingSpot.getApartament(), parkingSpot.getBlock())) throw new DuplicateRecordException("Conflict: Apartament and block is already in use!");

            return parkingSpotDataProvider.insert(parkingSpot);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateRecordException(e.getMessage());
        }
    }

    @Override
    public ParkingSpot update(ParkingSpot parkingSpot) throws DuplicateRecordException, RecordNotFoundException, InvalidUUIDException {
        try {
            this.findById(parkingSpot.getId().toString());
            if(parkingSpotDataProvider.existsByLicensePlateCar(parkingSpot.getLicensePlateCar())) throw new DuplicateRecordException("Conflict: License Plate Car is already in use!");
            if(parkingSpotDataProvider.existsByParkingSpotNumber(parkingSpot.getParkingSpotNumber())) throw new DuplicateRecordException("Conflict: Parking Spot is already in use!");
            if(parkingSpotDataProvider.existsByApartamentAndBlock(parkingSpot.getApartament(), parkingSpot.getBlock())) throw new DuplicateRecordException("Conflict: Apartament and block is already in use!");

            return parkingSpotDataProvider.update(parkingSpot);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateRecordException(e.getMessage());
        } catch (RecordNotFoundException | InvalidUUIDException e) {
            throw e;
        }
    }

    @Override
    public ParkingSpot findById(String uuid) throws RecordNotFoundException, InvalidUUIDException {
        try {
            UUID convertUUID = UUID.fromString(uuid);
            return parkingSpotDataProvider.findById(convertUUID).orElseThrow(() -> new RecordNotFoundException("The parking spot was not found"));
        } catch (IllegalArgumentException e) {
            throw new InvalidUUIDException("Invalid UUID string: " + e.getMessage());
        }
    }
}
