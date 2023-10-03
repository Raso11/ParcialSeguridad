package pe.edu.upc.aaw.demo1_202302_si63.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Ingredient;
import pe.edu.upc.aaw.demo1_202302_si63.repositories.IIngredientRepository;
import pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces.IIngredientService;

import java.util.List;

@Service
public class IngredientServiceImplement implements IIngredientService {
    @Autowired
    private IIngredientRepository rasoiR;

    @Override
    public void insert(Ingredient rasoingredient) {
        rasoiR.save(rasoingredient);
    }

    @Override
    public List<Ingredient> list() {
        return rasoiR.findAll();
    }


}
