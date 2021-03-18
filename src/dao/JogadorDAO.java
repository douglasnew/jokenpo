/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import bdutil.BDUtil;
import model.Jogador;

/**
 * @author douglas
 *
 */
public class JogadorDAO {
	
	/**
	 * Salva jogador 
	 */
	public static String salva(Jogador jogador) {
		
		Connection conn = null;
		
		try {
			
			conn = BDUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Jogador(nome) values(?)");
			ps.setString(1, jogador.getNome());
			
			int executeUpdate = ps.executeUpdate();
			if (executeUpdate == 1 ) {
				String idUltimoJogadorSalvo = getJogadorByMaiorId();
				return idUltimoJogadorSalvo;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			BDUtil.closeConnection(conn);
			
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		getJogadorByMaiorId();
	}
	
	/**
	 * Recuperar ID do último jogador salvo
	 * 
	 * @return
	 */
	public static String getJogadorByMaiorId() {
		
		Connection conn = null;
		
		try {
			
			conn = BDUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Jogador ORDER BY id desc");
			
			while (rs.next()) {
				return rs.getString("id");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			BDUtil.closeConnection(conn);
			
		}
		
		return null;
	}

}
