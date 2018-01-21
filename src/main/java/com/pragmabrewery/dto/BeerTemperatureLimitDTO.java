package com.pragmabrewery.dto;

public class BeerTemperatureLimitDTO {


    private double minimumThreshold;
    private double maximumThreshold;


    public double getMinimumThreshold() {
        return minimumThreshold;
    }

    public void setMinimumThreshold(double minimumThreshold) {
        this.minimumThreshold = minimumThreshold;
    }

    public double getMaximumThreshold() {
        return maximumThreshold;
    }

    public void setMaximumThreshold(double maximumThreshold) {
        this.maximumThreshold = maximumThreshold;
    }
}
