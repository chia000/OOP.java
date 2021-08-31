package Gestionale;

public class Prodotto {
    Integer num_pezzi;
    String codice, nome, marca;
    Double prezzo;

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNum_pezzi(Integer num_pezzi) {
        this.num_pezzi = num_pezzi;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getCodice() {
        return codice;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNum_pezzi() {
        return num_pezzi;
    }
}
