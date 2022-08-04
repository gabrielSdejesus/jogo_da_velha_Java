package jogo_da_velha;

import tabuleiro.Quadrado;
import exceptions.velhaExceptions;
import jogador.Jogador;

public class UI {

	private static Quadrado[][] velha = new Quadrado[3][3];
	private Jogador jogador = Jogador.x;
	private int Turno = 0;

	public Jogador getJogador() {
		return jogador;
	}

	public static void padraoTabuleiro() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				velha[i][j] = new Quadrado();
			}
		}
	}

	public void Tabuleiro() {
		System.out.println("  0    1    2");
		System.out.printf("0 %c  | %c | %c\n", velha[0][0].getXouO(), velha[0][1].getXouO(), velha[0][2].getXouO());
		System.out.println("---------------");
		System.out.printf("1 %c  | %c | %c\n", velha[1][0].getXouO(), velha[1][1].getXouO(), velha[1][2].getXouO());
		System.out.println("---------------");
		System.out.printf("2 %c  | %c | %c\n", velha[2][0].getXouO(), velha[2][1].getXouO(), velha[2][2].getXouO());
	}

	public void Jogada(int linha, int coluna, Jogador jogador) {
		if (linha < 3 && linha > -1 && coluna < 3 && coluna > -1) {
			if (Turno % 2 == 0 && velha[linha][coluna].getXouO() == ' ') {
				velha[linha][coluna].setXouO('x');
			} else if (Turno % 2 != 0 && velha[linha][coluna].getXouO() == ' ') {
				velha[linha][coluna].setXouO('o');
			} else {
				throw new velhaExceptions("Campo preenchido!");
			}
		} else {
			throw new velhaExceptions("Numero de Linha/Coluna incorreto! ");
		}
		Turno++;
	}

	public void limparTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void Turno() {
		if (Turno % 2 == 0) {
			this.jogador = Jogador.x;
		} else {
			this.jogador = Jogador.o;
		}
	}

	public boolean Vitoria() {
		int sumX = 0;
		int sumO = 0;

		// Linhas
		for (int i = 0; i < 3; i++) {
			if (sumX == 3) {
				break;
			}
			if (sumO == 3) {
				break;
			}
			for (int j = 0; j < 3; j++) {
				if (velha[i][j].getXouO() == 'x') {
					sumX++;
				} else {
					sumX = 0;
				}
				if (velha[i][j].getXouO() == 'o') {
					sumO++;
				} else {
					sumO = 0;
				}

			}
		}

		// Colunas
		if (sumX != 3 && sumO != 3) {
			for (int j = 0; j < 3; j++) {
				if (sumX == 3) {
					break;
				}
				if (sumO == 3) {
					break;
				}
				for (int i = 0; i < 3; i++) {
					if (velha[i][j].getXouO() == 'x') {
						sumX++;
					} else {
						sumX = 0;
					}
					if (velha[i][j].getXouO() == 'o') {
						sumO++;
					} else {
						sumO = 0;
					}

				}
			}
		}

		// Diagonal Primaria
		if (sumX != 3 && sumO != 3) {
			for (int i = 0; i < 3; i++) {
				if (velha[i][i].getXouO() == 'x') {
					sumX++;
				} else {
					sumX = 0;
				}
				if (velha[i][i].getXouO() == 'o') {
					sumO++;
				} else {
					sumO = 0;
				}

				if (sumX == 3) {
					break;
				}
				if (sumO == 3) {
					break;
				}
			}
		}

		// Diagonal Secundaria
		if (sumX != 3 && sumO != 3) {
			for (int i = 2; i > -1;) {
				if (sumX == 3) {
					break;
				}
				if (sumO == 3) {
					break;
				}
				for (int j = 0; j < 3; j++) {
					if (velha[i][j].getXouO() == 'x') {
						sumX++;
					} else {
						sumX = 0;
					}
					if (velha[i][j].getXouO() == 'o') {
						sumO++;
					} else {
						sumO = 0;
					}
					i--;
				}
			}
		}

		if (sumX == 3) {
			System.out.println("Jogador X venceu!");
			return false;
		}

		if (sumO == 3) {
			System.out.println("Jogador O venceu!");
			return false;
		}
		return true;
	}

}
