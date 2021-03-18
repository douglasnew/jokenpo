/**
 * 
 */
package model;

/**
 * @author douglas
 *
 */
public class Partida {
	
	private Long id;
	private Jogador jogador;
	private Integer pontuacaoJogador;
	private Integer pontuacaoComputador;
	private String vencedor;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the jogador
	 */
	public Jogador getJogador() {
		return jogador;
	}
	
	/**
	 * @param jogador the jogador to set
	 */
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	/**
	 * @return the pontuacaoJogador
	 */
	public Integer getPontuacaoJogador() {
		return pontuacaoJogador;
	}
	
	/**
	 * @param pontuacaoJogador the pontuacaoJogador to set
	 */
	public void setPontuacaoJogador(Integer pontuacaoJogador) {
		this.pontuacaoJogador = pontuacaoJogador;
	}
	
	/**
	 * @return the pontuacaoComputador
	 */
	public Integer getPontuacaoComputador() {
		return pontuacaoComputador;
	}
	
	/**
	 * @param pontuacaoComputador the pontuacaoComputador to set
	 */
	public void setPontuacaoComputador(Integer pontuacaoComputador) {
		this.pontuacaoComputador = pontuacaoComputador;
	}
	
	/**
	 * @return the vencedor
	 */
	public String getVencedor() {
		return vencedor;
	}
	
	/**
	 * @param vencedor the vencedor to set
	 */
	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

}
