import { createApp } from 'vue';
import { createStore } from 'vuex'
import ElementPlus from 'element-plus';
import 'element-plus/theme-chalk/index.css';
import App from './App.vue';
import Login from './Login.vue'
import Home from './Home.vue';
import { createRouter, createWebHistory } from 'vue-router';
import createPersistedState from 'vuex';
import axios from "axios";


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/login',
            name: 'Login',
            component: Login
        }
    ]
});

const store = new createStore({
    state: {
        student:{
            name:'新',
            userID: 0,
            username:'',
            password:'',
            majorName:'各',
            direction:0
        }
    },
    mutations: {
        SET_STUDENT(state, student) {
            state.student = student;
        },
    },
    actions: {
        setStudent({ commit }, student) {
            commit('SET_STUDENT', student);
        },
    },
});


const app = createApp(App);
app.use(ElementPlus);
app.use(router);
app.use(store);
app.mount('#app');
