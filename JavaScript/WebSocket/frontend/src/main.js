import Vue from 'vue'
import App from './App.vue'

import VueSocketIO from 'vue-socket.io';
Vue.use(new VueSocketIO({
  debug: false,
  connection: 'http://localhost:8080', // URL Socket.IO сервера
}));

new Vue({
  render: (h) => h(App)
}).$mount('#app')
