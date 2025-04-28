package com.example.gestione_campioni_sql.Repository;

import com.example.gestione_campioni_sql.Entity.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChampionRepository extends JpaRepository<Champion, Long> {

    List<Champion> findByNome(String nome);

    List<Champion> deleteByNome(String nome);

    @Query("select b from Champion b where b.regione = ?1")
    List<Champion> findByRegione(String regione);

    @NativeQuery("select * from champion where ruolo = ?1")
    List<Champion> findByRuolo(String ruolo);

    @Query(value = "select * from champion where difficolta = :difficolta", nativeQuery = true)
    List<Champion> findByDifficolta(@Param("difficolta") String difficolta);

}