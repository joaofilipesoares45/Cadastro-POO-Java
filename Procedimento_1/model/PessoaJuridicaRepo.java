package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PessoaJuridicaRepo extends PessoaJuridica{

    private ArrayList<PessoaJuridica> PessoaJuridicaArrList = new ArrayList<>();

    public void inserir(PessoaJuridica pessoaJuridica) {
        PessoaJuridicaArrList.add(pessoaJuridica);
    }

    public void alterar( int x , String att ) {

    }

    public void excluir( int index ) {
        
    }

    public void obter( int index ) {
        
    }

    public void obterTodos() {
        
    }

    public void persistir(String file) throws FileNotFoundException, IOException{
        ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file));
        for (PessoaJuridica pessoaJuridica : PessoaJuridicaArrList) {
            objectOutput.writeObject(pessoaJuridica);
        }
        objectOutput.close();
        System.out.println("Dados de Pessoa Juririca Armazenados");
    }
    
    public void recuperar(String file, int size) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file));
        System.out.println("Dados de Pessoa Juririca Recuperados");
        for (int i = 0; i < size; i++) {
            PessoaJuridica pessoaJuridica = (PessoaJuridica)objectInput.readObject();
            pessoaJuridica.exibir();
        }
        objectInput.close();
    }
    
}
