package chromo.ec.breadindex.controller;

import chromo.ec.breadindex.data.*;
import chromo.ec.breadindex.service.BreadServiceImpl;
import chromo.ec.breadindex.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppUserController {
    private InstructionRepo instructionRepo;
    private BreadRepo breadRepo;
    private IngredientRepo ingredientRepo;
    private UserRoleRepo userRoleRepo;
    private IngredientAndAmountRepo ingredientAndAmountRepo;
    private UserRepo userRepo;
    private BreadServiceImpl breadService;
    private UserServiceImpl userService;

    @Autowired
    public AppUserController(InstructionRepo instructionRepo, BreadRepo breadRepo, IngredientRepo ingredientRepo, UserRoleRepo userRoleRepo, IngredientAndAmountRepo ingredientAndAmountRepo, UserRepo userRepo, BreadServiceImpl breadService, UserServiceImpl userService) {
        this.instructionRepo = instructionRepo;
        this.breadRepo = breadRepo;
        this.ingredientRepo = ingredientRepo;
        this.userRoleRepo = userRoleRepo;
        this.ingredientAndAmountRepo = ingredientAndAmountRepo;
        this.userRepo = userRepo;
        this.breadService = breadService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginForm(){
        return "login";
    }
}
