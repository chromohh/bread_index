package chromo.ec.breadindex.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class BreadForm {
    @NotBlank(message = "BreadName are required")
    @Size(min = 2, max = 60)
    private String breadName;

    @NotBlank(message = "Instructions are required")
    @Size(min = 100, max = 1500, message = "Please enter at least 100 characters")
    private String instructions;

    private String author;

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
