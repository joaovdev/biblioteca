package biblioteca.gui;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.Dao;
import biblioteca.Factory;
import biblioteca.Livro;

public class InsereLivro extends JPanel {

	private JTextField idLivro;
	private JTextField nomeLivro;
	private JTextField authorLivro;

	public InsereLivro() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOME ");
		lblNewLabel.setBounds(159, 120, 48, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(159, 59, 23, 14);
		add(lblNewLabel_1);
		
		idLivro = new JTextField();
		idLivro.setBounds(159, 73, 116, 20);
		add(idLivro);
		idLivro.setColumns(10);
		
		nomeLivro = new JTextField();
		nomeLivro.setBounds(159, 135, 116, 20);
		add(nomeLivro);
		nomeLivro.setColumns(10);
		
		JLabel lblCadastroGarom = new JLabel("CADASTRO LIVRO");
		lblCadastroGarom.setForeground(Color.RED);
		lblCadastroGarom.setBounds(163, 23, 112, 14);
		add(lblCadastroGarom);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(159, 232, 116, 23);
		add(btnCadastrar);
		
		authorLivro = new JTextField();
		authorLivro.setColumns(10);
		authorLivro.setBounds(159, 201, 116, 20);
		add(authorLivro);
		
		JLabel label = new JLabel("AUTHOR");
		label.setBounds(159, 185, 48, 14);
		add(label);
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int id = Integer.parseInt(idLivro.getText());
				String nome = nomeLivro.getText();
				String author = authorLivro.getText();
				Livro livro = new Livro(id,nome,author);
				
				Factory factory = new Factory();
				try {
					Dao daoBd = factory.getDao(Livro.class, "Bd");
					daoBd.insert(livro);
					JOptionPane.showMessageDialog(null, "Salvo!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

	}
}
