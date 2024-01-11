package example.m08_aula07_appdemo;

import java.time.LocalDate;
import java.util.spi.LocaleNameProvider;

/**
 * Super Classe Pessoa.
 * Serve a classe Aluno e outras que possam derivar
 */
public class Pessoa {
    //region Atributos
    private String nome;    //Nome da Pessoa
    private LocalDate dataNascimento;   //Data de nascimento da Pessoa
    private boolean genero; //Género da Pessoa
    //endregion

    //region Construtores
    /**
     * Construtor completo
     * @param nome nome da pessoa
     * @param dataNascimento data de nascimento da pessoa
     * @param genero género da pessoa
     */
    public Pessoa(String nome, LocalDate dataNascimento, boolean genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }
    //endregion
    //region Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    //endregion
}
