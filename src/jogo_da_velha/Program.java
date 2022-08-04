package jogo_da_velha;

import java.util.Scanner;

import exceptions.velhaExceptions;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean game = true;
		UI ui = new UI();
		UI.padraoTabuleiro();

		while (ui.Vitoria()) {
			try {
				ui.limparTela();
				ui.Tabuleiro();
				ui.Turno();
				System.out.println();
				System.out.println("Jogador " + ui.getJogador());
				System.out.print("Linha: ");
				int linha = scan.nextInt();
				System.out.print("Coluna: ");
				scan.nextLine();
				int coluna = scan.nextInt();
				scan.nextLine();
				ui.Jogada(linha, coluna, ui.getJogador());
			} catch (velhaExceptions e) {
				System.out.println(e.getMessage());
				scan.nextLine();
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
				scan.nextLine();
			}
		}
		ui.limparTela();
		ui.Tabuleiro();
		System.out.println();
		ui.Vitoria();
	}

}
