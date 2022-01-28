const App = {
    data() {
        return {
            title: 'Счётчик',
            counter: 0
        }
    }
}

Vue.createApp(App).mount('#app')