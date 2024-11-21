<template>
  <div className="weather-app">
    <h1 className="app-title">Weather app</h1>
    <p className="description">
      Know weather in {{ city == "" ? "your city" : cityName }}
    </p>
    <input className="city-input" type="text" v-model="city" placeholder="input your city">
    <button className="get-weather-button" type="button" v-show="city != ''" @click="getWeather()">Get weather</button>
    <p className="description" v-show="message != null">{{ message }}</p>
  </div>
</template>

<script>
  import axios from 'axios';

  export default {
    data() {
      return {
        city: "",
        message: ""
      }
    },
    computed: {
      cityName() {
        return "<<" + this.city + ">>";
      }
    },
    methods: {
      getWeather() {
        axios.get(`https://api.openweathermap.org/data/2.5/weather?q=${this.city}&units=metric&appid=c4aff1c51ec1c89aa5bc54ccb831381f`)
          .then(response => this.processResponse(response));
        this.city = "";
      },
      processResponse(response) {
        if(response.data.message == "city not found") {
          this.message = response.data.message;
        } else {
          this.message = "Temperature in " + response.data.name + ": " + response.data.main.temp;
        }
      }
    }
  }
</script>

<style scoped>

</style>
