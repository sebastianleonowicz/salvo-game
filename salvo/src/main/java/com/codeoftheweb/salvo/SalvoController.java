package com.codeoftheweb.salvo;

import com.codeoftheweb.salvo.Game;
import com.codeoftheweb.salvo.GameRepository;
import com.codeoftheweb.salvo.GamePlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

@RestController
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @RequestMapping("/games")
    public  List<Object> getAllGames() {
//        Map<String, Integer> gameMap = new HashMap<>();
//        List<Object>
//        return repository.findAll();
        return
                gameRepository
                        .findAll()
                        .stream()
                        .map(game -> makeGameDTO(game))
                        .collect(toList());


    }
    private Map<String, Object> makeGameDTO(Game game) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", game.getId());
        dto.put("created", game.getDate());
//        dto.put("pet", makePetDTO(owner.getPet()));
        dto.put("gamePlayer", game.getGamePlayers().stream()
                                                    .map(gp -> makeGamePlayerDTO(gp))
                                                    .collect(Collectors.toList()));
        return dto;
    }
    private  Map<String, Object> makeGamePlayerDTO(GamePlayer gamePlayer) {

        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", gamePlayer.getId());
        dto.put("player", makePlayerDTO(gamePlayer.getPlayer()));

        return dto;

    }
    private Map<String, Object> makePlayerDTO(Player player){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", player.getId());
        dto.put("name", player.getLastName());
        return dto;
    }
    @RequestMapping("/game_view/{gamePlayerId}")
    private Map<String, Object> getGamePlayerView(@PathVariable long gamePlayerId){
        GamePlayer gamePlayer = gamePlayerRepository.findOne(gamePlayerId);
        Map<String, Object> gamePlayerView = new LinkedHashMap<>();
        gamePlayerView.put("id", gamePlayer.getId());
        gamePlayerView.put("created", gamePlayer.getDate());
        gamePlayerView.put("gamePlayers", gamePlayer.getGame().getGamePlayers().stream()
                                                                    .map(pl -> makeGamePlayerDTO(pl))
                                                                    .collect(toList()));
        gamePlayerView.put("ships", gamePlayer.getShips().stream()
                                                            .map(sh -> makeShipsDTO(sh))
                                                            .collect(toList()));


        gamePlayerView.put("salvoes", gamePlayer.getGame().getSalvoesList().stream()
                .map(salvo -> makeSalvoDTO(salvo))
                .collect(toList()));


        return gamePlayerView;
    }
    private Map<String, Object> makeSalvoDTO(Salvo salvo){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("turn", salvo.getTurn());
        dto.put("player", salvo.getGamePlayer().getId());
        dto.put("locations", salvo.getSalvoLocations());
        return dto;
    }


    private Map<String, Object> makeShipsDTO(Ship ship){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("type", ship.getShipType());
        dto.put("locations", ship.getShipLocations());
        return dto;
    }



}
