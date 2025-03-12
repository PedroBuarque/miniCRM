<template>
    <v-menu
      v-model="menu"
      transition="scale-transition"
      offset-y
      min-width="290px"
      :close-on-content-click="false"
    >
      <template #activator="{ props }">
        <!-- Use a computed property via v-model for automatic updates -->
        <v-text-field
          v-model="displayDate"
          label="Date of Birth (YYYY-MM-DD)"
          prepend-inner-icon="mdi-calendar"
          readonly
          v-bind="props"
          :rules="rules"
        ></v-text-field>
      </template>
      <v-date-picker
        v-model="internalDate"
        locale="en"
        hide-title
      >
        <template #actions>
          <v-btn text color="primary" @click="submitDate">OK</v-btn>
        </template>
      </v-date-picker>
    </v-menu>
  </template>
  
  <script>
  export default {
    name: "DatePickerInput",
    props: {
      modelValue: {
        type: [Date, String],
        default: null
      },
      rules: {
        type: Array,
        default: () => []
      }
    },
    data() {
      return {
        menu: false,
        internalDate: null
      };
    },
    computed: {
      // This computed property is used for displaying the formatted date.
      displayDate: {
        get() {
          if (!this.internalDate) return "";
          const date =
            this.internalDate instanceof Date ? this.internalDate : new Date(this.internalDate);
          const year = date.getFullYear();
          const month = String(date.getMonth() + 1).padStart(2, "0");
          const day = String(date.getDate()).padStart(2, "0");
          return `${year}-${month}-${day}`;
        },
        // Read-only since we update the date via the date picker.
        set() {}
      }
    },
    watch: {
      modelValue: {
        immediate: true,
        handler(newVal) {
          if (newVal) {
            this.internalDate = newVal instanceof Date ? newVal : new Date(newVal);
          }
        }
      },
      internalDate(newVal) {
        // Emit the updated date to the parent when it changes.
        this.$emit("update:modelValue", newVal);
      }
    },
    methods: {
      submitDate() {
        // When OK is clicked, simply close the menu.
        this.menu = false;
      }
    }
  };
  </script>
  
  <style scoped>
  /* Add custom styles if needed */
  </style>  