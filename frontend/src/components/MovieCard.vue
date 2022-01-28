<template>
  <div class="card">
    <div class="card-content">
      <p class="title">{{ movie.name }}</p>
      <p class="subtitle">{{ movie.year }}</p>
    </div>
    <footer class="card-footer" v-if="likesEnabled">
      <p class="card-footer-item">
        <a class="icon">
          <i @click="like"
             :class="[movie.liked ? 'fas' : 'far', 'fa-lg', 'fa-thumbs-up']"
          />
        </a>
      </p>
    </footer>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "MovieCard",
  props: {
    userId: {
      type: String,
      required: true
    },
    movie: {
      type: Object,
      required: true
    },
    likesEnabled: {
      type: Boolean,
      default: true
    }
  },
  methods: {
    like() {
      const url = `/users/${this.userId}/like`

      if (this.movie.liked) {
        axios.delete(url, {
          params: {
            movieId: this.movie.id
          }
        }).then(() => {
          this.$emit('setLike', this.movie.id, false)
        })
      } else {
        axios.post(url, null, {
          params: {
            movieId: this.movie.id
          }
        }).then(() => {
          this.$emit('setLike', this.movie.id, true)
        })
      }
    }
  }
}
</script>

<style scoped>
.card {
  max-width: 20%;
}
</style>