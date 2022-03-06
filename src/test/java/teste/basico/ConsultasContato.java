package teste.basico;

import java.util.List;

import com.desafio.gabrielmaranhao.models.dao.ContatoDAO;
import com.desafio.gabrielmaranhao.models.entities.Contato;
import com.google.gson.Gson;




public class ConsultasContato {
	
	public static void obtemContato(long id) {
		
		ContatoDAO dao = new ContatoDAO();
		Contato contato =  dao.obterContatoById(id);
//		System.out.println(contato.getNome());
		System.out.println(contato.toJson().toString());
		// EntityManagerFactory emf = Persistence.createEntityManagerFactory("projeto-desafio");
	    // EntityManager em = emf.createEntityManager();
	    
	    // Contato contato = em.find(Contato.class, id);
	    // System.out.println(contato.getNome());

	    // em.close();
	    // emf.close();
	}
	
	public static void obtemContatos(int deslocamento, int qtde) {
		
		ContatoDAO dao = new ContatoDAO();
        List<Contato> contatos = dao.obterTodos();

        for(Contato contato: contatos) {
            System.out.println(contato.getNome());
        }

        // double idsTotal = usuarios.stream().mapToDouble(Usuario::getId).sum();
        // // double idsTotal = usuarios.stream().map(p -> p.getId()).reduce(0, (a, b) -> a + b).getAsDouble(); //ou doubleValue();
        // System.out.println("Soma dos ids: " + idsTotal);
	}
	
	public static void insereContato(String conteudo) {

		ContatoDAO dao = new ContatoDAO();
		Contato contato = new Gson().fromJson(conteudo, Contato.class);
		dao.incluirAtomico(contato).fechar();

	}
	
	//function that updates a contact
	public static void atualizaContato(String conteudo) {
		ContatoDAO dao = new ContatoDAO();
		Contato contatoAtualizado = new Gson().fromJson(conteudo, Contato.class);
		dao.alterarContato(contatoAtualizado.getCodigo(), contatoAtualizado);
	}

	//function that deletes a contact
	public static void deletaContato(long id) {
		ContatoDAO dao = new ContatoDAO();
		dao.excluirContato(id);
	}

	public static String pegaEnderecos(long id) {
		ContatoDAO dao = new ContatoDAO();
		return dao.obterContatoById(id).getEndereco();
	}

	public static void main(String[] args) {
//		obtemContatos(0, 10);
//		obtemContato(1L);
//		insereContato("{\"nome\":\"TesteGW\",\"sobreNome\":\"SobreTeste\",\"cpf\":\"12345678911\",\"email\":\"teste@gmail.com\"}");
		// atualizaContato("{\"codigo\":2,\"nome\":\"Leandro\"}");
		// deletaContato(2L);
//		System.out.println(pegaEnderecos(3L));
	}
}
