<template>
    <div className="user-card">
        <h3>{{ idx }}</h3>
        <h4 className="user-info">{{ user.fio }}</h4>
        <h4 className="user-info">{{ user.position }}</h4>
        <h4 className="user-info">{{ user.salary }}</h4>
        <button className="delete-button" type="button" @click="removeUser(idx)">Remove</button>
    </div>
</template>

<script>
export default {
    props: {
        user: {
            type: Object,
            required: true
        },
        idx: {
            type: Number,
            required: true
        },
        removeUser: {
            type: Function,
            required: true
        }
    }
}
</script>

<style scoped>
.delete-button {
  padding: 10px 20px;
  font-size: 16px;
  font-weight: bold;
  color: #fff;
  background-color: #e63946; /* Красный цвет */
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: all 0.3s ease;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.delete-button:hover {
  background-color: #d62839; /* Более тёмный красный при наведении */
  box-shadow: 0 6px 8px rgba(0, 0, 0, 0.2);
  transform: translateY(-2px); /* Лёгкий эффект "подъёма" */
}

.delete-button:active {
  background-color: #b71c1c; /* Ещё более тёмный красный при нажатии */
  box-shadow: 0 3px 4px rgba(0, 0, 0, 0.2);
  transform: translateY(1px); /* Эффект "нажатия" */
}

.delete-button:focus {
  outline: none;
  box-shadow: 0 0 0 3px rgba(230, 57, 70, 0.5); /* Красное кольцо */
}
</style>