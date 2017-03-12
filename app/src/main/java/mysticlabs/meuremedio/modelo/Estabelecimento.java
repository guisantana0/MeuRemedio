package mysticlabs.meuremedio.modelo;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Guilherme on 11/03/2017.
 */

public class Estabelecimento {

    private LatLng ponto;
    private String nome;

    public LatLng getPonto() {
        return ponto;
    }

    public void setPonto(LatLng ponto) {
        this.ponto = ponto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
