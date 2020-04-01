package chromo.ec.breadindex.constants;

public class Regexs {
    public static final String PASSWORD = "^(?=.*[0-9]+.*)(?=.*[a-zA-Z]+.*)[0-9a-zA-Z]{6,}$";
    public static final String EMAIL = "^(.+)@(.+)$";
    public static final String INGREDIENTAMOUNT = "\\d+";
}
