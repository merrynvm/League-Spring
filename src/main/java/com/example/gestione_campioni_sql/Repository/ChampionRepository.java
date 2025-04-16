package com.example.gestione_campioni_sql.Repository;

import com.example.gestione_campioni_sql.Entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChampionRepository extends JpaRepository<Champion, Long> {

    List<Champion> findByNome(String nome);

    List<Champion> deleteByNome(String nome);

}