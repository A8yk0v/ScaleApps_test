package ru.scaleapps.app.java;

import ru.scaleapps.app.java.exception.NotExistingCommand;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWorker implements IWorker {

    private String inputFile;
    private String outputFile;
    private SolveEngine solveEngine;

    public FileWorker(String inputFile, String outputFile, SolveEngine solveEngine) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.solveEngine = solveEngine;
    }

    @Override
    public void go() {
        try (FileReader fileReader = new FileReader(inputFile);
             Scanner scan = new Scanner(fileReader);
             FileWriter fileWriter = new FileWriter(outputFile) )
        {
            while (scan.hasNextLine()) {
                String answer = solveEngine.solve( scan.nextLine() );
                fileWriter.write(answer + "\n");
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
