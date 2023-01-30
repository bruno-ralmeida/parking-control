package com.xxnbr.parkingcontrol.mapper;


import com.xxnbr.parkingcontrol.core.domain.ParkingSpot;
import com.xxnbr.parkingcontrol.dataprovider.repository.entity.ParkingSpotEntity;
import com.xxnbr.parkingcontrol.entrypoint.rest.request.ParkingSpotRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParkingSpotMapper {

    ParkingSpotEntity parkingSpotToParkingSpotEntity(ParkingSpot parkingSpot);

    ParkingSpot parkingSpotEntityToParkingSpot(ParkingSpotEntity parkingSpotEntity);

    @Mapping(target = "id", ignore = true)
    ParkingSpot parkingSpotRequestToParkingSpot(ParkingSpotRequest request);
}
