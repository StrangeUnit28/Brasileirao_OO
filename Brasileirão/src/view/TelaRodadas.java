package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controller.*;

/**
 * Classe responsável por listar os resultados dos confrontos das respectivas rodadas
 * @author Rafael Bosi
 *@version 1.0 (set 2022)
 */
public class TelaRodadas implements ActionListener {
	private JFrame rodada;
	private JLabel titulo; 
	private JTextField numRodada;
	private String[] listaResultados;
	private JList<String> resultados;
	private JButton mostrar;
	private static DadosController dados = new DadosController();
	TemporadaController temporada = new TemporadaController();
	int n;
	/**
	 * Método responsável por gerar a TelaRodadas
	 * @param d Objeto da classe DadosController
	 */
	public void showRodadas(DadosController d) {
		dados = d;
		
		rodada = new JFrame("Resultado das Rodada");
		titulo = new JLabel("Digite o número da Rodada");
		numRodada = new JTextField();
		listaResultados = temporada.listarJogosDaRodada(temporada.simularTemporada(dados), n);
		resultados = new JList<String>(listaResultados);
		mostrar = new JButton("Mostrar Confrontos da Rodada");
		
		resultados.setLayoutOrientation(JList.VERTICAL);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(180, 10, 500, 30);
		numRodada.setBounds(300, 40, 30, 30);
		resultados.setBounds(190, 80, 265, 380);
		mostrar.setBounds(220, 470, 200, 30);
		
		rodada.setLayout(null);
		rodada.add(titulo);
		rodada.add(numRodada);
		rodada.add(resultados);
		rodada.add(mostrar);
		
		rodada.setSize(600, 550);
		rodada.setLocationRelativeTo(null);
		rodada.setVisible(true);
		
		numRodada.addActionListener(this);
		mostrar.addActionListener(this);
	}
	
	/**
	 * Reage a eventos de clique nos botões declarados. Abre um submenu específico dependendo do botão clicado
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == mostrar) {
			if (Integer.parseInt(numRodada.getText()) > 0 && Integer.parseInt(numRodada.getText()) < 21) {
				n = Integer.parseInt(numRodada.getText());
				showRodadas(dados);
			}
			else {
				mensagemErro();
			}
		}	
	}
	
	/**
	 * Envia mensagem de erro caso a condição não seja seguida
	 */
	public void mensagemErro() {
		JOptionPane.showMessageDialog(null, "Por favor digite um número entre 1 e 20",
				null, JOptionPane.INFORMATION_MESSAGE);
		rodada.dispose();
	}
}
