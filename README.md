# JOKENPO

# Script Bando de Dados

CREATE TABLE IF NOT EXISTS Jogador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(25) NOT NULL
);

CREATE TABLE IF NOT EXISTS Partida (
	id INT AUTO_INCREMENT PRIMARY KEY,
    jogador_id INT,
    FOREIGN KEY (jogador_id) REFERENCES Jogador(id),
    pontuacao_jogador INT,
	pontuacao_computador INT,
    vencedor VARCHAR(20)
);
