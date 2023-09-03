package model2;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    public String getCnpj(){
        return this.cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public void exibir(){
        System.out.println("id: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Cnpj: " + getCnpj());
    }
}
