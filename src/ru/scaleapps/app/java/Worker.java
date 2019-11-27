package ru.scaleapps.app.java;

/**
 * Класс Worker реализует интерфейс IWorker
 * и добавляет зависимость на класс SolveEngine
 */
public abstract class Worker implements IWorker {
    protected SolveEngine solveEngine;

    public Worker(SolveEngine solveEngine) {
        this.solveEngine = solveEngine;
    }
}
