package com.xxnbr.parkingcontrol.core.dataprovider;

import com.xxnbr.parkingcontrol.core.domain.ParkingSpot;

import java.util.Optional;
import java.util.UUID;

public interface ParkingSpotDataProvider {

    ParkingSpot insert(final ParkingSpot parkingSpot);

    ParkingSpot update(final ParkingSpot parkingSpot);

    Optional<ParkingSpot> findById(final UUID uuid);

    boolean existsByApartamentAndBlock(final String apartament, final String block);

    boolean existsByParkingSpotNumber(final String parkingSpotNumber);

    boolean existsByLicensePlateCar(final String licensePlateCar);
}
