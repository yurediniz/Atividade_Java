package br.uniesp.poo.ted04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ManipulaArquivo implements Serializable{
    private static final long serialVersionUID = 1L;
    // serialização: gravando o objetos no arquivo binário "nomeArq"
    public static void gravarArquivo(ArrayList<Object> lista, String nomeArq) {
        File arq = new File(nomeArq);
        try {
            arq.delete();
            arq.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(lista);
            objOutput.flush();
            objOutput.close();

        } catch (IOException e) {
            System.out.printf("Erro: " + e.getMessage());
        }
    }

    // desserialização: recuperando os objetos gravados no arquivo binário "nomeArq"
    public static ArrayList<Object> lerArquivo(String nomeArq) {
        ArrayList<Object> lista = new ArrayList<>();
        try {
            File arq = new File(nomeArq);
            if (arq.exists()) {
                ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
                lista = (ArrayList<Object>) objInput.readObject();
                objInput.close();
            }
        } catch (IOException e) {
            System.out.printf("Erro: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.printf("Erro: " + e.getMessage());
        }
        return (lista);
    }
}