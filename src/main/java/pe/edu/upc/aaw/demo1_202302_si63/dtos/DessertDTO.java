package pe.edu.upc.aaw.demo1_202302_si63.dtos;

import java.time.LocalDate;

public class DessertDTO {
    private int rasoidDessert;
    private String rasonameDessert;
    private LocalDate rasodueDateDessert;
    private String rasotypeDessert;
    private int rasocaloryDessert;

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
