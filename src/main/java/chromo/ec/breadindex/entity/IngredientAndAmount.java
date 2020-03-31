package chromo.ec.breadindex.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class IngredientAndAmount {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "ingredientAndAmount_id", unique = true)
    private String ingredientAndAmount_id;
    private String amount;

    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;


    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "bread_id")
    private Bread bread;

    public IngredientAndAmount(Ingredient ingredient, String amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    IngredientAndAmount(){}

    public String getAmount() {
        return amount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Bread getBread() {
        return bread;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IngredientAndAmount{");
        sb.append("ingredientAndAmount_id='").append(ingredientAndAmount_id).append('\'');
        sb.append(", amount='").append(amount).append('\'');
        sb.append(", ingredient=").append(ingredient);
        sb.append(", bread=").append(bread);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientAndAmount that = (IngredientAndAmount) o;
        return Objects.equals(ingredientAndAmount_id, that.ingredientAndAmount_id) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(ingredient, that.ingredient) &&
                Objects.equals(bread, that.bread);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientAndAmount_id, amount, ingredient, bread);
    }
}
