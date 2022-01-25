<template>
  <div>
    <UsersDropdown @updated="getUserInfo"/>
    <div id="recommends">
      <MovieCard/>
      <MovieCard/>
      <MovieCard/>
      <MovieCard/>
      <MovieCard/>
      <MovieCard/>
    </div>
  </div>
</template>

<script>
import UsersDropdown from "@/components/UsersDropdown";
import MovieCard from "@/components/MovieCard";

export default {
  name: "RecsPage",
  components: {MovieCard, UsersDropdown}
}
</script>

<style scoped>

</style>