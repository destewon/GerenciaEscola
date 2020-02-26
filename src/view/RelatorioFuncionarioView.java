package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controler.FuncionarioController;

public class RelatorioFuncionarioView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JTable tabela1;
	private JTable tabela2;
	private JTable tabela3;
	private JTable tabela;
	FuncionarioController funcionario = new FuncionarioController();
	//String linhas[] = aluno.listarTodos().split(";");
	// String colunas2[] = linhas[0].split(";");
	// String colunas3[] = linhas[1].split(";");
	// String colunas4[] = linhas[2].split(";");
	// String nomeAluno = linhas[0];
	// String matriculaAluno = linhas[1];
	// String dataNascimentoAluno = linhas[2];
	private String[] colunas = new String[] { "NOME", "DATA DE NASCIMENTO","TELEFONE" };
	//private String[][] dados = new String[][] { { linhas[1], linhas[0], linhas[2] } };
	private JPanel primeiraAba;
	private JPanel segundaAba;
	private JPanel terceiraAba;
	private JTabbedPane painelComAbas;
	String[] vetor1;
	String[] vetor2;
	String[] vetor3;

	// private JLabel lblIncluirUf;

	private JButton botaoExcluir;
	private JScrollPane painelDeScroll1;
	private JScrollPane painelDeScroll2;
	private JScrollPane painelDeScroll3;
	private JScrollPane painelDeScroll;
	public RelatorioFuncionarioView() {
		iniciaRelatorio();
	}

	/*public void adicionaNaTabela(String a, String b, String c) {

		//String linhas[] = aluno.listarTodos().split(";");
		DefaultTableModel modelo = new DefaultTableModel();
		String[] vetor1 = a.split(";");
		String[] vetor2= b.split(";");
		String[] vetor3= c.split(";");
		

	}*/

	public void iniciaRelatorio() {

		janela = new JFrame("Relatorio do aluno");
		// janela.setFont(new Font("Consolas", Font.BOLD, 22));
		painelDaJanela = (JPanel) janela.getContentPane();
		painelDaJanela.setBackground(new Color(230, 230, 250));
		tabela1 = new JTable();
		tabela2 = new JTable();
		tabela3 = new JTable();
		
		painelDeScroll = new JScrollPane();
		// lblIncluirUf = new JLabel("Informe UF");

		botaoExcluir = new JButton("Cancelar");
		painelComAbas = new JTabbedPane();
		primeiraAba = new JPanel();
		segundaAba = new JPanel();
		terceiraAba = new JPanel();

		// configurar e adicionar as abas
		

		// insere texto nas abas
		
		
		
		// dados = new String[3][];

		// painelDeScroll = (JScrollPane) janela.getContentPane();

		// criar a tabela, ao invés de passar os atributos direto
		// iremos colocar em um modelo de dados

		// dados = aluno.listarTodos();

		// List<String> list = aluno.listarTodos();
		// DefaultTableModel modelo = new DefaultTableModel(dados,colunas);
		// DefaultTableModel modelo = new DefaultTableModel(dados,colunas);
		// modelo.addRow(aluno.listarTodos());

		/// modelo.addRow(aluno.listarTodos());
		// DefaultTableModel modelo2 = new DefaultTableModel(5, 5)
		DefaultTableModel modeloProfessor = new DefaultTableModel(colunas,0);
		DefaultTableModel modeloSecretaria = new DefaultTableModel(colunas,0);
		DefaultTableModel modeloFaxineira = new DefaultTableModel(colunas,0);
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		
		// modelo = (DefaultTableModel) tabela.getModel();

		//for (String string : vetor1) {

			 //String [] dados = new String[] {aluno.listarTodos()};
		//for (String string : colunas) {
		//	modelo.addRow(vetor1);
		//	modelo.addRow(vetor2);
		//	modelo.addRow(vetor3);
		//}
		
		//for(int i=0;i<dadosAluno.length;i++) {
		
		//while(!dadosAluno[i].equals(null)&&!dadosAluno[i].equals("")) {
		
		//for (String string : dadosAluno) {
			//if (i<dadosAluno.length) {
		String dadosAluno[] = funcionario.listarTodos().split(",");
		int i=0;
		while(i<dadosAluno.length) {
			
				String nomeAluno[] = dadosAluno[i].split(";");
				
				if (nomeAluno[3].equals("1")) {
					modeloProfessor.addRow(nomeAluno);
				}else if (nomeAluno[3].equals("2")) {
					modeloSecretaria.addRow(nomeAluno);
				}else if (nomeAluno[3].equals("3")) {
					modeloFaxineira.addRow(nomeAluno);
				}
				
				//modelo.addRow(nomeAluno);
				
				System.out.println(dadosAluno.length);
				
				i++;
		}
		//modelo.addRow(matriculaAluno);
		//modelo.addRow(dataNascimentoAluno);
		//modelo.addRow(nomeAluno2);
			//}
		//String matriculaAluno[] = dadosAluno[1].split(";");
		//String dataNascimentoAluno[] = dadosAluno[2].split(";");
		//String nomeAluno2[] = dadosAluno[3].split(";");
		//}
		//}
		
		//i++;
		//}
		tabela = new JTable(modelo);
		tabela.setBounds(10, 30, 300, 95);
		tabela.setFont(new Font("Consolas", Font.BOLD, 17));
		tabela1 = new JTable(modeloProfessor);
		tabela1.setBounds(10, 30, 300, 95);
		tabela1.setFont(new Font("Consolas", Font.BOLD, 17));
		tabela2 = new JTable(modeloSecretaria);
		tabela2.setBounds(10, 30, 300, 95);
		tabela2.setFont(new Font("Consolas", Font.BOLD, 17));
		tabela3 = new JTable(modeloFaxineira);
		tabela3.setBounds(10, 30, 300, 95);
		tabela3.setFont(new Font("Consolas", Font.BOLD, 17));
		
		// tabela.setEnabled(true);
		//painelDeScroll1.setLayout(null);
		painelDeScroll1 = new JScrollPane(tabela1);
		//painelDeScroll1.add(tabela1);
		
		painelDeScroll2 = new JScrollPane(tabela2);
		//painelDeScroll2.add(tabela2);
		
		
		painelDeScroll3 = new JScrollPane(tabela3);
		//painelDeScroll3.add(tabela3);
		
		
		painelDeScroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScroll1.setBackground(new Color(230, 230, 250));
		painelDeScroll1.setBounds(10, 50, 765, 400);
		
		painelDeScroll1.setVisible(true);
		painelDeScroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScroll2.setBackground(new Color(230, 230, 250));
		painelDeScroll2.setBounds(10, 50, 765, 400);
		painelDeScroll2.setVisible(true);
		painelDeScroll3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScroll3.setBackground(new Color(230, 230, 250));
		painelDeScroll3.setBounds(10, 50, 765, 400);
		painelDeScroll3.setVisible(true);
		
		
		
		
		
		
		painelComAbas.addTab("Professor", primeiraAba);
		painelComAbas.addTab("Secretaria", segundaAba);
		painelComAbas.addTab("Faxineira", terceiraAba);
		painelComAbas.setBounds(10, 50, 765, 400);
		//painelComAbas.setLayout(null);
		// instanciando e inserindo a tabela do stroll
		
		//painelDeScroll = new JScrollPane(tabela);
		tabela = new JTable(modelo);
		tabela.setBounds(10, 30, 300, 95);
		tabela.setFont(new Font("Consolas", Font.BOLD, 17));

		// tabela.setEnabled(true);

		// instanciando e inserindo a tabela do stroll

		painelDeScroll = new JScrollPane(tabela);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		painelDeScroll.setBackground(new Color(230, 230, 250));

		painelDeScroll.setBounds(10, 50, 765, 400);

		// tabela.setBackground(new Color(230, 230, 250));
		// janela.setSize(790, 570);
		botaoExcluir.setBounds(315, 455, 150, 75);
		botaoExcluir.setFont(new Font("Consolas", Font.BOLD, 20));
		// lblIncluirUf.setBounds(15, 20, 70, 25);

		botaoExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				excluirLinha();
			}

		});
		primeiraAba.add(painelDeScroll1);
		segundaAba.add(painelDeScroll2);
		terceiraAba.add(painelDeScroll3);
		// configuração do painel
		painelDaJanela.setLayout(null);
		// painelDaJanela.add(lblIncluirUf);

		painelDaJanela.add(botaoExcluir);
		
		//painelDaJanela.add(painelDeScroll);
		painelDaJanela.add(painelComAbas);
		// configurações da janela

		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setSize(790, 570);
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null);

	}// fim do metodo iniciaBui

	public void excluirLinha() {
		// TODO Auto-generated method stub

		this.janela.dispose();

	}

}
