package chromo.ec.breadindex.controller;

import chromo.ec.breadindex.data.*;
import chromo.ec.breadindex.dto.BreadForm;
import chromo.ec.breadindex.dto.UserForm;
import chromo.ec.breadindex.service.BreadServiceImpl;
import chromo.ec.breadindex.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @GetMapping("/users/request")
    public String register(Model model){
        model.addAttribute("form", new BreadForm());
        return "bread-request";
    }

    @PostMapping("/users/request")
    public String registerForm(@Valid @ModelAttribute(name = "form") UserForm form, BindingResult bindingResult) {

        userService.registerNew(form);
        return "redirect:/login";
    }
}
