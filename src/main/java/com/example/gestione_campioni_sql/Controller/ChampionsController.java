package com.example.gestione_campioni_sql.Controller;

import com.example.gestione_campioni_sql.Entity.Champion;
import com.example.gestione_campioni_sql.Service.ChampionService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/champion")
public class ChampionsController {
    final Logger logger = LoggerFactory.getLogger(ChampionsController.class);

    @Autowired
    private ChampionService championService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Champion>> getChampionList(){
        logger.info("GET /champion/find-all");
        logger.debug("list:{}", championService.getChampionList());

        if(championService.getChampionList() == null){
           return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(championService.getChampionList());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Champion> championByID(@PathVariable Long id){
        logger.info("GET /find-by-id/{id}");
        logger.debug("id:" + id);

        Optional<Champion> resultFound = championService.championByID(id);

        if(resultFound.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultFound.get());
    }

    @GetMapping("/find-by-field")
    public ResponseEntity<Champion> championByField(@RequestParam(required = false) String nome,
                                                    @RequestParam(required = false) String ruolo,
                                                    @RequestParam(required = false) String difficolta,
                                                    @RequestParam(required = false) String regione){

        if(championService.championByField(nome, ruolo, difficolta, regione) == null){
            return ResponseEntity.notFound().build();
        }

        Champion resultFound = championService.championByField(nome, ruolo, difficolta, regione);
        return ResponseEntity.ok(resultFound);
    }

    @PostMapping("/create-champion")
    public ResponseEntity<Champion> addChampion(@RequestBody Champion newChampion){
        if(newChampion.getNome() == null || newChampion.getNome().isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Champion championResult = championService.createChampion(newChampion);

        return ResponseEntity.ok(championResult);
    }

    @PostMapping("/find-by-id/{id}")
    public ResponseEntity<Champion> updateChampion(@PathVariable Long id, @RequestBody Champion championToUpdate){
        if(championService.updateChampion(id, championToUpdate) == null){
            return ResponseEntity.notFound().build();
        }

        Champion updatedUser = championService.updateChampion(id, championToUpdate);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteChampion(@PathVariable Long id){
        championService.deleteChampion(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/htmlstring")
    public ResponseEntity<String> test(){
        String html = """
    <!DOCTYPE html>
    <html>
      <head>
        <meta charset="UTF-8">
        <title>Pagina HTML in Java</title>
      </head>
      <body>
        <h1>Ciao, mondo!</h1>
        <p>Questa è una pagina HTML inclusa in una stringa Java.</p>
        <img src="https://preview.redd.it/emo3qsi6g5y91.png?width=1080&crop=smart&auto=webp&s=7eb44af85bd83019775805147c327ac8c9707de8">
      </body>
    </html>
    """;
        return ResponseEntity.ok(html);
    }

    @GetMapping("/by-name")
    public List<Champion> findByNome(@RequestParam String nome){
        return championService.championByNome(nome);
    }

    @Transactional
    //@Transactional fa in modo che tutte le operazioni di accesso al database vengano eseguite all'interno di una transazione.
    //apre una transazione all'inizio del metodo
    //se il metodo termina senza errori la transazione viene eseguita.
    @DeleteMapping("/delete")
    public List<Champion> deleteByNome(@RequestParam String nome){
        return championService.deleteByNome(nome);
    }
}
