package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.model.Artigo;
import br.com.infnet.minddesk.model.Cliente;
import br.com.infnet.minddesk.services.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        return clienteOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Cliente cliente = clienteOptional.get();
        Cliente clienteAtualizadoSalvo = clienteService.update(id, clienteAtualizado);
        return ResponseEntity.ok(clienteAtualizadoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isPresent()) {
            clienteService.deleteById(id);
            return ResponseEntity.ok("Cliente deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

