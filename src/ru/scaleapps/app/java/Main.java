package ru.scaleapps.app.java;

import ru.scaleapps.app.java.exception.IncorrectParameters;
import ru.scaleapps.app.java.exception.NotExistingCommand;

/**
 * Основной класс проекта.
 * Происходит разбор параметров и формируется необходимый объект Worker
 */
public class Main {

    public static void main(String[] args) {
        try {
            SolveEngine solveEngine = new SolveEngine();
            IWorker iWorker;

            if (args.length != 2)
                throw new IncorrectParameters();
            if (args[0].equals("-") && args[1].equals("-"))
                iWorker = new ConsoleConsoleWorker(solveEngine);
            else if (args[0].equals("-"))
                iWorker = new ConsoleFileWorker(args[1], solveEngine);
            else if (args[1].equals("-"))
                iWorker = new FileConsoleWorker(args[0], solveEngine);
            else
                iWorker = new FileFileWorker(args[0], args[1], solveEngine);

            iWorker.go();
        }
        catch (NotExistingCommand e) {
            System.out.println(e.toString());
        }
        catch (IncorrectParameters e) {
            System.out.println(e.toString());
        }
    }
}
