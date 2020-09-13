package lt.verbus.databases;

public class Queries {

    public static final String ALL_PROJECTS = "SELECT Nr, Pavadinimas FROM projektai";

    public static final String ALL_PROJECTS_AND_EXECUTORS =
            "SELECT \n" +
                    "    projektai.Nr,\n" +
                    "    projektai.pavadinimas,\n" +
                    "    vykdytojai.Pavardė\n" +
                    "FROM\n" +
                    "    vykdymas\n" +
                    "        JOIN\n" +
                    "    vykdytojai ON vykdymas.Vykdytojas = vykdytojai.Nr\n" +
                    "        JOIN\n" +
                    "    projektai ON vykdymas.projektas = projektai.Nr\n" +
                    "ORDER BY projektai.Nr;";

    public static final String ADD_PERSON = "INSERT INTO vykdytojai (Pavardė) VALUES (?)";

    public static final String APPOINT_PERSON_TO_PROJECT =
            "INSERT INTO vykdymas " +
                    "(Projektas, Vykdytojas, Statusas, Valandos) " +
                    "VALUES (?, ?, ?, ?)";

    public static final String GET_PERSON_ID_BY_SURNAME = "SELECT Nr FROM vykdytojai WHERE Pavardė = (?)";
}
