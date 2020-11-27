package lt.verbus.services;

import lt.verbus.model.Executor;
import lt.verbus.repository.ExecutorRepository;

import java.sql.SQLException;
import java.util.Map;

public class ExecutorService {
    private ExecutorRepository executorRepository;

    public ExecutorService(ExecutorRepository executorRepository) {
        this.executorRepository = executorRepository;
    }

    public Map<Integer, Executor> findAll() throws SQLException {
        return executorRepository.findAll();
    }

    public Executor addNewExecutor(Executor executor) throws SQLException {
        executorRepository.save(executor);
        executor.setId(executorRepository.getLastId());
        return executor;
    }

    public void update(Executor executor) throws SQLException {
        executorRepository.update(executor);
    }

    public ExecutorRepository getExecutorRepository() {
        return executorRepository;
    }

    public void setExecutorRepository(ExecutorRepository executorRepository) {
        this.executorRepository = executorRepository;
    }


}
