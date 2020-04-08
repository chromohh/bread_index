package chromo.ec.breadindex;

import chromo.ec.breadindex.data.*;
import chromo.ec.breadindex.dto.UserForm;
import chromo.ec.breadindex.entity.Bread;
import chromo.ec.breadindex.entity.User;
import chromo.ec.breadindex.entity.UserRole;
import chromo.ec.breadindex.service.BreadService;
import chromo.ec.breadindex.service.BreadServiceImpl;
import chromo.ec.breadindex.service.UserService;
import chromo.ec.breadindex.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {

    private InstructionRepo instructionRepo;
    private BreadRepo breadRepo;
    private IngredientRepo ingredientRepo;
    private UserRoleRepo userRoleRepo;
    private IngredientAndAmountRepo ingredientAndAmountRepo;
    private UserRepo userRepo;
    private BreadServiceImpl breadService;
    private UserServiceImpl userService;

    @Autowired
    public Seeder(InstructionRepo instructionRepo, BreadRepo breadRepo, IngredientRepo ingredientRepo, UserRoleRepo userRoleRepo, IngredientAndAmountRepo ingredientAndAmountRepo, UserRepo userRepo, BreadServiceImpl breadService, UserServiceImpl userService) {
        this.instructionRepo = instructionRepo;
        this.breadRepo = breadRepo;
        this.ingredientRepo = ingredientRepo;
        this.userRoleRepo = userRoleRepo;
        this.ingredientAndAmountRepo = ingredientAndAmountRepo;
        this.userRepo = userRepo;
        this.breadService = breadService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        try{
            userRoleRepo.save(new UserRole("ADMIN"));
            userRoleRepo.save(new UserRole("USER"));
        }catch (Exception e){  System.out.println("a");}
        try{
            breadService.save(new Bread("Surdegs Limpa"));
        }catch(Exception e){ System.out.println("a");}
        try{
            UserForm userForm = new UserForm();
            userForm.setAdmin(true);
            userForm.setEmail("eddan@gmail.com");
            userForm.setPassword("eddan");
            userForm.setUsername("eddan");
            userService.registerNew(userForm);
        }catch(Exception e){ System.out.println("a"); }
    }
}
