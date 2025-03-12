import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import { createVuetify } from 'vuetify';
import 'vuetify/styles';
import '../src/assets/main.css';
import '@mdi/font/css/materialdesignicons.css';

const vuetify = createVuetify({
  theme: {
    defaultTheme: 'dark', // Set default theme to dark
    themes: {
      dark: {
        dark: true,
        colors: {
          primary: '#1E88E5',    // Adjust primary color
          secondary: '#424242',  // Secondary color
          accent: '#82B1FF',
          error: '#FF5252',
          info: '#2196F3',
          success: '#4CAF50',
          warning: '#FFC107'
        }
      }
    }
  }
});

createApp(App)
  .use(router)
  .use(vuetify)
  .mount('#app');