<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <v-toolbar-title>miniCRM</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn text to="/" rounded>Home</v-btn>
      <v-btn text to="/clientes" rounded>Customers</v-btn>
      <v-btn text to="/add-cliente" rounded>Add Customer</v-btn>
    </v-app-bar>

    <v-main>
      <v-container>
        <router-view></router-view>
      </v-container>
    </v-main>

    <v-footer app padless>
      <v-col class="text-center" cols="12">
        &copy; 2025 miniCRM. All rights reserved.
      </v-col>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
/* You can add custom styling here */
</style>
