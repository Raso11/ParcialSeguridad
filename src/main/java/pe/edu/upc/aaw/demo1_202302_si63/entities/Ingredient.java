package pe.edu.upc.aaw.demo1_202302_si63.entities;

import javax.persistence.*;

@Entity
@Table(name = "Ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rasoidIngredient;
    @Column(name = "nameIngredient", nullable = false, length = 30)
    private String rasonameIngredient;
    @Column(name = "amountIngredient", nullable = false)
    private double rasoamountIngredient;
    @Column(name = "typeIngredient", nullable = false, length = 30)
    private String rasotypeIngredient;
    @ManyToOne
    @JoinColumn(name = "idDessert")
    private Dessert rasodessert;

    public Ingredient() {
    }

    public Ingredient(int rasoidIngredient, String rasonameIngredient, double rasoamountIngredient, String rasotypeIngredient, Dessert rasodessert) {
        this.rasoidIngredient = rasoidIngredient;
        this.rasonameIngredient = rasonameIngredient;
        this.rasoamountIngredient = rasoamountIngredient;
        this.rasotypeIngredient = rasotypeIngredient;
        this.rasodessert = rasodessert;
    }

    public int getRasoidIngredient() {
        return rasoidIngredient;
    }

    public void setRasoidIngredient(int rasoidIngredient) {
        this.rasoidIngredient = rasoidIngredient;
    }

    public String getRasonameIngredient() {
        return rasonameIngredient;
    }

    public void setRasonameIngredient(String rasonameIngredient) {
        this.rasonameIngredient = rasonameIngredient;
    }

    public double getRasoamountIngredient() {
        return rasoamountIngredient;
    }

    public void setRasoamountIngredient(double rasoamountIngredient) {
        this.rasoamountIngredient = rasoamountIngredient;
    }

    public String getRasotypeIngredient() {
        return rasotypeIngredient;
    }

    public void setRasotypeIngredient(String rasotypeIngredient) {
        this.rasotypeIngredient = rasotypeIngredient;
    }

    public Dessert getRasodessert() {
        return rasodessert;
    }

    public void setRasodessert(Dessert rasodessert) {
        this.rasodessert = rasodessert;
    }
}
