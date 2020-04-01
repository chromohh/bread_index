package chromo.ec.breadindex.data;

import chromo.ec.breadindex.entity.IngredientAndAmount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientAndAmountRepo extends CrudRepository<IngredientAndAmount, Integer> {
}
