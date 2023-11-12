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

            String response = rd.next();

            Class<?> class1 = response.getClass();

            if (class1.getSimpleName() != "int") {
                try {
                    int rsp = Integer.parseInt(response);
                    if (rsp >= 0 && rsp <= 7) {

                        if (rsp == 0) {
                            System.out.println("Seção Encerrada");
                            rd.close();
                            rd = null;

                        }
                        if (rsp == 1) {
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
                        if (rsp == 2) {
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
                        if (rsp == 3) {
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
                        if (rsp == 4) {
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
                        if (rsp == 5) {
                            pfRepo.obterTodos();
                            pjRepo.obterTodos();
                        }
                        if (rsp == 6) {
                            pfRepo.persistir("Procedimento_2/PessoaFisica.binBackup");
                            pjRepo.persistir("Procedimento_2/PessoaJuridica.binBackup");
                        }
                        if (rsp == 7) {
                            pfRepo.recuperar("Procedimento_2/PessoaFisica.binBackup");
                            pjRepo.recuperar("Procedimento_2/PessoaJuridica.binBackup");
                        }
                    } else {
                        System.out.println("\nERRO!!\nDigite Uma Escolha Válida!");
                    }
                } catch (Exception e) {
                    System.out.println("\nERRO!!\nDigite Uma Escolha Válida!");
                }
            }
        }
    }
}
