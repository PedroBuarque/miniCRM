<template>
    <div>
      <v-card>
        <v-card-title>Customer List</v-card-title>
        <v-data-table
          :headers="headers"
          :items="clientes"
          :items-per-page="5"
          class="elevation-1"
          dark
        >
          <!-- eslint-disable-next-line vue/valid-v-slot -->
          <template v-slot:item.actions="{ item }">
            <v-btn color="primary" @click="editCliente(item.id)" small> Edit </v-btn>
            <v-btn color="error" @click="deleteCliente(item.id)" small> Delete </v-btn>
          </template>
        </v-data-table>
      </v-card>
    </div>
  </template>
  
  <script>
  import api from '../api';
  
  export default {
    name: "CustomerList",
    data() {
      return {
        clientes: [],
        headers: [
          { title: 'ID', key: 'id' },
          { title: 'Name', key: 'nome' },
          { title: 'Email', key: 'email' },
          { title: 'Actions', key: 'actions', sortable: false },
        ]
      }
    },
    methods: {
      fetchClientes() {
        api.getClientes().then(response => {
          this.clientes = response.data;
        });
      },
      editCliente(id) {
        this.$router.push(`/edit-cliente/${id}`);
      },
      deleteCliente(id) {
        api.deleteCliente(id).then(() => {
          this.fetchClientes();
        });
      }
    },
    mounted() {
      this.fetchClientes();
    }
  }
  </script>
  