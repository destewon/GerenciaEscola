import controler.AlunoController;
import view.MenuView;

public class Main {

	public static void main(String[] args) {
		/*try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//com.jgoodies.looks.plastic.Plastic3DLookAndFeel
		//com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
		//
		/*try {
		UIManager
				.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
	} catch (Exception e) {
		e.printStackTrace();
	}*/
		//UIManager.getDefaults().put("OptionPane.background",new Color(0,0,0));
		// TODO Auto-generated method stub
		//ProfessorControler p1 = new ProfessorControler();
		//p1.testeProfessor();

		//AlunoController al1 = new AlunoController();
		//al1.inserirAluno();
		//al1.listarTodos();

		AlunoController al1 = new AlunoController();
		//al1.inserirAluno();
		al1.listarTodos();
		//al1.listarAniversariantes(6);

		
		//new AlunoController();
		
		new MenuView();
		
	
		
	}
	
	}

	
