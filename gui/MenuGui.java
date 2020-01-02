package biblioteca.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuGui extends JFrame {

	private JPanel cadastraGarcom = new InsereLivro();
	private JPanel cadastraPedido = new DeletaLivro();

	public MenuGui() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initMenu();
		setLayout(new BorderLayout());
	}

	private class MenuAction implements ActionListener {

		private JPanel panel;

		private MenuAction(JPanel pnl) {
			this.panel = pnl;
		}

		public void actionPerformed(ActionEvent e) {
			changePanel(panel);

		}

	}

	private void initMenu() {
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem menuItem1 = new JMenuItem("Cadastrar Livro");
		JMenuItem menuItem3 = new JMenuItem("Deletar Livro");
		menubar.add(menu);
		menu.add(menuItem1);
		menu.add(menuItem3);
		setJMenuBar(menubar);
		menuItem1.addActionListener(new MenuAction(cadastraGarcom));
		menuItem3.addActionListener(new MenuAction(cadastraPedido));

	}

	private void changePanel(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().doLayout();
		update(getGraphics());
	}

	public static void main(String[] args) {
		MenuGui frame = new MenuGui();
		frame.setBounds(200, 400, 600, 400);
		frame.setVisible(true);

	}
}