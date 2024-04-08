
// Classe que representa um tipo de combustível
class Combustivel {
    // Atributos
    private String tipo;
    private double preco;
    // Constructor
    public Combustivel (String tipo, double preco){
        this.tipo = tipo;
        this.preco = preco;
    }
    // getter
    public String getTipo() { return tipo; }
    public double getPreco() { return preco; }
    // setter
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPreco(Double preco) { this.preco = preco; }
}
