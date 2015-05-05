package br.com.desafiowallmart.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.desafiowallmart.domain.Local;

public interface LocalRepository extends CrudRepository<Local, String> {

    Local findByNome(String nome);
}
