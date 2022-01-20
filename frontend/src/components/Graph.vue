<template>
  <div class="box" id="graph-box">
    <v-network-graph
        class="graph"
        :nodes="elements.nodes"
        :edges="elements.edges"
        :configs="config"
        :key="key"
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
import { v4 as uuid } from 'uuid';

export default {
  name: "Graph",
  components: {VNetworkGraph},
  props: {
    elements: {
      type: Object
    }
  },
  data() {
    return {
      key: uuid(),
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
  methods: {
    refresh() {
      this.key = uuid()
    }
  },
  watch: {
    elements() {
      this.refresh()
    }
  }
}
</script>

<style scoped>
#graph-box {
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.graph {
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 80vh;
  /*margin: auto;*/

  /*overflow: hidden;*/
  /*margin: 0 auto;*/
}
</style>