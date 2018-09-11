package com.infinity.weather.appel.weatherapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.infinity.weather.appel.weatherapp.api_collections.RetrofitClient;
import com.infinity.weather.appel.weatherapp.api_collections.WeatherApi;
import com.infinity.weather.appel.weatherapp.models.forecast.Forecast;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForecastWeatherFragment extends Fragment {
    WeatherApi weatherApi;
    ListView forecastLV;
    java.util.List<List> forecastlist;
    String url="forecast/daily?q=Dhaka,bd&units=metric&appid=e384f9ac095b2109c751d95296f8ea76";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forcast_weather, container, false);
        forecastLV = view.findViewById(R.id.flist);
        getForecastWeather();
        return view;
    }

    private void getForecastWeather() {
        weatherApi = RetrofitClient.getRetrofitClient().create(WeatherApi.class);
        Call<Forecast> forecastCall = weatherApi.getForecastCall(url);

        forecastCall.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                Forecast forecast = response.body();
                ForecastAdapter forecastAdapter = new ForecastAdapter(getContext(), forecast.getList());
                forecastLV.setAdapter(forecastAdapter);
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Toast.makeText(getContext(), "" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
