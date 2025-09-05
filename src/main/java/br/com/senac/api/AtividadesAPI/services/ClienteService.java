package br.com.senac.api.AtividadesAPI.services;

import br.com.senac.api.AtividadesAPI.controllers.dto.ClienteRequestDTO;
import br.com.senac.api.AtividadesAPI.modelos.Cliente;
import br.com.senac.api.AtividadesAPI.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public void criar(ClienteRequestDTO cliente) {
        Cliente clientePersist = this.clienteRequestDtoParaCliente(cliente);
        clienteRepositorio.save(clientePersist);
    }

    public Cliente atualizar(Long id, ClienteRequestDTO cliente) throws Exception {
        if (!clienteRepositorio.existsById(id)){
            throw new RuntimeException("Registro não encontrado.");
        }
        Cliente clientePersist = this.clienteRequestDtoParaCliente(cliente);
        clientePersist.setId(id);
        return clienteRepositorio.save(clientePersist);
    }

    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    public void deletar(Long id){
        if (!clienteRepositorio.existsById(id)){
            throw new RuntimeException("Registro não encontrado");
        }
        clienteRepositorio.deleteById(id);
    }

    private Cliente clienteRequestDtoParaCliente(ClienteRequestDTO in) {
        Cliente out = new Cliente();
        out.setNome(in.getNome());
        out.setSobrenome(in.getSobrenome());
        out.setEmail(in.getEmail());
        out.setIdade(in.getIdade());
        out.setSexo(in.getSexo());
        out.setDataNascimento(in.getDataNascimento());
        out.setDdd(in.getDdd());
        out.setTelefone(in.getTelefone());

        return out;
    }
}
