package com.example.gestione_campioni_sql.Service;

import com.example.gestione_campioni_sql.Entity.Champion;
import com.example.gestione_campioni_sql.Repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChampionService {
    @Autowired
    private ChampionRepository championRepository;
    private List<Champion> championList;

    public List<Champion> getChampionList(){
        List<Champion> list = championRepository.findAll();
        return new ArrayList<>(list);
    }

    public Optional<Champion> championByID(Long id){
        return championRepository.findById(id);
    }

    public Champion championByField(String nome, String ruolo, String difficolta, String regione){
        List<Champion> list = championRepository.findAll();

        Champion resultFound = null;

        for(Champion champion : list){
            if(champion.getNome().equals(nome) || champion.getRuolo().equals(ruolo)
                    || champion.getDifficolta().equals(difficolta) || champion.getRegione().equals(regione)){
                resultFound = champion;
            }
        }

        return resultFound;
    }

    public Champion createChampion(Champion newChampion){
        return championRepository.save(newChampion);
    }

    public Champion updateChampion(Long id, Champion championToUpdate){
        for (Champion existingChampion : championList) {
            if (existingChampion.getId().equals(id)) {
                existingChampion.setNome(championToUpdate.getNome());
                existingChampion.setRuolo(championToUpdate.getRuolo());
                existingChampion.setDifficolta(championToUpdate.getDifficolta());
                existingChampion.setDataRilascio(championToUpdate.getDataRilascio());
                existingChampion.setRegione(championToUpdate.getRegione());

                return championToUpdate;
            }
        }
        return null;
    }

    public void deleteChampion(Long id){
        championRepository.deleteById(id);
    }

    public List<Champion> championByNome(String nome){
        return championRepository.findByNome(nome);
    }

    public List<Champion> deleteByNome(String nome){
        return championRepository.deleteByNome(nome);
    }

    public List<Champion> championByRegion(String regione){
        return championRepository.findByRegione(regione);
    }

}
