package senac.aula.view;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import senac.aula.model.Cliente;

public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {
		// Configura o título da janela
		setTitle("Projeto Aula");

		// Define o tamanho da janela (largura x altura)
		setSize(1024, 768);

		// Posiciona a janela no centro da tela
		setLocationRelativeTo(null);

		// Define a operação padrão ao fechar a janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

		// Cria um DesktopPane (área para internal frames)
		JDesktopPane desktopPane = new JDesktopPane();
		add(desktopPane);

		// Cria a barra de menu
		JMenuBar menuBar = new JMenuBar();

		// Cria o menu "Arquivo"
		JMenu menuCadastros = new JMenu("Cadastros");

		JMenuItem itemCliente = new JMenuItem("Clientes");
		itemCliente.addActionListener(e -> {
			desktopPane.add(new TelaCliente(new Cliente()));
		});
		
		JMenuItem itemListarCliente = 
				new JMenuItem("Listar Clientes");
		itemListarCliente.addActionListener(e -> {
			desktopPane.add(new TelaListarCliente(desktopPane));
		});

		// Cria o item "Sair" dentro do menu
		JMenuItem itemSair = new JMenuItem("Sair");

		// Ação ao clicar em Sair
		itemSair.addActionListener(e -> {
			System.exit(0);
		});

		// Adiciona o item ao menu
		menuCadastros.add(itemCliente);
		menuCadastros.add(itemListarCliente);
		menuCadastros.add(itemSair);

		// Adiciona o menu à barra de menu
		menuBar.add(menuCadastros);

		// Define a barra de menu na janela
		setJMenuBar(menuBar);

		// Torna a janela visível
		setVisible(true);
	}

}
