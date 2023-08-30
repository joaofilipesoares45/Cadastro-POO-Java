package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {

        PessoaFisica pf1 = new PessoaFisica();
        pf1.setCpf("11111111111");
        pf1.setId(1);
        pf1.setNome("Ana");
        pf1.setIdade(25);
        PessoaFisica pf2 = new PessoaFisica();
        pf2.setCpf("22222222222");
        pf2.setId(2);
        pf2.setNome("Carlos");
        pf2.setIdade(52);
    
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        ArrayList<PessoaFisica> pfList = new ArrayList<>();
        pfList.add(pf1);
        pfList.add(pf2);
        for (PessoaFisica pessoaFisica : pfList) {
            repo1.inserir(pessoaFisica);
        }

        repo1.persistir("Procedimento 1/PessoaFisica.binBackup");

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar("Procedimento 1/PessoaFisica.binBackup",pfList.size());

        PessoaJuridica pj1 = new PessoaJuridica();
        pj1.setCnpj("33333333333333");
        pj1.setId(3);
        pj1.setNome("XPTO Sales");
        PessoaJuridica pj2 = new PessoaJuridica();
        pj2.setCnpj("44444444444444");
        pj2.setId(4);
        pj2.setNome("XPTO Solutions");

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        ArrayList<PessoaJuridica> pjList = new ArrayList<>();
        pjList.add(pj1);
        pjList.add(pj2);
        for (PessoaJuridica pessoaJuridica : pjList) {
            repo3.inserir(pessoaJuridica);
        }
        repo3.persistir("Procedimento 1/PessoaJuridica.binBackup");

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar("Procedimento 1/PessoaJuridica.binBackup",pjList.size());

    }
}
