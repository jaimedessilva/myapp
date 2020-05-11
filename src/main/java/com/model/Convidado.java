package com.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**gestaoFesta
 * Convidado.java
 * @author jaime
 * Em 06-05-2020 **/

@Entity
public class Convidado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private Integer qtdAcompanhantes;
	/*
	 * Construct
	 */
	public Convidado() {}
	/*
	 * Construct
	 */
	public Convidado(String nome, Integer qtdAcompanhantes) {
		this.nome = nome;
		this.qtdAcompanhantes = qtdAcompanhantes;
	}
	/* Getter */
	public long getId() {
		return id;
	}
	/* Setter */
	public void setId(long id) {
		this.id = id;
	}
	/* Getter */
	public String getNome() {
		return nome;
	}
	/* Setter */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/* Getter */
	public Integer getQtdAcompanhantes() {
		return qtdAcompanhantes;
	}
	/* Setter */
	public void setQtdAcompanhantes(Integer qtdAcompanhantes) {
		this.qtdAcompanhantes = qtdAcompanhantes;
	}
	@Override
	public String toString() {
		return "Convidado id:" + id + "\n nome:" + nome + "\n qtdAcompanhantes:" + qtdAcompanhantes;
	}
}
