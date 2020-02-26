package controler;

import model.Professor;
import model.Secretaria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Cidade;
import model.Data;
import model.Endereco;
import model.Estado;
import model.Faxineira;
import model.Funcionario;
import view.FuncionarioView;
import view.RelatorioAlunoView;

public class FuncionarioController {

	// gravar dados do aluno
	Cidade cidade2 = new Cidade();
	Estado estado2 = new Estado();
	Faxineira faxineira1 = new Faxineira();
	Secretaria secretaria1 = new Secretaria();
	Funcionario funcionario1 = new Funcionario();
	Professor professor1 = new Professor();

	List<String> arrayAluno = new ArrayList<String>();
	// private String[][] dados;
	String matriculaAluno = "";
	String nomeAluno = "";
	String dataNasimentoAluno = "";
	String materias = "";
	boolean limpar = false;

	public FuncionarioController() {

	}

	public void inserirFuncionario(String nome, String data, String rg, String cpf, String telefone, String logradouro,
			String numero, String cep, String complemento, String bairro, String cidade, String estado,
			List<String> arrayFuncionario, String turno, String cargo, String ramal, String salario) {

		if (nome.trim().equals(null) || nome.trim().equals("") || data.trim().equals(null) || data.trim().equals("")
				|| rg.trim().equals(null) || rg.trim().equals("") || cpf.trim().equals(null) || cpf.trim().equals("")
				|| telefone.equals(null) || telefone.trim().equals("") || numero.equals(null)
				|| numero.trim().equals("") || cep.trim().equals(null) || cep.trim().equals("")
				|| bairro.trim().equals(null) || bairro.trim().equals("") || cidade.equals(null)
				|| cidade.trim().equals("") || estado.equals(null) || estado.trim().equals("")
				|| cargo.trim().equals("") || cargo.trim().equals(null) || salario.trim().equals("")
				|| salario.trim().equals(null) || cidade.trim().equals("") || cidade.trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Dados nulos", "ERRO", 0);
		} else {
			if (cargo.trim().equals("Professor")) {
				// for (String string : arrayFuncionario) {
				materias += arrayFuncionario;
				// }
			}
			limpar = true;
			String data2[] = data.split("/");
			String estado3[] = estado.split("-");
			cidade2.setNome(cidade);
			estado2.setNome(estado);
			estado2.setUf(estado3[1]);

			Endereco endereco = new Endereco();

			Data data1 = new Data(Integer.parseInt(data2[0]), Integer.parseInt(data2[1]), Integer.parseInt(data2[2]));

			funcionario1.setNome(nome);
			funcionario1.setDataNascimento(data1);
			funcionario1.setRg(rg);
			funcionario1.setCpf(cpf);
			funcionario1.setTelefone(telefone);
			funcionario1.setSalario(Double.parseDouble(salario));
			professor1.setMateria(arrayFuncionario);
			faxineira1.setTurno(turno);
			secretaria1.setRamal(ramal);
			
			endereco.setLogradouro(logradouro);
			endereco.setNumero(Integer.parseInt(numero));
			endereco.setCep(cep);
			if (complemento.equals(null) || complemento.trim().equals("")) {
				endereco.setComplemento("");
			} else {
				endereco.setComplemento(complemento);
			}

			endereco.setBairro(bairro);
			endereco.setCidade(cidade2);
			endereco.setEstado(estado2);
			
			
			
			try {
				File arquivo = new File("funcionario.txt");
				FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
				PrintStream gravador = new PrintStream(arquivoOutput);

				// String teste = arrayFuncionario.get(0);
//|| arrayFuncionario.get(0).trim().equals(null)||arrayFuncionario.get(0).trim().equals(""))
				//arrayFuncionario.size() <= 0||
				
				if ((arrayFuncionario.size() <= 0 && (turno.equals(null) && turno.trim().equals(""))
						&& (ramal.trim().equals(null))&& ramal.trim().equals(""))  ) {

					JOptionPane.showMessageDialog(null, "Dados nulos", "ERRO", 0);
				} else if(Integer.parseInt(data2[0]) > 30
						|| Integer.parseInt(data2[1]) > 12 || Integer.parseInt(data2[2]) > 2500){
					JOptionPane.showMessageDialog(null, "Data invalida", "ERRO", 0);
					
				}else {

					gravador.print(funcionario1.getNome().toUpperCase());
					gravador.print(";");
					gravador.print(funcionario1.getRg().toUpperCase());
					gravador.print(";");
					gravador.print(funcionario1.getCpf().toUpperCase());
					gravador.print(";");
					gravador.print(funcionario1.getTelefone().toUpperCase());
					gravador.print(";");
					gravador.print(data.toString().toUpperCase());
					gravador.print(";");
					gravador.print(funcionario1.getSalario());
					gravador.print(";");
					gravador.print(endereco.getLogradouro().toUpperCase());
					gravador.print(";");
					gravador.print(endereco.getNumero());
					gravador.print(";");
					gravador.print(endereco.getCep().toUpperCase());
					gravador.print(";");
					gravador.print(endereco.getComplemento().toUpperCase());
					gravador.print(";");
					gravador.print(endereco.getBairro().toUpperCase());
					gravador.print(";");
					gravador.print(cidade2.getNome().toUpperCase());
					gravador.print(";");
					gravador.print(estado2.getNome().toUpperCase());
					gravador.print(";");
					if (cargo.trim().equals("Professor")) {
						// for (String string : arrayFuncionario) {
						materias += arrayFuncionario;
						gravador.print(materias.toUpperCase());
						gravador.print(";");
						gravador.print(1);
						gravador.print(";");
					} else if (cargo.trim().equals("Secretaria")) {
						gravador.print(ramal.toUpperCase());
						gravador.print(";");
						gravador.print(2);
						gravador.print(";");
					} else if (cargo.trim().equals("Faxineira")) {
						gravador.print(turno.toUpperCase());
						gravador.print(";");
						gravador.print(3);
						gravador.print(";");
					}
					gravador.println();

					gravador.close();
					arquivoOutput.close();
					// f1.limparCampos();
					new FuncionarioView(limpar);
					JOptionPane.showMessageDialog(null, "Gravado com sucesso");
					System.out.println("Gravado com sucesso");
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * try { File arquivo = new File("aluno.txt"); FileOutputStream arquivoOutput =
	 * new FileOutputStream(arquivo, true); PrintStream gravador = new
	 * PrintStream(arquivoOutput);
	 * 
	 * gravador.print(aluno1.getNome()); gravador.print(";");
	 * gravador.print(aluno1.getMatricula()); gravador.print(";");
	 * gravador.print(aluno1.getRg()); gravador.print(";");
	 * gravador.print(aluno1.getCpf()); gravador.print(";");
	 * gravador.print(aluno1.getTelefone()); gravador.print(";");
	 * gravador.print(data.toString()); gravador.print(";");
	 * gravador.print(aluno1.getSexo()); gravador.print(";");
	 * gravador.print(aluno1.getSenha()); gravador.print(";");
	 * gravador.print(endereco.getLogradouro()); gravador.print(";");
	 * gravador.print(endereco.getNumero()); gravador.print(";");
	 * gravador.print(endereco.getCep()); gravador.print(";");
	 * gravador.print(endereco.getComplemento()); gravador.print(";");
	 * gravador.print(endereco.getBairro()); gravador.print(";");
	 * gravador.print(endereco.getCidade()); gravador.print(";");
	 * gravador.print(endereco.getEstado()); gravador.print(";");
	 * 
	 * gravador.println();
	 * 
	 * gravador.close(); arquivoOutput.close();
	 * System.out.println("Gravado com sucesso"); } catch (FileNotFoundException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */

	// exibe todos os arquivos do arquivo aluno
	public String listarTodos() {
		// dados = new String [3][];
		int i = 0;
		int j = 0;
		String dadosAluno = "";
		String[][] dados;
		dados = new String[][] { { "", "", "" } };
		try {
			InputStream is = new FileInputStream("funcionario.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader leitor = new BufferedReader(isr);
			String aluno = leitor.readLine();

			// System.out.println(aluno);

			System.out.println();
			while (aluno != null) {

				// arrayAluno.add(aluno1.getMatricula());
				// arrayAluno.add(aluno1.getNome());
				// arrayAluno.add(data2.toString());
				// arrayAluno.add(",");

				String data2[] = aluno.split(";");

				dadosAluno += data2[0] + ";";
				dadosAluno += data2[4] + ";";
				dadosAluno += data2[3] + ";";
				dadosAluno += data2[14] + ";";
				dadosAluno += ",";

				// vetorAluno.adicionaNaTabela(data2[0],data2[1],data2[5]);
				/*
				 * for (String string : data2) { String dados2[] = dadosAluno.split(";");
				 * dados[i][j]=data2[0]; dados[i+1][j]=data2[1]; dados[i+2][j]=data2[5]; //dados
				 * = new String[][] {{data2[1],data2[0],data2[5]}}; i++; }
				 * 
				 * i=0; j++;
				 */
				// dados[5][5]="a";
				aluno = leitor.readLine();
				// return dadosAluno;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Arquivo de entrada não encontrado!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Arquivo de entrada não encontrado!");
			e.printStackTrace();
		}
		System.out.println(dadosAluno);
		return dadosAluno;

	}

	/*
	 * public void listarTodos() {
	 * 
	 * try { InputStream is = new FileInputStream("aluno.txt"); InputStreamReader
	 * isr = new InputStreamReader(is); BufferedReader leitor = new
	 * BufferedReader(isr); String aluno = leitor.readLine(); String data2[] =
	 * aluno.split(";"); // System.out.println(aluno);
	 * 
	 * System.out.println(); while (aluno != null) {
	 * 
	 * aluno = leitor.readLine(); System.out.print("Matricula: ");
	 * System.out.println(data2[0]); System.out.print("Nome: ");
	 * System.out.println(data2[1]); System.out.print("Data de aniversario: ");
	 * System.out.println(data2[2]); System.out.print("Sexo: ");
	 * System.out.println(data2[3]); }
	 * 
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * System.out.println("Arquivo de entrada não encontrado!");
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block System.out.println("Arquivo de entrada não encontrado!");
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	// listar aniversariantes no mes
	/*
	 * public void listarAniversariantes(int mes) {
	 * 
	 * try { InputStream is = new FileInputStream("aluno.txt"); InputStreamReader
	 * isr = new InputStreamReader(is); BufferedReader leitor = new
	 * BufferedReader(isr);
	 * 
	 * String aluno = leitor.readLine();
	 * 
	 * System.out.println("Aniversariantes do mes: "); while (aluno != null) {
	 * 
	 * String data2[] = aluno.split(";"); String aniversario[] =
	 * data2[2].split("/");
	 * 
	 * if ((Integer.parseInt(aniversario[1])) == (mes)) { System.out.println();
	 * System.out.println("Aniversariantes do mes: ");
	 * 
	 * if ((Integer.parseInt(aniversario[1])) == (6)) { System.out.println("");
	 * 
	 * System.out.print("Matricula: "); System.out.println(data2[0]);
	 * System.out.print("Nome: "); System.out.println(data2[1]);
	 * System.out.print("Data de aniversario: "); System.out.println(data2[2]);
	 * System.out.print("Sexo: "); System.out.println(data2[3]);
	 * 
	 * } else {
	 * 
	 * }
	 * 
	 * aluno = leitor.readLine();
	 * 
	 * } } } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * System.out.println("Arquivo de entrada não encontrado!");
	 * e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated catch
	 * block System.out.println("Arquivo de entrada não encontrado!");
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	public boolean limparFuncionario() {

		return this.limpar;
	}

}
