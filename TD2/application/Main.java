package TD2.application;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
    private static int year;

    // TODO : Ajouter une course dans la saison actuelle
    private static void insererCourse() {
        System.out.println("Course à insérer.");
    }

    // TODO : Afficher la liste de courses dans la saison actuelle
    private static void afficherListeCourses() {
        System.out.println("Liste des courses : ");
    }

    private static void afficherMenu() {
        while (true) {
            System.out.println("Que voulez vous faire ?");
            System.out.println("1 - Afficher la liste de courses dans la saison actuelle");
            System.out.println("2 - Ajouter une course dans la saison actuelle");
            System.out.println("0 - Quitter le programme");

            Scanner sc = new Scanner(System.in);
            System.out.println("Que voulez vous faire ?");
            int choix = sc.nextInt();

            switch (choix) {
                case 0:
                    System.out.println("Au revoir !");
                    return;
                case 1:
                    afficherListeCourses();
                    break;
                case 2:
                    insererCourse();
                    break;
                default:
                    System.out.println("Ce choix n'est pas possible !");
                    break;
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le gestionnaire de Formule 1 !");

        // On récupère l'année actuelle
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);

        System.out.println("Saison actuelle : " + year);

        afficherMenu();
    }
}
