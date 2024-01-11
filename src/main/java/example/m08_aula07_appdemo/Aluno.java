package example.m08_aula07_appdemo;

import java.time.LocalDate;

/**
 * Classe de Dados do Aluno
 * Possui os atributos necessários à manipulação dos dados da tabela
 */
public class Aluno extends Pessoa{
    //region Atributos
    /**
     * Código de Processo do Aluno.
     * É o único atributo local
     */
    private int id;
    //endregion
    //region Construtores
    /**
     * Construtor Completo
     * Usa também o construtor da Pessoa para lhe passar dados.
     * @param id número do processo do aluno
     * @param nome nome do aluno
     * @param dataNascimento data de nascimento do aluno
     * @param genero género do aluno
     */
    public Aluno(int id, String nome, LocalDate dataNascimento, boolean genero) {
        //passagem dos dados da superclasse
        super(nome, dataNascimento, genero);
        this.id = id;
    }
    //endregion
    //region Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //endregion
}
