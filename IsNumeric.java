package br.uniesp.poo.ted04;

import java.util.regex.Pattern;

public class IsNumeric {
    
// Verifica se a String é um numero Inteiro
    public static boolean numFloat(String strNum) throws Exception {
        Pattern patternFloat = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (strNum == null) {
            throw new Exception("\n\t\tERRO: Valor inválido, tente novamente");
        }
        return patternFloat.matcher(strNum).matches();
    }

// Verifica se a String é um número Float
    public static boolean numInt(String strNum) throws Exception {
        Pattern patternFloat = Pattern.compile("-?\\d+?");
        if (strNum == null) {
            throw new Exception("\n\t\tERRO: Valor inválido, tente novamente");
        }
        return patternFloat.matcher(strNum).matches();
    }

// Verifica se a String possui apenas letras
    public static boolean numChar(String nome) throws Exception {
        for (int i = 0; i < nome.length(); i++) {
            if (Character.isDigit(nome.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
