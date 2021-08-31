package Gestionale;

public class OrdineFornitore {
    Integer num_pezzi;
    String codice, nomeProdotto, fornitore;

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getCodice() {
        return codice;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setFornitore(String fornitore) {
        this.fornitore = fornitore;
    }

    public String getFornitore() {
        return fornitore;
    }

    public void setNum_pezzi(Integer num_pezzi) {
        this.num_pezzi = num_pezzi;
    }

    public Integer getNum_pezzi() {
        return num_pezzi;
    }
}
