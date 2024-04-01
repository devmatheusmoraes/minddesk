package br.com.infnet.minddesk.services;

import br.com.infnet.minddesk.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    void save(Cliente cliente);

    List<Cliente> findAll();

    Optional<Cliente> findById(Long id);

    Cliente update(Long id, Cliente clienteAtualizado);

    void deleteById(Long id);
}
