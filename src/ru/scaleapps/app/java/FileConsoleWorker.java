package ru.scaleapps.app.java;

import ru.scaleapps.app.java.exception.NotExistingCommand;

import java.io.FileReader;
import java.util.Scanner;

/**
 * Реализация Worker-а, которая:
 * Считывает данные из файла;
 * Выводит информацию на консоль.
 */
public class FileConsoleWorker extends Worker {
    private String inputFile;

    public FileConsoleWorker(String inputFile, SolveEngine solveEngine) {
        super(solveEngine);
        this.inputFile = inputFile;
    }

    @Override
    public void go() {
        try (FileReader fileReader = new FileReader(inputFile);
             Scanner scan = new Scanner(fileReader))
        {
            while (scan.hasNextLine()) {
                String answer = solveEngine.solve( scan.nextLine() );
                System.out.println(answer);
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
