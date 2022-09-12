package model;

import java.util.*;

/**
 * Classe responsável pela criação de objetos do tipo Tecnico e classe filha da classe Pessoa
 * @author Rafael Bosi
 *@version 1.0 (set 2022)
 */
public class Tecnico extends Pessoa {
	
	private boolean cbf;
	private ArrayList<String> opcoesTaticas;
	private String imagemInterna;
	private String imagemExterna;
	
	/**
	 * Construtor sem parâmetro da classe Tecnico
	 */
	public Tecnico() {
		super();
	}
	
	/**
	 * Construtor da classe tecnico que necessita de informações para funcionar
	 * @param nome Nome do técnico
	 * @param nomeTime Nome do time do técnico
	 * @param sexo Sexo do técnico
	 * @param idade Idade do técnico
	 * @param cbf Se true o técnico possui CBF, caso false o técnico não possui CBF
	 * @param opcoesTaticas ArrayList de String contendo as póssiveis táticas que o técnico pode escolher
	 * @param imagemInterna Imagem Interna do técnico
	 * @param imagemExterna Imagem externa do técnico
	 */
	public Tecnico(String nome, String nomeTime, String sexo, 
			int idade, boolean cbf, ArrayList<String> opcoesTaticas, 
			String imagemInterna, String imagemExterna) {
		super(nome, nomeTime, sexo, idade);
		this.cbf = cbf;
		this.opcoesTaticas = opcoesTaticas;
		this.imagemInterna = imagemInterna;
		this.imagemExterna = imagemExterna;
	}
	
	public boolean isCbf() {
		return cbf;
	}
	public void setCbf(boolean cbf) {
		this.cbf = cbf;
	}
	public ArrayList<String> getOpcoesTaticas() {
		return opcoesTaticas;
	}
	public void setOpcoesTaticas(ArrayList<String> opcoesTaticas) {
		this.opcoesTaticas = opcoesTaticas;
	}
	public String getImagemInterna() {
		return imagemInterna;
	}
	public void setImagemInterna(String imagemInterna) {
		this.imagemInterna = imagemInterna;
	}
	public String getImagemExterna() {
		return imagemExterna;
	}
	public void setImagemExterna(String imagemExterna) {
		this.imagemExterna = imagemExterna;
	}

	/**
	 * Pega todos os dados relevantes do objeto e transforma em uma String
	 */
	@Override
	public String toString() {
		return nome + " - " + "time: " + nomeTime + " / sexo: " + sexo + 
				" / idade: " + idade + " / cbf: " + cbf + " / imagemInterna: " + imagemInterna
				+ " / imagemExterna: " + imagemExterna + "\n";
	}
}
