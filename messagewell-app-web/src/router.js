import HomeScreen from "@/components/HomeScreen.vue";
import LoginScreen from "@/components/LoginScreen.vue";
import RegisterScreen from "@/components/RegisterScreen.vue";
import {createRouter, createWebHistory} from "vue-router";

const routes = [
    {
        path: "/", component: HomeScreen,
    },
    {
        path: "/login", component: LoginScreen
    },
    {
        path: "/register", component: RegisterScreen
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes: routes
})
export default router