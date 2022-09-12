package view;

import java.awt.event.*;
import javax.swing.*;
import controller.*;
/**
 * Classe que seria responsável por editar e criar Técnicos e Jogadores
 * @author Rafael Bosi
 *@version 1.0 (set 2022)
 */
public class TelaDetalhePessoa implements ActionListener {
	
	private JFrame janela;
	private JList<String> valorJogador;
	private JList<String> valorTecnico;
	private JButton excluir = new JButton("Excluir");
	private JButton salvar = new JButton("Salvar");
	private String[] novoDadoJogador = new String[5];
	private String[] novoDadoTenico = new String[4];
	private static DadosController dados;
	private int posicao;
	private int opcao;
	private String s;
	
	/**
	 * Método que seria responsável por criar e editar Jogadores e Técnicos
	 * @param op int representando a operação a ser feita
	 * @param d Objeto da classe DadosController
	 * @param p Objeto da classe TelaPessoa
	 * @param pos int que representa a posição de algum dado dentro de um String[]
	 */
	public void criarEditar(int op, DadosController d,
			TelaPessoa p, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if (op == 1) {
			s = "Cadastro de Jogador";
		}
		if (op == 2) {
			s = "Cadastro de Técnico";
		}
		if (op == 3) {
			s = "Detalhe de Jogador";
		}
		if (op == 4) {
			s = "Detalhe de Tecnico";
		}
		
		janela = new JFrame(s);
		
		if (op == 3) {
			valorJogador = new JList<String>(dados.transformarDadosJogadores(dados.getJogadores()));
		}
		else if(op == 4) {
			valorTecnico = new JList<String>(dados.transformarDadosTecnico(dados.getTecnicos()));
		}
	}
	
	/**
	 * Reage a eventos de clique nos botões declarados. Abre um submenu específico dependendo do botão clicado
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
	}
		
}
