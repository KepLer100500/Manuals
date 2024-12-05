<template>
    <div class="progress-bar">
      <svg :width="width" :height="height">
        <!-- Рамка -->
        <rect
          x="0"
          y="0"
          :width="width"
          :height="height"
          stroke="blue"
          fill="none"
          stroke-width="2"
        ></rect>
        <!-- Заполняющий прямоугольник -->
        <rect
          x="0"
          y="0"
          :width="fillWidth"
          :height="height"
          :fill="fillColor"
        ></rect>
      </svg>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      progress: {
        type: Number,
        required: true,
        validator: (value) => value >= 0 && value <= 100,
      },
      width: {
        type: Number,
        default: 200, // Ширина прямоугольника
      },
      height: {
        type: Number,
        default: 20, // Высота прямоугольника
      },
    },
    computed: {
      fillWidth() {
        // Ширина заливки в зависимости от прогресса
        return (this.width * this.progress) / 100;
      },
      fillColor() {
        // Синий для 0-80, красный для 80-100
        // return this.progress > 80 ? "red" : "blue";
        var color = "";
        if(this.progress <= 60) {
            color = "blue";
        }
        if(this.progress > 60 && this.progress <= 80) {
            color = "yellow";
        }
        if(this.progress > 80 && this.progress <= 100) {
            color = "red";
        }
        return color;
      },
    },
  };
  </script>
  
  <style scoped>
  .progress-bar {
    display: inline-block;
  }
  </style>
  