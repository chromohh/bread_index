package chromo.ec.breadindex.controller;

import chromo.ec.breadindex.data.*;
import chromo.ec.breadindex.entity.Bread;
import chromo.ec.breadindex.service.BreadServiceImpl;
import chromo.ec.breadindex.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdminController {
    private InstructionRepo instructionRepo;
    private BreadRepo breadRepo;
    private IngredientRepo ingredientRepo;
    private UserRoleRepo userRoleRepo;
    private IngredientAndAmountRepo ingredientAndAmountRepo;
    private UserRepo userRepo;
    private BreadServiceImpl breadService;
    private UserServiceImpl userService;

    @Autowired
    public AdminController(InstructionRepo instructionRepo, BreadRepo breadRepo, IngredientRepo ingredientRepo, UserRoleRepo userRoleRepo, IngredientAndAmountRepo ingredientAndAmountRepo, UserRepo userRepo, BreadServiceImpl breadService, UserServiceImpl userService) {
        this.instructionRepo = instructionRepo;
        this.breadRepo = breadRepo;
        this.ingredientRepo = ingredientRepo;
        this.userRoleRepo = userRoleRepo;
        this.ingredientAndAmountRepo = ingredientAndAmountRepo;
        this.userRepo = userRepo;
        this.breadService = breadService;
        this.userService = userService;
    }

    @GetMapping("/admin/bread/delete/{breadId}")
    public String deleteBread(@PathVariable(value = "breadId") int breadId, @AuthenticationPrincipal UserDetails caller, Model model){

        if(caller.getAuthorities().stream().anyMatch(auth -> ((GrantedAuthority) auth).getAuthority().equals("ADMIN"))){
            breadRepo.deleteById(breadId);
            return "redirect:/breads";
        }

        return "redirect:/accessdenied";
    }

    @GetMapping("/admin/bread/approve/{breadId}")
    public String approveBread(@PathVariable(value = "breadId") int breadId, @AuthenticationPrincipal UserDetails caller, Model model){

        if(caller.getAuthorities().stream().anyMatch(auth -> ((GrantedAuthority) auth).getAuthority().equals("ADMIN"))){
            if(breadRepo.findById(breadId).get().getIsApproved()){
                Bread temp = breadRepo.findById(breadId).get();
                temp.setIsApproved(false);
                breadRepo.save(temp);
            }else{Bread temp = breadRepo.findById(breadId).get();
                temp.setIsApproved(true);
                breadRepo.save(temp);}
            return "redirect:/breads";
        }

        return "redirect:/accessdenied";
    }


    @GetMapping("/accessdenied")
    public String getAccessDenied(){
        return "access-denied";
    }
    

}
