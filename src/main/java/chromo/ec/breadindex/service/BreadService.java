package chromo.ec.breadindex.service;

import chromo.ec.breadindex.dto.BreadForm;
import chromo.ec.breadindex.entity.*;

import java.util.Optional;

public interface BreadService {
    Bread createBread(BreadForm breadForm);
    Bread save(Bread bread);
    Optional<Bread> approveBread(Bread bread);
    Optional<Ingredient> createIngredient(Ingredient Form);
    Optional<IngredientAndAmount> addIngredientToBread(String amount, Ingredient ingredient, Bread bread);
    Optional<Instruction> createAndAddInstructions(Instruction Form, Bread bread);
    Optional<Bread> findByBreadName(String breadName);
    Optional<Bread> findById(int breadId);

}
