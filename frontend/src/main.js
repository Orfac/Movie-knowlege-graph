import {createApp} from "vue"
import VNetworkGraph from "v-network-graph"
import App from "./App.vue"
import axios from "axios";

import "v-network-graph/lib/style.css"
import {createRouter, createWebHistory} from "vue-router";
import HelloPage from "@/pages/HelloPage";
import BigGraphPage from "@/pages/BigGraphPage";
import RecommendationPage from "@/pages/SetPrefsPage";
import CreateUserPage from "@/pages/CreateUserPage";

axios.defaults.baseURL = "http://localhost:8081"

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', component: HelloPage},
        {path: '/all', component: BigGraphPage},
        {path: '/prefs', component: RecommendationPage},
        {path: '/newuser', component: CreateUserPage},
        // {path: '/recs', component: BigGraphPage}
    ]
})

createApp(App)
    .use(VNetworkGraph)
    .use(router)
    .mount("#app")