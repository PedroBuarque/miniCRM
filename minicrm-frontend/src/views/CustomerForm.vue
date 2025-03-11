<template>
    <v-card class="pa-5">
      <v-card-title>{{ isEditing ? "Edit Customer" : "Add Customer" }}</v-card-title>
      <v-form @submit.prevent="handleSubmit">
        <v-text-field label="Name" v-model="cliente.nome" required></v-text-field>
        <v-text-field label="CPF" v-model="cliente.cpf" required></v-text-field>
        <v-text-field label="Email" v-model="cliente.email" required></v-text-field>
        <v-text-field label="Data de Nascimento" v-model="cliente.dataNascimento" required></v-text-field>
        <v-text-field label="Sexo" v-model="cliente.sexo" required></v-text-field>
        <v-text-field label="Nome da Mãe" v-model="cliente.nomeMae" required></v-text-field>
        <!-- Add more fields as needed, such as date fields for dataNascimento, etc. -->
        <v-btn color="primary" type="submit" rounded>
          {{ isEditing ? "Update" : "Add" }}
        </v-btn>
      </v-form>
    </v-card>
  </template>
  
  <script>
  import api from '../api';
  
  export default {
    name: "CustomerForm",
    data() {
      return {
        cliente: {
          nome: '',
          cpf: '',
          email: '',
          sexo: '',
          nomeMae: '',
          dataNascimento:'',
          dataCadastro: '',
          // add additional properties: dataNascimento, sexo, nomeMae, dataCadastro
        },
        isEditing: false
      }
    },
    methods: {
  handleSubmit() {
    // Set the registration date to the current time in ISO format
    this.cliente.dataCadastro = new Date().toISOString();

    if (this.cliente.id) {
      api.updateCliente(this.cliente.id, this.cliente).then(() => {
        this.$router.push('/clientes');
      });
    } else {
      api.addCliente(this.cliente).then(() => {
        this.$router.push('/clientes');
      });
    }
  }
},
    
    created() {
      const id = this.$route.params.id;
      if (id) {
        this.isEditing = true;
        api.getCliente(id).then(response => {
          this.cliente = response.data;
        });
      }
    }
  }
  </script>
  