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
        item-text="title"
        item-value="value"
        label="Search Field"
        solo
        dense
        hide-details
        style="max-width: 150px;"
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
    };
  },
  methods: {
    onSearchChange() {
      this.$emit("update:query", this.localQuery);
    }
  },
  watch: {
    // When localField changes, emit an event to update the parent’s searchField
    localField(newVal) {
      this.$emit("update:searchField", newVal);
    },
    // Also sync changes coming from parent into our local values:
    query(newVal) {
      this.localQuery = newVal;
    },
    searchField(newVal) {
      this.localField = newVal;
    }
  }
};
</script>
