package pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces;

import pe.edu.upc.aaw.demo1_202302_si63.entities.Dessert;

import java.time.LocalDate;
import java.util.List;

public interface IDessertService {
    public void insert(Dessert rasodessert);
    public List<Dessert> list();
    public void delete(int rasoidDessert);
    public Dessert listarId(int rasoidDessert);
    List<Dessert> findByRasoDueDateDessert(LocalDate rasodueDateDessert);

}
