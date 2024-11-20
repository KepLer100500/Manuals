<template>
    <div className="message-container">
      <div v-if="users.length == 0">
        <h3 className="message">List is empty</h3>
      </div>
      <div v-else-if="users.length == 1">
        <h3 className="message">In list 1 record</h3>
      </div>
      <div v-else>
        <h3 className="message">In list more than 1 record</h3>
      </div>
    </div>
</template>

<script>
export default {
    props: {
        users: {
            type: Object,
            required: true
        }
    }
}
</script>

<style scoped>
.message-container {
  margin: 20px 0;
  text-align: center;
}

.message {
  color: #888;
}
</style>