package br.com.senai.model;

import javax.persistence.*;

// Anotacao @Entity indica que esta classe eh uma entidade JPA
@Entity
@Table(name = "clientes") // Mapeia para a tabela 'clientes' no banco
public class Cliente {

    // @Id define a chave primaria
    // @GeneratedValue(strategy = GenerationType.IDENTITY) configura o auto-incremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    private String telefone;

    // Construtor padrao exigido pelo Hibernate
    public Cliente() {
    }

    // Construtor para facilitar a criacao de novos clientes
    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Metodo toString para facilitar a exibicao dos dados do cliente
    @Override
    public String toString() {
        return "Cliente {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}