package com.training.myweatherapp;
public class WeatherResponse {
    public Main main;
    public String name;

    public class Main {
        public float temp;
        public int humidity;
    }
}
