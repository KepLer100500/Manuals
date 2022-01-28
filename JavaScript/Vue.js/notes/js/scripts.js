const App = {
    data() {
        return {
            title: 'Заметки',
            counter: 0,
            placeholderString: "Введите текст заметки",
            inputValue: "",
            notes: []
        }
    }, 
    methods: {
        addNote() {
            // Add new note, if note is not empty
            if (this.inputValue !== "") {
                this.notes.push(this.inputValue);
                this.inputValue = "";
            }
        }, 
        removeNote(idx) {
            // Delete selected note
            this.notes.splice(idx, 1);
        },
        toUpper(text) {
            // Put text note into upper case
            return text.toUpperCase();
        }
    },
    computed: {
        doubleCount() {
            // Calculate count notes * 2
            return this.notes.length * 2;
        }
    },
    watch: {
        inputValue(value){
            // If note length more than 10, clear input field 
            if(this.inputValue.length > 10){
                this.inputValue = "";
            }
        }
    }
}

Vue.createApp(App).mount('#app')