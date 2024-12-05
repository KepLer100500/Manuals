<template>
  <div>
    <h2>Values</h2>
    <h3>Field1: {{ items.field1 }}</h3>
    <h3>Field2: {{ items.field2 }}</h3>
    <h3>Field3: {{ items.field3 }}</h3>
    <ProgressBar :progress="progress" :width="300" :height="30" />
    <br>
    <GaugeIndicator :value="currentValue" :size="200" />
  </div>
</template>

<script>
import ProgressBar from './ProgressBar.vue';
import GaugeIndicator from './GaugeIndicator.vue';

export default {
  components: {
    ProgressBar,
    GaugeIndicator,
  },
  data() {
    return {
      progress: 0,
      currentValue: 0,
      items: {
        field1: 0,
        field2: 0,
        field3: 0,
      },
      
    };
  },
  sockets: {
    connect() {
      console.log('Socket connected');
    },
    dataUpdated(data) {
      // console.log('Data received:', data);
      this.progress = data.field3;
      this.currentValue = data.field3;

      this.items = data;
    },
  },
};
</script>
