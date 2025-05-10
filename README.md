# 🌤 MyWeatherApp

MyWeatherApp is a simple Android weather application that fetches real-time weather data using a public API. Built using **Kotlin**, the app demonstrates how to handle network responses, parse JSON, and securely use API keys via `local.properties`.

## ✨ Features

- 🌍 Get real-time weather updates for your current location
- ⏱ View local time information
- 🌡 Temperature, humidity, and weather description display
- 🛡 Secure API key handling with `local.properties`

## 🛠 Tech Stack


- **XML-based UI**
- **Retrofit** for networking
- **Gson** / **Moshi** for JSON parsing
- **MVVM** Architecture (optional)

## 🔑 API Key Setup

1. Create a file called `local.properties` in the root of your project (if not already there).
2. Add your API key:
   ```properties
   WEATHER_API_KEY=your_api_key_here
