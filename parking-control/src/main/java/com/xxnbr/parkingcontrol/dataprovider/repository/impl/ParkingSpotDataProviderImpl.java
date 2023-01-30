package com.xxnbr.parkingcontrol.dataprovider.repository.impl;


import com.xxnbr.parkingcontrol.core.dataprovider.ParkingSpotDataProvider;
import com.xxnbr.parkingcontrol.core.domain.ParkingSpot;
import com.xxnbr.parkingcontrol.core.exceptions.InvalidUUIDException;
import com.xxnbr.parkingcontrol.dataprovider.repository.ParkingSportRepository;
import com.xxnbr.parkingcontrol.dataprovider.repository.entity.ParkingSpotEntity;
import com.xxnbr.parkingcontrol.mapper.ParkingSpotMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotDataProviderImpl implements ParkingSpotDataProvider {

    @Autowired
    private ParkingSpotMapper mapper;

    @Autowired
    private ParkingSportRepository repository;

    @Override
    public void insert(ParkingSpot parkingSpot) {
        var parkingSpotEntity = new ParkingSpotEntity();

        BeanUtils.copyProperties(parkingSpot, parkingSpotEntity);

        repository.save(parkingSpotEntity);
    }

    @Override
    public void update(ParkingSpot parkingSpot) {
        var parkingSpotEntity = mapper.parkingSpotToParkingSpotEntity(parkingSpot);

        repository.save(parkingSpotEntity);
    }

    @Override
    public Optional<ParkingSpot> findById(String uuid) throws InvalidUUIDException {

        try {
            UUID convertUUID = UUID.fromString(uuid);

            Optional<ParkingSpotEntity> optionalParkingSpotEntity = repository.findById(convertUUID);

            if (optionalParkingSpotEntity.isEmpty()) {
                return Optional.empty();
            }

            var parkingSpot = mapper.parkingSpotEntityToParkingSpot(optionalParkingSpotEntity.get());
            return Optional.of(parkingSpot);

        } catch (IllegalArgumentException e) {
            throw new InvalidUUIDException("Invalid UUID string: " + e.getMessage());
        }
    }

}
