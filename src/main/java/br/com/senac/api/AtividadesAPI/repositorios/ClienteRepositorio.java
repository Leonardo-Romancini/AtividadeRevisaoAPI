package br.com.senac.api.AtividadesAPI.repositorios;

import br.com.senac.api.AtividadesAPI.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {
}
