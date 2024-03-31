import packages.IO;

// Classe principal para gerenciar o posto de combustível
public class main {
    public static void main(String[] args) {
        Combustivel alcool = new Combustivel("Alcool", 5.0);
        Combustivel gasolina = new Combustivel("Gasolina", 8.0);
        Tanque tanqueGasolina = new Tanque(gasolina, 1000); // Tanque de gasolina com capacidade de 1000 litros
        Tanque tanqueAlcool = new Tanque(alcool, 2000); // Tanque de alcool com capacidade de 800 litros
        Bomba bombaGasolina = new Bomba(0, tanqueGasolina, 10);
        Bomba bombaAlcool = new Bomba(1, tanqueGasolina, 15);
        
            while (true) {
            int opcao = IO.prinInt(
            "----------------------------------"
            + "\n\tPOSTO DE GASOLINA"   
            + "\n----------------------------------"
            + "\nEscolha uma opção:" 
            + "\n1 - Abastecer" 
            + "\n2 - Vender"
            + "\n3 - Ver combustível sobrando no tanque"
            + "\n4 - Alterar manualmente a quantidade de combustível em um tanque"
            + "\n5 - Editar preço do combustível"
            + "\n6 - Faturamento total"
            + "\n7 - Sair", "Digite uma opção válida\n");

            switch (opcao) {
                case 1:
                    // Abastecer por litro ou por valor
                    int tipoCase1 = IO.prinInt("Escolha o tipo de combustível: \n1 - Gasolina \n2 - Álcool", "Digite um valor válido");
                    if (tipoCase1 == 1) {
                        bombaGasolina.abastecer(tanqueGasolina);
                        IO.prin("Abastecimento de gasolina realizado com sucesso.");
                    } else if (tipoCase1 == 2) {
                        bombaAlcool.abastecer(tanqueAlcool);
                        IO.prin("Abastecimento de Álcool realizado com sucesso.");
                    } else {
                        IO.prin("Opção inválida.");
                    }
                    break;
                case 2:
                    // Vender combustível por litro
                    int tipoCase2 = IO.prinInt("Escolha o tipo de combustível: \n1 - Gasolina \n2 - Álcool", "Digite uma opção válida");
                    if (tipoCase2 == 1) {
                        bombaGasolina.vender();
                    } else if (tipoCase2 == 2) {
                        bombaAlcool.vender();
                    } else {
                        IO.prin("Opção inválida.");
                    }
                    break;
                case 3:
                    // Exibir quantidade de combustível em cada tanque
                    IO.prin("Combustível no tanque:");
                    IO.prin("Gasolina: " + tanqueGasolina.getQuantidade() + " litros");
                    IO.prin("Alcool: " + tanqueAlcool.getQuantidade() + " litros");
                    break;
                case 4:
                    // Alterar manualmente a quantidade de combustível em um tanque específico
                    int tanqueOpcao = IO.prinInt("Escolha o tanque que deseja alterar: \n1 - Gasolina \n2 - Álcool", "Digite um valor válido");
                    IO.prin("Digite a nova quantidade de combustível (em litros):");
                    double novaQuantidade = IO.lerDouble();
                    if (tanqueOpcao == 1) {
                        tanqueGasolina.setQuantidade(novaQuantidade);
                        IO.prin("Quantidade de gasolina alterada com sucesso.");
                    } else if (tanqueOpcao == 2) {
                        tanqueAlcool.setQuantidade(novaQuantidade);
                        IO.prin("Quantidade de alcool alterada com sucesso.");
                    } else {
                        IO.prin("Opção inválida.");
                    }
                    break;
                case 5:
                    // Editar preço do combustivel
                    int CombustivelOpcao = IO.prinInt("Escolha o tipo de combustível que deseja alterar: \n1 - Gasolina \n2 - Álcool", "Digite um valor válido");
                    if (CombustivelOpcao == 1) {
                        double novoPrecoGasolina = IO.prinDouble("Preço atual da Gasolina: " + gasolina.getPreco() + "\nNovo preço: " , "Digite um valor válido");
                        gasolina.setPreco(novoPrecoGasolina);
                    } else if (CombustivelOpcao == 2) {
                        double novoPrecoAlcool = IO.prinDouble("Preço atual do Álcool: " + gasolina.getPreco() + "\nNovo preço: " , "Digite um valor válido");
                        alcool.setPreco(novoPrecoAlcool);
                    } else {
                        IO.prin("Opção inválida.");
                    }
                    break;
                case 6:
                    IO.prin("O faturamento das duas bombas é: " + (bombaAlcool.getFaturamento() + bombaGasolina.getFaturamento()));
                case 7:
                    IO.prin("Encerrando...");
                    return;
                default:
                    IO.prin("Opção inválida.");
            }
        }
    }
}