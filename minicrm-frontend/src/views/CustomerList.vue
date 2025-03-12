<template>
  <v-card>
    <v-card-title>
      Customer List
      <v-spacer></v-spacer>
      <v-text-field v-model="query" label="Search Customers" solo clearable></v-text-field>
      <v-select
        v-model="searchField"
        :items="searchFields"
        label="Search Field"
        dense
        hide-details
        style="max-width: 150px;"
      ></v-select>
    </v-card-title>
    <v-data-table
      :headers="headers"
      :items="filteredClientes"
      :items-per-page="5"
      class="elevation-1"
    >
      <!-- eslint-disable-next-line vue/valid-v-slot -->
      <template v-slot:item.actions="{ item }">
        <div style="display: flex; gap: 10px; justify-content: start;">
          <v-btn color="primary" @click="editCliente(item.id)" small> Edit </v-btn>
          <v-btn color="error" @click="deleteCliente(item.id)" small> Delete </v-btn>
        </div>
      </template>
    </v-data-table>
  </v-card>
</template>


<script>
import api from '../api';

export default {
  name: "CustomerList",
  data() {
    return {
      query: "",
      // Default search field is "all", meaning search across all fields
      searchField: "all",
      // Options for the search field selector
      searchFields: [
        { title: "All", value: "all" },
        { title: "CPF", value: "cpf" },
        { title: "Name", value: "nome" },
        { title: "Data of Birth", value: "dataNascimento"},
        { title: "Mother's Name", value: "nomeMae" },
        { title: "Sexo", value: "sexo" }
      ],
      clientes: [],
      headers: [
        { title: 'ID', value: 'id' },
        { title: 'CPF', value: 'cpf' },
        { title: 'Name', value: 'nome' },
        { title: 'Data of Birth', value: 'dataNascimento'},
        { title: "Mother's Name", value: 'nomeMae' },
        { title: 'Sexo', value: 'sexo' },
        { title: 'Actions', value: 'actions', sortable: false },
      ]
    }
  },
  computed: {
    filteredClientes() {
      // If no search query is provided, return all customers.
      if (!this.query) return this.clientes;
      const q = this.query.toLowerCase();
      if (this.searchField === "all") {
        // Filter across all fields.
        return this.clientes.filter(cliente =>
          (cliente.cpf && cliente.cpf.toString().toLowerCase().includes(q)) ||
          (cliente.nome && cliente.nome.toLowerCase().includes(q)) ||
          (cliente.nomeMae && cliente.nomeMae.toLowerCase().includes(q)) ||
          (cliente.sexo && cliente.sexo.toLowerCase().includes(q))
        );
      } else {
        // Filter only the selected field.
        return this.clientes.filter(cliente => {
          const fieldValue = cliente[this.searchField];
          return fieldValue && fieldValue.toString().toLowerCase().includes(q);
        });
      }
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
