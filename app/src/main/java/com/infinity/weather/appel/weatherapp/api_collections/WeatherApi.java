package com.infinity.weather.appel.weatherapp.api_collections;

import com.infinity.weather.appel.weatherapp.models.CurrentWeather;
import com.infinity.weather.appel.weatherapp.models.forecast.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {

    @GET ("weather?q=Dhaka,bd&units=metric&appid=e384f9ac095b2109c751d95296f8ea76")
    Call<CurrentWeather>getCurrentWeatherCall();

    @GET("forecast/daily?q=Dhaka,bd&units=metric&appid=e384f9ac095b2109c751d95296f8ea76")
    Call<Forecast>getForecastCall();
}
