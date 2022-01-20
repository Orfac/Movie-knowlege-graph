<template>
  <Graph :elements="elements"/>
</template>

<script>
import Graph from "@/components/Graph";
import axios from "axios";

export default {
  name: "BigGraphPage",
  components: {Graph},
  data() {
    return {
      elements: {},
      nodes: {},
      edges: {}
    }
  },
  created() {
    axios
        .get('/graph')
        .then(response => {
          this.nodes = response.data.nodes;
          this.edges = response.data.edges;
          this.elements = response.data;
        })

  }
}
</script>

<style scoped>

</style>