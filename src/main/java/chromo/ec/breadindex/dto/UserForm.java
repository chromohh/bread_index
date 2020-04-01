package chromo.ec.breadindex.dto;
import chromo.ec.breadindex.constants.Regexs;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm {
    @NotBlank(message = "Username is required")
    @Size(min = 2, max = 60)
    private String username;
    @NotBlank(message = "Password is required")
    @Pattern(regexp = Regexs.PASSWORD, message = "Must contain at least one letter, one number, and be longer than six characters.")
    private String password;
    @NotBlank(message = "Email is required")
    @Pattern(regexp = Regexs.EMAIL, message = "Enter a valid email..")
    private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
