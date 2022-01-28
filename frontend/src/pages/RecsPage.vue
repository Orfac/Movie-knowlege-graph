<template>
  <div>
    <UsersDropdown @updated="getUserInfo"/>
    <div id="recommends">
      <MovieCard v-for="m in movies"
                 :movie="m"
                 :likes-enabled="false"
                 :key="m.key"/>
    </div>
  </div>
</template>

<script>
import UsersDropdown from "@/components/UsersDropdown";
import MovieCard from "@/components/MovieCard";
import axios from "axios";

export default {
  name: "RecsPage",
  components: {MovieCard, UsersDropdown},
  data() {
    return {
      movies: [],
      userId: ''
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
