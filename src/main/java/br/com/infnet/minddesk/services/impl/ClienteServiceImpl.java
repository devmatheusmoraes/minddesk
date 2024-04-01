package br.com.infnet.minddesk.services.impl;

import br.com.infnet.minddesk.model.Cliente;
import br.com.infnet.minddesk.repositories.ClienteRepository;
import br.com.infnet.minddesk.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente update(Long id, Cliente clienteAtualizado) {
        clienteAtualizado.setId(id);
        return clienteRepository.save(clienteAtualizado);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
