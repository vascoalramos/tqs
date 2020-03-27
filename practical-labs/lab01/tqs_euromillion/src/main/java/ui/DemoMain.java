package ui;

import euromillions.CuponEuromillions;
import euromillions.Dip;
import euromillions.EuromillionsDraw;

import java.util.logging.Logger;

public class DemoMain {
    private static final Logger logger = Logger.getLogger(DemoMain.class.getName());

    /**
     * demonstrates a client for random lottery bets
     */
    public static void main(String[] args) {

        // played sheet
        CuponEuromillions thisWeek = new CuponEuromillions();
        logger.info("Betting with three random bets...");
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());
        thisWeek.addDipToCuppon(Dip.generateRandomDip());

        // simulate a random draw
        EuromillionsDraw draw = EuromillionsDraw.generateRandomDraw();

        // report results
        logger.info("You played:");
        String play = thisWeek.format();
        logger.info(play);

        logger.info("Draw results:");
        String results = draw.getDrawResults().format();
        logger.info(results);

        logger.info("Your score:");
        for (Dip dip : draw.findMatches(thisWeek)) {
            String dipResult = dip.format();
            logger.info(dipResult);

        }
    }
}
