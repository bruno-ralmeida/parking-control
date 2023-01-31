package com.xxnbr.parkingcontrol.core.usecase;

import com.xxnbr.parkingcontrol.core.domain.ParkingSpot;
import com.xxnbr.parkingcontrol.core.exceptions.DuplicateRecordException;
import com.xxnbr.parkingcontrol.core.exceptions.InvalidUUIDException;
import com.xxnbr.parkingcontrol.core.exceptions.RecordNotFoundException;

public interface ParkingSpotUseCase {

    ParkingSpot insert(final ParkingSpot parkingSpot) throws DuplicateRecordException;

    ParkingSpot update(final ParkingSpot parkingSpot) throws InvalidUUIDException, DuplicateRecordException, RecordNotFoundException;

    ParkingSpot findById(final String uuid) throws RecordNotFoundException, InvalidUUIDException;
}
