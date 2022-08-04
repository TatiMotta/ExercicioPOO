package expoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import expo.interfaces.ICrud;
import expo.utilidades.Conexao;
import expoo.entidades.Comida;

public class DaoComida implements ICrud<Comida> {

	public boolean salvar(Comida obj) {
		String sql = "insert into comida(culinaria, nome, preco)values(?,?,?)";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getCulinaria());
			stm.setString(2, obj.getNome());
			stm.setDouble(3, obj.getPreco());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean alterar(Comida obj) {
		String sql = "update comida set" + " culinaria = ?," + "	nome = ?," + "	preco = ?"
				+ "where id = ?";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getCulinaria());
			stm.setString(2, obj.getNome());
			stm.setDouble(3, obj.getPreco());
			stm.setInt(4, obj.getId());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			Conexao.fechar();
		}
		return true;
	}

	public void excluir(int id) {
		String sql = "delete from comida where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.execute();
		
		}catch(

	SQLException e)
	{
		System.out.println(e.getMessage());
	}finally
	{
		Conexao.fechar();
	}
}

	public Comida consultar(int id) {
		Comida comida = new Comida();
		String sql = "select * from comida where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				comida = new Comida();
				comida.setId(rs.getInt(id));
				comida.setCulinaria(rs.getString("culinaria"));
				comida.setNome(rs.getString("nome"));
				comida.setPreco(rs.getDouble("preco"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexao.fechar();
		}
		return comida;
	}

	public List<Comida> consultar() {
		List<Comida> comidas = new ArrayList<>();
		String sql = "select * from comida";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Comida comida = new Comida();
				comida.setId(rs.getInt("id"));
				comida.setCulinaria(rs.getString("culinaria"));
				comida.setNome(rs.getString("nome"));
				comida.setPreco(rs.getDouble("preco"));
				comidas.add(comida);
			}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			finally {
				Conexao.fechar();
			}
		return comidas;
	}
}