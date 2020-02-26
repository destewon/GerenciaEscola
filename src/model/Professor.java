package model;

import java.util.List;

public class Professor extends Funcionario {
	
	private List<String> materia;
	
	public Professor() {
		System.out.println("Professor criado");
	}

	public Professor(List<String> materia) {
		
		this.materia = materia;
	}

	public List<String> getMateria() {
		return materia;
	}

	public void setMateria(List<String> materia) {
		this.materia = materia;
	}
	
	public void exibe() {
		super.exibe();
		System.out.println("Materia do Professor: "+materia);
	}
}
