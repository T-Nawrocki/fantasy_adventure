import static adventure.Adventure.*;

public class Runner {

    private static boolean gameOver = false;

    public static void main(String[] args) {

        gatherParty();
        introDescription();

        changeRoom();
        while (!gameOver) {
        }

    }

}
