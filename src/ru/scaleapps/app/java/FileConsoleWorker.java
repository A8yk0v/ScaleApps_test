package ru.scaleapps.app.java;

import ru.scaleapps.app.java.exception.NotExistingCommand;

import java.io.FileReader;
import java.util.Scanner;

public class FileConsoleWorker implements IWorker {

    private String inputFile;
    private SolveEngine solveEngine;

    public FileConsoleWorker(String inputFile, SolveEngine solveEngine) {
        this.inputFile = inputFile;
        this.solveEngine = solveEngine;
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
            // TODO заменить
            e.printStackTrace();
        }
    }
}
