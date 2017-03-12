package mysticlabs.meuremedio.modelo;

/**
 * Created by Guilherme on 11/03/2017.
 */

public class Produto {
    private String nome;
    private String descricao;
    private String preco;
    private double mPreco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public double getmPreco() {
        return mPreco;
    }

    public void setmPreco(double mPreco) {
        this.mPreco = mPreco;
    }
}
