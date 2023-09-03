package model2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class PessoaFisicaRepo extends PessoaFisica {

    private ArrayList<PessoaFisica> PessoaFisicaArrList = new ArrayList<>();

    public void inserir() {
        Scanner rd = new Scanner(System.in);
        System.out.println("Digite os Dados da Pessoa:");
        System.out.println("Nome:");
        String nome = rd.nextLine();
        System.out.println("Cpf:");
        String cpf = rd.nextLine();
        System.out.println("Idade:");
        int idade = rd.nextInt();

        PessoaFisica pf = new PessoaFisica();
        pf.setNome(nome);
        pf.setCpf(cpf);
        pf.setId(PessoaFisicaArrList.size());
        pf.setIdade(idade);
        PessoaFisicaArrList.add(pf);
        System.out.println("Adicionado com Sucesso");
        
    }

    public void alterar() {
        Scanner rd = new Scanner(System.in);
        System.out.println("Digite o id da Pessoa que deseja alterar:");
        int index = rd.nextInt();

        System.out.println("Insira os Dados Atualizados");
        System.out.println("Nome:");
        String nome = rd.next();
        System.out.println("Cpf:");
        String cpf = rd.next();
        System.out.println("Idade:");
        int idade = rd.nextInt();

        PessoaFisica pf = new PessoaFisica();
        pf.setNome(nome);
        pf.setCpf(cpf);
        pf.setIdade(idade);
        PessoaFisicaArrList.set(index, pf);
        System.out.println("Alteração bem Sucedida");
        pf.exibir();
    }

    public void excluir() {
        Scanner rd = new Scanner(System.in);
        System.out.println("Digite o id da Pessoa que deseja excluir:");
        int index = rd.nextInt();

        if (index <= PessoaFisicaArrList.size()) {
            PessoaFisicaArrList.remove(index);
            System.out.println("Excluido com sucesso");
        } else {
            System.out.println("ERRO!!\nEscolha um id valido");
        }
    }

    public void obter() {
        Scanner rd = new Scanner(System.in);
        System.out.println("\nDigite o id da Pessoa:");
        int index = rd.nextInt();

        if (PessoaFisicaArrList.size() == 0 || index > PessoaFisicaArrList.size()) {
            System.out.println("Id Não Encontrado\nTente Novamente");
        } else {
            System.out.println("\nResultado da busca:");
            System.out.println("------------------------------------------"); 
            PessoaFisicaArrList.get(index).exibir();
            System.out.println("------------------------------------------");
        }
    }

    public void obterTodos() {

        if (PessoaFisicaArrList.size() > 0) {
            System.out.println("\nDados de Pessoas Fisicas");
            System.out.println("------------------------------------------");
            for (PessoaFisica pessoaFisica : PessoaFisicaArrList) {
                pessoaFisica.exibir();
                System.out.println("------------------------------------------");
            }
        } else {
            System.out.println("------------------------------------------");
            System.out.println("Nenhum Dado de Pessoa Fisica Armazenado");
            System.out.println("------------------------------------------");
        }
    }

    public void persistir(String file) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file));

        for (PessoaFisica pessoaFisica : PessoaFisicaArrList) {
            objectOutput.writeObject(pessoaFisica);
        }
        objectOutput.write(PessoaFisicaArrList.size());
        objectOutput.close();
        System.out.println("Dados de Pessoa Fisica Armazenados.");
    }

    public void recuperar(String file) throws FileNotFoundException, IOException, ClassNotFoundException {

        try (ObjectInputStream inputObject = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("Dados de Pessoa Fisica Recuperados.");
            while (true) {
                PessoaFisica pessoaFisica = (PessoaFisica) inputObject.readObject();
                if (PessoaFisicaArrList.contains(pessoaFisica)) {
                    System.out.println("Dados já Recuperados");
                }else{
                    pessoaFisica.setId(PessoaFisicaArrList.size());
                    PessoaFisicaArrList.add(pessoaFisica);
                }
                
            }
        } catch (Exception e) {}
    }
}