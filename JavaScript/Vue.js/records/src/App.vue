<template>
  <div className="app-container">
    <div className="form-container">
      <input className="form-input" type="text" placeholder="Full Name" v-model="fio" />
      <input className="form-input" type="text" placeholder="Position" v-model="position" />
      <input className="form-input" type="number" placeholder="Salary" v-model="salary" />
      <button className="add-button" type="button" v-on:click="addUser"> Add </button>
    </div>

    <Message :users="users" />

    <div className="user-list">
      <UserCard className="user-card" v-for="(user, idx) in users" :key="idx" :user="user" :idx="idx" :removeUser="removeUser"/>
    </div>
  </div>
</template>

<script>
import UserCard from './components/UserCard.vue';
import Message from './components/Message.vue';

export default {
  components: {
    UserCard,
    Message,
  },
  data() {
    return {
      users: [],
      fio: '',
      position: '',
      salary: 0,
    };
  },
  methods: {
    addUser() {
      this.users.push({
        fio: this.fio,
        position: this.position,
        salary: this.salary,
      });
      // Clear fields
      this.fio = '';
      this.position = '';
      this.salary = 0;
    },
    removeUser(idx) {
      this.users.splice(idx, 1);
    }
  },
};
</script>

<style scoped>
.app-container {
  font-family: Arial, sans-serif;
  max-width: 600px;
  margin: 50px auto;
  padding: 20px;
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.form-container {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.form-input {
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
  transition: border-color 0.2s;
}

.form-input:focus {
  border-color: #007bff;
  outline: none;
}

.add-button {
  padding: 10px;
  font-size: 16px;
  background-color: hwb(143 7% 15%);
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.2s;
}

.add-button:hover {
  background-color: hsl(123, 91%, 56%);
}

.user-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.user-card {
  padding: 15px;
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.user-info {
  margin: 0;
  font-size: 14px;
  color: #333;
}
</style>
