package com.xxnbr.parkingcontrol.core.usecase;

import com.xxnbr.parkingcontrol.core.domain.ParkingSpot;
import com.xxnbr.parkingcontrol.core.exceptions.InvalidUUIDException;
import com.xxnbr.parkingcontrol.core.exceptions.RecordNotFoundException;

public interface ParkingSpotUseCase {

    void insert(final ParkingSpot parkingSpot);

    void update(final ParkingSpot parkingSpot) throws InvalidUUIDException;

    ParkingSpot findById(final String uuid) throws RecordNotFoundException, InvalidUUIDException;
}
