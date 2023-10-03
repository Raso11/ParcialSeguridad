package pe.edu.upc.aaw.demo1_202302_si63.dtos;

import pe.edu.upc.aaw.demo1_202302_si63.entities.Dessert;

public class IngredientDTO {
    private int rasoidIngredient;
    private String rasonameIngredient;
    private double rasoamountIngredient;
    private String rasotypeIngredient;

    private Dessert rasodessert;

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
