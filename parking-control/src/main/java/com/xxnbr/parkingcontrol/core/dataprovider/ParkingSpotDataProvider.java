package com.xxnbr.parkingcontrol.core.dataprovider;

import com.xxnbr.parkingcontrol.core.domain.ParkingSpot;
import com.xxnbr.parkingcontrol.core.exceptions.InvalidUUIDException;

import java.util.Optional;

public interface ParkingSpotDataProvider {

    void insert(final ParkingSpot parkingSpot);

    void update(final ParkingSpot parkingSpot);

    Optional<ParkingSpot> findById(final String uuid) throws InvalidUUIDException;

}
