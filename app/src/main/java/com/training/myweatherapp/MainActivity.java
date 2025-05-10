package com.training.myweatherapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText edtLocation;
    private Button btnSearch;
    private TextView txtWeather, txtTime;

    private final String WEATHER_API_KEY = BuildConfig.WEATHER_API_KEY;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLocation = findViewById(R.id.edtLocation);
        btnSearch = findViewById(R.id.btnSearch);
        txtWeather = findViewById(R.id.txtWeather);
        txtTime = findViewById(R.id.txtTime);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = edtLocation.getText().toString();
                if (!city.isEmpty()) {
                    fetchWeather(city);
                    fetchTime(city);
                } else {
                    Toast.makeText(MainActivity.this, "Enter a city!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fetchWeather(String city) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherAPI api = retrofit.create(WeatherAPI.class);

        api.getWeather(city, WEATHER_API_KEY, "metric").enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    txtWeather.setText("Weather: " + response.body().main.temp + "°C, " +
                            "Humidity: " + response.body().main.humidity + "%");
                    txtWeather.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "Invalid city!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "API Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchTime(String city) {
        // Implement WorldTimeAPI call similarly...
    }
}
