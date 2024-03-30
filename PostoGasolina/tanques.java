
// Classe representando um tanque de combustível
class Tanque {
    // Atributos
    private double quantidadeLitros;
    private Combustivel tipoPreco;
    // Construtor
    public Tanque(Combustivel tipoPreco, double quantidade) {
        this.tipoPreco = tipoPreco;
        this.quantidadeLitros = quantidade; // Tanque cheio no início
    }
    // getter
    public double getQuantidade() { return quantidadeLitros; }
    public Combustivel getTipoPreco() { return tipoPreco; }
    // setter
    public void setQuantidade(double quantidade) { this.quantidadeLitros = quantidade; }   
    public void setCombustivel(Combustivel tipo_preco) {this.tipoPreco = tipo_preco;}
}