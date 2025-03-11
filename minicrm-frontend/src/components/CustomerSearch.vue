<template>
    <div>
      <h1>Search Customers</h1>
      <input v-model="query" placeholder="Search by name" @input="searchCustomers" />
      <ul>
        <li v-for="customer in filteredCustomers" :key="customer.id">
          {{ customer.name }} - {{ customer.email }}
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import api from '../api';
  
  export default {
    data() {
      return {
        query: '',
        customers: [],
        filteredCustomers: []
      }
    },
    methods: {
      fetchCustomers() {
        api.getCustomers().then(response => {
          this.customers = response.data;
          this.filteredCustomers = this.customers;
        });
      },
      searchCustomers() {
        this.filteredCustomers = this.customers.filter(c =>
          c.name.toLowerCase().includes(this.query.toLowerCase())
        );
      }
    },
    mounted() {
      this.fetchCustomers();
    }
  }
  </script>
  