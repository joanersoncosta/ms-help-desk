package com.github.joanersoncosta.apiordem.ordem.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.joanersoncosta.apiordem.ordem.domain.Ordem;

public interface OrdemSpringJpaInfraRepository extends JpaRepository<Ordem, UUID>{

}
