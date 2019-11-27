package ru.scaleapps.app.java;

import ru.scaleapps.app.java.exception.NotExistingCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleConsoleWorker extends Worker {

    public ConsoleConsoleWorker(SolveEngine solveEngine) {
        super(solveEngine);
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
            e.printStackTrace();
        }
    }
}
