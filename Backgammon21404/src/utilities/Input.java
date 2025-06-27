package utilities;

import game_functionalities.*;
import game_objects.GameObjectFactory;
import utilities.board_logic_utilities.Move;
import utilities.exceptions.InvalidInputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static State readState() throws InvalidInputException, IOException {
        System.out.println("Въведете игра:" +
                "1 - табла" +
                "2 - гюлбара" +
                "3 - тапа");
        try {
            String input = READER.readLine();
            if (input.equalsIgnoreCase("табла")
                    || input.equalsIgnoreCase("гюлбара")
                    || input.equalsIgnoreCase("тапа")) {
                switch (input) {
                    case ("табла") -> TablaState.getINSTANCE();
                    case ("гюлбара") -> GiulbaraState.getINSTANCE();
                    case ("тапа") -> TapaState.getINSTANCE();
                }
            }
            else {
                throw new InvalidInputException("Невалидни входни данни. ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return TablaState.getINSTANCE();
    }

    public static Move readMove() throws InvalidInputException {
        try {
            System.out.println("Въведете хода, който щe играете:");
            System.out.println("x: ");
            int x = READER.read();
            System.out.println("y: ");
            int y = READER.read();
            System.out.println("зар: ");
            int dieValue = READER.read();
            if (x >= 0 && x <= 11 && y >= 0 && y <= 1 && GameContext.getPlayer().hasDieValue(dieValue)) {
                return new Move(x, y, dieValue);
            } else {
                throw new InvalidInputException("Невалидни входни данни");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
