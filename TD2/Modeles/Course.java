package TD2.Modeles;

import java.sql.Time;
import java.util.Date;

public class Course {
    private int annee;
    private int round;
    private int circuitId;
    private String name;
    private Date date;
    private Time time;
    private String url;
    private Date fp1_date;
    private Time fp1_time;
    private Date fp2_date;
    private Time fp2_time;
    private Date fp3_date;
    private Time fp3_time;
    private Date quali_date;
    private Time quali_time;
    private Date sprint_date;
    private Time sprint_time;

    public Course(int annee, int round, int circuitId, String name, Date date, Time time, String url, Date fp1_date, Time fp1_time, Date fp2_date, Time fp2_time, Date fp3_date, Time fp3_time, Date quali_date, Time quali_time, Date sprint_date, Time sprint_time) {
        this.annee = annee;
        this.round = round;
        this.circuitId = circuitId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.url = url;
        this.fp1_date = fp1_date;
        this.fp1_time = fp1_time;
        this.fp2_date = fp2_date;
        this.fp2_time = fp2_time;
        this.fp3_date = fp3_date;
        this.fp3_time = fp3_time;
        this.quali_date = quali_date;
        this.quali_time = quali_time;
        this.sprint_date = sprint_date;
        this.sprint_time = sprint_time;
    }

    public int getAnnee() {
        return annee;
    }

    public int getRound() {
        return round;
    }

    public int getCircuitId() {
        return circuitId;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getUrl() {
        return url;
    }

    public Date getFp1_date() {
        return fp1_date;
    }

    public Time getFp1_time() {
        return fp1_time;
    }

    public Date getFp2_date() {
        return fp2_date;
    }

    public Time getFp2_time() {
        return fp2_time;
    }

    public Date getFp3_date() {
        return fp3_date;
    }

    public Time getFp3_time() {
        return fp3_time;
    }

    public Date getQuali_date() {
        return quali_date;
    }

    public Time getQuali_time() {
        return quali_time;
    }

    public Date getSprint_date() {
        return sprint_date;
    }

    public Time getSprint_time() {
        return sprint_time;
    }

    @Override
    public String toString() {
        return "Course{" +
                "annee=" + annee +
                ", round=" + round +
                ", circuitId=" + circuitId +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", url='" + url + '\'' +
                ", fp1_date=" + fp1_date +
                ", fp1_time=" + fp1_time +
                ", fp2_date=" + fp2_date +
                ", fp2_time=" + fp2_time +
                ", fp3_date=" + fp3_date +
                ", fp3_time=" + fp3_time +
                ", quali_date=" + quali_date +
                ", quali_time=" + quali_time +
                ", sprint_date=" + sprint_date +
                ", sprint_time=" + sprint_time +
                '}';
    }
}
