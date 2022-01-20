import {createApp} from "vue"
import VNetworkGraph from "v-network-graph"
import App from "./App.vue"
import axios from "axios";

import "v-network-graph/lib/style.css"
import {createRouter, createWebHistory} from "vue-router";
import HelloPage from "@/pages/HelloPage";
import BigGraphPage from "@/pages/BigGraphPage";

axios.defaults.baseURL = "http://localhost:8081"

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', component: HelloPage},
        {path: '/all', component: BigGraphPage}
    ]
})

createApp(App)
    .use(VNetworkGraph)
    .use(router)
    .mount("#app")