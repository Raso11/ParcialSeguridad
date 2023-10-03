package pe.edu.upc.aaw.demo1_202302_si63.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Dessert;
import pe.edu.upc.aaw.demo1_202302_si63.repositories.IDessertRepository;
import pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces.IDessertService;

import java.time.LocalDate;
import java.util.List;

@Service
public class DessertServiceImplement implements IDessertService {
    @Autowired
    private IDessertRepository rasodR;

    @Override
    public void insert(Dessert rasodessert) {
        rasodR.save(rasodessert);
    }

    @Override
    public List<Dessert> list() {
        return rasodR.findAll();
    }

    @Override
    public void delete(int rasoidDessert) {
        rasodR.deleteById(rasoidDessert);
    }

    @Override
    public Dessert listarId(int rasoidDessert) {
        return rasodR.findById(rasoidDessert).orElse(new Dessert());
    }

    @Override
    public List<Dessert> findByRasoDueDateDessert(LocalDate rasodueDateDessert) {
        return rasodR.findByRasodueDateDessert(rasodueDateDessert);
    }




}
