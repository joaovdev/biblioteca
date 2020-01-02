package biblioteca.gui;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.Base;
import biblioteca.Dao;
import biblioteca.Factory;
import biblioteca.Livro;

public class DeletaLivro extends JPanel {
	private JTextField idLivro;

	public DeletaLivro() {
		setLayout(null);
		
		JLabel lblCadastroGarom = new JLabel("DELETAR LIVRO");
		lblCadastroGarom.setForeground(Color.RED);
		lblCadastroGarom.setBackground(Color.WHITE);
		lblCadastroGarom.setBounds(171, 22, 96, 14);
		add(lblCadastroGarom);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(159, 45, 23, 14);
		add(lblNewLabel_1);

		JButton btnCadastrar = new JButton("Deletar");
		btnCadastrar.setBounds(159, 90, 108, 23);
		add(btnCadastrar);

		idLivro = new JTextField();
		idLivro.setBounds(159, 59, 108, 20);
		add(idLivro);
		idLivro.setColumns(10);
		
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int id = Integer.parseInt(idLivro.getText());

				Livro p = new Livro(id);
				
				Factory factory = new Factory();
				try {
					Dao daoBd = factory.getDao(Livro.class, "Bd");
					daoBd.delete(p);
					JOptionPane.showMessageDialog(null, "Deletado!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});


	}
}
