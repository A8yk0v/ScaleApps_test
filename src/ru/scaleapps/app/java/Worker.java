package ru.scaleapps.app.java;

public abstract class Worker implements IWorker {
    protected SolveEngine solveEngine;

    public Worker(SolveEngine solveEngine) {
        this.solveEngine = solveEngine;
    }
}
