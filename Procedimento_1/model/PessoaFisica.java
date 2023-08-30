package model;


public class PessoaFisica extends Pessoa {
    private String cpf;
    private int idade;

    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;  
    }

    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int idade){
        if (idade > 0 && idade < 130){
            this.idade = idade;
        }
    }

    public void exibir(){
        System.out.println("id: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Cpf: " + getCpf());
        System.out.println("Idade: " + getIdade());
    }
}