package entities;

public class PessoaJuridica extends Pessoa{

    private Integer numeroFuncionarios;

    public PessoaJuridica () {

    }

    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public Integer getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(Integer numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public Double impostoArrecadado () {
        if (numeroFuncionarios > 10) {
            return rendaAnual * 0.14;
        } else {
            return rendaAnual * 0.16;
        }
    }

}
