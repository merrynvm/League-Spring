package com.example.gestione_campioni_sql.Repository;

import com.example.gestione_campioni_sql.Entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChampionRepository extends JpaRepository<Champion, Long> {

    List<Champion> findByNome(String nome);

    List<Champion> deleteByNome(String nome);

    @Query("select b from Champion b where b.regione = ?1")
    List<Champion> findByRegione(String regione);

    @Query(value = "select * from champion where ruolo = ?1", nativeQuery = true)
    List<Champion> findByRuolo(String ruolo);

}