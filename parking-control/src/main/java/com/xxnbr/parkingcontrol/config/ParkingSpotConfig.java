package com.xxnbr.parkingcontrol.config;

import com.xxnbr.parkingcontrol.core.usecase.impl.ParkingSpotUseCaseImpl;
import com.xxnbr.parkingcontrol.dataprovider.repository.impl.ParkingSpotDataProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParkingSpotConfig {

    @Bean
    public ParkingSpotUseCaseImpl parkingSpotUseCase(ParkingSpotDataProviderImpl parkingSpotDataProvider){
        return new ParkingSpotUseCaseImpl(parkingSpotDataProvider);
    }
}
