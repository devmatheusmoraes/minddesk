package br.com.infnet.minddesk.controllers;

import br.com.infnet.minddesk.exception.ClienteException;
import br.com.infnet.minddesk.model.Cliente;
import br.com.infnet.minddesk.records.ClienteDTO;
import br.com.infnet.minddesk.services.DTOConverterService;
import br.com.infnet.minddesk.services.impl.ClienteServiceImpl;
import br.com.infnet.minddesk.services.impl.SolicitacaoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Clientes", description = " - Operações relacionadas a clientes")
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @Autowired
    private DTOConverterService dtoConverterService;

    @Autowired
    private SolicitacaoServiceImpl solicitacaoService;

    @Operation(summary = "Adicionar um Novo Cliente")
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody ClienteDTO dto) {
        try {
            Cliente cliente = dtoConverterService.converterParaClienteDTO(dto);
            clienteService.save(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
        }catch (ClienteException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @Operation(summary = "Listagem de Clientes")
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        try {
            List<Cliente> clientes = clienteService.findAll();
            return ResponseEntity.ok(clientes);
        }catch (ClienteException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Exibir Cliente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        return clienteOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Editar Cliente por ID")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Cliente clienteAtualizadoSalvo = clienteService.update(id, clienteAtualizado);
        return ResponseEntity.ok(clienteAtualizadoSalvo);
    }

    @Operation(summary = "Excluir Cliente por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if (clienteOptional.isPresent()) {
            if (!solicitacaoService.existsByClienteId(id)) {
                clienteService.deleteById(id);
                return ResponseEntity.ok("Cliente deletado com sucesso");
            }else{
                return ResponseEntity.ok("Existe pelo menos uma solicitação com este Cliente.");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

