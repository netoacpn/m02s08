package tech.devinhouse.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.ponto.module.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Integer> {
}
