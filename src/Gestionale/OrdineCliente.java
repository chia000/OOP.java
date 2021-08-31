package Gestionale;

public class OrdineCliente {

    Integer num_pezzi;
    String codice, nomeProdotto, cf;

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public void setNum_pezzi(Integer num_pezzi) {
        this.num_pezzi = num_pezzi;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public Integer getNum_pezzi() {
        return num_pezzi;
    }

    public String getCodice() {
        return codice;
    }

    public String getCf() {
        return cf;
    }
}
