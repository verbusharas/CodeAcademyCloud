package lt.verbus.config;

public class QueriesMySql {

    public static final String ALL_EXECUTORS = "SELECT * FROM executor";

    public static final String ALL_EXECUTORS_BY_PROJECT =
            "SELECT e.id, e.full_name, e.qualification, e.education " +
            "FROM executor_to_project ep " +
            "JOIN project p ON ep.project_id = p.id " +
            "JOIN executor e ON ep.executor_id = e.id " +
            "WHERE project_id = ?";

    public static final String ADD_EXECUTOR =
            "INSERT INTO executor (full_name, qualification, education) VALUES (?, ?, ?)";

    public static final String UPDATE_EXECUTOR =
            "UPDATE executor " +
                    "SET " +
                    "full_name = ? " +
                    "qualification = ? " +
                    "education = ? " +
                    "WHERE id= ?";

    public static final String ALL_PROJECTS_AND_EXECUTORS =
            "SELECT p.id AS project_id, p.title, e.id AS executor_id, " +
                    "e.full_name AS executor_name, " +
                    "p.importance, p.started_at, p.duration " +
                    "FROM executor_to_project ep " +
                    "JOIN executor e ON ep.executor_id = e.id " +
                    "JOIN project p ON ep.project_id = p.id " +
                    "ORDER BY p.id";


    public static final String UPDATE_PROJECT =
            "UPDATE project " +
                    "SET " +
                    "title = ? " +
                    "importance = ? " +
                    "started_at = ? " +
                    "duration = ? " +
                    "WHERE id= ?";

    public static final String APPOINT_EXECUTOR_TO_PROJECT =
            "INSERT INTO executor_to_project " +
                    "(project_id, executor_id) " +
                    "VALUES (?, ?)";

}
