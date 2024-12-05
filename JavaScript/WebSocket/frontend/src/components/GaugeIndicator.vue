<template>
    <div class="gauge-indicator">
      <svg :width="size" :height="size" viewBox="0 0 100 100">
        <!-- Внешний круг -->
        <circle
          cx="50"
          cy="50"
          r="45"
          stroke="black"
          fill="none"
          stroke-width="2"
        ></circle>
        
        <!-- Числа по кругу -->
        <g v-for="tick in ticks" :key="tick.value">
          <text
            :x="tick.x"
            :y="tick.y"
            fill="black"
            font-size="4"
            text-anchor="middle"
            dominant-baseline="middle"
          >
            {{ tick.value }}
          </text>
        </g>
  
        <!-- Стрелка -->
        <line
          x1="50"
          y1="50"
          :x2="arrowX"
          :y2="arrowY"
          stroke="black"
          stroke-width="2"
        ></line>
      </svg>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      value: {
        type: Number,
        required: true,
        validator: (v) => v >= 0 && v <= 100,
      },
      size: {
        type: Number,
        default: 200, // Размер SVG
      },
    },
    computed: {
      ticks() {
        // Создаем массив чисел по окружности (каждые 20%)
        const radius = 40;
        return Array.from({ length: 20 }, (_, i) => {
          const angle = (i * 10 * Math.PI) / 100 - Math.PI / 2;
          return {
            value: i * 5,
            x: 50 + radius * Math.cos(angle),
            y: 50 + radius * Math.sin(angle),
          };
        });
      },
      arrowAngle() {
        // Угол стрелки в радианах
        return (this.value * Math.PI) / 50 - Math.PI / 2;
      },
      arrowX() {
        // Координата X конца стрелки
        const radius = 40;
        return 50 + radius * Math.cos(this.arrowAngle);
      },
      arrowY() {
        // Координата Y конца стрелки
        const radius = 40;
        return 50 + radius * Math.sin(this.arrowAngle);
      },
    },
  };
  </script>
  
  <style scoped>
  .gauge-indicator {
    display: inline-block;
  }
  </style>
  