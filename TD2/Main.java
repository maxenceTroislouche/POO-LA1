package TD2;

import TD2.Modeles.Circuit;
import TD2.Modeles.Pilote;
import TD2.utilitaires.jdbcDataAccess;

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
        //testGetCircuitsBDD();
        //testGetNbPilotes();
        //testGetPilote();
        testAddPilote();
    }

    public static void testGetCircuitsBDD() throws SQLException {
        System.out.println(Circuit.lesCircuitsBDD);
        jdbcDataAccess.getJDBCListeCircuits();
        System.out.println(Circuit.lesCircuitsBDD);
        System.out.println(Circuit.lesCircuitsBDD.size());
    }

    public static void testGetNbPilotes() throws SQLException {
        System.out.println("Nombre de pilotes : " + jdbcDataAccess.GetNbPilotes());
    }

    public static void testGetPilote() throws SQLException {
        System.out.println("On récupère les infos de lewis hamilton (id = 1)");
        Pilote hamilton = jdbcDataAccess.getPilote("hamilton");
        System.out.println(hamilton);

        Pilote res = jdbcDataAccess.getPilote("moi");
        if (res == null) {
            System.out.println("Test validé, le pilote n'existe pas");
        } else {
            System.out.println("Test échoué, le pilote n'est pas censé exister");
        }
    }

    public static void testAddPilote() throws SQLException {
        Pilote p = new Pilote("test", 666, "TES", "test", "test", new Date(), "français", "https://www.youtube.com/watch?v=dQw4w9WgXcQ");
        jdbcDataAccess.addPilote(p);
    }
}
