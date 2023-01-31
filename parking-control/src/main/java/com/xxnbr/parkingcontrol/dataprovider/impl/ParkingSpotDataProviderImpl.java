package com.xxnbr.parkingcontrol.dataprovider.impl;


import com.xxnbr.parkingcontrol.core.dataprovider.ParkingSpotDataProvider;
import com.xxnbr.parkingcontrol.core.domain.ParkingSpot;
import com.xxnbr.parkingcontrol.dataprovider.repository.ParkingSportRepository;
import com.xxnbr.parkingcontrol.dataprovider.repository.entity.ParkingSpotEntity;
import com.xxnbr.parkingcontrol.mapper.ParkingSpotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotDataProviderImpl implements ParkingSpotDataProvider {

    @Autowired
    private ParkingSpotMapper mapper;

    @Autowired
    private ParkingSportRepository repository;

    @Transactional
    @Override
    public ParkingSpot insert(ParkingSpot parkingSpot) {
        var parkingSpotEntity = mapper.parkingSpotToParkingSpotEntity(parkingSpot);

        return mapper.parkingSpotEntityToParkingSpot(repository.save(parkingSpotEntity));
    }


    @Transactional
    @Override
    public ParkingSpot update(ParkingSpot parkingSpot) {
        var parkingSpotEntity = mapper.parkingSpotToParkingSpotEntity(parkingSpot);

        return mapper.parkingSpotEntityToParkingSpot(repository.save(parkingSpotEntity));
    }

    @Override
    public Optional<ParkingSpot> findById(UUID uuid) {

        Optional<ParkingSpotEntity> optionalParkingSpotEntity = repository.findById(uuid);

        if (optionalParkingSpotEntity.isEmpty()) {
            return Optional.empty();
        }

        var parkingSpot = mapper.parkingSpotEntityToParkingSpot(optionalParkingSpotEntity.get());
        return Optional.of(parkingSpot);
    }

    @Override
    public boolean existsByApartamentAndBlock(String apartament, String block) {
        return repository.existsByApartamentAndBlock(apartament, block);
    }

    @Override
    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return repository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    @Override
    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return repository.existsByLicensePlateCar(licensePlateCar);
    }

}
