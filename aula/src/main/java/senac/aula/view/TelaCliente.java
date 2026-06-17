package senac.aula.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import senac.aula.model.Cliente;
import senac.aula.repository.ClienteRepository;

public class TelaCliente extends JInternalFrame {

	public TelaCliente(final Cliente cliente) {
		TelaCliente frame = this;

		setTitle("Cadastro de Clientes");

		setClosable(true);
		setMaximizable(true);

		setSize(800, 600);

		setLayout(null);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(30, 30, 80, 25); // x, y, largura, altura
		add(labelNome);

		// Campo Nome
		JTextField campoNome = new JTextField();
		campoNome.setBounds(120, 30, 180, 25);		
		add(campoNome);

		// Label Senha
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setBounds(30, 70, 80, 25);
		add(labelSenha);

		// Campo Senha
		JPasswordField campoSenha = new JPasswordField();
		campoSenha.setBounds(120, 70, 180, 25);
		add(campoSenha);

		// Botão Salvar
		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.setBounds(120, 110, 100, 30);
		add(botaoSalvar);
		
		//verifica se o cliente não é nulo e carrega os dados
		if (cliente != null) {
			campoNome.setText(cliente.getNome());
			campoSenha.setText(cliente.getSenha());
		}

		botaoSalvar.addActionListener(e -> {
			System.out.println("clicou no salvar");			
						
			cliente.setNome(campoNome.getText());
			cliente.setSenha(new String(campoSenha.getPassword()));

			if (cliente.getNome().equals("")) {
				campoNome.setBorder(BorderFactory.createLineBorder(Color.RED, 2));				
				// Mostra caixa de diálogo de sucesso
				JOptionPane.
					showMessageDialog(null, 
							"O campo nome precisa ser preenchido!",
							"Atenção",             
				            JOptionPane.ERROR_MESSAGE );
				return;
			}
			
			if (cliente.getSenha().equals("")) {
				campoSenha.setBorder(BorderFactory.createLineBorder(Color.RED, 2));				
				// Mostra caixa de diálogo de sucesso
				JOptionPane.
					showMessageDialog(null, "O campo senha precisa ser preenchido!");
				return;
			}

			System.out.println(cliente.getNome());
			System.out.println(cliente.getSenha());
			// vamos salvar o cliente no banco de dados
			ClienteRepository clienteRepository = new ClienteRepository();
			if (cliente.getId() == null)
				clienteRepository.cadastrar(cliente);
			else 
				clienteRepository.editar(cliente);
			
			JOptionPane.
			showMessageDialog(null, 
					"O cliente foi salvo com sucesso!",
					"Atenção",             
		            JOptionPane.INFORMATION_MESSAGE );
		});

		setVisible(true);
	}

}
