<template>
  <div class="card">
    <div class="card-content">
      <p class="title">Star Wars</p>
      <p class="subtitle">2021</p>
    </div>
    <footer class="card-footer">
      <p class="card-footer-item">
        <a class="icon">
          <i @click="liked = !liked"
             :class="[liked ? 'fas' : 'far', 'fa-lg', 'fa-thumbs-up']"
          />
        </a>
      </p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "MovieCard",
  data() {
    return {
      liked: false
    }
  },
}
</script>

<style scoped>
.card {
  max-width: 20%;
}
</style>