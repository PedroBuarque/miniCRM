import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../views/Home.vue';
import CustomerList from '../views/CustomerList.vue';
import CustomerForm from '../views/CustomerForm.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/clientes',
    name: 'CustomerList',
    component: CustomerList
  },
  {
    path: '/add-cliente',
    name: 'AddCustomer',
    component: CustomerForm
  },
  {
    path: '/edit-cliente/:id',
    name: 'EditCustomer',
    component: CustomerForm,
    props: true
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;