package br.com.senac.api.AtividadesAPI.controllers;

import br.com.senac.api.AtividadesAPI.controllers.dto.ClienteRequestDTO;
import br.com.senac.api.AtividadesAPI.modelos.Cliente;
import br.com.senac.api.AtividadesAPI.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/criar")
    public ResponseEntity<Void> cadastrarCliente(@RequestBody ClienteRequestDTO cliente) {
        System.out.println(cliente.toString());
        clienteService.criar(cliente);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody ClienteRequestDTO cliente){
        try {
            return ResponseEntity.ok(clienteService.atualizar(id, cliente));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            clienteService.deletar(id);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
