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
import MovieCard from "@/components/MovieCard";
import UsersDropdown from "@/components/UsersDropdown";

export default {
  name: "SetPrefsPage",
  components: {UsersDropdown, MovieCard},
  data() {
    return {
      userId: 0
    }
  },
  methods: {
    getUserInfo(id) {
      this.userId = id
      console.log('current user:', id)
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
}

#recommends > * {
  margin: 20px;
}
</style>