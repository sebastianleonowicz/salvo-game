package com.codeoftheweb.salvo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Score {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;
    private String gameName;
    private long gameId;
    private long playerId;
    private Long score;
    private Date finishDate;

    public Score() { }

    public Score(String first, long second, long third, Long fourth, Date fifth) {
        this.gameName = first;
        this.gameId = second;
        this.playerId = third;
        this.score = fourth;
        this.finishDate = fifth;
    }
    public String getGameName(){
        return this.gameName;
    }





}

