import java.lang.reflect.Array;
import java.util.ArrayList;
import packages.IO;

// Classe principal para gerenciar o posto de combustível
public class main {
    public static void main(String[] args) {
        Combustivel alcool = new Combustivel("Alcool", 5.0);
        Combustivel gasolina = new Combustivel("Gasolina", 8.0);
        Tanque tanqueGasolina = new Tanque(gasolina, 1000); // Tanque de gasolina com capacidade de 1000 litros
        Tanque tanqueAlcool = new Tanque(alcool, 2000); // Tanque de alcool com capacidade de 800 litros
        ArrayList<Bomba> bombas = new ArrayList<Bomba>();

            while (true) {
            int opcao = IO.prinInt(
            "\n----------------------------------"
            + "\n\tPOSTO DE GASOLINA"   
            + "\n----------------------------------"
            + "\nEscolha uma opção:" 
            + "\n1 - Abastecer"
            + "\n2 - Ver combustível sobrando no tanque"
            + "\n3 - Alterar manualmente a quantidade de combustível em um tanque"
            + "\n4 - Editar preço do combustível"
            + "\n5 - Faturamento total"
            + "\n6 - Cadastrar uma nova bomba"
            + "\n7 - Sair", "Digite uma opção válida\n");

            switch (opcao) {
                case 1:
                    // Abastecer por litro ou por valor
                    if (bombas.size() != 0) {
                        int tipoCase1 = IO.prinInt("Escolha o tipo de combustível: \n1 - Gasolina \n2 - Álcool", "Digite um valor válido");
                        if (tipoCase1 == 1) {
                            for(Bomba bomba: bombas) {
                                if (bomba.getTanque() == tanqueGasolina) {
                                   IO.prin("\n-----------------------"
                                    + "\nBomba ID: " + bomba.getId()  
                                    + "\n-----------------------" 
                                    + "\nTanque: " + bomba.getTanque()
                                    + "\nFaturamento: " + bomba.getFaturamento());
                                } 
                            } 
                            int bombaId = IO.prinInt("Digita o ID da bomba de gasolina escolhida: ", "Digite um valor válido");
                            for(Bomba bomba: bombas) {
                                if (bomba.getId() == bombaId) {
                                    bomba.abastecer(tanqueGasolina);
                                    break;
                                }  
                            }
                            IO.prin("Abastecimento de gasolina realizado com sucesso.");
                        } else if (tipoCase1 == 2) {
                            for(Bomba bomba: bombas) {
                                if (bomba.getTanque() == tanqueAlcool) {
                                   IO.prin("\n-----------------------"
                                    + "\nBomba ID: " + bomba.getId()  
                                    + "\n-----------------------" 
                                    + "\nTanque: " + bomba.getTanque()
                                    + "\nFaturamento: " + bomba.getFaturamento());
                                } 
                            } 
                            int bombaId = IO.prinInt("Digita o ID da bomba de álcool escolhida: ", "Digite um valor válido");
                            for(Bomba bomba: bombas) {
                                if (bomba.getId() == bombaId) {
                                    bomba.abastecer(tanqueAlcool);
                                    break;
                                }  
                            }
                            IO.prin("Abastecimento de Álcool realizado com sucesso.");
                        } else {
                            IO.prin("Opção inválida.");
                        }
                    } else {
                        IO.prin("Não há bombas cadastradas, por favor crie uma antes de abastecer.");
                    }
                    break;
                case 2:
                    // Exibir quantidade de combustível em cada tanque
                    IO.prin("Combustível no tanque:");
                    IO.prin("Gasolina: " + tanqueGasolina.getQuantidade() + " litros");
                    IO.prin("Alcool: " + tanqueAlcool.getQuantidade() + " litros");
                    break;
                case 3:
                    // Alterar manualmente a quantidade de combustível em um tanque específico
                    int tanqueOpcao = IO.prinInt("Escolha o tanque que deseja alterar: \n1 - Gasolina \n2 - Álcool", "Digite um valor válido");
                    if (tanqueOpcao == 1) {
                        IO.prin("Digite a nova quantidade de gasolina(em litros):");
                        double novaQuantidade = IO.lerDouble();
                        tanqueGasolina.setQuantidade(novaQuantidade);
                        IO.prin("Quantidade de gasolina alterada com sucesso.");
                    } else if (tanqueOpcao == 2) {
                        IO.prin("Digite a nova quantidade de álcool(em litros):");
                        double novaQuantidade = IO.lerDouble();
                        tanqueAlcool.setQuantidade(novaQuantidade);
                        IO.prin("Quantidade de alcool alterada com sucesso.");
                    } else {
                        IO.prin("Opção inválida.");
                    }
                    break;
                case 4:
                    // Editar preço do combustivel
                    int CombustivelOpcao = IO.prinInt("Escolha o tipo de combustível que deseja alterar: \n1 - Gasolina \n2 - Álcool", "Digite um valor válido");
                    if (CombustivelOpcao == 1) {
                        double novoPrecoGasolina = IO.prinDouble("Preço atual da Gasolina: " + gasolina.getPreco() +" BRL" + "\nNovo preço: " , "Digite um valor válido");
                        gasolina.setPreco(novoPrecoGasolina);
                    } else if (CombustivelOpcao == 2) {
                        double novoPrecoAlcool = IO.prinDouble("Preço atual do Álcool: " + gasolina.getPreco() +" BRL" + "\nNovo preço: " , "Digite um valor válido");
                        alcool.setPreco(novoPrecoAlcool);
                    } else {
                        IO.prin("Opção inválida.");
                    }
                    break;
                case 5:
                    // Faturamento total das bombas
                    if (bombas.size() != 0) {
                        int tipoCase1 = IO.prinInt("Escolha o tipo das bombas para ver o faturamento: \n1 - Gasolina \n2 - Álcool \n3 - Todas", "Digite um valor válido");
                        int total = 0;
                        if (tipoCase1 == 1) {
                            for(Bomba bomba: bombas) {
                                if (bomba.getTanque() == tanqueGasolina) {
                                   total += bomba.getFaturamento();
                                } 
                            } 
                            IO.prin( "\nFaturamento: " + total + " BRL");
                        } else if (tipoCase1 == 2) {
                            for(Bomba bomba: bombas) {
                                if (bomba.getTanque() == tanqueAlcool) {
                                    total += bomba.getFaturamento();
                                } 
                            } 
                            IO.prin( "\nFaturamento: " + total +" BRL");
                        } else if (tipoCase1 == 3) {
                            for(Bomba bomba: bombas) {
                                total += bomba.getFaturamento();
                            } 
                            IO.prin( "\nFaturamento: " + total +" BRL");
                        } else {
                            IO.prin("Opção inválida.");
                        }
                    } else {
                        IO.prin("Não há bombas cadastradas, por favor crie uma antes de ver o faturamento.");
                    }
                    break;
                case 6:
                    // Cadastro de bombas
                        int id = IO.prinInt("Digite o ID(número inteiro) da bomba: ", "Digite um valor válido");
                        boolean value = false;
                        for(Bomba bomba: bombas) {
                            if (bomba.getId() == id) {
                                IO.prin("A bomba tem o identidicador(ID) repetido, tente de novo");
                                value = true;
                                break;
                            } 
                        }
                        if (value == false) {
                            int Tanqueopcao = IO.prinInt("Escolha o tanque que vai estar relacionado com sua bomba: \n1 - Tanque Gasolina \n2 - Tanque Álcool", "Digite um valor válido");
                            if (Tanqueopcao == 1) {
                                Bomba novaBomba = new Bomba(id, tanqueGasolina, 0.0);
                                bombas.add(novaBomba);
                                IO.prin("Bomba de gasolina cadastrada com sucesso!");
                                break;
                            } else if (Tanqueopcao == 2) {
                                Bomba novaBomba = new Bomba(id, tanqueAlcool, 0.0);
                                bombas.add(novaBomba);
                                IO.prin("Bomba de álcool cadastrada com sucesso!");
                                break;
                            } else {
                                IO.prin("Opção inválida.");
                            }     
                        }
                        break;
                case 7:
                    IO.prin("Encerrando...");
                    return;                    
                default:
                    IO.prin("Opção inválida.");
            }
        }
    }
}