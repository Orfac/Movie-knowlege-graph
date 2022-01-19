import { createApp } from "vue"
import VNetworkGraph from "v-network-graph"
import "v-network-graph/lib/style.css"
import App from "./App.vue"
import axios from "axios";


const app = createApp(App)

axios.defaults.baseURL = "http://localhost:8081"
// axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

app.use(VNetworkGraph)
app.mount("#app")