package com.wordpress.fabianosoft.entidades;

public class Carne {

	private String nome;
	private String matricula;
	private String turma;
	private String valor;
	private String numeroParcela;
	private String curso;
	private String vencimento;
	private String horario;

	public Carne() {
		// TODO Stub de construtor gerado automaticamente
	}

	public Carne(String nome, String matricula, String turma, String valor, String numeroParcela, String curso,
			String vencimento, String horario) {
		this.nome = nome;
		this.matricula = matricula;
		this.turma = turma;
		this.valor = valor;
		this.numeroParcela = numeroParcela;
		this.curso = curso;
		this.vencimento = vencimento;
		this.horario = horario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(String numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
