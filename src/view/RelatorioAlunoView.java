package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Spliterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controler.AlunoController;

public class RelatorioAlunoView {

	private JFrame janela;
	private JPanel painelDaJanela;
	private JTable tabela;
	AlunoController aluno = new AlunoController();
	//String linhas[] = aluno.listarTodos().split(";");
	// String colunas2[] = linhas[0].split(";");
	// String colunas3[] = linhas[1].split(";");
	// String colunas4[] = linhas[2].split(";");
	// String nomeAluno = linhas[0];
	// String matriculaAluno = linhas[1];
	// String dataNascimentoAluno = linhas[2];
	private String[] colunas = new String[] { "NOME", "MATRICULA", "DATA DE NASCIMENTO" };
	//private String[][] dados = new String[][] { { linhas[1], linhas[0], linhas[2] } };
	String[] vetor1;
	String[] vetor2;
	String[] vetor3;

	// private JLabel lblIncluirUf;

	private JButton botaoExcluir;
	private JScrollPane painelDeScroll;

	public RelatorioAlunoView() {
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
		tabela = new JTable();
		// lblIncluirUf = new JLabel("Informe UF");

		botaoExcluir = new JButton("Cancelar");
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
		String dadosAluno[] = aluno.listarTodos().split(",");
		int i=0;
		while(i<dadosAluno.length) {
			
				String nomeAluno[] = dadosAluno[i].split(";");
				
				
				modelo.addRow(nomeAluno);
				
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

		// configuração do painel
		painelDaJanela.setLayout(null);
		// painelDaJanela.add(lblIncluirUf);

		painelDaJanela.add(botaoExcluir);

		painelDaJanela.add(painelDeScroll);

		// configurações da janela

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
