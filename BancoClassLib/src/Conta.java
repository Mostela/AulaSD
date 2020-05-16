import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conta {

    private int id;
    private String nome;
    private double saldo;


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }


    /**
     * Atualiza o BD retirando o valor quantia do saldo atual da conta
     *
     * @param quantia 	a quantia desejada para realizar o saque
     * @return		Boolean indicando se operação obteve sucesso
     */
    public boolean saque(double quantia) {
        // TODO Implementar saque
        return true;
    }


    /**
     * Atualiza o BD adicionando a quantia do depósito ao saldo atual da conta
     *
     * @param quantia	A quantia a ser adicionada ao saldo
     * @return		Boolean indicando se operação obteve sucesso
     */
    public boolean deposito(double quantia) {
        // TODO Implementar deposito
        return true;
    }

    /**
     * Consulta no BD as informações da conta dado o valor salvo no atributo id
     * @return		Boolean indicando se operação obteve sucesso
     */
    public boolean recuperar() {
        System.out.println("Dentro do método recuperar()");

        boolean resultado = false;
        Connection con;
        PreparedStatement stmt;
        ResultSet rs;

        try {
            con = this.getConexao();
            stmt = con.prepareStatement("SELECT * FROM conta WHERE idconta = ?");
            stmt.setInt(1, this.getId());
            rs = stmt.executeQuery();

            if (rs.next()) {
                this.setNome(rs.getString("nome"));
                this.setSaldo(rs.getDouble("saldo"));
                resultado = true;
            }

            con.close();

        } catch (Exception e) {
            System.out.println("Erro no método recuperar: " + e.getMessage());
            e.printStackTrace();
        }

        return resultado;
    }


    /**
     * Realiza a conexão com o banco de dados
     * @return	O objeto da conexão, null se houver erro
     */
    private Connection getConexao() {
        Connection con = null;

        try{
            String url ="jdbc:postgresql://localhost:5432/dbbanco";
            String usuario="postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conexão realizada com sucesso.");
        }catch(Exception e) {
            System.out.println("Falha conexão: " + e.getMessage());
        }

        return con;
    }
}