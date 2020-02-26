package controler;

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
import view.RelatorioAlunoView;

public class AlunoController {

	// gravar dados do aluno
	Cidade cidade2 = new Cidade();
	Estado estado2 = new Estado();
	Aluno aluno1 = new Aluno();
	List<String> arrayAluno = new ArrayList<String>();
	// private String[][] dados;
	String matriculaAluno = "";
	String nomeAluno = "";
	String dataNasimentoAluno = "";

	public void inserirAluno(String nome, String matricula, String data, String rg, String cpf, String telefone,
			String sexo, String senha, String logradouro, String numero, String cep, String complemento, String bairro,
			String cidade, String estado) {
		if (nome.trim().equals(null) || nome.trim().equals("") || data.trim().equals(null) || data.trim().equals("")
				|| rg.trim().equals(null) || rg.trim().equals("") || cpf.trim().equals(null) || cpf.trim().equals("")
				|| telefone.equals(null) || telefone.trim().equals("") || numero.equals(null)
				|| numero.trim().equals("") || cep.trim().equals(null) || cep.trim().equals("") || bairro.trim().equals(null)
				|| bairro.trim().equals("") || cidade.trim().equals(null) || cidade.trim().equals("") || estado.trim().equals(null)
				|| estado.trim().equals("") || matricula.trim().equals("") || matricula.equals(null)
				|| sexo.trim().equals("") || sexo.trim().equals(null) || cidade.trim().equals("")
				|| cidade.trim().equals("")) {

			JOptionPane.showMessageDialog(null, "Dados nulos", "ERRO", 0);
		} else {

			String data2[] = data.split("/");

			String estado3[] = estado.split("-");

			cidade2.setNome(cidade);
			estado2.setNome(estado);
			estado2.setUf(estado3[1]);

			Endereco endereco = new Endereco();

			Data data1 = new Data(Integer.parseInt(data2[0]), Integer.parseInt(data2[1]), Integer.parseInt(data2[2]));

			aluno1.setNome(nome);
			aluno1.setMatricula(matricula);
			aluno1.setDataNascimento(data1);
			aluno1.setRg(rg);
			aluno1.setCpf(cpf);
			aluno1.setTelefone(telefone);
			aluno1.setSexo(sexo.charAt(0));
			aluno1.setSenha(senha);
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
				File arquivo = new File("aluno.txt");
				FileOutputStream arquivoOutput = new FileOutputStream(arquivo, true);
				PrintStream gravador = new PrintStream(arquivoOutput);
				if (Integer.parseInt(data2[0])>30||Integer.parseInt(data2[1])>12||Integer.parseInt(data2[2])>2500) {
					JOptionPane.showMessageDialog(null, "Data Invalida", "ERRO", 0);
				}else {
				gravador.print(aluno1.getNome().toUpperCase());
				gravador.print(";");
				gravador.print(aluno1.getMatricula().toUpperCase());
				gravador.print(";");
				gravador.print(aluno1.getRg().toUpperCase());
				gravador.print(";");
				gravador.print(aluno1.getCpf().toUpperCase());
				gravador.print(";");
				gravador.print(aluno1.getTelefone().toUpperCase());
				gravador.print(";");
				gravador.print(data.toString().toUpperCase());
				gravador.print(";");
				gravador.print(aluno1.getSexo());
				gravador.print(";");
				gravador.print(aluno1.getSenha().toUpperCase());
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

				gravador.println();

				gravador.close();
				arquivoOutput.close();
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
			InputStream is = new FileInputStream("aluno.txt");
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
				dadosAluno += data2[1] + ";";
				dadosAluno += data2[5] + ";";
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

}
