package com.luizbuarque.minicrm.controller;

import com.luizbuarque.minicrm.entity.Cliente;
import com.luizbuarque.minicrm.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    // Consulta de Cliente: Listar todos os clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
    
    // Consulta de Cliente: Buscar um cliente por ID
    @GetMapping("/{id}")
    public Optional<Cliente> obterCliente(@PathVariable Long id) {
        return clienteService.obterClientePorId(id);
    }
    
    // Inclusão de Cliente: Adicionar novo cliente
    @PostMapping
    public Cliente incluirCliente(@RequestBody Cliente cliente) {
        return clienteService.incluirCliente(cliente);
    }
    
    // Alteração de Cliente: Atualizar cliente existente
    @PutMapping("/{id}")
    public Cliente alterarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.alterarCliente(id, cliente);
    }
    
    // Exclusão de Cliente: Deletar um cliente
    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
    }
}
