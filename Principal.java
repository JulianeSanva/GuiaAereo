/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AulaInvertida;

/**
 *
 * @author Juliane
 */
import java.util.Scanner;

public class Principal {
	
	private static final int S1 = 0;
	private static final int S2 = 1;
	private static final int S3 = 2;
	private static final int S4 = 3;
	private static final int S5 = 4;
	private static final int S6 = 5;
	private static final int S7 = 6;
	private static final int S8 = 7;
	private static final int S9 = 8;
	private static final int S10 = 9;
	private static final int S11 = 10;
	private static final int S12 = 11;
	private static final int S13 = 12;
	private static final int S14 = 13;
	private static final int S15 = 14;
	private static final int S16 = 15;
	private static final int S17 = 16;
	private static final int S18 = 17;
	private static final int S19 = 18;
	private static final int S20 = 19;	
	
	private static int lerEstacao(final String tipo, final Scanner in) {
		
		while (true) {
			System.out.println(tipo+":");
			String linha = in.nextLine().trim();
			if (linha.isEmpty()) {
				System.out.println("Boa viagem!");
				System.exit(0);
			}

			try {
    int aeroporto = Integer.parseInt(linha);
    if (aeroporto < 1 || aeroporto > 20) {
        throw new IllegalArgumentException("Número fora do intervalo de aeroportos (1-20)");
    }
    return aeroporto - 1;
} catch (NumberFormatException e) {
    System.out.println("Digite um número válido.");
} catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
}			
		}
	}

	public static void main(String[] args) {
		
		Grafo g = new Grafo(20);
		
	
		g.criarAresta(S1, S2, 100);
		g.criarAresta(S3, S2, 350);
		g.criarAresta(S3, S4, 1150);
		g.criarAresta(S4, S5, 12);
		g.criarAresta(S5, S6, 450);
		g.criarAresta(S6, S7, 580);
		g.criarAresta(S7, S8, 470);
		g.criarAresta(S8, S9, 1700);
		g.criarAresta(S9, S10, 1200);
		g.criarAresta(S10, S11, 650);
		g.criarAresta(S11, S12, 550);
		g.criarAresta(S12, S13, 650);
		g.criarAresta(S20, S1, 3200);
		g.criarAresta(S12, S9, 1400);
		g.criarAresta(S15, S16, 2100);
		g.criarAresta(S16, S17, 1600);
		g.criarAresta(S17, S18, 1100);
		g.criarAresta(S18, S19, 500);
		g.criarAresta(S19, S20, 2500);
		g.criarAresta(S2, S16, 1500);
		g.criarAresta(S11, S18, 1300);
		g.criarAresta(S14, S6, 1300);
		g.criarAresta(S6, S19, 1800);
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("~*~ Bem-vindo ao seu guia de rotas aéreas ~*~\n");
	

		
		while (true) {
							
			System.out.println("Por favor, entre com a sua rota ou pressione ENTER para sair do programa.\n\nSegue a lista de aeroportos:\n1 - Aeroporto de Congonhas (CGH) - São Paulo\n2 - Aeroporto de Viracopos (VCP) - Campinas\n3 - Aeroporto Internacional de Curitiba/Afonso Pena (CWB) - Curitiba \n4 - Aeroporto Internacional Tom Jobim/Galeão (GIG) - Rio de Janeiro\n5 - Aeroporto de Santos Dumont (SDU) - Rio de Janeiro\n6 - Aeroporto Internacional de Belo Horizonte/Confins (CNF) - Belo Horizonte \n7 - Aeroporto Internacional de Florianópolis/Hercílio Luz (FLN) - Florianópolis\n8 - Aeroporto Internacional de Porto Alegre/Salgado Filho (POA) - Porto Alegre\n9 - Aeroporto Internacional de Brasília (BSB) - Brasília\n10 - Aeroporto Internacional de Vitória/Eurico de Aguiar Salles (VIX) - Vitória\n11 - Aeroporto Internacional de Salvador (SSA) - Salvador\n12 - Aeroporto Internacional de Recife/Guararapes (REC) - Recife\n13 - Aeroporto Internacional de Fortaleza/Pinto Martins (FOR) - Fortaleza\n14 - Aeroporto Internacional de Maceió/Zumbi dos Palmares (MCZ) - Maceió\n15 - Aeroporto Internacional de Natal/Governador Aluízio Alves (NAT) - Natal\n16 - Aeroporto Internacional de Cuiabá/Marechal Rondon (CGB) - Cuiabá\n17 - Aeroporto Internacional de Manaus/Eduardo Gomes (MAO) - Manaus\n18 - Aeroporto Internacional de Belém/Val-de-Cans (BEL) - Belém\n19 - Aeroporto de São Luís/Marechal Cunha Machado (SLZ) - São Luís\n20 - Aeroporto Internacional de Rio Branco/Plácido de Castro (RBR) - Rio Branco\n");
			int origem = lerEstacao("Origem", in);
			int destino = lerEstacao("Destino", in);			
			
			ResultadoCaminho resultado = g.caminhoMinimo(origem, destino);
	        
	        System.out.println("A rota mais curta é: ");
	        for (Integer estacao : resultado.getCaminho()) {
	            System.out.print((estacao + 1) + " -> ");
	        }
	        System.out.print("Fim da Rota");
	        System.out.println("\nPercurso total: " + resultado.getPercursoTotal()+"Km\n");
			
		}
	}

}