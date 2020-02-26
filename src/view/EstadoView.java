package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controler.EstadoController;
public class EstadoView {
	


		private JFrame janela;
		private JPanel painelDaTela;
		private JTable tabela;
		
		private JLabel lblIncluirUf;
		private JLabel lblIncluirEstado;
		private JLabel lblTitulo;
		private JTextField jtfIncluirEstado;
		private JTextField jtfIncluirUf;
		private JButton botaoIncluir;
		private JButton botaoCancelar;
		
		public EstadoView() {
			iniciaCidade();
		}
		
		public void iniciaCidade() {
			janela = new JFrame();
			painelDaTela = (JPanel) janela.getContentPane();
			painelDaTela.setBackground(new Color(230, 230, 250));
			lblIncluirUf = new JLabel("Informe UF");
			lblIncluirEstado = new JLabel("Informe Estado");
			
			jtfIncluirEstado = new JTextField();
			jtfIncluirUf = new JTextField();
			jtfIncluirUf = new JTextField();
			
			botaoIncluir = new JButton("Salvar");
			botaoCancelar = new JButton("Cancelar");
			//painelDeScroll = (JScrollPane) janela.getContentPane();
			
			painelDaTela.setBackground(new Color(230, 230, 250));
			
			//instanciando e inserindo a tabela do stroll
			lblTitulo = new JLabel();
			lblTitulo.setText("Cadastro de Estado");
			lblTitulo.setBounds(10, 22, 300, 20);
			lblTitulo.setFont(new Font("Consolas", Font.BOLD, 22));
			
			
			lblIncluirUf.setBounds(15, 125, 70, 25);
			
			jtfIncluirUf.setBounds(135, 125, 50, 25);
			
			botaoIncluir.setBounds(135, 200, 120, 30);
			botaoCancelar.setBounds(305, 205, 120, 30);

			lblIncluirEstado.setBounds(15, 85, 150, 25);
			jtfIncluirEstado.setBounds(135, 85, 300, 25);
			
			
			botaoIncluir.addActionListener(new ActionListener() {
			
				
				public void actionPerformed(ActionEvent arg0) {
					
					EstadoController estado=	new EstadoController();
					estado.inserirAluno(jtfIncluirEstado.getText(), jtfIncluirUf.getText());
					jtfIncluirEstado.setText("");
					jtfIncluirUf.setText("");
					
				}

				
			});
			
			botaoCancelar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {

					janela.dispose();
				}

			});
			
			
			
			//configuração do painel
			painelDaTela.setLayout(null);
			painelDaTela.add(lblIncluirUf);
			painelDaTela.add(lblIncluirEstado);
			painelDaTela.add(jtfIncluirEstado);
			painelDaTela.add(jtfIncluirUf);
			painelDaTela.add(botaoIncluir);
			painelDaTela.add(botaoCancelar);
			painelDaTela.add(lblTitulo);
			
			//configurações da janela
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janela.setSize(790, 370);
			janela.setVisible(true);
			janela.setResizable(false);
			janela.setLocationRelativeTo(null);
					
			
			
		}//fim do metodo iniciaBui
		
		
			
			
		
		
		
		
		
	}


