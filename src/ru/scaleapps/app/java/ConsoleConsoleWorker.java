package ru.scaleapps.app.java;

import ru.scaleapps.app.java.exception.NotExistingCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleConsoleWorker implements IWorker {

    private SolveEngine solveEngine;

    public ConsoleConsoleWorker(SolveEngine solveEngine) {
        this.solveEngine = solveEngine;
    }

    @Override
    public void go() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String command = reader.readLine();
                if (command.equals("exit") || command.equals(""))
                    return;

                String answer = solveEngine.solve(command);
                System.out.println(answer);
            }
        }
        catch (NotExistingCommand e) {
            throw  e;
        }
        catch (Exception e) {
            // TODO заменить
            //throw e;
            e.printStackTrace();
        }
    }
}
