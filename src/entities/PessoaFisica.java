package entities;

public class PessoaFisica extends Pessoa {

    private Double gastosComSaude;

    public PessoaFisica () {

    }

    public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    public Double getGastosComSaude() {
        return gastosComSaude;
    }

    public void setGastosComSaude(Double gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public Double impostoArrecadado () {
        if (rendaAnual < 20000.0) {
            return rendaAnual * 0.15;
        } else if (rendaAnual >= 20000.0) {
            return rendaAnual * 0.25;
        } else if (gastosComSaude != 0.0 && rendaAnual < 20000.0) {
            return rendaAnual * 0.15 - gastosComSaude * 0.5;
        } else if (gastosComSaude != 0 && rendaAnual >= 20000.0) {
            return rendaAnual * 0.25 - gastosComSaude * 0.5;
        } else {
            return null;
        }
    }

}
