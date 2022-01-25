<template>
  <div>
    <UsersDropdown @updated="getUserInfo"/>
    <div id="recommends">
      <MovieCard v-for="m in movies"
                 :key="m.id"
                 :movie="m"
                 @set-like="setLike"
                 :user-id="userId"/>
    </div>
  </div>
</template>

<script>
import MovieCard from "@/components/MovieCard";
import UsersDropdown from "@/components/UsersDropdown";
import axios from "axios";

export default {
  name: "SetPrefsPage",
  components: {UsersDropdown, MovieCard},
  data() {
    return {
      userId: '',
      movies: []
    }
  },
  methods: {
    setLike(id, value) {
      const i = this.movies.findIndex(m => m.id === id)
      this.movies[i].liked = value
    },
    getUserInfo(id) {
      this.userId = id
      console.log('current user:', id)
      this.updateMovies()
    },
    async updateMovies() {
      const response = await axios.get('/movies')

      this.movies = response.data;

      console.log(this.movies)

      axios.get(`/users/${this.userId}`).then(response => {
        const liked = response.data.liked;

        for (const m of this.movies) {
          m.liked = liked.filter(l => l.id === m.id).length > 0
        }
      })
    }
  }
};
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