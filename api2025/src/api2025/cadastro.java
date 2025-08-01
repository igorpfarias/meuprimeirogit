package api2025;
import java.util.Scanner;
public class cadastro {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		bancodedados banco = new bancodedados();
		/*System.out.println("Digite seu nome");
		String nome = input.nextLine();
		System.out.println("Digite seu telefone");
		String telefone = input.nextLine();*/
		banco.conectar();
		if(banco.estaConectado()) {
			//banco.editarContato("1", "(85)9.86070-0589", "Larissa");
			//banco.inserirContato("Francisco Aureliano Indaiá", "85987118233");
			banco.apagarContato("3");
			banco.listarContatos();
			banco.desconectar();
		}else {
			System.out.println("Não foi possível conectar ao banco de dados!");
		}

	}

}
