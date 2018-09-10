package com.infinity.weather.appel.weatherapp.api_collections;

import com.infinity.weather.appel.weatherapp.models.CurrentWeather;
import com.infinity.weather.appel.weatherapp.models.forecast.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {

    @GET ("weather?q=Dhaka,bd&units=metric&appid=abb74ce02a1ee3459cd776bc87d50166")
    Call<CurrentWeather>getCurrentWeatherCall();

    @GET("forecast?q=Dhaka,bd&units=metric&appid=abb74ce02a1ee3459cd776bc87d50166")
    Call<Forecast>getForecastCall();
}
