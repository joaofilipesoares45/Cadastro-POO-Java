package model2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaJuridicaRepo extends PessoaJuridica {

    private ArrayList<PessoaJuridica> PessoaJuridicaArrList = new ArrayList<>();

    public void inserir() {
        Scanner rd = new Scanner(System.in);
        System.out.println("Digite os Dados da Pessoa:");
        System.out.println("Nome:");
        String nome = rd.nextLine();
        System.out.println("Cnpj:");
        String cnpj = rd.nextLine();

        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome(nome);
        pj.setId(PessoaJuridicaArrList.size());
        pj.setCnpj(cnpj);

        PessoaJuridicaArrList.add(pj);
        System.out.println("Adicionado com Sucesso");

    }

    public void alterar() {
        Scanner rd = new Scanner(System.in);
        System.out.println("Digite o id da Pessoa que deseja alterar:");
        int index = rd.nextInt();

        System.out.println("Insira os Dados Atualizados:");
        System.out.println("Nome:");
        String nome = rd.nextLine();
        System.out.println("Cnpj:");
        String cnpj = rd.nextLine();

        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome(nome);
        pj.setCnpj(cnpj);

        PessoaJuridicaArrList.set(index, pj);
        System.out.println("Alteração bem Sucedida");
        
    }

    public void excluir() {
        Scanner rd = new Scanner(System.in);
        System.out.println("Digite o id da Pessoa que deseja excluir:");
        int index = rd.nextInt();

        PessoaJuridicaArrList.remove(index);

        System.out.println("Excluido com sucesso");
        
    }

    public void obter() {
        Scanner rd = new Scanner(System.in);
        System.out.println("\nDigite o id da Pessoa:");
        int index = rd.nextInt();

        if (PessoaJuridicaArrList.size() != 0 || index < PessoaJuridicaArrList.size()) {
            System.out.println("Resultado da busca:");
            System.out.println("------------------------------------------");
            System.out.println("Id Encontrado");
            PessoaJuridicaArrList.get(index).exibir();
            System.out.println("------------------------------------------");
        } else {
            System.out.println("Id Não Encontrado\nTente Novamente");
        }
        
    }

    public void obterTodos() {
        if (PessoaJuridicaArrList.size() > 0) {
            System.out.println("\nDados de Pessoas Juridicas");
            System.out.println("------------------------------------------");
            for (PessoaJuridica pessoaJuridica : PessoaJuridicaArrList) {
                pessoaJuridica.exibir();
                System.out.println("------------------------------------------");
            }
        } else {
            System.out.println("------------------------------------------");
            System.out.println("Nenhum Dado de Pessoa Juridica Armazenado");
            System.out.println("------------------------------------------");
        }
        
    }

    public void persistir(String file) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file));
        for (PessoaJuridica pessoaJuridica : PessoaJuridicaArrList) {
            objectOutput.writeObject(pessoaJuridica);
        }
        objectOutput.close();
        System.out.println("Dados de Pessoa Juridica Armazenados");
    }

    public void recuperar(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file));) {
            System.out.println("Dados de Pessoa Juridica Recuperados");
            while (true) {
                PessoaJuridica pessoaJuridica = (PessoaJuridica) objectInput.readObject();
                pessoaJuridica.setId(PessoaJuridicaArrList.size());
                PessoaJuridicaArrList.add(pessoaJuridica);
            }
        } catch (Exception e) {}
    }
}
