package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Aluno;

public class AlunoDao implements IDAO<Aluno>{

	@Override
	public List<Aluno> buscarTodos() {
		List<Aluno> resultado = new ArrayList<Aluno>();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Pessoa JOIN Aluno USING(matricula)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(rs.getInt("matricula"));
				// aluno.setTipoid(rs.getCharacterStream("tipoid"));
				aluno.setNome(rs.getString("nome"));
				aluno.setTelefone(rs.getInt("telefone"));
				aluno.setEmail(rs.getString("email"));
				aluno.setSenha(rs.getString("senha"));
				aluno.setPeriodo(rs.getInt("periodo"));
				resultado.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public Aluno buscar(Aluno elemento) {
		Aluno resultado = new Aluno();
		Connection con = GerenciarConexao.getConexao();
		String sql = "SELECT * FROM Pessoa JOIN Aluno WHERE matricula='"+elemento.getMatricula()+"';";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resultado.setMatricula(rs.getInt("matricula"));
				// resultado.setTipoid(rs.getCharacterStream("tipoid"));
				resultado.setNome(rs.getString("nome"));
				resultado.setTelefone(rs.getInt("telefone"));
				resultado.setEmail(rs.getString("email"));
				resultado.setSenha(rs.getString("senha"));
				resultado.setPeriodo(rs.getInt("periodo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public void inserir(Aluno novo) {
		Connection con = GerenciarConexao.getConexao();
		String sql = "INSERT INTO Aluno VALUES (?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, novo.getMatricula());
			//tipoid faltando
			ps.setString(2, novo.getNome());
			ps.setInt(3, novo.getTelefone());
			ps.setString(4, novo.getEmail());
			ps.setString(5, novo.getSenha());
			ps.setInt(6, novo.getPeriodo());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Aluno elemento) {
		// TODO Auto-generated method stub
		
	}

}