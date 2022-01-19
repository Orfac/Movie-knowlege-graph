<template>
  <div class="graph">
    <v-network-graph
        v-if="enabled"
        :nodes="nodes"
        :edges="edges"
        :configs="config"
    >
      <template #edge-label="{ edge, ...slotProps }">
        <v-edge-label :text="edge.name" align="center" vertical-align="above" v-bind="slotProps"/>
      </template>
    </v-network-graph>
  </div>
</template>

<script>
import {VNetworkGraph} from "v-network-graph";
import {ForceLayout} from 'v-network-graph/lib/force-layout.es'
import axios from "axios";

export default {
  name: "Graph",
  components: {VNetworkGraph},
  data() {
    return {
      nodes: {},
      edges: {},
      enabled: false,
      config: {
        view: {
          layoutHandler: new ForceLayout({
            positionFixedByDrag: false,
            positionFixedByClickWithAltKey: true,
          }),
        },
        edge: {
          marker: {
            target: {
              type: 'arrow'
            }
          }
        }
      }
    }
  },
  mounted() {
    axios.get("/graph")
        .then(response => {
          this.nodes = response.data.nodes
          this.edges = response.data.edges

          this.enabled = true
        })
  }
}
</script>

<style scoped>
.graph {
  max-width: 50%;
  max-height: 50%;
  margin: 0 auto;
}
</style>