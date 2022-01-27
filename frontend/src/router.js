import {createRouter, createWebHistory} from "vue-router";

import HelloPage from "@/pages/HelloPage";
import BigGraphPage from "@/pages/BigGraphPage";
import RecommendationPage from "@/pages/SetPrefsPage";
import CreateUserPage from "@/pages/CreateUserPage";
import CreateMoviePage from "@/pages/CreateMoviePage";
import SetPrefsPage from "@/pages/SetPrefsPage";

export default createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', component: HelloPage},
        {path: '/all', component: BigGraphPage},
        {path: '/prefs', component: SetPrefsPage},
        {path: '/newuser', component: CreateUserPage},
        {path: '/newmovie', component: CreateMoviePage},
        {path: '/recs', component: RecommendationPage}
    ]
})
