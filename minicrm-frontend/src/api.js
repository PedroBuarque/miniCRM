import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://localhost:8080', // Adjust if your backend runs on a different URL or port
  headers: {
    'Content-Type': 'application/json'
  }
});

export default {
  getClientes() {
    return apiClient.get('/clientes');
  },
  getCliente(id) {
    return apiClient.get(`/clientes/${id}`);
  },
  addCliente(cliente) {
    return apiClient.post('/clientes', cliente);
  },
  updateCliente(id, cliente) {
    return apiClient.put(`/clientes/${id}`, cliente);
  },
  deleteCliente(id) {
    return apiClient.delete(`/clientes/${id}`);
  }
}