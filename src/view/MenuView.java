package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuView {
	private JFrame janela;
	private JPanel painelDaJanela;
	private JMenuBar barraMenu;
	private JMenu menu01;
	private JMenu menu02;
	private JMenuItem aluno;
	private JMenuItem funcionario;
	private JMenuItem cidade;
	private JMenuItem estado;
	private JMenuItem alunoRelatorio;
	private JMenuItem funcionarioRelatorio;

	public MenuView() {
		iniciaMenuView();
	}

	public void iniciaMenuView() {
		janela = new JFrame("Exemplo de menu");
		barraMenu = new JMenuBar();
		
		menu01 = new JMenu("Cadastro");
		menu01.setFont(new Font("Consolas", Font.BOLD, 22));
		
		menu02 = new JMenu("Relatório");
		menu02.setFont(new Font("Consolas", Font.BOLD, 22));
		
		aluno = new JMenuItem("Aluno");
		aluno.setFont(new Font("Consolas", Font.BOLD, 22));
		
		funcionario = new JMenuItem("Funcionario");
		funcionario.setFont(new Font("Consolas", Font.BOLD, 22));
		
		cidade = new JMenuItem("Cidade");
		cidade.setFont(new Font("Consolas", Font.BOLD, 22));
		
		estado = new JMenuItem("Estado");
		estado.setFont(new Font("Consolas", Font.BOLD, 22));
		
		alunoRelatorio = new JMenuItem("Aluno");
		alunoRelatorio.setFont(new Font("Consolas", Font.BOLD, 22));
		
		funcionarioRelatorio = new JMenuItem("Funcionario");
		funcionarioRelatorio.setFont(new Font("Consolas", Font.BOLD, 22));
		
		
		
		painelDaJanela = (JPanel) janela.getContentPane();
		painelDaJanela.setBackground(new Color(230, 230, 250));

		// apresentar menus na barra de menu
		barraMenu.add(menu01);
		barraMenu.add(menu02);

		// colocar item menu no menu
		menu01.add(aluno);
		menu01.add(funcionario);
		menu01.add(cidade);
		menu01.add(estado);
		menu02.add(alunoRelatorio);
		menu02.add(funcionarioRelatorio);

		aluno.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AlunoView();
			}
		});

		funcionario.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// new TesteGui05().iniciaGui();
				// janela.dispose();
				new FuncionarioView();
			}
		});

		cidade.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 new CidadeView();
			}
		});

		estado.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// new TesteGui05().iniciaGui();
				// janela.dispose();
				new EstadoView();
			}
		});
		alunoRelatorio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RelatorioAlunoView();
			}
		});

		funcionarioRelatorio.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// new TesteGui05().iniciaGui();
				// janela.dispose();
				new RelatorioFuncionarioView();
			}
		});
		// painel
		painelDaJanela.setLayout(null);
		
		// painelDaJanela.add(barraMenu);

		// config tela
		janela = new JFrame();	
		janela.add(painelDaJanela);
		
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		janela.setSize(790, 370);
		janela.setVisible(true);
		janela.setJMenuBar(barraMenu);		
		janela.setLocationRelativeTo(null);		
		janela.setVisible(true);
		janela.setResizable(false);		
		janela.setUndecorated(true);
		
		
		

	}

}
