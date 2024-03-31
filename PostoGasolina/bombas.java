import packages.IO;

// {}

class Bomba {
    // Atributos
    private int id;
    private Tanque tanque;
    private double faturamento;
    // Construtor
    public Bomba(int id, Tanque tanque, double faturamento) {
        this.id = id;
        this.tanque = tanque;
        this.faturamento = faturamento;
    }
    // getter
    public int getId() { return id; }
    public Tanque getTanque() { return tanque; }
    public double getFaturamento() { return faturamento; }
    // setter
    public void setId(int id) { this.id = id; }
    public void setTanque(Tanque tanque) { this.tanque = tanque; }
    public void setFaturamento(double faturamento) {this.faturamento = faturamento; }
    // Método Abastecer 
    public void abastecer(Tanque tanque) {
        int option = IO.prinInt("Como vai abastecer? \n1 - Reais \n2 - Litros", "Digite uma opção válida\n");
        double preco = tanque.getTipoPreco().getPreco();
        double quantidade = tanque.getQuantidade();
        double faturamento = getFaturamento();
        switch (option) {
            case 1:
                double reais = IO.prinDouble("Quantos reais vai abastecer?", "Digite valores válidos");
                double litrosReais = reais / preco;
                tanque.setQuantidade(quantidade - litrosReais);
                setFaturamento(faturamento + reais);
                break;
            case 2:
                double litros = IO.prinDouble("Quantos litros vai abastecer?", "Digite valores válidso");
                tanque.setQuantidade(quantidade - litros);
                double valor = litros * preco;
                setFaturamento(faturamento + valor);
                break;
            default:
                IO.prin("Opção inválida.");
    
        }
    }

    //Método Vender
    public void vender() {
        double litrosCompra = IO.prinDouble("Quantos litros deseja comprar?", "Digite valores válidos");
        double preco = tanque.getTipoPreco().getPreco();
        double faturamento = getFaturamento();
        double quantidade = tanque.getQuantidade();
        if (quantidade < litrosCompra) {
            IO.prin("Desculpe, combustível insuficiente.");
        } else {
            tanque.setQuantidade(quantidade - litrosCompra);
            double total = preco * litrosCompra;
            setFaturamento(faturamento + total);
            IO.prin("Venda realizada com sucesso. Quantidade vendida: " + litrosCompra + " litros");
            IO.prin("Valor total da venda: R$ " + total);
        }
        
    }
}