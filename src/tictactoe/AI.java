import java.util.Random;

public class AI {

    Random random;

    public AI() {
        this.random = new Random();
    }

    public int randomNumber() {
        return random.nextInt(3) + 1;
    }
}
