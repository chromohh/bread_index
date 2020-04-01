package chromo.ec.breadindex.data;

import chromo.ec.breadindex.entity.Bread;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BreadRepo extends CrudRepository<Bread, Integer> {

    @Query("SELECT b FROM Bread b WHERE b.breadName LIKE %:breadName%")
    List<Bread> findByBreadNameContains(@Param("breadName") String Name);

    @Query("SELECT b FROM Bread b JOIN FETCH b.ingredients IngredientAndAmount WHERE IngredientAndAmount.ingredient.ingredientName = :ingredientName")
    List<Bread> findByIngredientName(@Param("ingredientNam") String ingredientName);

    List<Bread> findByAuthorUserNameContainsIgnoreCase(String author);


}
