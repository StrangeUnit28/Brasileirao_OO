package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import controller.*;

/**
 * Menu inicial da aplicação. Permite navegar entre as opções/operações possíveis em toda a aplicação
 * @author Rafael Bosi
 *
 */
public class MenuPrincipal implements ActionListener{
	
	private static JFrame janela = new JFrame("Champions League");
	private static JLabel titulo = new JLabel("Bem-Vindo a Champions League");
	private static JLabel tituloTabela = new JLabel("Classificação da Liga");
	private static JLabel tituloArt = new JLabel("Artilharia da Liga");
	private static JLabel subtituloTabela = new JLabel("NOME  PTS  PJ  V  E  D  GM  GS");
	private static JLabel subtituloArt = new JLabel("NOME            TIME             GOLS");
	private static String[] listaTabela;
	private static String[] listaArt;
	private static JList<String> tabela;
	private static JList<String> tabelaArt;
	private static JButton simular = new JButton("Simular Temporada");
	private static JButton jogador = new JButton("Jogadores");
	private static JButton tecnico = new JButton("Técnicos");
	private static JButton rodadas = new JButton("Dados das Rodadas");
	public static DadosController dados = new DadosController();

	/**
	 * Construtor da tela MenuPrincipal. Define a fonte e o tamanho da letra do título, o tamanho da janela, os componentes e seus respectivos tamanhos
	 */
	public MenuPrincipal() {
		listaTabela = new TabelaController(dados).montarClassificacao();
		listaArt = new TabelaDeArtilhariaController(dados).classificacaoArtilharia();
		tabela = new JList<String>(listaTabela);
		tabelaArt = new JList<String>(listaArt);
		
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		tituloTabela.setFont(new Font("Arial", Font.BOLD, 15));
		tituloArt.setFont(new Font("Arial", Font.BOLD, 15));
		subtituloTabela.setFont(new Font("Arial", Font.BOLD, 10));
		subtituloArt.setFont(new Font("Arial", Font.BOLD, 10));
		
		
		titulo.setBounds(325, 10, 400, 30);
		tituloTabela.setBounds(240, 40, 300, 30);
		tituloArt.setBounds(600, 40, 300, 30);
		subtituloTabela.setBounds(240, 60, 300, 30);
		subtituloArt.setBounds(570, 60, 300, 30);
		tabela.setBounds(200, 85, 250, 360);
		tabelaArt.setBounds(550, 85, 250, 360);
		simular.setBounds(50, 460, 200, 30);
		jogador.setBounds(275, 460, 200, 30);
		tecnico.setBounds(500, 460, 200, 30);
		rodadas.setBounds(725, 460, 200, 30);
		
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(tituloTabela);
		janela.add(tituloArt);
		janela.add(subtituloTabela);
		janela.add(subtituloArt);
		janela.add(tabela);
		janela.add(tabelaArt);
		janela.add(simular);
		janela.add(jogador);
		janela.add(tecnico);
		janela.add(rodadas);
		
		janela.setSize(1000, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	/**
	 * Método main da aplicação responsável por integrar o menu principal com os submenus
	 * @param args
	 */
	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
		
		simular.addActionListener(menu);
		jogador.addActionListener(menu);
		tecnico.addActionListener(menu);
		rodadas.addActionListener(menu);
	}
	
	/**
	 * Reage a eventos de clique nos botões declarados. Abre um submenu específico dependendo do botão clicado
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == simular) {
			TemporadaController t = new TemporadaController();
			t.simularTemporada(dados);
			tabela.setListData(new TabelaController(dados).montarClassificacao());
			tabelaArt.setListData(new TabelaDeArtilhariaController(dados).classificacaoArtilharia());
			tabela.updateUI();
			tabelaArt.updateUI();
		}
		if (src == jogador) {
			new TelaPessoa().showPessoa(dados, 1);
		}
		if(src == tecnico) {
			new TelaPessoa().showPessoa(dados, 2);
		}
		if(src == rodadas) {
			new TelaRodadas().showRodadas(dados);
		}	
	}
}
