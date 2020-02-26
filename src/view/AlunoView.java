package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controler.AlunoController;
import controler.CidadeController;
import controler.EstadoController;

public class AlunoView {
	// Declaração de telas, paineis e componentes

	private JFrame janela;
	private JPanel painelDaTela;
	private JLabel lblMatricula;
	private JLabel lblNome;
	private JLabel lblDataNascimento;
	private JLabel lblSexo;
	private JLabel lblRg;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblLogradouro;
	private JLabel lblComplemento;
	private JLabel lblNumero;
	private JLabel lblCep;
	private JLabel lblBairro;
	private JTextField txtMatricula;
	private JTextField txtNome;
	private JTextField txtDataNascimento;
	private JTextField txtTelefone;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JTextField txtLogradouro;
	private JTextField txtComplemento;
	private JTextField txtNumero;
	private JTextField txtCep;
	private JTextField txtBairro;
	private JPasswordField jpwSenha;
	private JPasswordField jpwSenha2;
	private JRadioButton rbtMasculino;
	private JRadioButton rbtFeminino;
	private JButton btm1;
	private JButton btm2;
	private JLabel lblTitulo;
	private JLabel lblSenha;
	private JLabel lblSenha2;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private ButtonGroup grpRadio;
	private JComboBox cboCidade;
	// Fim da Declaração de telas, paineis e componentes

	
	
//--------------------------------------------------------------------------------------------------------------------------------------------------

	// declaração de vetores
	private String[] cidades = { "Barueri", "Osasco", "Itapevi", "Carapicuiba", "Jandira" };
	private JComboBox cboEstado;
	private String[] estados = { "São Paulo - SP", "Rio de Janeiro - RJ", "Minas Gerais - MG", "Bahia - BA", "Amazonas - AM" };
	// fim da declaração de vetores
	
//--------------------------------------------------------------------------------------------------------------------------------------------------

	// construtor
	public AlunoView() {
		iniciaAlunoView();
	}
	// final do construtor
	
//--------------------------------------------------------------------------------------------------------------------------------------------------

	// inicio da classe iniciaGui contendo telas,
	// Componente e açoes dos componentes
	public void iniciaAlunoView() {
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Instanciando Janela de cadastro e painelDaTela
		janela = new JFrame();
		janela.setSize(790, 370);
		painelDaTela = (JPanel) janela.getContentPane();
		painelDaTela.setBackground(new Color(230, 230, 250));
		// fim da Instancia da Janela de cadastro e painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label titulo no painelDaTela
		lblTitulo = new JLabel();
		lblTitulo.setText("Cadastro de Aluno");
		lblTitulo.setBounds(10, 22, 300, 20);
		lblTitulo.setFont(new Font("Consolas", Font.BOLD, 22));
		painelDaTela.add(lblTitulo);
		// fim das Configurações e atribuição da label titulo no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label nome no painelDaTela
		lblNome = new JLabel();
		lblNome.setText("Nome:");
		lblNome.setBounds(10, 80, 150, 20);
		lblNome.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblNome);
		// fim da Configurações e atribuição da label nome no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jtext nome no painelDaTela
		txtNome = new JTextField();
		// txtNome.setFocusCycleRoot(true);//(txtLogradouro);
		txtNome.setFocusTraversalKeysEnabled(false);
		txtNome.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtMatricula.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtNome.setBounds(55, 80, 250, 20);
		txtNome.setBackground(new Color(240, 255, 255));
		txtNome.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub
				txtNome.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub
				txtNome.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado

		});// fim das ações ao JText ser focado

		// trocar borda da txtfield
		// txtNome.setBorder(new LineBorder(Color.RED));

		painelDaTela.add(txtNome);
		// fim das Configurações e atribuição da Jtext nome no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label matricula no painelDaTela
		lblMatricula = new JLabel();
		lblMatricula.setText("Matricula:");
		lblMatricula.setBounds(10, 110, 150, 20);
		lblMatricula.setFont(new Font("Consolas", Font.BOLD, 16));
		// janela.getContentPane().add(BorderLayout.EAST,lblMatricula);
		painelDaTela.add(lblMatricula);
		// painelDaTela.setBackground(new Color(217,232,238));
		// painelDaTela.setBackground(new Color(176,224,230));
		// fim das Configurações e atribuição da label nome no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jtext matricula no painelDaTela
		txtMatricula = new JTextField();
		txtMatricula.setFocusTraversalKeysEnabled(false);
		txtMatricula.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtDataNascimento.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita

		txtMatricula.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtMatricula.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtMatricula.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado

		txtMatricula.setBounds(100, 110, 205, 20);
		txtMatricula.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtMatricula);
		// fim das Configurações e atribuição da Jtext matricula no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da lable data de nascimento no painelDaTela
		lblDataNascimento = new JLabel();
		lblDataNascimento.setText("Data de Nascimento:");
		lblDataNascimento.setBounds(10, 140, 200, 20);
		lblDataNascimento.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblDataNascimento);
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jtext data de nascimento no painelDaTela
		txtDataNascimento = new JTextField();
		try {// mascara para uma data
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			txtDataNascimento = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {
			
		} // final da mascara para uma data
		txtDataNascimento.setFocusTraversalKeysEnabled(false);
		txtDataNascimento.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtRg.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita

		txtDataNascimento.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtDataNascimento.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtDataNascimento.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado

		txtDataNascimento.setBackground(new Color(240, 255, 255));
		txtDataNascimento.setBounds(180, 140, 125, 20);
		painelDaTela.add(txtDataNascimento);
		// txtDataNascimento = new JTextField();
		// txtDataNascimento.setBounds(110, 60, 350, 20);
		// fim das Configurações e atribuição da Jtext data de nascimento no
		// painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da lable data de nascimento no painelDaTela
		lblRg = new JLabel();
		lblRg.setText("Rg:");
		lblRg.setBounds(10, 170, 200, 20);
		lblRg.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblRg);
		// fim das Configurações e atribuição da lable rg no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------
		
		// Configurações e atribuição da Jtext rg no painelDaTela
		txtRg = new JTextField();

		try {// mascara para um rg
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##.###.###-A");
			txtRg = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {

		} // fim da mascara para um rg

		txtRg.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtRg.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtRg.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		txtRg.setFocusTraversalKeysEnabled(false);
		txtRg.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtCpf.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtRg.setBounds(38, 170, 268, 20);
		txtRg.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtRg);
		// fim das Configurações e atribuição da Jtext data de nascimento no
		// painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------
		
		// Configurações e atribuição da label cpf no painelDaTela
		lblCpf = new JLabel();
		lblCpf.setText("Cpf:");
		lblCpf.setBounds(10, 200, 200, 20);
		lblCpf.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblCpf);
		// fim das Configurações e atribuição da label cpf no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------
		
		// Configurações e atribuição da Jtext cpf no painelDaTela
		txtCpf = new JTextField();

		try {// mascara para cpf
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("###.###.###-##");
			txtCpf = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {

		} // fim da mascara para cpf
		txtCpf.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtCpf.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtCpf.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		txtCpf.setFocusTraversalKeysEnabled(false);
		txtCpf.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtTelefone.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtCpf.setBounds(45, 200, 261, 20);
		txtCpf.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtCpf);
		// fim das Configurações e atribuição da Jtext cpf no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------
		// Configurações e atribuição da label telefone no painelDaTela
		lblTelefone = new JLabel();
		lblTelefone.setText("Telefone:");
		lblTelefone.setBounds(10, 230, 200, 20);
		lblTelefone.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblTelefone);
		// fim das Configurações e atribuição da label telefone no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jtext telefone no painelDaTela
		txtTelefone = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("(##)#####-####");
			txtTelefone = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {

		}
		txtTelefone.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtTelefone.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtTelefone.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		txtTelefone.setFocusTraversalKeysEnabled(false);
		txtTelefone.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					rbtMasculino.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtTelefone.setBounds(90, 230, 215, 20);
		txtTelefone.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtTelefone);
		// fim das Configurações e atribuição da jtext telefone no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da label senha no painelDaTela
		lblSenha = new JLabel();
		lblSenha.setText("Cadastrar Senha:");
		lblSenha.setBounds(10, 290, 200, 20);
		lblSenha.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblSenha);
		// fim das Configurações e atribuição da label senha no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da Jpassword senha no painelDaTela
		jpwSenha = new JPasswordField();
		jpwSenha.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				jpwSenha.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				jpwSenha.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		jpwSenha.setFocusTraversalKeysEnabled(false);
		jpwSenha.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtLogradouro.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita

		jpwSenha.setBounds(155, 290, 150, 20);
		jpwSenha.setBackground(new Color(240, 255, 255));
		painelDaTela.add(jpwSenha);
		/*
		 * // label Senha lblSenha2 = new JLabel();
		 * lblSenha2.setText("Confirmar Senha:"); lblSenha2.setBounds(10, 320, 200, 20);
		 * lblSenha2.setFont(new Font("Consolas", Font.BOLD, 16));
		 * painelDaTela.add(lblSenha2);
		 * 
		 * // JText Senha jpwSenha2 = new JPasswordField(); jpwSenha2.setBounds(155,
		 * 320, 150, 20); jpwSenha2.setBackground(new Color(240, 255, 255));
		 * painelDaTela.add(jpwSenha2);
		 */
		// fim das Configurações e atribuição da JPassword senha no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da label sexo no painelDaTela
		lblSexo = new JLabel();		
		lblSexo.setText("Sexo:");
		lblSexo.setBounds(10, 260, 150, 20);
		lblSexo.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblSexo);
		// fim das Configurações e atribuição da lable sexo no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------
		
		//Configurações e atribuição da radio button (Masculino e Feminino) e group button no painelDaTela
		rbtMasculino = new JRadioButton();
		rbtFeminino = new JRadioButton();
		grpRadio = new ButtonGroup();
		grpRadio.add(rbtMasculino);
		grpRadio.add(rbtFeminino);
		painelDaTela.add(rbtMasculino);
		painelDaTela.add(rbtFeminino);
		
		//configurando radio button masculino
		rbtMasculino.setText("Masculino");
		rbtMasculino.setFont(new Font("Consolas", Font.BOLD, 16));
		rbtMasculino.setBounds(65, 260, 120, 20);
		rbtMasculino.setAlignmentX(JRadioButton.CENTER_ALIGNMENT);
		rbtMasculino.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				rbtMasculino.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				rbtMasculino.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		rbtMasculino.setFocusTraversalKeysEnabled(false);
		rbtMasculino.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					rbtFeminino.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		
		
		//configurando radio button feminino
		rbtFeminino.setText("Feminino");
		rbtFeminino.setFont(new Font("Consolas", Font.BOLD, 16));
		// rbtFeminino.setBorder(new LineBorder(Color.RED));
		rbtFeminino.setBounds(185, 260, 120, 20);
		rbtFeminino.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				rbtFeminino.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				rbtFeminino.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		rbtFeminino.setFocusTraversalKeysEnabled(false);
		rbtFeminino.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					jpwSenha.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		//fim das Configurações e atribuição da radio button (Masculino e Feminino) e group button no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da lable logradouro no painelDaTela
		lblLogradouro = new JLabel();
		lblLogradouro.setText("Logradouro:");
		lblLogradouro.setBounds(400, 80, 150, 20);
		lblLogradouro.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblLogradouro);
		// fim das Configurações e atribuição da lable logradouro no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da Jtext logradouro no painelDaTela
		txtLogradouro = new JTextField();
		txtLogradouro.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtLogradouro.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtLogradouro.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		txtLogradouro.setFocusTraversalKeysEnabled(false);
		txtLogradouro.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtNumero.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtLogradouro.setBounds(505, 80, 260, 20);
		txtLogradouro.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtLogradouro);
		//fim das Configurações e atribuição da Jtext logradouro no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da label numero no painelDaTela
		lblNumero = new JLabel();
		lblNumero.setText("Numero:");
		lblNumero.setBounds(400, 110, 150, 20);
		lblNumero.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblNumero);
		//fim dasConfigurações e atribuição da label numero no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da Jtext numero no painelDaTela
		txtNumero = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("####");
			txtNumero = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {

		}
		txtNumero.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtNumero.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtNumero.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		txtNumero.setFocusTraversalKeysEnabled(false);
		txtNumero.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtCep.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtNumero.setBounds(465, 110, 40, 20);
		txtNumero.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtNumero);
		//fim das Configurações e atribuição da Jtext numero no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------
		EstadoController estado = new EstadoController();
		String nomeEstado[] = estado.listarTodos().split(";");
		CidadeController cidade = new CidadeController();
		String nomeCidade[] = cidade.listarTodos().split(";");
		//Configurações e atribuição da label cep no painelDaTela
		lblCep = new JLabel();
		lblCep.setText("CEP:");
		lblCep.setBounds(512, 110, 150, 20);
		lblCep.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblCep);
		//fim das Configurações e atribuição da label cep no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da Jtext cep no painelDaTela
		txtCep = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("#####.###");
			txtCep = new javax.swing.JFormattedTextField(dt);
		} catch (Exception e) {

		}
		txtCep.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtCep.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtCep.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		txtCep.setFocusTraversalKeysEnabled(false);
		txtCep.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtComplemento.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtCep.setBounds(550, 110, 214, 20);
		txtCep.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtCep);
		//fim das Configurações e atribuição da Jtext cep no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da label complemento no painelDaTela
		lblComplemento = new JLabel();
		lblComplemento.setText("Complemento:");
		lblComplemento.setBounds(400, 140, 150, 20);
		lblComplemento.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblComplemento);
		//Fim das Configurações e atribuição da label complemento no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da JText complemento no painelDaTela
		txtComplemento = new JTextField();
		txtComplemento.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtComplemento.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtComplemento.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		txtComplemento.setFocusTraversalKeysEnabled(false);
		txtComplemento.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtBairro.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtComplemento.setBounds(510, 140, 253, 20);
		txtComplemento.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtComplemento);
		//Fim das Configurações e atribuição da JText complemento no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		///Configurações e atribuição da label bairro no painelDaTela
		lblBairro = new JLabel();
		lblBairro.setText("Bairro:");
		lblBairro.setBounds(400, 170, 150, 20);
		lblBairro.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblBairro);
		//Fim das Configurações e atribuição da label bairro no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da JText bairro no painelDaTela
		txtBairro = new JTextField();
		txtBairro.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtBairro.setBorder(txtNome.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtBairro.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		txtBairro.setFocusTraversalKeysEnabled(false);
		txtBairro.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					cboCidade.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtBairro.setBounds(465, 170, 299, 20);
		txtBairro.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtBairro);
		//Fim das Configurações e atribuição da JText bairro no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da label cidade no painelDaTela
		lblCidade = new JLabel();
		lblCidade.setText("Cidade:");
		lblCidade.setBounds(400, 200, 150, 20);
		lblCidade.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblCidade);
		//fim das Configurações e atribuição da label cidade no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da combobox cidade no painelDaTela
		cboCidade = new JComboBox();	
		cboCidade.setModel(new DefaultComboBoxModel(nomeCidade));
		//cboCidade.insertItemAt("-- Selecione uma cidade -- ", 0);
		cboCidade.insertItemAt(" ", 0);
		// configuração do combo box da cidade
		cboCidade.setSelectedIndex(0);
		cboCidade.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				cboCidade.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				cboCidade.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		cboCidade.setFocusTraversalKeysEnabled(false);
		cboCidade.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					cboEstado.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		cboCidade.setBounds(464, 200, 298, 20);
		cboCidade.setMaximumRowCount(10);
		cboCidade.setBackground(new Color(240, 255, 255));
		painelDaTela.add(cboCidade);
		//fim das Configurações e atribuição da combobox cidade no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da label Estado no painelDaTela
		lblEstado = new JLabel();
		lblEstado.setText("Estado:");
		lblEstado.setBounds(400, 230, 150, 20);
		lblEstado.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblEstado);
		cboEstado = new JComboBox(estados);
		//fim das Configurações e atribuição da label Estado no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da combobox Estado no painelDaTela
		cboEstado.setModel(new DefaultComboBoxModel(nomeEstado));
		//cboEstado.insertItemAt("-- Selecione um estado -- ", 0);
		cboEstado.insertItemAt(" ", 0);
		cboEstado.setSelectedIndex(0);
		cboEstado.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				cboEstado.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				cboEstado.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		cboEstado.setFocusTraversalKeysEnabled(false);
		cboEstado.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					btm1.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		cboEstado.setBounds(464, 230, 298, 20);
		cboEstado.setMaximumRowCount(10);
		cboEstado.setBackground(new Color(240, 255, 255));
		painelDaTela.add(cboEstado);
		//fim das Configurações e atribuição da combobox Estado no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da Jbutton1 no painelDaTela
		btm1 = new JButton();
		btm1.setText("Salvar");
		btm1.setBounds(420, 290, 130, 30);
		// btm1.addActionListener(new Salvar());
		
		btm1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AlunoController aluno = new AlunoController();
				String senha = new String(jpwSenha.getPassword());
				String cidade = (String) cboCidade.getSelectedItem().toString();
				String estado = (String) cboEstado.getSelectedItem().toString();
				aluno.inserirAluno(txtNome.getText(), txtMatricula.getText(), txtDataNascimento.getText(),
						txtRg.getText(), txtCpf.getText(), txtTelefone.getText(), opcaoSelecionada(), senha,
						txtLogradouro.getText(), txtNumero.getText(), txtCep.getText(), txtComplemento.getText(),
						txtBairro.getText(), cidade.trim(), estado.trim());
				txtNome.setText("");
				txtMatricula.setText("");
				txtDataNascimento.setText("");
				txtLogradouro.setText("");
				txtNumero.setText("");
				txtRg.setText("");
				txtCpf.setText("");
				txtTelefone.setText("");
				jpwSenha.setText("");
				txtCep.setText("");
				txtComplemento.setText("");
				txtBairro.setText("");
				cboCidade.setSelectedIndex(0);
				cboEstado.setSelectedIndex(0);
				
				 
			}
		});
		btm1.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				btm1.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				btm1.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		btm1.setFocusTraversalKeysEnabled(false);
		
		btm1.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					btm2.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		painelDaTela.add(btm1);
		//fim das Configurações e atribuição da Jbutton1 no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações e atribuição da Jbutton2 no painelDaTela
		btm2 = new JButton();
		btm2.setText("Cancelar");
		btm2.setBounds(580, 290, 130, 30);
		btm2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				janela.dispose();
			}
		});
		// btm2.addActionListener(new Cancelar());
		btm2.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				btm2.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				btm2.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		btm2.setFocusTraversalKeysEnabled(false);
		
		btm2.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtNome.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		painelDaTela.add(btm2);		
		//fim das Configurações e atribuição da Jbutton2 no painelDaTela
		
//--------------------------------------------------------------------------------------------------------------------------------------------------

		//Configurações do JPanel e da JFrame
		painelDaTela.setLayout(null);
		// painelDaTela.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		// painelDaTela.setLayout(new BorderLayout(0,0));
		// painelDaTela.setBorder(BorderFactory.createLoweredBevelBorder());
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// janela.setUndecorated(true);
		janela.setVisible(true);
		janela.setResizable(false);
		// janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// janela.setPreferredSize(new
		// Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		// janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setUndecorated(true);
		// janela.pack();
		// janela.getContentPane().setBackground(new Color(240, 255, 255));
		// janela.setUndecorated(true);
		//fim das configurações do JPanel e da JFrame

	}// fim da classe iniciaGui contendo telas,
	// Componente e açoes dos componentes
	
//--------------------------------------------------------------------------------------------------------------------------------------------------

	//private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {
		// cant capture my TAB?
		//System.out.print(evt.getKeyChar());

	//}
	
	
	//metodo para pegar a informção ticada nos radio buttons masculino e feminino 
	public String opcaoSelecionada() {
		String resposta = " ";

		if (rbtMasculino.isSelected()) {
			resposta += rbtMasculino.getText();
		} else if (rbtFeminino.isSelected()) {
			resposta += rbtFeminino.getText();
		} else {
			JOptionPane.showMessageDialog(null, "Campo Sexo Invalido", "Erro", 0);

		}

		return resposta;
	}	
	//fim do metodo para pegar a informção ticada nos radio buttons masculino e feminino 

//--------------------------------------------------------------------------------------------------------------------------------------------------

//	public void tab(JTextField jtextFocada, JTextField jtextProxima) {
//		jtextFocada.setFocusTraversalKeysEnabled(false);
//		jtextFocada.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent event) {
//				if (event.getKeyChar() == KeyEvent.VK_TAB) {
//					jtextProxima.requestFocusInWindow();
//
//				}
//			}
//		});
//	}
	/*
	 * public class Salvar implements ActionListener {
	 * 
	 * public void actionPerformed(ActionEvent e) { Data data = new Data();
	 * AlunoController aluno = new AlunoController(); String data2[] =
	 * txtDataNascimento.getText().split("/"); if (rbtSexo.getText().equals(null) ||
	 * rbtSexo.getText().trim().equals("") || txtNome.getText().equals(null) ||
	 * txtNome.getText().trim().equals("") || txtMatricula.equals(null) ||
	 * txtMatricula.getText().trim().equals("") ||
	 * txtDataNascimento.getText().equals(null) ||
	 * txtDataNascimento.getText().trim().equals("")) {
	 * JOptionPane.showMessageDialog(null, "Campos incorretos!!!", "Erro", 0);
	 * 
	 * } else { if (!txtDataNascimento.getText().trim().contains("/") ||
	 * txtDataNascimento.getText().trim().charAt(5) != '/' || data2.length != 3) {
	 * JOptionPane.showMessageDialog(null, "Data Incorreta!!!", "Erro", 0); } else {
	 * if (Integer.parseInt(data2[2].trim()) > 2500) {
	 * JOptionPane.showMessageDialog(null, "Campo Ano incorreto!!!", "Erro", 0); }
	 * else { if (Integer.parseInt(data2[1].trim()) > 12) {
	 * JOptionPane.showMessageDialog(null, "Campo Mes incorreto!!!", "Erro", 0); }
	 * else {
	 * 
	 * if ((Integer.parseInt(data2[0].trim()) > 31 &&
	 * Integer.parseInt(data2[1].trim()) == 1) || (Integer.parseInt(data2[0].trim())
	 * > 31 && Integer.parseInt(data2[1].trim()) == 3) ||
	 * (Integer.parseInt(data2[0].trim()) > 31 && Integer.parseInt(data2[1].trim())
	 * == 5) || (Integer.parseInt(data2[0].trim()) > 31 &&
	 * Integer.parseInt(data2[1].trim()) == 7) || (Integer.parseInt(data2[0].trim())
	 * > 31 && Integer.parseInt(data2[1].trim()) == 8) ||
	 * (Integer.parseInt(data2[0].trim()) > 30 && Integer.parseInt(data2[1].trim())
	 * == 10) || (Integer.parseInt(data2[0].trim()) > 30 &&
	 * Integer.parseInt(data2[1].trim()) == 12)) {
	 * 
	 * JOptionPane.showMessageDialog(null, "Campo Dia incorreto!!!", "Erro", 0);
	 * 
	 * } else { if ((Integer.parseInt(data2[0].trim()) > 30 &&
	 * Integer.parseInt(data2[1].trim()) == 4) || (Integer.parseInt(data2[0].trim())
	 * > 30 && Integer.parseInt(data2[1].trim()) == 6) ||
	 * (Integer.parseInt(data2[0].trim()) > 30 && Integer.parseInt(data2[1].trim())
	 * == 9) || (Integer.parseInt(data2[0].trim()) > 31 &&
	 * Integer.parseInt(data2[1].trim()) == 11)) {
	 * 
	 * JOptionPane.showMessageDialog(null, "Campo Dia incorreto!!!", "Erro", 0);
	 * 
	 * } else { if (Integer.parseInt(data2[1]) == 2 && Integer.parseInt(data2[0]) >
	 * 28) { JOptionPane.showMessageDialog(null,
	 * "Campo Dia incorreto!!!\nMes de fevereiro só tem 28 dias", "Erro", 0);
	 * 
	 * } else { if ((rbtSexo.getText().trim().charAt(0) == 'M' ||
	 * rbtSexo.getText().trim().charAt(0) == 'F' ||
	 * rbtSexo.getText().trim().charAt(0) == 'm' ||
	 * rbtSexo.getText().trim().charAt(0) == 'f')) {
	 * 
	 * Data data1 = new Data(Integer.parseInt(data2[0].trim()),
	 * Integer.parseInt(data2[1].trim()), Integer.parseInt(data2[2].trim()));
	 * 
	 * aluno.inserirAluno(txtMatricula.getText().trim(), txtNome.getText(), data1,
	 * rbtSexo.getText().trim().charAt(0));
	 * 
	 * JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!!!",
	 * "Sucesso", 1); txtMatricula.setText(""); txtNome.setText("");
	 * txtDataNascimento.setText(""); rbtSexo.setText("");
	 * 
	 * } else { JOptionPane.showMessageDialog(null, "Campo Sexo incorretos!!!",
	 * "Erro", 0); } } } } } } } } }
	 * 
	 * }
	 * 
	 * public class Cancelar implements ActionListener {
	 * 
	 * public void actionPerformed(ActionEvent arg0) { // TODO Auto-generated method
	 * stub System.exit(0); }
	 * 
	 * }
	 */
	
}//fim da classe Aluno view
