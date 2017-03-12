package mysticlabs.meuremedio.modelo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Guilherme on 11/03/2017.
 */

public class Motor_interno {

    //Aqui vou guardar a referencia das categorias que tem de estabelecimentos:
    ArrayList<String> CATEGORIAS;

    //aqui vai guardar as referencias dos pontos;
    //Onde o primeiro campo é o tipo do estabelecimento e o segundo é a lista de estabelecimentos desse tipo nome do estabelecimento
     HashMap<String,ArrayList<Estabelecimento>> CATEGORIA_ESTABELECIMENTO;

    //Aqui vou guardar as referencias da lista de produtos do estabelecimento:
     HashMap<String,ArrayList<Produto>> LISTA_DE_PRODUTOS;

    public void Recupera_categorias(){
        //Pega a instancia do firebase;

        //Firebase blabla

        //faz o get da lista de categorias

        //CATEGORIAS = resultadoJSON;
    }


    public void Recupera_estabelecimentos(){

        //Abre a conexao com o firebase

        //Pega os dados do servidor em JSON

        //coloca
    }


}
