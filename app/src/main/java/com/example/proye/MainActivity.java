package com.example.proye;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private Spinner spinner;
    private List<Personaje> personajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configurar DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Configurar el botón de toggle para abrir/cerrar el menú
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Inicializar vistas
        recyclerView = findViewById(R.id.recyclerView);
        spinner = findViewById(R.id.spinner_roles);

        // Lista de personajes
        personajes = new ArrayList<>();
        personajes.add(new Personaje("Ahri", "Mago", R.drawable.ahri, "Jonia", "Media", 4800, "2011-12-14", "Orbe del Engaño", 500, 350, true, "Ahri es una vastaya conectada de manera innata al poder latente de Runaterra..."));
        personajes.add(new Personaje("Darius", "Luchador", R.drawable.darius, "Noxus", "Fácil", 3150, "2012-05-23", "Guillotina Noxiana", 600, 300, false, "Darius es un líder implacable y poderoso en el ejército de Noxus."));
        personajes.add(new Personaje("Ezreal", "Tirador", R.drawable.ezreal, "Piltover", "Media", 4800, "2010-03-16", "Disparo Místico", 530, 375, true, "Ezreal es un explorador y aventurero que busca tesoros perdidos."));
        personajes.add(new Personaje("Leona", "Tanque", R.drawable.leona, "Monte Targon", "Media", 4800, "2011-07-13", "Eclipse Solar", 576, 302, false, "Leona es una guerrera sagrada del Monte Targon que utiliza los poderes del sol."));
        personajes.add(new Personaje("Zed", "Asesino", R.drawable.zed, "Jonia", "Alta", 4800, "2012-11-13", "Marca de la Sombra", 584, 200, false, "Zed es el líder de la Orden de la Sombra, un maestro de las artes oscuras."));

        // Configurar el RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PersonajeAdapter(personajes));

        // Lista de roles para el Spinner
        List<String> roles = new ArrayList<>();
        roles.add("Todos");
        roles.add("Mago");
        roles.add("Luchador");
        roles.add("Tirador");
        roles.add("Tanque");
        roles.add("Asesino");

        // Configurar el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Filtrado de personajes por rol
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedRole = roles.get(position);
                List<Personaje> filteredList = new ArrayList<>();
                for (Personaje personaje : personajes) {
                    if (selectedRole.equals("Todos") || personaje.getRol().equals(selectedRole)) {
                        filteredList.add(personaje);
                    }
                }
                recyclerView.setAdapter(new PersonajeAdapter(filteredList));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Manejar clics en el menú de navegación
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            // Acción para la opción "Home"
        } else if (id == R.id.nav_settings) {
            // Acción para la opción "Settings"
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        // Cerrar el menú si está abierto
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}