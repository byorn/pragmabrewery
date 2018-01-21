package com.pragmabrewery.util;

import com.pragmabrewery.dto.BeerTemperatureStatusDTO;

import java.util.ArrayList;
import java.util.List;

public class MockBeerTemperatureData {


    public static List<BeerTemperatureStatusDTO> getBeerTemperatureStatusData(){
        List<BeerTemperatureStatusDTO> beerTemperatureStatusDTOList = new ArrayList<>();
        BeerTemperatureStatusDTO beer1 = new BeerTemperatureStatusDTO();
        beer1.setBeerName("Pilsner");
        beer1.setTemperature(5.0);
        beer1.setStatus(Constants.ok.toString());

        BeerTemperatureStatusDTO beer2 = new BeerTemperatureStatusDTO();
        beer2.setBeerName("IPA");
        beer2.setTemperature(5.0);
        beer2.setStatus(Constants.ok.toString());

        BeerTemperatureStatusDTO beer3 = new BeerTemperatureStatusDTO();
        beer3.setBeerName("Lager");
        beer3.setTemperature(5.0);
        beer3.setStatus(Constants.ok.toString());

        BeerTemperatureStatusDTO beer4 = new BeerTemperatureStatusDTO();
        beer4.setBeerName("Stout");
        beer4.setTemperature(5.0);
        beer4.setStatus(Constants.ok.toString());

        BeerTemperatureStatusDTO beer5 = new BeerTemperatureStatusDTO();
        beer5.setBeerName("Wheat beer");
        beer5.setTemperature(7.0);
        beer5.setStatus(Constants.alert.toString());

        BeerTemperatureStatusDTO beer6 = new BeerTemperatureStatusDTO();
        beer6.setBeerName("Pale Ale");
        beer6.setTemperature(5.0);
        beer6.setStatus(Constants.ok.toString());


        beerTemperatureStatusDTOList.add(beer1);
        beerTemperatureStatusDTOList.add(beer2);
        beerTemperatureStatusDTOList.add(beer3);
        beerTemperatureStatusDTOList.add(beer4);
        beerTemperatureStatusDTOList.add(beer5);
        beerTemperatureStatusDTOList.add(beer6);

        return beerTemperatureStatusDTOList;
    }
}
