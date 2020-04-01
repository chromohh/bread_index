package chromo.ec.breadindex.data;

import chromo.ec.breadindex.entity.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepo extends CrudRepository<Ingredient, Integer> {

    Optional<Ingredient> findByIngredientName(String Name);

    @Query("SELECT i FROM Ingredient i WHERE i.ingredientName LIKE %:ingredientName%")
    List<Ingredient> findByIngredientNameContains(@Param("ingredientName") String Name);
}
