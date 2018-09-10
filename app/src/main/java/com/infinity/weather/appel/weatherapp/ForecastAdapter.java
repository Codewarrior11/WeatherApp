package com.infinity.weather.appel.weatherapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ForecastAdapter extends ArrayAdapter<com.infinity.weather.appel.weatherapp.models.forecast.List> {
    Context context;
    java.util.List<com.infinity.weather.appel.weatherapp.models.forecast.List> forecastlist;

    public ForecastAdapter(@NonNull Context context, @NonNull java.util.List<com.infinity.weather.appel.weatherapp.models.forecast.List> forecastlist) {
        super(context, R.layout.forecast_weather_layout, forecastlist);
        this.context = context;
        this.forecastlist=forecastlist;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null) {
            viewHolder=new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.forecast_weather_layout, parent, false);
            viewHolder.days=convertView.findViewById(R.id.day);
            viewHolder.date=convertView.findViewById(R.id.date);
            viewHolder.min=convertView.findViewById(R.id.min);
            viewHolder.max=convertView.findViewById(R.id.max);
            viewHolder.fimage=convertView.findViewById(R.id.fimage);
            convertView.setTag(viewHolder);

        }
        else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        for (com.infinity.weather.appel.weatherapp.models.forecast.List obj : forecastlist){
            viewHolder.max.setText(String.valueOf(obj.getMain().getTempMax()));
        }


        return convertView;
    }

    private static class ViewHolder{
        TextView days,date,min,max,ficon;
        ImageView fimage;

    }
}
