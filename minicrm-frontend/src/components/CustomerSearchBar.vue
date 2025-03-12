<template>
    <v-row align="center" class="mb-4">
      <v-col cols="12" sm="6" md="4">
        <v-text-field
          v-model="localQuery"
          label="Search Customers"
          solo
          dense
          hide-details
          clearable
          @input="onSearchChange"
        ></v-text-field>
      </v-col>
      <v-col cols="12" sm="6" md="4">
        <v-select
          v-model="localField"
          :items="searchFields"
          label="Search Field"
          solo
          dense
          hide-details
          style="max-width: 150px;"
          @change="onFieldChange"
        ></v-select>
      </v-col>
    </v-row>
  </template>
  
  <script>
  export default {
    name: "CustomerSearchBar",
    props: {
      query: {
        type: String,
        default: ""
      },
      searchField: {
        type: String,
        default: "all"
      }
    },
    data() {
      return {
        localQuery: this.query,
        localField: this.searchField,
        searchFields: [
          { title: "All", value: "all" },
          { title: "CPF", value: "cpf" },
          { title: "Name", value: "nome" },
          { title: "Date of Birth", value: "dataNascimento" },
          { title: "Mother's Name", value: "nomeMae" },
          { title: "Sexo", value: "sexo" }
        ]
      }
    },
    methods: {
      onSearchChange() {
        this.$emit("update:query", this.localQuery);
      },
      onFieldChange() {
        this.$emit("update:searchField", this.localField);
      }
    },
    watch: {
      query(newVal) {
        this.localQuery = newVal;
      },
      searchField(newVal) {
        this.localField = newVal;
      }
    }
  };
  </script>  