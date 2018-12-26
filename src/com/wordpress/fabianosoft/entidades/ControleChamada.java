package com.wordpress.fabianosoft.entidades;

public class ControleChamada {

	private String dias, horarios, curso, inicio, termino;
	private String numero, matriculaNome, fone;

	public ControleChamada() {
		super();
		// TODO Stub de construtor gerado automaticamente
	}

	public ControleChamada(String dias, String horarios, String curso, String inicio, String termino, String numero,
			String matriculaNome, String fone) {
		super();
		this.dias = dias;
		this.horarios = horarios;
		this.curso = curso;
		this.inicio = inicio;
		this.termino = termino;
		this.numero = numero;
		this.matriculaNome = matriculaNome;
		this.fone = fone;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getMatriculaNome() {
		return matriculaNome;
	}

	public void setMatriculaNome(String matriculaNome) {
		this.matriculaNome = matriculaNome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

}
