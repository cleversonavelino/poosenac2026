package senac.aula;

import senac.aula.view.TelaPrincipal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        new TelaPrincipal();
        
        //crio a fábrica de entity manager
        //um entity manager gerencia as entidades
        //ex: cliente
        //com ele é possível salvar alterar listar dados do banco
        //EntityManagerFactory emf = Persistence.
        	//	createEntityManagerFactory("aula-senac-poo");
        //recupero um entity manager para poder fazer operações de banco
        //EntityManager em = emf.createEntityManager();

        //em.getTransaction().begin();

        // cria o objeto do tipo cliente
        //Cliente cliente = new Cliente();
        //cliente.setNome("meu nome");
        //cliente.setSenha("123456");
        //método utilizado para salvar o objeto no banco de dados
        //em.persist(cliente);

        //em.getTransaction().commit();
        
        //em.close();
//        emf.close();
    }
}
