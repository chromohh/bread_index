package chromo.ec.breadindex.service;

import chromo.ec.breadindex.data.*;
import chromo.ec.breadindex.dto.BreadForm;
import chromo.ec.breadindex.dto.IngredientForm;
import chromo.ec.breadindex.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BreadServiceImpl implements BreadService{
    private BreadRepo breadRepository;
    private IngredientAndAmountRepo ingredientAndAmountRepository;
    private IngredientRepo ingredientRepository;
    private InstructionRepo instructionRepoitory;

    @Autowired
    public BreadServiceImpl(BreadRepo breadRepository, IngredientAndAmountRepo ingredientAndAmountRepository, IngredientRepo ingredientRepository, InstructionRepo instructionRepoitory) {
        this.breadRepository = breadRepository;
        this.ingredientAndAmountRepository = ingredientAndAmountRepository;
        this.ingredientRepository = ingredientRepository;
        this.instructionRepoitory = instructionRepoitory;
    }

    @Override
    public Bread createBread(BreadForm breadForm) {
        return null;
    }

    @Override
    public Bread save(Bread bread) {
        return null;
    }

    @Override
    public Optional<Bread> approveBread(Bread bread) {
        return Optional.empty();
    }

    @Override
    public Optional<Ingredient> createIngredient(IngredientForm ingredientForm) {
        return Optional.empty();
    }

    @Override
    public Optional<Ingredient> saveIngredient(Ingredient ingredient) {
        return Optional.empty();
    }

    @Override
    public Optional<IngredientAndAmount> addIngredientToBread(String amount, Ingredient ingredient, Bread bread) {
        return Optional.empty();
    }

    @Override
    public Optional<Instruction> createAndAddInstructions(Instruction Form, Bread bread) {
        return Optional.empty();
    }

    @Override
    public Optional<Bread> findByBreadName(String breadName) {
        return Optional.empty();
    }

    @Override
    public Optional<Bread> findById(int breadId) {
        return Optional.empty();
    }
}
