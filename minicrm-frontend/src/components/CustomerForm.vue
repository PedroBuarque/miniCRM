<template>
    <div>
      <h1>Add / Edit Customer</h1>
      <form @submit.prevent="handleSubmit">
        <div>
          <label>Name:</label>
          <input v-model="customer.name" required />
        </div>
        <div>
          <label>Email:</label>
          <input v-model="customer.email" type="email" required />
        </div>
        <div>
          <label>Phone Number:</label>
          <input v-model="customer.phoneNumber" required />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  </template>
  
  <script>
  import api from '../api';
  
  export default {
    data() {
      return {
        customer: {
          name: '',
          email: '',
          phoneNumber: ''
        }
      }
    },
    methods: {
      handleSubmit() {
        // Check if customer has an ID (editing) or not (adding)
        if (this.customer.id) {
          api.updateCustomer(this.customer.id, this.customer).then(() => {
            this.$router.push('/');
          });
        } else {
          api.addCustomer(this.customer).then(() => {
            this.$router.push('/');
          });
        }
      }
    },
    created() {
      // If editing an existing customer, load its data using the ID from the URL
      const id = this.$route.params.id;
      if (id) {
        api.getCustomer(id).then(response => {
          this.customer = response.data;
        });
      }
    }
  }
  </script>
  