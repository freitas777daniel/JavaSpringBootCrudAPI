package crudModelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crudModelo.model.Proprietario;


@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

}
