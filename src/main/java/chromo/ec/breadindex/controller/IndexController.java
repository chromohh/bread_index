package chromo.ec.breadindex.controller;

import chromo.ec.breadindex.data.*;
import chromo.ec.breadindex.dto.UserForm;
import chromo.ec.breadindex.entity.Bread;
import chromo.ec.breadindex.service.BreadServiceImpl;
import chromo.ec.breadindex.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class IndexController {

    private InstructionRepo instructionRepo;
    private BreadRepo breadRepo;
    private IngredientRepo ingredientRepo;
    private UserRoleRepo userRoleRepo;
    private IngredientAndAmountRepo ingredientAndAmountRepo;
    private UserRepo userRepo;
    private BreadServiceImpl breadService;
    private UserServiceImpl userService;

    @Autowired
    public IndexController(InstructionRepo instructionRepo, BreadRepo breadRepo, IngredientRepo ingredientRepo, UserRoleRepo userRoleRepo, IngredientAndAmountRepo ingredientAndAmountRepo, UserRepo userRepo, BreadServiceImpl breadService, UserServiceImpl userService) {
        this.instructionRepo = instructionRepo;
        this.breadRepo = breadRepo;
        this.ingredientRepo = ingredientRepo;
        this.userRoleRepo = userRoleRepo;
        this.ingredientAndAmountRepo = ingredientAndAmountRepo;
        this.userRepo = userRepo;
        this.breadService = breadService;
        this.userService = userService;
    }

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/create/user")
    public String register(Model model){
        model.addAttribute("form", new UserForm());
        return "create-user";
    }

    @PostMapping("/create/user")
    public String registerForm(@Valid @ModelAttribute(name = "form") UserForm form, BindingResult bindingResult) {
        if(userService.findByEmail(form.getEmail()).isPresent()){
            FieldError error = new FieldError("form" ,"email", "Email already taken");
            bindingResult.addError(error);
        }if(bindingResult.hasErrors()){
            return "create-user";
        }
        userService.registerNew(form);
        return "redirect:/login";
    }


    @RequestMapping("/public/breads/{breadId}")
    public String viewBread(@PathVariable(value = "breadId") String breadId, Model model){
        try{
            Optional<Bread> opt = breadRepo.findById(Integer.parseInt(breadId));
            model.addAttribute("bread", opt.get());
            return "bread-view";
        }catch(Exception e){
            return "/index";
        }
    }

    @GetMapping("/breads")
    public String findAll(Model model){
        model.addAttribute("breads", breadRepo.findAll());
        return "breads";
    }



}
