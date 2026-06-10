package senac.aula.view;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import senac.aula.model.Cliente;
import senac.aula.repository.ClienteRepository;

public class TelaCliente extends JInternalFrame {

	public TelaCliente() {
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

		botaoSalvar.addActionListener(e -> {
			System.out.println("clicou no salvar");
			Cliente cliente = new Cliente();

			cliente.setNome(campoNome.getText());
			cliente.setSenha(new String(campoSenha.getPassword()));

			System.out.println(cliente.getNome());
			System.out.println(cliente.getSenha());
			
			ClienteRepository clienteRepository = 
					new ClienteRepository();
			clienteRepository.cadastrar(cliente);
		});

		setVisible(true);
	}

}
