package api2025;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class bancodedados {
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultset = null;
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/cadastro";
		String usuario ="root";
		String senha = "Aluno";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor,usuario,senha);
			this.statement = this.connection.createStatement();
		}catch(Exception e) {
			System.out.println("não foi possível conectar ao banco: "+e.getMessage());
		}
}
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
	}
	public void listarContatos() {
		try {
			String query ="select * from contato order by nome";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println("ID: "+ this.resultset.getString("id")+"Nome: " + this.resultset.getString("nome")+"Telefone: "+this.resultset.getString("telefone"));
			}
		}catch(Exception e) {
			System.out.println("não foi possível acessar a tabela: " + e.getMessage());
		}
	}
	public void inserirContato(String nome,String telefone) {
		try {
			String query ="insert into contato(nome,telefone) values('"+nome+"','"+telefone+"');";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}
	public void editarContato(String id, String telefone, String nome) {
		try {
			String query ="update contato set nome = '"+nome+"',telefone = '"+telefone+"' where id = "+id+"";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}
	public void apagarContato(String id) {
		try {
			String query = "delete from contato where id = '"+id+"'";
			this.statement.executeUpdate(query);
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public void desconectar() {
		try {
			this.connection.close();
		}catch(Exception e) {
			System.out.println("Erro ao desconectar: " + e.getMessage());
		}
	}
}