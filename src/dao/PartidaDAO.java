/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bdutil.BDUtil;
import model.Partida;

/**
 * @author douglas
 *
 */
public class PartidaDAO {
	
	/**
	 * Salva partida
	 * 
	 * @param partida
	 */
	public static void salva(Partida partida) {
		
		Connection conn = null;
		
		try {
			
			conn = BDUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Partida(jogador_id, pontuacao_jogador, pontuacao_computador, vencedor) values(?,?,?,?)");
			ps.setObject(1, partida.getJogador().getId());
			ps.setInt(2, partida.getPontuacaoJogador());
			ps.setInt(3, partida.getPontuacaoComputador());
			ps.setString(4, partida.getVencedor());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			BDUtil.closeConnection(conn);
			
		}
		
	}

}
