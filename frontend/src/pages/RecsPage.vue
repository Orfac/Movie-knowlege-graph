<template>
  <div>
    <div class="field" id="users">
      <p class="control has-icons-left">
    <span class="select">
      <select v-model="userId">
        <option @click="$emit('updated', item.id)"
                v-for="(item, i) in users"
                :value="item.id"
                :key="i">{{ item.name }}</option>
      </select>
    </span>
        <span class="icon is-small is-left">
      <i class="fas fa-user"></i>
    </span>
      </p>
    </div>
    <div id="recommends">
      <MovieCard v-for="m in movies"
                 :movie="m"
                 :likes-enabled="false"
                 :key="m.key"/>
    </div>
  </div>
</template>

<script>
import MovieCard from "@/components/MovieCard";
import axios from "axios";

export default {
  name: "RecsPage",
  components: {MovieCard},
  data() {
    return {
      movies: [],
      userId: '',
      users: []
    }
  },

  methods: {
    getUserInfo(id) {
      this.userId = id;
      this.updateMovies()
    },
    updateMovies() {
      axios.get('users/' + this.userId + '/recommendations').then(response => {
        this.movies = response.data
      })
    }
  },
  created() {
    axios.get('/users').then(response => {
      this.users = response.data
      this.userId = this.users[0].id
      this.updateMovies()
    })
  }

}
</script>

<style scoped>
#recommends {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: flex-start;
  align-items: flex-start;
}

#recommends > * {
  margin: 20px;
}
</style>
