package Util;

import Interfaces.Validate;

public class ValidadeUtils implements Validate {

    @Override
    public String requireNonEmpty(String value, String field){
        if(value == null || value.trim().isEmpty()){
            throw new IllegalArgumentException("[" + field + "]" + " Não pode ser nulo/vazio.");
        }
        return value.trim();
    }
}
