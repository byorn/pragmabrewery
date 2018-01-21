package com.pragmabrewery.restservice;

import com.pragmabrewery.dto.BeerTemperatureStatusDTO;
import com.pragmabrewery.util.BeerStatusValidator;
import com.pragmabrewery.util.MockBeerTemperatureData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SensorController {


    @RequestMapping(value = "/getBeerTemperature",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BeerTemperatureStatusDTO>> getBeerTemperature() {

        List<BeerTemperatureStatusDTO> beerTemperatureStatusDTOS = MockBeerTemperatureData.getBeerTemperatureStatusData();

        validateStatus(beerTemperatureStatusDTOS);


        return new ResponseEntity<>(beerTemperatureStatusDTOS, HttpStatus.OK);
    }

    private void validateStatus(List<BeerTemperatureStatusDTO> beerTemperatureStatusDTOS) {
        beerTemperatureStatusDTOS.forEach(beerTemperatureStatusDTO -> {

            String status = BeerStatusValidator.getInstance().validateStatus(beerTemperatureStatusDTO);
            beerTemperatureStatusDTO.setStatus(status);

        });
    }
}
