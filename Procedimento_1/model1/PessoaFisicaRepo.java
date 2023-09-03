package model1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> PessoaFisicaArrList = new ArrayList<>();

    public void inserir(PessoaFisica pessoaFisica) {
        PessoaFisicaArrList.add(pessoaFisica);
    }
    
    public void alterar(int id, String att) {
    }

    public void excluir(int index) {
    }

    public void obter(int index) {

    }

    public void obterTodos() {
    }

    public void persistir(String file) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file));

        for (PessoaFisica pessoaFisica : PessoaFisicaArrList) {
            objectOutput.writeObject(pessoaFisica);
        }
        objectOutput.close();
        System.out.println("Dados de Pessoa Fisica Armazenados.");
    }

    public void recuperar(String file,int size) throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("Dados de Pessoa Fisica Recuperados.");
        ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file));
       
        for (int i = 0; i < size; i++) {
            PessoaFisica pessoaFisica = (PessoaFisica) objectInput.readObject();
            pessoaFisica.exibir();
        }
        objectInput.close();
    }
}