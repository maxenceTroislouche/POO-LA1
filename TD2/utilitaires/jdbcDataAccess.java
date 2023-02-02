package TD2.utilitaires;

import TD2.Modeles.Circuit;
import TD2.Modeles.Location;
import TD2.Modeles.Pilote;

import java.sql.*;
import java.util.ArrayList;

public class jdbcDataAccess {
    private static Connection connect;
    private static String url = "jdbc:mysql://localhost:3306/formule1";
    private static String user = "maxence";
    private static String mdp = "Ursule115";

    public static void requeteFormule() throws SQLException {
        connect = DriverManager.getConnection(url, user, mdp);
    }

    public static void getJDBCListeCircuits() throws SQLException {
        // On se connecte à la BDD
        requeteFormule();

        String requete = "SELECT * FROM circuits;";
        Statement stmt = connect.createStatement();
        ResultSet res = stmt.executeQuery(requete);
        Circuit.lesCircuitsBDD = new ArrayList<>();
        while (res.next()) {
            System.out.println("Id : " + res.getInt("circuitId"));
            System.out.println("Name : " + res.getString("name"));
            System.out.println("Url : " + res.getString("url"));
            System.out.println("City : " + res.getString("location"));
            System.out.println("Country : " + res.getString("country"));
            System.out.println("Lat : " + res.getString("lat"));
            System.out.println("Long : " + res.getString("lng"));
            System.out.println();

            String circuitRef = res.getString("circuitRef");
            String name = res.getString("name");
            String url = res.getString("url");
            String city = res.getString("location");
            String country = res.getString("country");
            String lat = res.getString("lat");
            String lng = res.getString("lng");

            Location l = new Location("", lat, lng, city, country);
            Circuit c = new Circuit(url, circuitRef, name, l);
            // System.out.println(c.toString());
            Circuit.lesCircuitsBDD.add(c);
        }
        res.close();
        stmt.close();
    }

    public static int GetNbPilotes() throws SQLException {
        requeteFormule();
        String requete = "SELECT COUNT(*) FROM drivers;";
        Statement stmt = connect.createStatement();
        ResultSet set = stmt.executeQuery(requete);
        set.next();

        int res = set.getInt("COUNT(*)") ;
        set.close();
        stmt.close();
        return res;
    }

    public static Pilote getPilote(String ref) throws SQLException {
        requeteFormule();

        String requete = "SELECT * FROM drivers WHERE UPPER(driverRef) = ?;";
        PreparedStatement pstmt = connect.prepareStatement(requete);
        pstmt.setString(1, ref.toUpperCase());
        ResultSet set = pstmt.executeQuery();
        boolean resNext = set.next();

        if (!resNext) {
            // Pas de résultat !
            return null;
        }

        String refPilote = set.getString("driverRef");
        int numero = set.getInt("number");
        String code = set.getString("code");
        String prenom = set.getString("forename");
        String nomDeFamille = set.getString("surname");
        Date dateDeNaissance = set.getDate("dob");
        String nationalite = set.getString("nationality");
        String url = set.getString("url");

        Pilote p = new Pilote(refPilote, numero, code, prenom, nomDeFamille, dateDeNaissance, nationalite, url);
        set.close();
        pstmt.close();
        return p;
    }

    public static int addPilote(Pilote p) throws SQLException {
        if (p == null) {
            return -1;
        }

        // On se connecte à la bdd
        requeteFormule();

        String requete = "INSERT INTO drivers (driverRef, number, code, forename, surname, dob, nationality, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connect.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, p.getRef());
        pstmt.setString(2, String.valueOf(p.getNumero()));
        pstmt.setString(3, p.getCode());
        pstmt.setString(4, p.getPrenom());
        pstmt.setString(5, p.getNomDeFamille());
        pstmt.setString(6, String.valueOf(p.getDateDeNaissance()));
        pstmt.setString(7, p.getNationalite());
        pstmt.setString(8, p.getUrl());
        try {
            int res = pstmt.executeUpdate();
            System.out.println("Insertion réussie !");
            return 1;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Pilote déjà présent dans la base !");
            return -1;
        }
    }
}
