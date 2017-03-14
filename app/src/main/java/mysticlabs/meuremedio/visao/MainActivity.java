package mysticlabs.meuremedio.visao;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
//import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.zip.Inflater;

import mysticlabs.meuremedio.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentStatePagerAdapter adapterFragmentos;
    private GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));
        iniciaMapaNoFragmento();
//        adapterFragmentos = new viewPaging(getSupportFragmentManager());
//        ((ViewPager) findViewById(R.id.content_principal)).setAdapter(adapterFragmentos);
    }

    private SupportMapFragment mSupportMapFragment;

    private void iniciaMapaNoFragmento() {
        try{
//            LayoutInflater inflador = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            ((ViewPager)findViewById(R.id.content_principal)).addView(inflador.inflate(R.layout.mapa_fragmento,(null)));
//            mSupportMapFragment = SupportMapFragment.newInstance();
            mSupportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.content_principal);
            if (mSupportMapFragment == null) {
                FragmentManager fragmentManager =  getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                mSupportMapFragment = SupportMapFragment.newInstance();
                fragmentTransaction.replace(R.id.content_principal, mSupportMapFragment).commit();
            }

            if (mSupportMapFragment != null) {
                mSupportMapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        if (googleMap != null) {

                            googleMap.getUiSettings().setAllGesturesEnabled(true);

                            //-> marker_latlng // MAKE THIS WHATEVER YOU WANT
                            LatLng Home = new LatLng(-16.4638229, -54.6094163);
                            googleMap.addMarker(new MarkerOptions().position(Home).title("Marker in Rondonopolis"));
                            CameraPosition cameraPosition = new CameraPosition.Builder().target(Home).zoom(15.0f).build();
                            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
                            googleMap.moveCamera(cameraUpdate);

                        }

                    }
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        // Inflate menu to add items to action bar if it is present.
        //inflater.inflate(R.menu.main, menu);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_remedio) {
//            Intent intencao = new Intent ();
//            intencao.setClass(this,Mapa.class);
//            startActivity(intencao);
            //getSupportFragmentManager().beginTransaction().replace(R.id.content_principal,adapterFragmentos.getItem(0)).commit();
//            getSupportFragmentManager().beginTransaction().add(adapterFragmentos.getItem(0),"mapa");
            //getSupportFragmentManager().beginTransaction().replace();
            //getSupportFragmentManager().beginTransaction().add(MapFragment.newInstance(),"");
        } else if (id == R.id.nav_farmacia) {
//            iniciaPlacePicker();

        } else if (id == R.id.meus_pedidos) {

        } else if (id == R.id.nav_ajuda) {

        } else if (id == R.id.nav_sair) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private final int REQUEST_CODE_PLACEPICKER = 1;

    private void iniciaPlacePicker() {
        PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
        try{
            Intent intent = intentBuilder.build(this);
            startActivityForResult(intent,REQUEST_CODE_PLACEPICKER);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onStart() {
        System.out.println("onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        System.out.println("onResume");
        super.onResume();
    }

    @Override
    protected void onStop() {
        System.out.println("onStop");
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("onActivityResult");
        if (REQUEST_CODE_PLACEPICKER == requestCode){
            System.out.println("requestCode: "+requestCode);
            System.out.println("Intent: "+data.toString());
            displaySelectedPlaceFromPlacePicker(data);
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPostResume() {
        System.out.println("onPostResume");
        super.onPostResume();
    }

    private void displaySelectedPlaceFromPlacePicker(Intent data) {
        Place local = PlacePicker.getPlace(data,this);
        try{

            String nome = local.getName().toString();
            String end = local.getAddress().toString();
            Toast.makeText(this, "Nome: "+nome+" end: "+end, Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public class viewPaging extends FragmentStatePagerAdapter{

        Fragment oldFragment, mapa = null;
        FragmentManager mFM;
        public viewPaging(FragmentManager fm) {
            super(fm);
            mFM = fm;
        }

        @Override
        public Fragment getItem(int position) {
//
//            switch (position){
//                case 0:
//                    if (mapa == null) {
//
//                    }
//                    return mapa;

//            }
            return null;
        }

        @Override
        public int getCount() {
            return 1;
        }
    }

}
