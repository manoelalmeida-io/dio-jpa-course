package model;

import javax.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private Integer idade;

    @ManyToOne(fetch = FetchType.EAGER)
    private Estado estado;

    public Aluno() {
    }

    public Aluno(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Aluno(String nome, Integer idade, Estado estado) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", estado=" + estado +
                '}';
    }
}
