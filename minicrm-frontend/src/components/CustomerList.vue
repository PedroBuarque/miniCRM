<template>
    <div>
      <h1>Customer List</h1>
      <ul>
        <li v-for="customer in customers" :key="customer.id">
          {{ customer.name }} - {{ customer.email }}
          <button @click="deleteCustomer(customer.id)">Delete</button>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import api from '../api';
  
  export default {
    data() {
      return {
        customers: []
      }
    },
    methods: {
      fetchCustomers() {
        api.getCustomers().then(response => {
          this.customers = response.data;
        });
      },
      deleteCustomer(id) {
        api.deleteCustomer(id).then(() => {
          this.fetchCustomers();
        });
      }
    },
    mounted() {
      this.fetchCustomers();
    }
  }
  </script>
  