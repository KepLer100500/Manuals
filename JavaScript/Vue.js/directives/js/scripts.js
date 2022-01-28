const App = {
    data() {
        return {
            title: 'Заголовок 1',
            myHtml: '<h1>Заголовок 0</h1>',
            person: {
                name: 'Иван',
                surname: 'Иванов',
                age: 33
            },
            items: [1, 2, 3, 4]
        }
    },
    methods: {
        removeItem(i){
            this.items.splice(i, 1);
        },
        log(item){
            alert(item);
        }
    },
    computed: {
        evenItems() {
            return this.items.filter(i => i % 2 === 0);
        }
    }
}

Vue.createApp(App).mount('#app')