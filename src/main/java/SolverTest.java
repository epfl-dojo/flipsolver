import org.junit.*;

import java.util.*;

public class SolverTest {

    /**
     * The test that has to pass to check your algorithm.
     */
    @Test
    public void testSolve() {

        Solver solver = new Solver();

        // the game comes in 3 difficulty levels (easy = 0, normal = 1, hard = 2)

        // the matrix size for each difficulty (4x4, 5x5, 6x6)
        int[] sizes = {16, 25, 36};

        // the matrix number of columns for each difficulty
        int[] cols = {4, 5, 6};

        // the number of squares that are flipped when the game start (excluding their neighbours)
        int[] nums = {4, 5, 10};

        Random random = new Random();

        int good = 0;
        int bad = 0;

        long startingTime = System.currentTimeMillis();

        // test with a lot of games
        for (int i = 0; i < 100000; i++) {
            // get a random level
            int level = random.nextInt(3);

            int size = sizes[level];

            int num = nums[level];

            int col = cols[level];

            // the random indexes we will flip when the game start (without showing the user of course)
            int[] starting = solver.randomIntegers(0, size - 1, num);

            // the game representation, false means it's not flipped, true it is
            boolean[] game = new boolean[size];

            // flip the starting indexes (and their neighbours)
            for (int flip : starting) {
                solver.flip(game, flip, col);
            }

            // solve the game
            int[] solution = solver.solve(game);

            // flip the indexes found in the solution (and their neighbours)
            for (int index : solution) {
                solver.flip(game, index, col);
            }

            // check the game values
            for (boolean value : game) {
                if (value) {
                    throw new RuntimeException("All values must be false");
                }
            }

            // check the length
            if (solution.length <= num) {
                good++;
            } else {
                bad++;
            }
        }

        long stoppingTime = System.currentTimeMillis();

        long elapsedTime = stoppingTime - startingTime;

        int total = good + bad;
        float percent = (good * 100) / total;

        System.out.println("Good     = " + good);
        System.out.println("Bad      = " + bad);
        System.out.println("Accuracy = " + percent + "%");
        System.out.println("Time     = " + elapsedTime + " milliseconds");
    }
}
