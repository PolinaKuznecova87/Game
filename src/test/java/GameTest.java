import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.game.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void shouldOnePlayerIsStronger() {
        Game game = new Game();
        Player sergey = new Player(1, "Sergey", 72);
        Player anna = new Player(2, "Anna", 54);
        game.register(sergey);
        game.register(anna);

        int expected = 1;
        int actual = game.round("Sergey", "Anna");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldTheStrengthOfThePlayersIsTheSame() {
        Game game = new Game();
        Player ivan = new Player(5, "Ivan", 50);
        Player pety = new Player(6, "Pety", 50);
        game.register(ivan);
        game.register(pety);

        int expected = 0;
        int actual = game.round("Ivan", "Pety");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldSecondPlayerIsStronger() {
        Game game = new Game();
        Player andrey = new Player(3, "Andrey", 23);
        Player oleg = new Player(4, "Oleg", 54);
        game.register(andrey);
        game.register(oleg);

        int expected = 2;
        int actual = game.round("Andrey", "Oleg");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldWhenTheFirstPlayerIsNotRegistered() {
        Game game = new Game();
        Player dima = new Player(7, "Dima", 23);
        Player oleg = new Player(8, "Oleg", 54);

        game.register(oleg);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Dima", "Oleg");


        });
    }

    @Test
    public void shouldWhenTheSecondPlayerIsNotRegistered() {
        Game game = new Game();
        Player dima = new Player(7, "Dima", 23);
        Player oleg = new Player(8, "Oleg", 54);

        game.register(dima);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Dima", "Oleg");


        });


    }

    @Test
    public void shouldWhenNoPlayersIsNotRegistered() {
        Game game = new Game();
        Player dima = new Player(7, "Dima", 23);
        Player oleg = new Player(8, "Oleg", 54);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Dima", "Oleg");


        });


    }
}