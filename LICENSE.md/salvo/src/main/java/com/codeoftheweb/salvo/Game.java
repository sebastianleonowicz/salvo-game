package com.codeoftheweb.salvo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.toList;
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;
    private String gameName;
    private Date creationDate;

    public Game() { }

    public Game(String first, Date last) {
        this.gameName = first;
        this.creationDate = last;

    }
    @OneToMany(mappedBy="game", fetch=FetchType.EAGER)
    Set<GamePlayer> gamePlayers;

    public void addGamePlayer(GamePlayer gamePlayer) {
        gamePlayer.setGame(this);
        gamePlayers.add(gamePlayer);
    }

    public long getId(){
        return id;
    }
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    public Date getDate(){
        return creationDate;
    }
    public void setDate(Date date){
        this.creationDate = date;
    }
    public String toString() {
        return gameName ;
    }
    public List<Player> getPlayers() {
        return gamePlayers.stream().map(sub -> sub.getPlayer()).collect(toList());
    }


    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }
}

