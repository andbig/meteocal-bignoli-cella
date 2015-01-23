/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meteocal.business.entities;

import com.meteocal.business.entities.shared.WeatherCondition;
import java.time.LocalDateTime;
import java.util.Comparator;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrea Bignoli
 */
@MappedSuperclass
public class WeatherForecastBase {
    
    @Enumerated(EnumType.STRING)
    private WeatherCondition weatherCondition;
    
    @NotNull
    private LocalDateTime forecastStart;

    @NotNull
    private LocalDateTime forecastEnd;
    
    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
    
    public LocalDateTime getForecastStart() {
        return forecastStart;
    }

    public void setForecastStart(LocalDateTime start) {
        this.forecastStart = start;
    }

    public LocalDateTime getForecastEnd() {
        return forecastEnd;
    }

    public void setForecastEnd(LocalDateTime end) {
        this.forecastEnd = end;
    }

    public boolean isValid() {
        return !(forecastStart == null || forecastEnd == null || forecastStart.isAfter(forecastEnd) || weatherCondition == null);
    }
}
