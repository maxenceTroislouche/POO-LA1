package TD2.Modeles;

import java.util.Date;

public class Pilote {
    private String ref;
    private int numero;
    private String code;
    private String prenom;
    private String nomDeFamille;
    private Date dateDeNaissance;
    private String nationalite;
    private String url;

    public Pilote(String ref, int numero, String code, String prenom, String nomDeFamille, Date dateDeNaissance, String nationalite, String url) {
        this.ref = ref;
        this.numero = numero;
        this.code = code;
        this.prenom = prenom;
        this.nomDeFamille = nomDeFamille;
        this.dateDeNaissance = dateDeNaissance;
        this.nationalite = nationalite;
        this.url = url;
    }

    public String getRef() {
        return ref;
    }

    public int getNumero() {
        return numero;
    }

    public String getCode() {
        return code;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNomDeFamille() {
        return nomDeFamille;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Pilote{" +
                "ref='" + ref + '\'' +
                ", numero=" + numero +
                ", code='" + code + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nomDeFamille='" + nomDeFamille + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", nationalite='" + nationalite + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
