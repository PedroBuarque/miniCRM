<template>
  <v-text-field
    v-model="value"
    :label="label"
    v-bind="$attrs"
    :rules="rules"
    :type="type"
    :readonly="readonly"
  ></v-text-field>
</template>

<script>
export default {
  name: "FormInput",
  inheritAttrs: false,
  props: {
    label: {
      type: String,
      required: true
    },
    modelValue: {
      type: [String, Number],
      default: ""
    },
    rules: {
      type: Array,
      default: () => []
    },
    type: {
      type: String,
      default: "text"
    },
    readonly: {
      type: Boolean,
      default: false
    }
  },
  computed: {
    value: {
      get() {
        return this.modelValue;
      },
      set(newValue) {
        this.$emit("update:modelValue", newValue);
      }
    }
  }
};
</script>
