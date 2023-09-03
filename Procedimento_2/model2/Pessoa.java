package model2;

import java.io.Serializable;

public class Pessoa implements Serializable{
    private int id;
    private String nome;

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public void exibir(){
        System.out.println("Id: " + getId());
        System.out.println("Nome: " + getNome());  
    }
}