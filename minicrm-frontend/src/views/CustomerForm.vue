<template>
  <v-card class="pa-5">
    <v-card-title>
      {{ isEditing ? "Edit Customer" : "Add Customer" }}
    </v-card-title>
    <v-form ref="form" v-model="valid">
      <FormInput label="Name" v-model="cliente.nome" :rules="[rules.required, rules.string]" required />
      <FormInput label="CPF" v-model="cliente.cpf" :rules="[rules.required, rules.cpf]" required />
      <DatePickerInput v-model="cliente.dataNascimento" :rules="[rules.required, rules.validDate]" />
      <FormInput label="Sexo" v-model="cliente.sexo" :rules="[rules.required, rules.sex]" required />
      <FormInput label="Mother's Name" v-model="cliente.nomeMae" :rules="[rules.required, rules.string]" required />
      <v-btn color="primary" type="submit" @click="submitForm" rounded>
        {{ isEditing ? "Update" : "Add" }}
      </v-btn>
    </v-form>
  </v-card>
</template>

<script>
import api from '../api';
import FormInput from '@/components/FormInput.vue';
import DatePickerInput from '@/components/DatePickerInput.vue';

export default {
  name: "CustomerForm",
  components: {
    FormInput,
    DatePickerInput
  },
  data() {
    return {
      valid: false,
      cliente: {
        nome: '',
        cpf: '',
        email: '',
        dataNascimento: null,
        sexo: '',
        nomeMae: '',
        dataCadastro: ''
      },
      isEditing: false,
      rules: {
        required: v => !!v || 'This field is required',
        string: v => /^[A-Za-zÀ-ÿ\s]+$/.test(v) || 'Must contain only letters and spaces',
        cpf: v => /^\d{11}$/.test(v) || 'CPF must contain exactly 11 digits',
        validDate: v => {
          console.log("Validating date:", v);
          const date = v instanceof Date ? v : new Date(v);
          return !isNaN(date.getTime()) || 'Enter a valid date (YYYY-MM-DD)';
        },
        sex: v => ['male', 'female'].includes(v) || 'Sexo must be "m" or "f"',
      }
    }
  },
  methods: {
    submitForm() {
      if (this.$refs.form.validate()) {
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
    }
  },
  created() {
    const id = this.$route.params.id;
    if (id) {
      this.isEditing = true;
      api.getCliente(id).then(response => {
        const data = response.data;
        if (data.dataNascimento) {
          data.dataNascimento = new Date(data.dataNascimento);
        }
        this.cliente = data;
      });
    }
  }
}
</script>
