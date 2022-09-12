package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.*;
/**
 * Classe ressponsável por montar a TelaPessoa, que apresenta Jogadores ou Técnicos, dependendo do botão que foi clicado em menu 
 * @author rafael Bosi
 *@version 1.0 (set 2022)
 */
public class TelaPessoa implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastrarJogador;
	private JButton refreshJogador;
	private JButton cadastrarTecnico;
	private JButton refreshTecnico;
	private JList<String> listaJogadores;
	private JList<String> listaTecnicos;
	private static DadosController dados = new DadosController();
	private String[] listaGeral;
	
	/**
	 * Construtor da TelaPessoa. Define a fonte e o tamanho da letra do título, o tamanho da janela, os componentes e seus respectivos tamanhos
	 */
	public void showPessoa(DadosController d, int op) {
		dados = d;
		
		switch(op) {
		case 1:
			listaGeral = dados.transformarDadosJogadores(dados.getJogadores());
			listaJogadores = new JList<String>(listaGeral);
			janela = new JFrame("Jogadores");
			titulo = new JLabel("Jogadores em Atividade");
			cadastrarJogador = new JButton("Cadastrar");
			refreshJogador = new JButton("Atualizar");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(250, 10, 250, 30);
			listaJogadores.setBounds(20, 50, 750, 595);
			listaJogadores.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaJogadores.setVisibleRowCount(10);
			
			cadastrarJogador.setBounds(270, 655, 100, 30);
			refreshJogador.setBounds(390, 655, 100, 30);
			
			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaJogadores);
			janela.add(cadastrarJogador);
			janela.add(refreshJogador);
			
			janela.setSize(800, 800);
			janela.setVisible(true);

			cadastrarJogador.addActionListener(this);
			refreshJogador.addActionListener(this);
			listaJogadores.addListSelectionListener(this);
			break;
			
		case 2:
			listaGeral = dados.transformarDadosTecnico(dados.getTecnicos());
			listaTecnicos = new JList<String>(listaGeral);
			janela = new JFrame("Técnicos");
			titulo = new JLabel("Técnicos em Atividade");
			cadastrarTecnico = new JButton("Cadastrar");
			refreshTecnico = new JButton("Atualizar");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(250, 10, 250, 30);
			listaTecnicos.setBounds(20, 50, 700, 400);
			listaTecnicos.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaTecnicos.setVisibleRowCount(10);
			
			cadastrarTecnico.setBounds(220, 460, 100, 30);
			refreshTecnico.setBounds(350, 460, 100, 30);
			
			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaTecnicos);
			janela.add(cadastrarTecnico);
			janela.add(refreshTecnico);
			
			janela.setSize(750, 800);
			janela.setVisible(true);

			cadastrarTecnico.addActionListener(this);
			refreshTecnico.addActionListener(this);
			listaTecnicos.addListSelectionListener(this);
			break;
			
		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Reage a eventos de clique nos botões declarados. Abre um submenu específico dependendo do botão clicado
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastrarJogador) {
			new TelaDetalhePessoa().criarEditar(1, dados, this, 0);
		}
		if(src == cadastrarTecnico) {
			new TelaDetalhePessoa().criarEditar(2, dados, this, 0);
		}
		if(src == refreshJogador) {
			listaJogadores.setListData(dados.transformarDadosJogadores(new DadosController().getJogadores()));
			listaJogadores.updateUI();
		}
		if(src == refreshTecnico) {
			listaTecnicos.setListData(dados.transformarDadosTecnico(new DadosController().getTecnicos()));
		}
	}
	
	/**
	 * Método responsável por reagir quando um dados dentro da lista é clicado
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaJogadores) {
			new TelaDetalhePessoa().criarEditar(3, dados, this, 
					listaJogadores.getSelectedIndex());
		}
		if(e.getValueIsAdjusting() && src == listaTecnicos) {
			new TelaDetalhePessoa().criarEditar(4, dados, this, 
					listaTecnicos.getSelectedIndex());
		}
	}

}
