package com.pragmabrewery.restservice;

import com.pragmabrewery.dto.BeerTemperatureStatusDTO;
import com.pragmabrewery.util.BeerStatusValidator;
import com.pragmabrewery.util.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBeerStatusValidator {


    @Test(expected = IllegalStateException.class)
    public void testWhenBeerNameNotFound() {

        BeerTemperatureStatusDTO beerTemperatureStatusDTO = new BeerTemperatureStatusDTO();
        beerTemperatureStatusDTO.setBeerName("xxx");
        beerTemperatureStatusDTO.setTemperature(9);

        BeerStatusValidator.getInstance().validateStatus(beerTemperatureStatusDTO);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenNullObjectIsPassed() {

       BeerStatusValidator.getInstance().validateStatus(null);

    }

    @Test
    public void testWhenPilsnerBeerFallsOutOfRange() {

        BeerTemperatureStatusDTO beerTemperatureStatusDTO = new BeerTemperatureStatusDTO();
        beerTemperatureStatusDTO.setBeerName("Pilsner");
        beerTemperatureStatusDTO.setTemperature(9);

        String status = BeerStatusValidator.getInstance().validateStatus(beerTemperatureStatusDTO);

        Assert.assertEquals(status, Constants.alert.toString());

        assert true;
    }

    @Test
    public void testWhenPilsnerBeerFallsWithinRange() {

        BeerTemperatureStatusDTO beerTemperatureStatusDTO = new BeerTemperatureStatusDTO();
        beerTemperatureStatusDTO.setBeerName("Pilsner");
        beerTemperatureStatusDTO.setTemperature(5);

        String status = BeerStatusValidator.getInstance().validateStatus(beerTemperatureStatusDTO);

        Assert.assertEquals(status, Constants.ok.toString());

        assert true;
    }


}
