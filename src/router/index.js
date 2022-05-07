import VueRouter from 'vue-router';

import login from '../components/login.vue'
import homepage from '../components/homepage.vue'

import Experience from '../pages/Experience.vue'
import PersonalCenter from '../pages/PersonalCenter.vue'
import Technology from '../pages/Technology.vue'
import PersonalInformation from '../pages/PersonalInformation.vue'
import Recommend from '../pages/Recommend.vue'
import ChangeInf from '../pages/ChangeInf.vue'
import Share from '../pages/Share.vue'

const router = new VueRouter({
    mode: "history",
    routes: [{
        name: 'login',
        path: '/',
        component: login
    }, {
        name: 'homepage',
        path: '/homepage ',
        component: homepage,
        children: [{
            name: 'Experience',
            path: 'Experience',
            component: Experience
        }, {
            name: 'Technology',
            path: 'Technology',
            component: Technology
        }, {
            name: 'PersonalCenter',
            path: 'PersonalCenter',
            component: PersonalCenter,
            children: [{
                name: 'PersonalInformation',
                path: 'PersonalInformation',
                component: PersonalInformation
            }, {
                name: 'ChangeInf',
                path: 'ChangeInf',
                component: ChangeInf
            }]
        }, {
            name: 'Recommend',
            path: 'Recommend',
            component: Recommend
        }, {
            name: 'Share',
            path: 'Share',
            component: Share
        }]
    }]
})

// 每一次路由切换之前调用、 初始化时被调用
// 全局前置路由守卫
// router.beforeEach((to, from, next) => {
//     console.log(to, from);
//     // if (to.name === 'xiaoxi' || to.name === 'xinwen') {
//     //     if (localStorage.getItem('school') === 'qyyz') {
//     //         next()
//     //     }
//     // } else {
//     //     next()
//     // }
//     if (to.meta.isAuth) {
//         if (localStorage.getItem('school') === 'qyyz') {
//             next()
//         } else {
//             alert('Error!')
//         }
//     } else {
//         next()
//     }
// })

// 全局后置路由守卫
// 每一次路由切换之后调用、 初始化时被调用
// router.afterEach((to, from) => {
//     document.title = to.name || '主页';
// })
export default router;