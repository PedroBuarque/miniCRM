<template>
    <v-data-table
      :headers="headers"
      :items="clientes"
      :items-per-page="5"
      class="elevation-1"
    >
      <!-- eslint-disable-next-line vue/valid-v-slot -->
      <template v-slot:item.actions="{ item }">
        <div style="display: flex; gap: 10px;">
          <v-btn color="primary" @click="$emit('edit', item.id)" small> Edit </v-btn>
          <v-btn color="error" @click="$emit('delete', item.id)" small> Delete </v-btn>
        </div>
      </template>
    </v-data-table>
  </template>
  
  <script>
  export default {
    name: "CustomerTable",
    props: {
      clientes: {
        type: Array,
        default: () => []
      },
      headers: {
        type: Array,
        default: () => []
      }
    }
  };
  </script>
  