package chromo.ec.breadindex.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Bread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int breadId;
    private String breadName;
    private Boolean isApproved;

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
            orphanRemoval = true
    )
    @JoinColumn(name = "instruction_id")
    private Instruction instructions;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
            orphanRemoval = true,
            mappedBy = "bread"
    )
    private List<IngredientAndAmount> ingredients = new ArrayList<>();

    @ManyToOne(
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private User author;

    public Bread(String breadName, Instruction instructions, List<IngredientAndAmount> ingredients, User author) {
        this.breadName = breadName;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.author = author;
        this.isApproved = false;
    }

    public Bread(String breadName, Instruction instructions, User author) {
        this.breadName = breadName;
        this.instructions = instructions;
        this.author = author;
        this.isApproved = false;
    }

    public Bread(String breadName){
        this.breadName = breadName;
        this.isApproved = false;
    }

    Bread(){}

    public int getBreadId() {
        return breadId;
    }

    public String getBreadName() {
        return breadName;
    }

    public Instruction getInstructions() {
        return instructions;
    }

    public List<IngredientAndAmount> getIngredients() {
        return ingredients;
    }

    public User getAuthor() {
        return author;
    }

    public void setBreadName(String breadName) {
        this.breadName = breadName;
    }

    public void setInstructions(Instruction instructions) {
        this.instructions = instructions;
    }

    public void setIngredients(List<IngredientAndAmount> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(IngredientAndAmount ingredient){
        ingredients.add(ingredient);
    }

    public void removeIngredient(IngredientAndAmount ingredient){
        ingredients.remove(ingredient);
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bread bread = (Bread) o;
        return breadId == bread.breadId &&
                Objects.equals(breadName, bread.breadName) &&
                Objects.equals(isApproved, bread.isApproved) &&
                Objects.equals(instructions, bread.instructions) &&
                Objects.equals(ingredients, bread.ingredients) &&
                Objects.equals(author, bread.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breadId, breadName, isApproved, instructions, ingredients, author);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bread{");
        sb.append("breadId=").append(breadId);
        sb.append(", breadName='").append(breadName).append('\'');
        sb.append(", isApproved=").append(isApproved);
        sb.append(", instructions=").append(instructions);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", author=").append(author);
        sb.append('}');
        return sb.toString();
    }
}
