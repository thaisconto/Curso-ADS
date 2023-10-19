package POO.aula10Exercicio.aula10ExercicioDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import POO.aula10Exercicio.aula10ExercicioEntity.Produto;

public class ProdutoDAO {
    public void inserir(Produto produto) {
        String sql = "insert into produto(nome, quantidadeProduto, valorProduto) values (?, ?, ?)";

//dentro do try crio a conexão e statement ele já fecha os objetos quando termina o try para não dar erro no BD 
        try (Connection conn = ConnectionFactory.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidadeProduto());
            stmt.setDouble(3, produto.getValorProduto());
            stmt.executeUpdate();


        } catch (SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }
    
    public void editar(Produto produto) {
        String sql = "update produto set nome = ?, quantidadeProduto = ?, valorProduto = ? where ID = ?";


        try (Connection conn = ConnectionFactory.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setInt(1, produto.getID());
            stmt.setString(2, produto.getNome());
            stmt.setInt(3, produto.getQuantidadeProduto());
            stmt.setDouble(4, produto.getValorProduto());
           
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao editar produto: " + ex.getMessage());

        }
    }
    
    public void excluir(int codigo) {
        String sql = "delete from produto where ID = ?";


        try (Connection conn = ConnectionFactory.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setInt(1, codigo);
            stmt.execute();
            stmt.close();
            System.out.println("deletou");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir produto: " + ex.getMessage());
        }
    }
    
    public ArrayList<Produto> getAllProduto() {
        String sql = "SELECT * FROM produto";
        ArrayList<Produto> produtos = new ArrayList<>();


        try (Connection conn = ConnectionFactory.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql); 
                ResultSet rs = stmt.executeQuery()) {


            while (rs.next()) {
                String nome = rs.getString("nome");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                double valorProduto = rs.getInt("valorProduto");
                int ID = rs.getInt("ID");


                Produto prod = new Produto(ID, nome, quantidadeProduto, valorProduto);
                produtos.add(prod);
            }


        } catch (SQLException ex) {
            System.out.println("Erro ao buscar Todos produto: " + ex.getMessage());
        }


        return produtos;
    }

}
