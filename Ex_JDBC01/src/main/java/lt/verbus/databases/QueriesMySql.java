package lt.verbus.databases;

public class QueriesMySql {

    public static final String ALL_EXECUTORS = "SELECT id, full_name FROM executor";

    public static final String ALL_PROJECTS_AND_EXECUTORS =
            "SELECT p.id AS project_id, p.title, e.id AS executor_id, e.full_name AS executor_name " +
                    "FROM executor_to_project ep " +
                    "JOIN executor e ON ep.executor_id = e.id " +
                    "JOIN project p ON ep.project_id = p.id " +
                    "ORDER BY p.id";

    public static final String ADD_EXECUTOR = "INSERT INTO executor (full_name) VALUES (?, ?)";

    public static final String APPOINT_EXECUTOR_TO_PROJECT =
            "INSERT INTO executor_to_projeect " +
                    "(project_id, executor_id) " +
                    "VALUES (?, ?)";

}
