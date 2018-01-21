package com.pragmabrewery.util;

import com.pragmabrewery.dto.BeerTemperatureLimitDTO;
import com.pragmabrewery.dto.BeerTemperatureStatusDTO;

import java.util.HashMap;
import java.util.Map;

public class BeerStatusValidator {
    private static BeerStatusValidator ourInstance = new BeerStatusValidator();
    private Map<String, BeerTemperatureLimitDTO> temperatureLimitsMap = new HashMap<>();

    public static BeerStatusValidator getInstance() {
        return ourInstance;
    }

    private BeerStatusValidator() {
        populateRules();

    }

    public String validateStatus(BeerTemperatureStatusDTO beerTemperatureStatusDTO) {

        if (beerTemperatureStatusDTO == null) {
            throw new IllegalArgumentException("BeerTemperatureStatusDTO object is needed to perform validation");
        }

        BeerTemperatureLimitDTO limitDTO = temperatureLimitsMap.get(beerTemperatureStatusDTO.getBeerName());

        if (limitDTO == null) {
            throw new IllegalStateException(beerTemperatureStatusDTO.getBeerName() + " is not configured");
        }

        if (isInRange(beerTemperatureStatusDTO, limitDTO)) {
            return Constants.ok.toString();
        }

        return Constants.alert.toString();
    }

    private boolean isInRange(BeerTemperatureStatusDTO beerTemperatureStatusDTO, BeerTemperatureLimitDTO limitDTO) {
        return limitDTO.getMinimumThreshold() <= beerTemperatureStatusDTO.getTemperature() && beerTemperatureStatusDTO.getTemperature() <= limitDTO.getMaximumThreshold();
    }


    /**
     * Configurable Data Dictionary (Rules Pulled From a DataBase Table, or Properties File)
     */
    private void populateRules() {
        BeerTemperatureLimitDTO beer1 = new BeerTemperatureLimitDTO();
        beer1.setMinimumThreshold(4.0);
        beer1.setMaximumThreshold(6.0);
        temperatureLimitsMap.put("Pilsner", beer1);

        BeerTemperatureLimitDTO beer2 = new BeerTemperatureLimitDTO();
        beer2.setMinimumThreshold(5.0);
        beer2.setMaximumThreshold(6.0);
        temperatureLimitsMap.put("IPA", beer2);

        BeerTemperatureLimitDTO beer3 = new BeerTemperatureLimitDTO();
        beer3.setMinimumThreshold(4.0);
        beer3.setMaximumThreshold(7.0);
        temperatureLimitsMap.put("Lager", beer3);

        BeerTemperatureLimitDTO beer4 = new BeerTemperatureLimitDTO();
        beer4.setMinimumThreshold(6.0);
        beer4.setMaximumThreshold(8.0);
        temperatureLimitsMap.put("Stout", beer4);

        BeerTemperatureLimitDTO beer5 = new BeerTemperatureLimitDTO();
        beer5.setMinimumThreshold(3.0);
        beer5.setMaximumThreshold(5.0);
        temperatureLimitsMap.put("Wheat beer", beer5);


        BeerTemperatureLimitDTO beer6 = new BeerTemperatureLimitDTO();
        beer6.setMinimumThreshold(4.0);
        beer6.setMaximumThreshold(6.0);
        temperatureLimitsMap.put("Pale Ale", beer6);
    }
}
