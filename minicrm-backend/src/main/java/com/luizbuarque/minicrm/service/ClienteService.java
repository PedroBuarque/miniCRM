package com.luizbuarque.minicrm.service;

import com.luizbuarque.minicrm.entity.Cliente;
import com.luizbuarque.minicrm.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    // Consulta de Cliente: Listar todos
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
    
    // Consulta de Cliente: Buscar por ID
    public Optional<Cliente> obterClientePorId(Long id) {
        return clienteRepository.findById(id);
    }
    
    // Inclusão de Cliente: Adicionar novo cliente
    public Cliente incluirCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    // Alteração de Cliente: Atualizar dados do cliente
    public Cliente alterarCliente(Long id, Cliente cliente) {
        return clienteRepository.findById(id).map(c -> {
            c.setCpf(cliente.getCpf());
            c.setNome(cliente.getNome());
            c.setDataNascimento(cliente.getDataNascimento());
            c.setSexo(cliente.getSexo());
            c.setNomeMae(cliente.getNomeMae());
            c.setDataCadastro(cliente.getDataCadastro());
            return clienteRepository.save(c);
        }).orElse(null);
    }
    
    // Exclusão de Cliente: Remover cliente
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}