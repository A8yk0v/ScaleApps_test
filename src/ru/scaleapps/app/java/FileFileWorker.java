package ru.scaleapps.app.java;

import ru.scaleapps.app.java.exception.NotExistingCommand;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileFileWorker extends Worker {
    private String inputFile;
    private String outputFile;

    public FileFileWorker(String inputFile, String outputFile, SolveEngine solveEngine) {
        super(solveEngine);
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public void go() {
        try (FileReader fileReader = new FileReader(inputFile);
             Scanner scan = new Scanner(fileReader);
             FileWriter fileWriter = new FileWriter(outputFile) )
        {
            while (scan.hasNextLine()) {
                String answer = solveEngine.solve( scan.nextLine() );
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
