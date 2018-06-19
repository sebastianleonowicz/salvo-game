package com.codeoftheweb.salvo;

import javax.persistence.*;
import java.util.*;

import static java.util.stream.Collectors.toList;


@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Game_id")
    private Game game;

    @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER)
    Set<Ship> ships;

    @OneToMany(mappedBy = "gamePlayer", fetch = FetchType.EAGER)
    Set<Salvo> salvoes;




    public GamePlayer () {

    }
    public GamePlayer(Game game, Player gamePlayer, Date date) {
        this.game = game;
        this.player = gamePlayer;
        this.date = date;
    }
    public long getId(){
        return this.id;
    }
    public Date getDate(){
        return this.date;
    }

    public Game getGame(){
        return game;
    }
    public void setGame(Game game){
        this.game = game;
    }
    public Player getPlayer(){
        return player;
    }

    public List<Player> getGamePlayers(){
        List<Player> gamePlayers = new ArrayList<>();
        gamePlayers.add(getPlayer());
        return gamePlayers;
    }


    public void setGamePlayer(Player gamePlayer){
        this.player = gamePlayer;
    }

    public void setDate(Date date){
        this.date = date;
    }
    public Set<Ship> getShips() {
        return ships;
    }
    public Set<Salvo> getSalvoes() {
        return salvoes;
    }






}
