package pe.edu.upc.aaw.demo1_202302_si63.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.demo1_202302_si63.dtos.IngredientDTO;
import pe.edu.upc.aaw.demo1_202302_si63.entities.Ingredient;
import pe.edu.upc.aaw.demo1_202302_si63.serviceinterfaces.IIngredientService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredientes")
public class IngredientController {
    @Autowired
    private IIngredientService rasoiS;

    @PostMapping
    public void registrar(@RequestBody IngredientDTO rasodto) {
        ModelMapper rasom = new ModelMapper();
        Ingredient rasoi = rasom.map(rasodto, Ingredient.class);
        rasoiS.insert(rasoi);
    }

    @GetMapping
    public List<IngredientDTO> listar() {
        return rasoiS.list().stream().map(rasox -> {
            ModelMapper rasom = new ModelMapper();
            return rasom.map(rasox, IngredientDTO.class);
        }).collect(Collectors.toList());

    }

}
