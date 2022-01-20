<template>
  <div class="columns pt-6">
    <div class="column is-one-quarter">
      <Menu/>
    </div>
    <div class="column is-half mx-auto">
      <router-view/>
    </div>
  </div>
</template>

<script>

// import Graph from "@/components/Graph";

import Menu from "@/components/Menu";

export default {
  name: 'App',
  components: {
    Menu
    // Graph
  }
}
</script>

<style>

</style>
