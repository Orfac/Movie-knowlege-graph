<template>
  <div class="field" id="users">
    <p class="control has-icons-left">
    <span class="select">
      <select v-model="currentIndex">
        <option @click="$emit('updated', item.id)"
                v-for="(item, i) in items"
                :value="item.id"
                :key="i">{{ item.name }}</option>
      </select>
    </span>
      <span class="icon is-small is-left">
      <i class="fas fa-user"></i>
    </span>
    </p>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "UsersDropdown",
  data() {
    return {
      currentIndex: '',
      items: []
    }
  },
  created() {
    axios.get('/users').then(response => {
      this.items = response.data
      this.currentIndex = this.items[0].id
      this.$emit('updated', this.items[0].id)
    })
  }
}
</script>

<style scoped>
#users {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}
</style>