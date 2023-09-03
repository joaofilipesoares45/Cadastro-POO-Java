package model2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


// Sempre que iniciar o programa realize a função RECUPERAR DADOS para evitar mal funcionamento.
// Função recuperar pode ser ativada teclando "7" na escolha de funções.


public class Main2 {
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {

        System.out.println("Procedimento 2");

        Scanner rd = new Scanner(System.in);

        PessoaFisicaRepo pfRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pjRepo = new PessoaJuridicaRepo();
        while (rd != null) {
            System.out.println(
                    "\n1 - Incluir Pessoa\n2 - Alterar Pessoa\n3 - Excluir Pessoa\n4 - Buscar pelo Id\n5 - Exibir Dados\n6 - Persistir Dados\n7 - Recuperar Dados\n0 - Finalizar Programa");
            int response = rd.nextInt();
            if (response >= 0 && response <= 7) {

                if (response == 0) {
                    System.out.println("Seção Encerrada");
                    rd.close();
                    rd = null;

                }
                if (response == 1) {
                    System.out.println("1 - Pessoa Fisica\n2 - Pessoa Juridica");
                    switch (rd.nextInt()) {
                        case 1:
                            pfRepo.recuperar("Procedimento_2/PessoaFisica.binBackup");
                            pfRepo.inserir();
                            break;

                        case 2:
                            pjRepo.recuperar("Procedimento_2/PessoaJuridica.binBackup");
                            pjRepo.inserir();
                            break;
                    }

                }
                if (response == 2) {
                    System.out.println("1 - Pessoa Fisica\n2 - Pessoa Juridica");
                    switch (rd.nextInt()) {
                        case 1:
                            pfRepo.alterar();
                            break;

                        case 2:
                            pjRepo.alterar();
                            break;
                    }
                }
                if (response == 3) {
                    System.out.println("1 - Pessoa Fisica\n2 - Pessoa Juridica");
                    switch (rd.nextInt()) {
                        case 1:
                            pfRepo.excluir();
                            break;

                        case 2:
                            pjRepo.excluir();
                            break;
                    }
                }
                if (response == 4) {
                    System.out.println("1 - Pessoa Fisica\n2 - Pessoa Juridica");
                    switch (rd.nextInt()) {
                        case 1:
                            pfRepo.obter();
                            break;

                        case 2:
                            pjRepo.obter();
                            break;
                    }
                }
                if (response == 5) {
                    pfRepo.obterTodos();
                    pjRepo.obterTodos();
                }
                if (response == 6) {
                    pfRepo.persistir("Procedimento_2/PessoaFisica.binBackup");
                    pjRepo.persistir("Procedimento_2/PessoaJuridica.binBackup");
                }
                if (response == 7) {
                    pfRepo.recuperar("Procedimento_2/PessoaFisica.binBackup");
                    pjRepo.recuperar("Procedimento_2/PessoaJuridica.binBackup");
                }
            }else{
                System.out.println("\nERRO!!\nDigite Uma Escolha Valida!");
            }
        }
    }
}
