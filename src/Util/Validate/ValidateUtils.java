package Util.Validate;

public class ValidateUtils {
    public static String requireNonEmpty(String value, String field){
        if(value == null || value.trim().isEmpty()){
            throw new IllegalArgumentException("[" + field + "]" + " Não pode ser nulo/vazio.");
        }
        return value.trim();
    }
}
