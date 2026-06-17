package senac.aula.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import senac.aula.model.Cliente;
import senac.aula.repository.ClienteRepository;

public class TelaListarCliente extends JInternalFrame {
	
	public TelaListarCliente(JDesktopPane desktopPane) {
		setTitle("Lista de Clientes");

		setClosable(true);
		setMaximizable(true);

		setSize(800, 600);

		setLayout(null);

		// crio o objeto repository que vai
		// permitir interagir com o banco de dados
		ClienteRepository clienteRepository = new ClienteRepository();

		// chamo o metodo listar que vai carregar todos
		// os clientes do banco de dados
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

		// Selecionar coluna inteira ao clicar no cabeçalho
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clicou na tabela");
				int row = tabela.rowAtPoint(e.getPoint());
				System.out.println(row);
				
				if (row >= 0) {
		            // Retrieve data from the row (example: column 0)
		            Object value = tabela.getValueAt(row, 0);
		            System.out.println("Clicked row: " + row + ", Value: " + value);
		            
		            Cliente cliente = clienteRepository.
		            		buscar(Integer.valueOf(value.toString()));
		            
		            TelaCliente telacliente = new TelaCliente(cliente);
		            desktopPane.add(telacliente);
		            desktopPane.moveToFront(telacliente);
		        }
			}
		});

		setVisible(true);
	}

}
