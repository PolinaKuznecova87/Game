package ru.netology.game;

import ru.netology.game.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Game {
    List<Player> players = new ArrayList<Player>();

    Game[] games = new Game[0];


    public void register(Player player) {


        players.add(player);
    }


    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getPlayerName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getPlayerName().equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException("Player not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player not registered");

        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;

        }
        return 0;
    }

}





