package com.codeoftheweb.salvo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;


import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import static java.util.stream.Collectors.toList;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;


    public Player() {
    }
    public long getId(){
        return this.id;
    }

    public Player(String first, String last) {
        this.firstName = first;
        this.lastName = last;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    Set<GamePlayer> gamePlayers;


    public void addGamePlayer(GamePlayer gamePlayer) {
        gamePlayer.setGamePlayer(this);
        gamePlayers.add(gamePlayer);
    }
//    public List<Game> getGames() {
//        return gamePlayers.stream().map(sub -> sub.getGame()).collect(toList());
//    }
    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

}
