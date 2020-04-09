package chromo.ec.breadindex.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class IngredientForm {

    @NotBlank(message = "Name of ingredient name is required")
    @Size(min = 2, max = 100)
    private String ingredientName;

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
