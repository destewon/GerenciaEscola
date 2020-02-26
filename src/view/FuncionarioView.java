/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controler.CidadeController;
import controler.EstadoController;
import controler.FuncionarioController;

/**
 * @author ander
 *
 */
public class FuncionarioView {

	// Declaração de telas, paineis e componentes

	private JFrame janela;
	private JPanel painelDaTela;

	private JLabel lblNome;
	private JLabel lblDataNascimento;

	private JLabel lblRg;
	private JLabel lblCpf;
	private JLabel lblTelefone;
	private JLabel lblLogradouro;
	private JLabel lblComplemento;
	private JLabel lblNumero;
	private JLabel lblCep;
	private JLabel lblBairro;
	private JLabel lblRamal;
	private JLabel lblTurno;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblSalario;

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
	private JTextField txtRamal;
	private JTextField txtSalario;

	private JButton btm1;
	private JButton btm2;
	private JButton btm3;
	private JLabel lblTitulo;
	private ButtonGroup grpRadio;
	private JRadioButton rbtManha;
	private JRadioButton rbtNoite;

	private JLabel lblCargo;
	private JTable tabela;
	private String[] colunas = new String[] { "MATERIAS DO PROFESSOR" };
	private JLabel lblIncluirUf;
	private JTextField jtfIncluirMateria;
	private JButton botaoIncluir;
	private JButton botaoExcluir;
	private JScrollPane painelDeScroll;
	private String[] dados;

	private JComboBox cboCargo;
	private JComboBox cboCidade;
	private JComboBox cboEstado;

	// Fim da Declaração de telas, paineis e componentes

	// --------------------------------------------------------------------------------------------------------------------------------------------------

	// declaração de vetores
	private String[] cargos = { "Professor", "Faxineira", "Secretaria" };
	private String[] cidades;
	private String[] estados;
	private List<String> arrayFuncionario = new ArrayList<String>();
	private boolean controleCargo=false;
	//FuncionarioController f1 = new FuncionarioController();
	
	// arrayFuncionario ;
	// fim da declaração de vetores

	// --------------------------------------------------------------------------------------------------------------------------------------------------

	// construtor
	public FuncionarioView() {
		// TODO Auto-generated constructor stub

		iniciaFuncionarioView();
	}
	
	public FuncionarioView(boolean limpar) {
		// TODO Auto-generated constructor stub

		limparCampos();
	}
	// final do construtor

	// --------------------------------------------------------------------------------------------------------------------------------------------------

	// inicio da classe iniciaGui contendo telas,
	// Componente e açoes dos componentes
	public void iniciaFuncionarioView() {
		//arrayFuncionario.add("");
		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Instanciando Janela de cadastro e painelDaTela
		janela = new JFrame();
		janela.setSize(790, 400);
		painelDaTela = (JPanel) janela.getContentPane();
		painelDaTela.setBackground(new Color(230, 230, 250));
		// fim da Instancia da Janela de cadastro e painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// professor
		tabela = new JTable();
		lblIncluirUf = new JLabel("Cadastro de matéria:");
		jtfIncluirMateria = new JTextField();
		botaoExcluir = new JButton("Excluir");
		botaoIncluir = new JButton("Incluir");

		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		modelo.addRow(dados);

		tabela = new JTable(modelo);

		tabela.setEnabled(true);
		painelDeScroll = new JScrollPane(tabela);
		painelDeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		painelDeScroll.setBounds(400, 255, 365, 70);
		tabela.setBackground(new Color(240, 255, 255));
		tabela.setBounds(10, 30, 300, 95);
		botaoIncluir.setBounds(585, 200, 80, 20);
		botaoExcluir.setBounds(683, 200, 80, 20);
		lblIncluirUf.setBounds(400, 200, 200, 20);
		lblIncluirUf.setFont(new Font("Consolas", Font.BOLD, 16));
		jtfIncluirMateria.setBounds(400, 225, 365, 20);
		jtfIncluirMateria.setBackground(new Color(240, 255, 255));
		
		
		EstadoController estado = new EstadoController();
		String nomeEstado[] = estado.listarTodos().split(";");
		CidadeController cidade = new CidadeController();
		String nomeCidade[] = cidade.listarTodos().split(";");
		//int i=0;
		//while(i<nomeEstado.length) {
			
				
				
				
				//estados[i] = nomeEstado[i];
				
				//cboEstado.setModel(new DefaultComboBoxModel(nomeEstado));
				
				//System.out.println(nomeEstado.length);
				
			//	i++;
		//}//
		
		

		painelDaTela.add(lblIncluirUf);
		painelDaTela.add(jtfIncluirMateria);
		painelDaTela.add(botaoExcluir);
		painelDaTela.add(botaoIncluir);
		painelDaTela.add(painelDeScroll);
		lblIncluirUf.setVisible(false);
		jtfIncluirMateria.setVisible(false);
		botaoExcluir.setVisible(false);
		botaoIncluir.setVisible(false);
		painelDeScroll.setVisible(false);
		botaoIncluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				adicionaLinha();

			}

		});
		botaoExcluir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				excluirLinha();
			}

		});
		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Secretaria
		JLabel lblRamal = new JLabel("Ramal: ");
		JTextField txtRamal = new JTextField();
		txtRamal.setText("");
		lblRamal.setBounds(400, 200, 200, 20);

		lblRamal.setFont(new Font("Consolas", Font.BOLD, 16));
		txtRamal.setBounds(400, 225, 365, 20);
		txtRamal.setBackground(new Color(240, 255, 255));

		painelDaTela.add(lblRamal);
		painelDaTela.add(txtRamal);

		lblRamal.setVisible(false);
		txtRamal.setVisible(false);

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label cidade no painelDaTela
		// lblCidade = new JLabel();
		// lblCidade.setText("Cidade:");
		// lblCidade.setBounds(10, 200, 150, 20);
		// lblCidade.setFont(new Font("Consolas", Font.BOLD, 16));
		// painelDaTela.add(lblCidade);
		// fim das Configurações e atribuição da label cidade no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da combobox cidade no painelDaTela
		cboCidade = new JComboBox();
		// configuração do combo box da cidade
		cboCidade.setModel(new DefaultComboBoxModel(nomeCidade));
		cboCidade.insertItemAt(" ", 0);
		cboCidade.setSelectedIndex(0);
		cboCidade.setFont(new Font("Consolas", Font.BOLD, 16));
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
		cboCidade.setBounds(10, 260, 298, 20);
		cboCidade.setMaximumRowCount(10);
		cboCidade.setBackground(new Color(240, 255, 255));
		painelDaTela.add(cboCidade);
		// fim das Configurações e atribuição da combobox cidade no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label Estado no painelDaTela
		// lblEstado = new JLabel();
		// lblEstado.setText("Estado:");
		// lblEstado.setBounds(10, 230, 150, 20);
		// lblEstado.setFont(new Font("Consolas", Font.BOLD, 16));
		// painelDaTela.add(lblEstado);

		// fim das Configurações e atribuição da label Estado no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da combobox Estado no painelDaTela
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(nomeEstado));
		cboEstado.setFont(new Font("Consolas", Font.BOLD, 16));
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
		cboEstado.setBounds(10, 285, 298, 20);
		cboEstado.setMaximumRowCount(10);
		cboEstado.setBackground(new Color(240, 255, 255));
		painelDaTela.add(cboEstado);
		// fim das Configurações e atribuição da combobox Estado no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label turno no painelDaTela
		lblTurno = new JLabel();
		lblTurno.setText("Turno:");
		lblTurno.setBounds(400, 225, 150, 20);

		lblTurno.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblTurno);
		// lblTurno.setVisible(false);
		// fim das Configurações e atribuição da lable sexo no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da radio button (Masculino e Feminino) e group
		// button no painelDaTela
		rbtManha = new JRadioButton();
		rbtNoite = new JRadioButton();
		grpRadio = new ButtonGroup();
		rbtManha.setVisible(false);
		rbtNoite.setVisible(false);
		lblTurno.setVisible(false);
		grpRadio.add(rbtManha);
		grpRadio.add(rbtNoite);
		painelDaTela.add(rbtManha);
		painelDaTela.add(rbtNoite);

		// configurando radio button masculino
		rbtManha.setText("Diurno");
		rbtManha.setFont(new Font("Consolas", Font.BOLD, 16));
		rbtManha.setBounds(455, 225, 120, 20);

		rbtManha.setAlignmentX(JRadioButton.CENTER_ALIGNMENT);
		rbtManha.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				rbtManha.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				rbtManha.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		rbtManha.setFocusTraversalKeysEnabled(false);
		rbtManha.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					rbtNoite.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita

		// configurando radio button feminino
		rbtNoite.setText("Noturno");
		rbtNoite.setFont(new Font("Consolas", Font.BOLD, 16));
		// rbtFeminino.setBorder(new LineBorder(Color.RED));
		rbtNoite.setBounds(580, 225, 120, 20);

		rbtNoite.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				rbtNoite.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				rbtNoite.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		rbtNoite.setFocusTraversalKeysEnabled(false);
		rbtNoite.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtLogradouro.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
			// fim das Configurações e atribuição da radio button (Masculino e Feminino) e
			// group button no painelDaTela
			// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Faxineira
		JLabel lblRamal1 = new JLabel("Ramal: ");
		JTextField txtRamal1 = new JTextField();

		lblRamal1.setBounds(400, 200, 200, 20);

		lblRamal1.setFont(new Font("Consolas", Font.BOLD, 16));
		txtRamal1.setBounds(400, 225, 365, 20);
		txtRamal1.setBackground(new Color(240, 255, 255));

		painelDaTela.add(lblRamal1);
		painelDaTela.add(txtRamal1);

		lblRamal1.setVisible(false);
		txtRamal1.setVisible(false);

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label titulo no painelDaTela
		lblTitulo = new JLabel();
		lblTitulo.setText("Cadastro de Funcionario");
		lblTitulo.setBounds(10, 22, 300, 20);
		lblTitulo.setFont(new Font("Consolas", Font.BOLD, 22));
		painelDaTela.add(lblTitulo);
		// fim das Configurações e atribuição da label titulo no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label nome no painelDaTela
		lblNome = new JLabel();
		lblNome.setText("Nome:");
		lblNome.setBounds(10, 80, 150, 20);
		lblNome.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblNome);
		// fim da Configurações e atribuição da label nome no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jtext nome no painelDaTela
		txtNome = new JTextField();
		
		// txtNome.setFocusCycleRoot(true);//(txtLogradouro);
		txtNome.setFocusTraversalKeysEnabled(false);
		txtNome.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtDataNascimento.requestFocusInWindow();
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

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da lable data de nascimento no painelDaTela
		lblDataNascimento = new JLabel();
		lblDataNascimento.setText("Data de Nascimento:");
		lblDataNascimento.setBounds(10, 110, 200, 20);
		lblDataNascimento.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblDataNascimento);

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jtext data de nascimento no painelDaTela
		txtDataNascimento = new JTextField();
		try {// mascara para uma data
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("##/##/####");
			//dt.setPlaceholderCharacter('#');
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
		txtDataNascimento.setBounds(180, 110, 125, 20);
		painelDaTela.add(txtDataNascimento);
		// txtDataNascimento = new JTextField();
		// txtDataNascimento.setBounds(110, 60, 350, 20);
		// fim das Configurações e atribuição da Jtext data de nascimento no
		// painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da lable data de nascimento no painelDaTela
		lblRg = new JLabel();
		lblRg.setText("Rg:");
		lblRg.setBounds(10, 140, 200, 20);
		lblRg.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblRg);
		// fim das Configurações e atribuição da lable rg no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

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
		txtRg.setBounds(38, 140, 268, 20);
		txtRg.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtRg);
		// fim das Configurações e atribuição da Jtext data de nascimento no
		// painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label cpf no painelDaTela
		lblCpf = new JLabel();
		lblCpf.setText("Cpf:");
		lblCpf.setBounds(10, 170, 200, 20);
		lblCpf.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblCpf);
		// fim das Configurações e atribuição da label cpf no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

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
		txtCpf.setBounds(45, 170, 261, 20);
		txtCpf.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtCpf);
		// fim das Configurações e atribuição da Jtext cpf no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------
		// Configurações e atribuição da label telefone no painelDaTela
		lblTelefone = new JLabel();
		lblTelefone.setText("Telefone:");
		lblTelefone.setBounds(10, 200, 200, 20);
		lblTelefone.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblTelefone);
		// fim das Configurações e atribuição da label telefone no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

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
					txtSalario.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtTelefone.setBounds(90, 200, 215, 20);
		txtTelefone.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtTelefone);
		// fim das Configurações e atribuição da jtext telefone no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------
		
		// Configurações e atribuição da label telefone no painelDaTela
		lblSalario = new JLabel();
		lblSalario.setText("Salario:");
		lblSalario.setBounds(10, 230, 200, 20);
		lblSalario.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblSalario);
		// fim das Configurações e atribuição da label telefone no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jtext telefone no painelDaTela
		txtSalario = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("########");
			//dt.setValidCharacters("0123456789");
			txtSalario = new javax.swing.JFormattedTextField(dt);
			
		} catch (Exception e) {

		}
		txtSalario.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				txtSalario.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				txtSalario.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		txtSalario.setFocusTraversalKeysEnabled(false);
		txtSalario.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					txtLogradouro.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtSalario.setBounds(90, 230, 215, 20);
		txtSalario.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtSalario);
		// fim das Configurações e atribuição da jtext telefone no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da lable logradouro no painelDaTela
		lblLogradouro = new JLabel();
		lblLogradouro.setText("Logradouro:");
		lblLogradouro.setBounds(400, 80, 150, 20);
		lblLogradouro.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblLogradouro);
		// fim das Configurações e atribuição da lable logradouro no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jtext logradouro no painelDaTela
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
		// fim das Configurações e atribuição da Jtext logradouro no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label numero no painelDaTela
		lblNumero = new JLabel();
		lblNumero.setText("Numero:");
		lblNumero.setBounds(400, 110, 150, 20);
		lblNumero.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblNumero);
		// fim dasConfigurações e atribuição da label numero no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jtext numero no painelDaTela
		txtNumero = new JTextField();
		try {
			javax.swing.text.MaskFormatter dt = new javax.swing.text.MaskFormatter("####");
			//dt.setValidCharacters("0123456789");
			
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
		// fim das Configurações e atribuição da Jtext numero no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label cep no painelDaTela
		lblCep = new JLabel();
		lblCep.setText("CEP:");
		lblCep.setBounds(512, 110, 150, 20);
		lblCep.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblCep);
		// fim das Configurações e atribuição da label cep no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jtext cep no painelDaTela
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
		// fim das Configurações e atribuição da Jtext cep no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label complemento no painelDaTela
		lblComplemento = new JLabel();
		lblComplemento.setText("Complemento:");
		lblComplemento.setBounds(400, 140, 150, 20);
		lblComplemento.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblComplemento);
		// Fim das Configurações e atribuição da label complemento no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da JText complemento no painelDaTela
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
		// Fim das Configurações e atribuição da JText complemento no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		/// Configurações e atribuição da label bairro no painelDaTela
		lblBairro = new JLabel();
		lblBairro.setText("Bairro:");
		lblBairro.setBounds(400, 170, 150, 20);
		lblBairro.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblBairro);
		// Fim das Configurações e atribuição da label bairro no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da JText bairro no painelDaTela
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
					cboCargo.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		txtBairro.setBounds(465, 170, 299, 20);
		txtBairro.setBackground(new Color(240, 255, 255));
		painelDaTela.add(txtBairro);
		// Fim das Configurações e atribuição da JText bairro no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da label Cargo no painelDaTela
		lblCargo = new JLabel();
		lblCargo.setText("Cargo:");
		lblCargo.setBounds(400, 30, 150, 20);
		lblCargo.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(lblCargo);
		// fim das Configurações e atribuição da label Cargo no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da combobox Cargo no painelDaTela
		cboCargo = new JComboBox(cargos);
		cboCargo.insertItemAt(" ", 0);
		// configuração do combo box da Cargo
		cboCargo.setSelectedIndex(0);

		cboCargo.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				cboCargo.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				cboCargo.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		cboCargo.setFocusTraversalKeysEnabled(false);
		cboCargo.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					cboEstado.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		cboCargo.setBounds(400, 50, 298, 20);
		cboCargo.setMaximumRowCount(10);
		cboCargo.setBackground(new Color(240, 255, 255));
		cboCargo.setFont(new Font("Consolas", Font.BOLD, 16));
		painelDaTela.add(cboCargo);
		// fim das Configurações e atribuição da combobox Cargo no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jbutton1 no painelDaTela
		btm1 = new JButton();
		btm1.setText("Salvar");
		btm1.setBounds(10, 320, 130, 30);
		// btm1.addActionListener(new Salvar());

		btm1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FuncionarioController funcionario = new FuncionarioController();
				// String senha = new String(jpwSenha.getPassword());

				String cargo = (String) cboCargo.getSelectedItem().toString();
				String estado = (String) cboEstado.getSelectedItem().toString();
				String cidade = (String) cboCidade.getSelectedItem().toString();
				// opcaoSelecionada();
				// if ((!cargo.equals(null) && !cargo.trim().equals(""))
				// && (!estado.equals(null) && !estado.trim().equals(""))
				// && (!cidade.equals(null) && !cidade.trim().equals(""))) {
				funcionario.inserirFuncionario(txtNome.getText(), txtDataNascimento.getText(), txtRg.getText(),
						txtCpf.getText(), txtTelefone.getText(), txtLogradouro.getText(), txtNumero.getText(),
						txtCep.getText(), txtComplemento.getText(), txtBairro.getText(), cidade.trim(), estado.trim(),
						arrayFuncionario, opcaoSelecionada(), cargo, txtRamal.getText(),txtSalario.getText());
				System.out.println(opcaoSelecionada());
				System.out.println(arrayFuncionario);
				txtNome.setText("");
				txtNome.removeAll();
				txtDataNascimento.setText("");
				txtTelefone.setText("");
				txtRg.setText("");
				txtCpf.setText("");
				txtLogradouro.setText("");
				txtComplemento.setText("");
				txtNumero.setText("");
				txtCep.setText("");
				txtBairro.setText("");
				txtRamal.setText("");
				txtSalario.setText("");
				cboCidade.setSelectedIndex(0);
				cboEstado.setSelectedIndex(0);
				cboCargo.setSelectedIndex(0);
				int i =1;
				for (String string : arrayFuncionario) {
					if(arrayFuncionario.size()<1) {
						
					}else {
					modelo.removeRow(i);
					i++;
					}
				}	
				i=0;
				lblIncluirUf.setVisible(false);
				jtfIncluirMateria.setVisible(false);
				botaoExcluir.setVisible(false);
				botaoIncluir.setVisible(false);
				painelDeScroll.setVisible(false);
				lblRamal1.setVisible(false);
				txtRamal1.setVisible(false);
				rbtManha.setVisible(false);
				rbtNoite.setVisible(false);
				lblTurno.setVisible(false);
				
					
				// }

				/*
				 * if (cargo.equals("Professor")) { for (int i = 0; i < modelo.getRowCount();
				 * i++) { List<String> arrayFuncionario = new ArrayList<String>(); String
				 * materias = modelo.getValueAt(i, 0).toString();
				 * arrayFuncionario.add(materias); System.out.println(materias);
				 * 
				 * }
				 * 
				 * }
				 */
				// aluno.inserirAluno(txtNome.getText(), txtMatricula.getText(),
				// txtDataNascimento.getText(),
				// txtRg.getText(), txtCpf.getText(), txtTelefone.getText(),
				// opcaoSelecionada().charAt(0), senha,
				// txtLogradouro.getText(), txtNumero.getText(), txtCep.getText(),
				// txtComplemento.getText(),
				// txtBairro.getText(), Cargo.trim(), estado.trim());

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
		// fim das Configurações e atribuição da Jbutton1 no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jbutton2 no painelDaTela
		btm2 = new JButton();
		btm2.setText("Cancelar");
		btm2.setBounds(170, 320, 130, 30);
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
		// fim das Configurações e atribuição da Jbutton2 no painelDaTela

		// --------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações e atribuição da Jbutton2 no painelDaTela
		btm3 = new JButton();
		btm3.setText("OK");
		btm3.setBounds(705, 50, 60, 20);
		
		btm3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (cboCargo.getSelectedItem().toString().equals(null)
						|| cboCargo.getSelectedItem().toString().trim().equals("")) {
					System.out.println("invalido");
				} else {
					String selecao = cboCargo.getSelectedItem().toString();
					lblIncluirUf.setVisible(false);
					jtfIncluirMateria.setVisible(false);
					botaoExcluir.setVisible(false);
					botaoIncluir.setVisible(false);
					painelDeScroll.setVisible(false);
					lblRamal1.setVisible(false);
					txtRamal1.setVisible(false);
					rbtManha.setVisible(false);
					rbtNoite.setVisible(false);
					lblTurno.setVisible(false);
					if (selecao.equals("Professor")) {
						
						System.out.println("Professor");
						//modelo.removeRow(0);
						
						lblIncluirUf.setVisible(true);
						jtfIncluirMateria.setVisible(true);
						botaoExcluir.setVisible(true);
						botaoIncluir.setVisible(true);
						painelDeScroll.setVisible(true);

					} else if (selecao.equals("Faxineira")) {
						System.out.println("Faxineira");
						rbtManha.setVisible(true);
						rbtNoite.setVisible(true);
						lblTurno.setVisible(true);
					} else if (selecao.equals("Secretaria")) {
						System.out.println("Secretaria");

						lblRamal1.setVisible(true);
						txtRamal1.setVisible(true);
					} else {
						System.out.println("invalido");
					}
				}
			}
		});
		// btm2.addActionListener(new Cancelar());
		btm3.addFocusListener(new FocusListener() {// ações ao JText ser focado

			public void focusLost(FocusEvent e) {// fazendo a borda do txt voltar ao norma quando perde o foco
				// TODO Auto-generated method stub

				btm3.setBorder(txtBairro.getBorder());
			}// fim do codigo para fazer a borda do txt voltar ao norma quando perde o foco

			public void focusGained(FocusEvent e) {// fazendo a borda do txt ficar azul quando focado
				// TODO Auto-generated method stub

				btm3.setBorder(new LineBorder(new Color(30, 144, 255)));
			}// fim do codigo para fazer a borda do txt ficar azul quando focado
		});// fim das ações ao JText ser focado
		btm3.setFocusTraversalKeysEnabled(false);

		btm3.addKeyListener(new KeyAdapter() {// fazendo o tab ir de cima para baixo, esquerda para direita
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyChar() == KeyEvent.VK_TAB) {
					cboCargo.requestFocusInWindow();
				}
			}
		});// fim do codigo para fazer o tab ir de cima para baixo, esquerda para direita
		painelDaTela.add(btm3);
		// fim das Configurações e atribuição da Jbutton2 no painelDaTela

//--------------------------------------------------------------------------------------------------------------------------------------------------

		// Configurações do JPanel e da JFrame
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
		//janela.setUndecorated(true);
		// janela.pack();
		// janela.getContentPane().setBackground(new Color(240, 255, 255));
		// janela.setUndecorated(true);
		// fim das configurações do JPanel e da JFrame

	}// fim da classe iniciaGui contendo telas,
		// Componente e açoes dos componentes

	// --------------------------------------------------------------------------------------------------------------------------------------------------

	public void adicionaLinha() {
		// TODO Auto-generated method stub

		if (jtfIncluirMateria.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Campo Invalido", "Erro", 0);
		} else {
			// obter modelo da tabela criada
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			// adicionar nova linha com os dados
			modelo.addRow(new String[] { jtfIncluirMateria.getText() });

			arrayFuncionario.add(jtfIncluirMateria.getText());
			jtfIncluirMateria.setText("");
			//JOptionPane.showMessageDialog(null, "Dados Incluidos com sucesso");
			System.out.println(arrayFuncionario);
		}

	}

	public void excluirLinha() {
		// TODO Auto-generated method stub

		if (tabela.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione uma linha", "Erro", 0);
		} else if (tabela.getSelectedRowCount() > 1) {
			JOptionPane.showMessageDialog(null, "Selecione apenas uma linha", "Erro", 0);
		} else if(tabela.getSelectedRow() == -0){
			JOptionPane.showMessageDialog(null, "Não foi possivel apagar essa linha");
		}else {
			DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
			modelo.removeRow(tabela.getSelectedRow());
			//JOptionPane.showMessageDialog(null, "Dados Excluidos com sucesso");
		}

	}

	public String opcaoSelecionada() {
		String resposta = "";

		if (rbtManha.isSelected()) {
			resposta += rbtManha.getText();
		}
		if (rbtNoite.isSelected()) {
			resposta += rbtNoite.getText();
		}else {
			resposta ="";
		}

		// troca a cor da fonte para vermelhor

		if (!resposta.equals("") || !resposta.equals(null)) {
			return resposta;
		} // fim tratamento nenhuma radio button ticada
		resposta = "";
		return " ";
	}
	
	
	public void limparCampos() {
		
		
		
		
	}
	
	
	

}// fim da classe Aluno view
