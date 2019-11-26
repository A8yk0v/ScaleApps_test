package ru.scaleapps.app.java;

import ru.scaleapps.app.java.exception.NotExistingCommand;

public class Main {

    public static void main(String[] args) {
        try {
            SolveEngine solveEngine = new SolveEngine();
            IWorker iWorker;

            if (args.length == 1 && args[0].equals("-"))
                iWorker = new ConsoleWorker(solveEngine);
            else if (args.length == 2)
                iWorker = new FileWorker(args[0], args[1], solveEngine);
            else
                throw new NotExistingCommand();

            iWorker.go();
        }
        catch (NotExistingCommand e) {
            System.out.println(e.toString());
        }
    }
}
