package senac.aula.view;

import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import senac.aula.model.Cliente;
import senac.aula.repository.ClienteRepository;

public class TelaListarCliente extends JInternalFrame {

	public TelaListarCliente() {
		setTitle("Lista de Clientes");

		setClosable(true);
		setMaximizable(true);

		setSize(800, 600);

		setLayout(null);
		
		//crio o objeto repository que vai 
		//permitir interagir com o banco de dados
		ClienteRepository clienteRepository = 
				new ClienteRepository();
		
		//chamo o metodo listar que vai carregar todos
		//os clientes do banco de dados
		List<Cliente> clientes = clienteRepository.listar();

		// Dados da tabela
		String[] colunas = { "ID", "Nome" };
		Object[][] dados = new Object[clientes.size()][2];
		
		for (int i = 0; i < clientes.size(); i++) {
			dados[i][0] = clientes.get(i).getId();
			dados[i][1] = clientes.get(i).getNome();
		}

		// Criar tabela
		JTable tabela = new JTable(dados, colunas);

		// Criar JScrollPane com posição e tamanho definidos
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(50, 50, 500, 150);

		// Adicionar à janela
		add(scrollPane);		

		setVisible(true);
	}

}
