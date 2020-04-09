package chromo.ec.breadindex.service;

import chromo.ec.breadindex.data.*;
import chromo.ec.breadindex.dto.BreadForm;
import chromo.ec.breadindex.dto.IngredientAndAmountForm;
import chromo.ec.breadindex.dto.IngredientForm;
import chromo.ec.breadindex.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    @Transactional(rollbackFor = RuntimeException.class)
    public Bread createBread(BreadForm breadForm) {
        Instruction newInstructions = new Instruction(breadForm.getInstructions());
        Bread newBread = new Bread (breadForm.getBreadName(), newInstructions, breadForm.getAuthor());

        instructionRepoitory.save(newInstructions);

        return breadRepository.save(newBread);
    }

    @Override
    public Bread save(Bread bread) {
        return breadRepository.save(bread);
    }

    @Override
    public Optional<Bread> approveBread(Bread bread) {
        Optional<Bread> ret = Optional.ofNullable(bread);
        ret.get().setIsApproved(true);
        breadRepository.save(ret.get());
        return ret;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Ingredient createIngredient(IngredientForm ingredientForm) {
        Ingredient newIngredient = new Ingredient(ingredientForm.getIngredientName());

        return ingredientRepository.save(newIngredient);
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public IngredientAndAmount addIngredientToBread(IngredientAndAmountForm amount, Ingredient ingredient, Bread bread) {
        IngredientAndAmount newIngredientAndAmount =  new IngredientAndAmount(ingredient, amount.getAmount());
        bread.addIngredient(newIngredientAndAmount);

        breadRepository.save(bread);
        return ingredientAndAmountRepository.save(newIngredientAndAmount);
    }

    @Override
    public List<Bread> findByBreadName(String breadName) {
        return breadRepository.findByBreadNameContains(breadName);
    }

    @Override
    public Optional<Bread> findById(int breadId) {
        return breadRepository.findById(breadId);
    }
}
