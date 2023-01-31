package com.xxnbr.parkingcontrol.dataprovider.repository;

import com.xxnbr.parkingcontrol.dataprovider.repository.entity.ParkingSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkingSportRepository extends JpaRepository<ParkingSpotEntity, UUID> {

    boolean existsByApartamentAndBlock(final String apartament, final String block);

    boolean existsByLicensePlateCar(final String licensePlateCar);

    boolean existsByParkingSpotNumber(final String parkingSpotNumber);

}
