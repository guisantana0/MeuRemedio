package mysticlabs.meuremedio.visao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import mysticlabs.meuremedio.R;

/**
 * Created by Guilherme on 13/03/2017.
 */

public class MapaFragmento extends MapFragment {
    @Override
    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        super.getMapAsync(onMapReadyCallback);
        System.out.println("getMapAsync...");
    }


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        //return super.onCreateView(layoutInflater, viewGroup, bundle);
//        return layoutInflater.inflate(R.layout.mapa_fragmento,viewGroup,true);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }


}
