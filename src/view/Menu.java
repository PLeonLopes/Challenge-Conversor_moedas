package view;

import exceptions.InvalidApiKeyException;
import models.Conversor;
import models.ParDeMoeda;
import services.ConverterMoedaApi;
import exceptions.InvalidOptionException;

import java.util.Scanner;

public class Menu {

    // Docs para moedas aceitas -> https://www.exchangerate-api.com/docs/supported-currencies
    private final ParDeMoeda[] paresDeMoedas = {
            new ParDeMoeda("Real Brasileiro [BRL]", "Dólar Americano [USD]"),           // BRL -> USD
            new ParDeMoeda("Dólar Americano [USD]", "Real Brasileiro [BRL]"),           // USD -> BRL

            new ParDeMoeda("Real Brasileiro [BRL]", "Euro [EUR]"),                      // BRL -> EUR
            new ParDeMoeda("Euro [EUR]", "Real Brasileiro [BRL]"),                      // EUR -> BRL

            new ParDeMoeda("Real Brasileiro [BRL]", "Iene Japonês [JPY]"),              // BRL -> JPY
            new ParDeMoeda("Real Brasileiro [BRL]", "Yuan Chinês [CNY]"),               // BRL -> CNY
    };

    public void displayMenu(){
        Scanner opcao = new Scanner(System.in);
        int escolha = 0;
        ConverterMoedaApi conversor = new ConverterMoedaApi();

        String menu = """
        ---------------------------------------------------------
                     Bem vindo(a) ao Conversor de Moeda
        ---------------------------------------------------------\n
        Escolha uma opção para converter:
        """;

        while (escolha != paresDeMoedas.length + 1){
            try {
                System.out.println(menu);
                for (int i = 0; i < paresDeMoedas.length; i++) {
                    System.out.println((i + 1) + ". " +
                            paresDeMoedas[i].fromMoeda() + " -> " + paresDeMoedas[i].toMoeda());
                }
                System.out.println(paresDeMoedas.length + 1 + ". SAIR");
                System.out.println("\nDigite uma opção: ");

                escolha = lerOpcao(opcao);
                double valor;

                switch (escolha){
                    case 1:
                        System.out.println("\nOpção 1 selecionada [BRL -> USD].");
                        System.out.println("Digite o valor [BRL]: ");
                        valor = opcao.nextDouble();
                        opcao.nextLine();           // LIMPA BUFFER (enter | \n)
                        Conversor brlUsd = conversor.buscaConversor("BRL", "USD", valor);
                        System.out.println("\nCotação Atual: " + brlUsd.conversion_rate());
                        System.out.println("R$" + valor + " -> $" + brlUsd.conversion_result() + "\n");
                        break;
                    case 2:
                        System.out.println("\nOpção 2 selecionada [USD -> BRL].");
                        System.out.println("Digite o valor [USD]: ");
                        valor = opcao.nextDouble();
                        opcao.nextLine();           // LIMPA BUFFER (enter | \n)
                        Conversor usdBrl = conversor.buscaConversor("USD", "BRL", valor);
                        System.out.println("\nCotação Atual: " + usdBrl.conversion_rate());
                        System.out.println("$" + valor + " -> R$" + usdBrl.conversion_result() + "\n");
                        break;
                    case 3:
                        System.out.println("\nOpção 3 selecionada [BRL -> EUR].");
                        System.out.println("Digite o valor [BRL]: ");
                        valor = opcao.nextDouble();
                        opcao.nextLine();           // LIMPA BUFFER (enter | \n)
                        Conversor brlEur = conversor.buscaConversor("BRL", "EUR", valor);
                        System.out.println("\nCotação Atual: " + brlEur.conversion_rate());
                        System.out.println("R$" + valor + " -> €" + brlEur.conversion_result() + "\n");
                        break;
                    case 4:
                        System.out.println("\nOpção 4 selecionada [EUR -> BRL].");
                        System.out.println("Digite o valor [EUR]: ");
                        valor = opcao.nextDouble();
                        opcao.nextLine();           // LIMPA BUFFER (enter | \n)
                        Conversor eurBrl = conversor.buscaConversor("EUR", "BRL", valor);
                        System.out.println("\nCotação Atual: " + eurBrl.conversion_rate());
                        System.out.println("€" + valor + " -> R$" + eurBrl.conversion_result() + "\n");
                        break;
                    case 5:
                        System.out.println("\nOpção 5 selecionada [BRL -> JPY].");
                        System.out.println("Digite o valor [BRL]: ");
                        valor = opcao.nextDouble();
                        opcao.nextLine();           // LIMPA BUFFER (enter | \n)
                        Conversor brlJpy = conversor.buscaConversor("BRL", "JPY", valor);
                        System.out.println("\nCotação Atual: " + brlJpy.conversion_rate());
                        System.out.println("R$" + valor + " -> ¥" + brlJpy.conversion_result() + "\n");
                        break;
                    case 6:
                        System.out.println("\nOpção 5 selecionada [BRL -> CNY].");
                        System.out.println("Digite o valor [BRL]: ");
                        valor = opcao.nextDouble();
                        opcao.nextLine();           // LIMPA BUFFER (enter | \n)
                        Conversor brlCny = conversor.buscaConversor("BRL", "CNY", valor);
                        System.out.println("\nCotação Atual: " + brlCny.conversion_rate());
                        System.out.println("R$" + valor + " -> ¥" + brlCny.conversion_result() + "\n");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        System.out.println("Digite uma das opções do menu.");
                }

            } catch (InvalidApiKeyException e) {
                System.out.println("Erro: " + e.getMessage());
                break; // Finaliza o programa após erro de API
            } catch (InvalidOptionException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro ao efetuar a conversão! Verifique os valores digitados e tente novamente!");
                break;
            }
        }
        System.out.println("Finalizando a Aplicação...");
    }

    private int lerOpcao(Scanner scanner) throws InvalidOptionException {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new InvalidOptionException("Entrada inválida! Digite uma opção VÁLIDA!");
        }
    }

}