package com.springuninter.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(nullable = false, length = 50)
	 @NotBlank(message = "Coloque um nome!")
	 @Size(min = 3, max = 50)
	 private String nome;
	 @Column(length = 14)
	 @CPF(message = "Cpf inválido!")
	 private String cpf;
	 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	 @Column(name = "data_nascimento", columnDefinition = "DATE")
	 @NotNull(message = "Esse campo não pode ser nulo!")
	 private LocalDate dataNascimento;
	 @Enumerated(EnumType.STRING)
	 @NotNull(message = "Esse campo não pode ser nulo!")
	 private Sexo sexo;
	 @Column(length = 14)
	 private String telefone;
	 @Column(length = 15)
	 private String celular;
	 @Column(length = 50)
	 @Email(message = "Informe um email válido!")
	 private String email;

	 private boolean ativo;
	 
	public Cliente() {

		this.ativo = true;
	}
	 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
}
