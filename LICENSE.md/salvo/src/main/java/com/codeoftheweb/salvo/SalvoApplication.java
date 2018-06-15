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
									  ShipRepository shipRepository
									  ) {
		return (args) -> {
			// save a couple of Players
			Player p1 = new Player("Peter", "Griffin");
			playerRepository.save(p1);
			Player p2 = new Player("Homer", "Simpson");
			playerRepository.save(p2);
			Player p3 = new Player("Albert", "Einstein");
			playerRepository.save(p3);
			Player p4 = new Player("Tony", "Stark");
			playerRepository.save(p4);
			Player p5 = new Player("Jon", "Snow");
			playerRepository.save(p5);
			Player p6 = new Player("Vladimir", "Putin");
			playerRepository.save(p6);


			java.util.Date date=new java.util.Date();
			Game g1 = new Game("Game1", date);
			gameRepository.save(g1);
			java.util.Date date2 =new java.util.Date().from(date.toInstant().plusSeconds(3600));
			Game g2 = new Game("Game2", date2);
			gameRepository.save(g2);
			java.util.Date date3 =new java.util.Date().from(date.toInstant().plusSeconds(7200));
			Game g3 = new Game("Game3", date3);
			gameRepository.save(g3);

			GamePlayer gp1 = new GamePlayer(g1, p1, date);
			gamePlayerRepository.save(gp1);
			GamePlayer gp2 = new GamePlayer(g1, p2, date2);
			gamePlayerRepository.save(gp2);
			GamePlayer gp3 = new GamePlayer(g3, p3, date3);
			gamePlayerRepository.save(gp3);

			List<String> shipList1 = Arrays.asList("H2", "H3", "H4");
			List<String> shipList2 = Arrays.asList("E1", "F1", "G1");
			List<String> shipList3 = Arrays.asList("B4", "B5");
			List<String> shipList4 = Arrays.asList("B5", "C5", "D5");
			List<String> shipList5 = Arrays.asList("F1", "F2");

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




		};
	}



}
