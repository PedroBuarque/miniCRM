<template>
  <v-card>
    <v-card-title>
      Customer List
    </v-card-title>
    <!-- Use the search bar component -->
    <CustomerSearchBar
      :query="query"
      :searchField="searchField"
      @update:query="query = $event"
      @update:searchField="searchField = $event"
    />
    <!-- Use the customer table component -->
    <CustomerTable
      :clientes="filteredClientes"
      :headers="headers"
      @edit="editCliente"
      @delete="deleteCliente"
    />
  </v-card>
</template>

<script>
import api from '../api';
import CustomerSearchBar from '@/components/CustomerSearchBar.vue';
import CustomerTable from '@/components/CustomerTable.vue';

export default {
  name: "CustomerList",
  components: {
    CustomerSearchBar,
    CustomerTable
  },
  data() {
    return {
      query: "",
      searchField: "all",
      clientes: [],
      headers: [
        { title: 'ID', value: 'id' },
        { title: 'CPF', value: 'cpf' },
        { title: 'Name', value: 'nome' },
        { title: 'Date of Birth', value: 'dataNascimento' },
        { title: 'Sexo', value: 'sexo' },
        { title: "Mother's Name", value: 'nomeMae' },
        {title: 'Registration date', value: 'dataCadastro'},
        { title: 'Actions', value: 'actions', sortable: false },
      ]
    };
  },
  computed: {
    filteredClientes() {
      if (!this.query) return this.clientes;
      const q = this.query.toLowerCase();
      if (this.searchField === "all") {
        return this.clientes.filter(cliente =>
          (cliente.cpf && cliente.cpf.toString().toLowerCase().includes(q)) ||
          (cliente.nome && cliente.nome.toLowerCase().includes(q)) ||
          (cliente.nomeMae && cliente.nomeMae.toLowerCase().includes(q)) ||
          (cliente.sexo && cliente.sexo.toLowerCase().includes(q)) ||
          (cliente.dataNascimento &&
            cliente.dataNascimento.toString().toLowerCase().includes(q))
        );
      } else {
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
};
</script>
