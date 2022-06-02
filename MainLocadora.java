package br.uniesp.poo.ted04;

import java.io.Serializable;

public class MainLocadora implements Serializable {
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) throws Exception {
        
        MenuLocadora menu = new MenuLocadora();
        menu.menu();
    }
}
