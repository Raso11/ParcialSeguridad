package pe.edu.upc.aaw.demo1_202302_si63.entities;



import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name ="Dessert" )
public class Dessert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rasoidDessert;
    @Column(name = "rasonameDessert",nullable = false,length = 40)
    private String rasonameDessert;
    @Column(name = "rasodueDateDessert",nullable = false)
    private LocalDate rasodueDateDessert;
    @Column(name = "rasotypeDessert",nullable = false,length = 20)
    private String rasotypeDessert;
    @Column(name = "rasocaloryDessert",nullable = false)
    private int rasocaloryDessert;

    public Dessert() {
    }

    public Dessert(int rasoidDessert, String rasonameDessert, LocalDate rasodueDateDessert, String rasotypeDessert, int rasocaloryDessert) {
        this.rasoidDessert = rasoidDessert;
        this.rasonameDessert = rasonameDessert;
        this.rasodueDateDessert = rasodueDateDessert;
        this.rasotypeDessert = rasotypeDessert;
        this.rasocaloryDessert = rasocaloryDessert;
    }

    public int getRasoidDessert() {
        return rasoidDessert;
    }

    public void setRasoidDessert(int rasoidDessert) {
        this.rasoidDessert = rasoidDessert;
    }

    public String getRasonameDessert() {
        return rasonameDessert;
    }

    public void setRasonameDessert(String rasonameDessert) {
        this.rasonameDessert = rasonameDessert;
    }

    public LocalDate getRasodueDateDessert() {
        return rasodueDateDessert;
    }

    public void setRasodueDateDessert(LocalDate rasodueDateDessert) {
        this.rasodueDateDessert = rasodueDateDessert;
    }

    public String getRasotypeDessert() {
        return rasotypeDessert;
    }

    public void setRasotypeDessert(String rasotypeDessert) {
        this.rasotypeDessert = rasotypeDessert;
    }

    public int getRasocaloryDessert() {
        return rasocaloryDessert;
    }

    public void setRasocaloryDessert(int rasocaloryDessert) {
        this.rasocaloryDessert = rasocaloryDessert;
    }
}
