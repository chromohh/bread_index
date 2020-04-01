package chromo.ec.breadindex.dto;

import chromo.ec.breadindex.constants.Regexs;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class IngredientAndAmountForm {

    @NotBlank(message = "cannot be empty")
    @Pattern(regexp = Regexs.INGREDIENTAMOUNT, message = "Only Numbers")
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
