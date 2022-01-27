import {createApp} from "vue"
import VNetworkGraph from "v-network-graph"
import App from "./App.vue"
import axios from "axios";

import "v-network-graph/lib/style.css"
import router from "@/router";

axios.defaults.baseURL = "http://localhost:8081"

createApp(App)
    .use(VNetworkGraph)
    .use(router)
    .mount("#app")