<template>
  <div class="box">
    <div class="field">
      <label class="label">Ник</label>
      <div class="control">
        <input v-model="username" class="input" type="text">
      </div>
    </div>
    <div class="field">
      <label class="label">Возраст</label>
      <div class="control">
        <input v-model="age" class="input" type="number">
      </div>
    </div>
    <div class="field is-grouped">
      <div class="control">
        <button @click="create" class="button is-link">Создать</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "CreateUserPage",
  data() {
    return {
      username: '',
      age: 0
    }
  },
  methods: {
    create() {
      axios.post('/users', {
        name: this.username,
        age: this.age
      }).then(() => {
        console.log('user created')
        this.$router.push('/all')
      })
    }
  }
}
</script>

<style scoped>

</style>