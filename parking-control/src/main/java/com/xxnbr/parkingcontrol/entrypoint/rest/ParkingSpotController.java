package com.xxnbr.parkingcontrol.entrypoint.rest;

import com.xxnbr.parkingcontrol.core.exceptions.DuplicateRecordException;
import com.xxnbr.parkingcontrol.core.exceptions.InvalidUUIDException;
import com.xxnbr.parkingcontrol.core.exceptions.RecordNotFoundException;
import com.xxnbr.parkingcontrol.core.usecase.ParkingSpotUseCase;
import com.xxnbr.parkingcontrol.entrypoint.rest.request.ParkingSpotRequest;
import com.xxnbr.parkingcontrol.entrypoint.rest.response.ParkingSpotResponse;
import com.xxnbr.parkingcontrol.mapper.ParkingSpotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/v1/parking-spot")
public class ParkingSpotController {

    @Autowired
    ParkingSpotMapper mapper;

    @Autowired
    private ParkingSpotUseCase parkingSpotUseCase;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParkingSpotResponse> index(@PathVariable String id) {
        try {
            var parkingSpot = parkingSpotUseCase.findById(id);

            var parkingSpotResponse = mapper.parkingSpotToParkingSpotResponse(parkingSpot);

            return ResponseEntity.ok(parkingSpotResponse);
        } catch (RecordNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (InvalidUUIDException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ParkingSpotRequest request) {
        try {
            var parkingSpot = mapper.parkingSpotRequestToParkingSpot(request);

            parkingSpot.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

            var insert = parkingSpotUseCase.insert(parkingSpot);

            var parkingSpotResponse = mapper.parkingSpotToParkingSpotResponse(insert);

            return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotResponse);
        } catch (DuplicateRecordException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

}
