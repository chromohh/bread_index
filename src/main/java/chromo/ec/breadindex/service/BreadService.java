package chromo.ec.breadindex.service;

import chromo.ec.breadindex.dto.BreadForm;
import chromo.ec.breadindex.dto.IngredientAndAmountForm;
import chromo.ec.breadindex.dto.IngredientForm;
import chromo.ec.breadindex.entity.*;

import java.util.List;
import java.util.Optional;

public interface BreadService {

    Bread createBread(BreadForm breadForm);

    Bread save(Bread bread);

    Optional<Bread> approveBread(Bread bread);

    Ingredient createIngredient(IngredientForm ingredientForm);

    Ingredient saveIngredient(Ingredient ingredient);

    IngredientAndAmount addIngredientToBread(IngredientAndAmountForm amount, Ingredient ingredient, Bread bread);

    List<Bread> findByBreadName(String breadName);

    Optional<Bread> findById(int breadId);

}
