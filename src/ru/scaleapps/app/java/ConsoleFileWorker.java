package ru.scaleapps.app.java;

import ru.scaleapps.app.java.exception.NotExistingCommand;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * Реализация Worker-а, которая:
 * Считывает данные с консоли;
 * Выводит информацию на в файл.
 */
public class ConsoleFileWorker extends Worker {
    private String outputFile;

    public ConsoleFileWorker(String outputFile, SolveEngine solveEngine) {
        super(solveEngine);
        this.outputFile = outputFile;
    }

    @Override
    public void go() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fileWriter = new FileWriter(outputFile) )
        {
            while (true) {
                String command = reader.readLine();
                if (command.equals("exit") || command.equals(""))
                    return;

                String answer = solveEngine.solve(command);
                fileWriter.write(answer + '\n');
            }
        }
        catch (NotExistingCommand e) {
            throw e;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
