package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository ,
									  GameRepository gameRepository,
									  com.codeoftheweb.salvo.GamePlayerRepository gamePlayerRepository,
									  ShipRepository shipRepository,
									  SalvoRepository salvoRepository
									  ) {
		return (args) -> {
			// save a couple of Players
			Player p1 = new Player("Peter", "Griffin");
			playerRepository.save(p1);
			Player p2 = new Player("Homer", "Simpson");
			playerRepository.save(p2);
			Player p3 = new Player("Albert", "Einstein");
			playerRepository.save(p3);
			Player p4 = new Player("Vladimir", "Putin");
			playerRepository.save(p4);



			java.util.Date date=new java.util.Date();
			Game g1 = new Game("Game1", date);
			gameRepository.save(g1);
			java.util.Date date2 =new java.util.Date().from(date.toInstant().plusSeconds(3600));
			Game g2 = new Game("Game2", date2);
			gameRepository.save(g2);
			java.util.Date date3 =new java.util.Date().from(date.toInstant().plusSeconds(7200));
			Game g3 = new Game("Game3", date3);
			gameRepository.save(g3);
			java.util.Date date4 =new java.util.Date().from(date.toInstant().plusSeconds(10800));
			Game g4 = new Game("Game4", date4);
			gameRepository.save(g4);
			java.util.Date date5 =new java.util.Date().from(date.toInstant().plusSeconds(14400));
			Game g5 = new Game("Game5", date5);
			gameRepository.save(g5);
			java.util.Date date6 =new java.util.Date().from(date.toInstant().plusSeconds(18000));
			Game g6 = new Game("Game6", date6);
			gameRepository.save(g6);
			java.util.Date date7 =new java.util.Date().from(date.toInstant().plusSeconds(21600));
			Game g7 = new Game("Game7", date7);
			gameRepository.save(g7);
			java.util.Date date8 =new java.util.Date().from(date.toInstant().plusSeconds(25200));
			Game g8 = new Game("Game8", date8);
			gameRepository.save(g8);







			GamePlayer gp1 = new GamePlayer(g1, p1, date);
			gamePlayerRepository.save(gp1);
			GamePlayer gp2 = new GamePlayer(g1, p2, date);
			gamePlayerRepository.save(gp2);
			GamePlayer gp3 = new GamePlayer(g2, p1, date2);
			gamePlayerRepository.save(gp3);
			GamePlayer gp4 = new GamePlayer(g2, p2, date2);
			gamePlayerRepository.save(gp4);
			GamePlayer gp5 = new GamePlayer(g3, p3, date3);
			gamePlayerRepository.save(gp5);
			GamePlayer gp6 = new GamePlayer(g3, p4, date3);
			gamePlayerRepository.save(gp6);
			GamePlayer gp7 = new GamePlayer(g4, p2, date4);
			gamePlayerRepository.save(gp7);
			GamePlayer gp8 = new GamePlayer(g4, p1, date4);
			gamePlayerRepository.save(gp8);
			GamePlayer gp9 = new GamePlayer(g5, p3, date5);
			gamePlayerRepository.save(gp9);
			GamePlayer gp10 = new GamePlayer(g5, p1, date5);
			gamePlayerRepository.save(gp10);
			GamePlayer gp11 = new GamePlayer(g6, p4, date6);
			gamePlayerRepository.save(gp11);
			GamePlayer gp12 = new GamePlayer(g7, p3, date7);
			gamePlayerRepository.save(gp12);
			GamePlayer gp13 = new GamePlayer(g8, p4, date8);
			gamePlayerRepository.save(gp13);
			GamePlayer gp14 = new GamePlayer(g8, p3, date8);
			gamePlayerRepository.save(gp14);







			List<String> shipList1 = Arrays.asList("H2", "H3", "H4");
			List<String> shipList2 = Arrays.asList("E1", "F1", "G1");
			List<String> shipList3 = Arrays.asList("B4", "B5");
			List<String> shipList4 = Arrays.asList("B5", "C5", "D5");
			List<String> shipList5 = Arrays.asList("F1", "F2");
			List<String> shipList6 = Arrays.asList("B5", "C5","D5");
			List<String> shipList7 = Arrays.asList("C6", "C7");
			List<String> shipList8 = Arrays.asList("A2", "A3","A4");
			List<String> shipList9 = Arrays.asList("G6", "H6");



			Ship ship1 = new Ship("Destroyer", gp1, shipList1);
//			gp1.addShip(ship1);
			shipRepository.save(ship1);
			Ship ship2 = new Ship("Submarine", gp1, shipList2);
//			gp1.addShip(ship2);
			shipRepository.save(ship2);
			Ship ship3 = new Ship("Patrol Boat", gp1, shipList3);
			shipRepository.save(ship3);
			Ship ship4 = new Ship("Destroyer", gp2, shipList4);
			shipRepository.save(ship4);
			Ship ship5 = new Ship("Patrol Boat", gp2, shipList5);
			shipRepository.save(ship5);
			Ship ship6 = new Ship("Destroyer", gp3, shipList6);
			shipRepository.save(ship6);
			Ship ship7 = new Ship("Patrol", gp3, shipList7);
			shipRepository.save(ship7);
			Ship ship8 = new Ship("Submarine", gp4, shipList8);
			shipRepository.save(ship8);
			Ship ship9 = new Ship("Patrol", gp4, shipList9);
			shipRepository.save(ship9);

			List<String> salvoList1 = Arrays.asList("B5", "C5", "F1");
			List<String> salvoList2 = Arrays.asList("F2", "D5");
			List<String> salvoList3 = Arrays.asList("B4", "B5", "B6");
			List<String> salvoList4 = Arrays.asList("E1", "H3", "A2");
			List<String> salvoList5 = Arrays.asList("A2", "A4", "G6");
			List<String> salvoList6 = Arrays.asList("A3", "H6");
			List<String> salvoList7 = Arrays.asList("B5", "D5", "C7");
			List<String> salvoList8 = Arrays.asList("C5", "C6");

			long turn1 = 1l;
			long turn2 = 2l;

			Salvo salvo1 = new Salvo(gp1,turn1, salvoList1);
			Salvo salvo2 = new Salvo(gp1, turn2, salvoList2);
			Salvo salvo3 = new Salvo(gp2, turn1, salvoList3);
			Salvo salvo4 = new Salvo(gp2, turn2, salvoList4);
			Salvo salvo5 = new Salvo(gp3, turn1, salvoList5);
			Salvo salvo6 = new Salvo(gp3, turn2, salvoList6);
			Salvo salvo7 = new Salvo(gp4, turn1, salvoList7);
			Salvo salvo8 = new Salvo(gp4, turn2, salvoList8);

			salvoRepository.save(salvo1);
			salvoRepository.save(salvo2);
			salvoRepository.save(salvo3);
			salvoRepository.save(salvo4);
			salvoRepository.save(salvo5);
			salvoRepository.save(salvo6);
			salvoRepository.save(salvo7);
			salvoRepository.save(salvo8);

		};
	}



}
