package controller;

import model.*;
import java.util.*;

/**
 * Controle de todos os tipos de dados disponíveis na aplicação
 * @author Rafael Bosi
 *@version 1.0 (set 2022)
 */
public class DadosController {

	private Dados d = new Dados();
	
	/**
	 * Construtor da classe DadosController
	 */
	public DadosController() {
		d.createAllData();
	}
	
	/**
	 * Método responsável por deletar um objeto Jogador a partir do time que joga e de seu index 
	 * @param nomeTime Nome do time do jogador a ser deletado
	 * @param index Posição do jogador a ser deletado
	 * @return true Caso o jogador tenha sido deletado adequadamente retorna true
	 */
	public boolean deletarJogador(String nomeTime, int index) {
		if (index < 0 || index > 10) {
			return false;
		}
		else {
			for (int j=0; j<20; j++) {
				if (d.getTimes().get(j).getNome() == nomeTime) {
					for(int n=0; n<219; n++) {
						if(d.getJogadores().get(n).getId() ==
								d.getTimes().get(j).getJogadores().get(index).getId()) {
							d.getJogadores().remove(n);
							d.getTimes().get(j).getJogadores().remove(index);
						}
					}
				}
			}
			return true;
		}
	}
	
	/**
	 * Método responsável por deletar um técnico a partir do seu index
	 * @param index Posição do técnico a ser deletado
	 * @return Retorna true caso o técnico tenha sido deletado com sucesso
	 */
	public boolean deletarTecnico(int index) {
		if (index >= 20) {
			return false;
		}
		else {
			d.getTecnicos().remove(index);
			return true;
		}
	}
	
	/**
	 * Método responsável por criar um novo técnico
	 * @param nomeTime Nome do time do técnico a ser criado
	 * @param dadosTecnico String[] contendo as informações [Nome, Idade, Imagem interna e Imagem externa] do novo técnico
	 * @return Retorna true caso o técnico tenha sido criado com sucesso
	 */
	public boolean criarTecnico(String nomeTime,String[] dadosTecnico) {
		if (d.getTecnicos().size()==20) {
			return false;
		}
		else {
			int p = d.getTecnicos().size();
			for(int j=0; j<p; j++) {
				if (d.getTecnicos().get(j).getNomeTime() == nomeTime) {
					return false;
				}
			}
		}
		d.getTecnicos().add(new Tecnico(dadosTecnico[0], nomeTime, 
				"Masculino", Integer.parseInt(dadosTecnico[1]), 
				true, d.getTaticas(), dadosTecnico[2], dadosTecnico[3]));
		return true;
	}
	
	/**
	 * Método responsável por criar um novo jogador
	 * @param nomeTime Nome do time do jogador a ser criado
	 * @param dadosJogador String[] contendo as informações [Nome, Idade, Posição, Número da camisa, Id] do novo joador
	 * @return Retorna true caso o jogador tenha sido criado com sucesso
	 */
	public boolean criarJogador(String nomeTime, String[] dadosJogador) {
		for (int j=0; j<20; j++) {
			if (d.getTimes().get(j).getNome() == nomeTime) {
				if (d.getTimes().get(j).getJogadores().size()>10) {
					return false;
				}
				else {
					d.getTimes().get(j).getJogadores().add(
					new Jogador(dadosJogador[0], nomeTime, "Masculino", 
							Integer.parseInt(dadosJogador[1]),
							0, dadosJogador[2], 0, Integer.parseInt(dadosJogador[3]), 
							Integer.parseInt(dadosJogador[4]) + 220));
					d.getJogadores().add(new Jogador(dadosJogador[0], nomeTime, "Masculino", 
							Integer.parseInt(dadosJogador[1]),
							0, dadosJogador[2], 0, Integer.parseInt(dadosJogador[3]), 
							Integer.parseInt(dadosJogador[4]) + 220));
				}
			}
		}
		return true;
	}
	
	/**
	 * Método responsável por alterar as informações de um jogador
	 * @param index int que representa a posição do jogador a ser atualizado
	 * @param update String[] contendo as informações [Nome, Idade, Posição, Número da camisa, Id]
	 * @return Retorna true caso a alteração tenha sido feita com sucesso
	 */
	public boolean atualizarJogador(int index, String[] update) {
		for(int j=0; j<5; j++){
			if (update[j]==null || update[j]=="" || update[j]==" ") {
				return false;
			}
		}
		d.getJogadores().get(index).setNome(update[0]);
		d.getJogadores().get(index).setIdade(Integer.parseInt(update[1]));
		d.getJogadores().get(index).setPosicao(update[2]);
		d.getJogadores().get(index).setNumCamisa(Integer.parseInt(update[3]));
		d.getJogadores().get(index).setId(Integer.parseInt(update[4])+220);
		return true;
	}
	
	/**
	 * Método responsável por alterar as informações de um técnico
	 * @param index int que representa a posição do técnico a ser atualizado
	 * @param update String[] contendo as informações [Nome, Idade, Imagem interna, Imagem externa]
	 * @return Retorna true caso a alteração tenha ocorrido com sucesso
	 */
	public boolean atualizarTecnico(int index, String[] update) {
		for(int j=0; j<4; j++){
			if (update[j]==null || update[j]=="") {
				return false;
			}
		}
		d.getTecnicos().get(index).setNome(update[0]);
		d.getTecnicos().get(index).setIdade(Integer.parseInt(update[1]));
		d.getTecnicos().get(index).setImagemInterna(update[2]);
		d.getTecnicos().get(index).setImagemExterna(update[3]);
		return true;
	}
	
	/**
	 * Método responsável por buscar um jogador a partir de seu Id
	 * @param id Id do jogador procurado
	 * @return Retorna um String[] com as informações do jogador procurado
	 */
	public String[] buscarJogador(int id){
		String[] jogador = new String[9];
		for (int j=0; j<20; j++) {
			for (int i=0; i<11; i++) {
				if (d.getTimes().get(j).getJogadores().get(i).getId() == id) {
					jogador[0] = "Nome = " + d.getTimes().get(j).getJogadores().get(i).getNome();
					jogador[1] = "Time = " + d.getTimes().get(j).getJogadores().get(i).getNomeTime();
					jogador[2] = "Sexo = " + d.getTimes().get(j).getJogadores().get(i).getSexo();
					jogador[3] = "Idade = " + String.valueOf(d.getTimes().get(j).getJogadores().get(i).getIdade());
					jogador[4] = "Posicao = " + d.getTimes().get(j).getJogadores().get(i).getPosicao();
					jogador[5] = "Partidas = " + String.valueOf(d.getTimes().get(j).getJogadores().get(i).getPartidas());
					jogador[6] = "Gols = " + String.valueOf(d.getTimes().get(j).getJogadores().get(i).getPartidas());
					jogador[7] = "Numero da Camisa = " + String.valueOf(d.getTimes().get(j).getJogadores().get(i).getNumCamisa());
					jogador[8] = "Id = " + String.valueOf(d.getTimes().get(j).getJogadores().get(i).getId());
				}
			}
		}
		return jogador;
	}
	
	/**
	 * Método responsável por buscar um técnico a partir do nome de seu time
	 * @param nomeTime Nome do time do técnico procurado
	 * @return Retorna um String[] com as informações do técnico procurado
	 */
	public String[] buscarTecnico(String nomeTime) {
		String[] tecnico = new String[8];
		for (int j=0; j<20; j++) {
			if (d.getTecnicos().get(j).getNomeTime() == nomeTime) {
				tecnico[0] = "Nome = " + d.getTecnicos().get(j).getNome();
				tecnico[1] = "Time = " + d.getTecnicos().get(j).getNomeTime();
				tecnico[2] = "Sexo = " + d.getTecnicos().get(j).getSexo();
				tecnico[3] = "Idade = " + String.valueOf(d.getTecnicos().get(j).getIdade());
				tecnico[4] = "CBF = " + String.valueOf(d.getTecnicos().get(j).isCbf());
				tecnico[5] = " Taticas = " + String.valueOf(d.getTaticas());
				tecnico[6] = "Imagem Interna = " + d.getTecnicos().get(j).getImagemInterna();
				tecnico[7] = "Imagem Externa = " + d.getTecnicos().get(j).getImagemExterna();
				return tecnico;
			}
		}
		return tecnico;
	}
	/**
	 * Método responsável por transformar os dados ArrayList<Jogador> em String[]
	 * @param ArrayList<Jogador> contendo objetos Jogadoor
	 * @return String[] Contendo os dados dos objetos Jogador 
	 */
	public String[] transformarDadosJogadores(ArrayList<Jogador> jogador) {
		String[] listaJogadores = new String[jogador.size()]; 
		for (int n=0; n<jogador.size(); n++) {
			listaJogadores[n] = jogador.get(n).toString(); 
		}
		return listaJogadores;
	}
	
	/**
	 * Método responsável por transformar os dados ArrayList<Tecnico> em String[]
	 * @param tecnico ArrayList<Tecnico> contendo objetos Tecnico
	 * @return String[] Contendo os dados dos objetos Tecnico
	 */
	public String[] transformarDadosTecnico(ArrayList<Tecnico> tecnico) {
		String[] listatecnicos = new String[tecnico.size()]; 
		for (int n=0; n<tecnico.size(); n++) {
			listatecnicos[n] = tecnico.get(n).toString(); 
		}
		return listatecnicos;
	}
	
	public ArrayList<Jogador> getJogadoresAtleticoMadrid(){
		return this.d.getJogadoresAtleticoMadrid();
	}
	public ArrayList<Jogador> getJogadoresAjax(){
		return this.d.getJogadoresAjax();
	}
	public ArrayList<Jogador> getJogadoresArsenal(){
		return this.d.getJogadoresArsenal();
	}
	public ArrayList<Jogador> getJogadoresBarcelona(){
		return this.d.getJogadoresBarcelona();
	}
	public ArrayList<Jogador> getJogadoresBayernLeverkusen(){
		return this.d.getJogadoresBayernLeverkusen();
	}
	public ArrayList<Jogador> getJogadoresBayern(){
		return this.d.getJogadoresBayern();
	}
	public ArrayList<Jogador> getJogadoresBenfica(){
		return this.d.getJogadoresBenfica();
	}
	public ArrayList<Jogador> getJogadoresBorussia(){
		return this.d.getJogadoresBorussia();
	}
	public ArrayList<Jogador> getJogadoresChealsea(){
		return this.d.getJogadoresChealsea();
	}
	public ArrayList<Jogador> getJogadoresJuventus(){
		return this.d.getJogadoresJuventus();
	}
	public ArrayList<Jogador> getJogadoresLiverpool(){
		return this.d.getJogadoresLiverpool();
	}
	public ArrayList<Jogador> getJogadoresManchesterCity(){
		return this.d.getJogadoresManchesterCity();
	}
	public ArrayList<Jogador> getJogadoresManchesterUnited(){
		return this.d.getJogadoresManchesterUnited();
	}
	public ArrayList<Jogador> getJogadoresMilan(){
		return this.d.getJogadoresMilan();
	}
	public ArrayList<Jogador> getJogadoresNapoli(){
		return this.d.getJogadoresNapoli();
	}
	public ArrayList<Jogador> getJogadoresParis(){
		return this.d.getJogadoresPSG();
	}
	public ArrayList<Jogador> getJogadoresPorto(){
		return this.d.getJogadoresPorto();
	}
	public ArrayList<Jogador> getJogadoresRealMadrid(){
		return this.d.getJogadoresRealMadrid();
	}
	public ArrayList<Jogador> getJogadoresShakhtar(){
		return this.d.getJogadoresShakhtar();
	}
	public ArrayList<Jogador> getJogadoresTottenham(){
		return this.d.getJogadoresTottenham();
	}
	public ArrayList<Tecnico> getTecnicos(){
		return this.d.getTecnicos();
	}
	public ArrayList<Time> getTimes(){
		return this.d.getTimes();
	}
	public ArrayList<Jogador> getJogadores(){
		return this.d.getJogadores();
	}
	
}
