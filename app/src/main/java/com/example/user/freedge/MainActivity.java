package com.example.user.freedge;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.freedge.Fragments.ProductsFragment;
import com.example.user.freedge.Fragments.RecipesFragment;
import com.example.user.freedge.Fragments.SettingsFragment;


public class MainActivity extends AppCompatActivity {

    android.app.FragmentTransaction transaction;
    RecipesFragment recipes;
    ProductsFragment products;
    SettingsFragment settings;
    TextView toolBarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализируем элементы интерфейса
        toolBarText = findViewById(R.id.toolBarText);
        BottomNavigationView bottomNavigationMenu = findViewById(R.id.navigationMenu);

        // Инициализируем фрагметы активити
        products = new ProductsFragment();
        recipes = new RecipesFragment();
        settings = new SettingsFragment();

        // Инициплизируем обработчик нажатия на меню
        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_products) {
                    // Меняем надпись на тулбаре
                    toolBarText.setText(R.string.appbar_products);
                    // Устанавливаем активити в фрагменте
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.contentContainer, products);
                    transaction.commit();
                } else if (menuItem.getItemId() == R.id.action_recipes) {
                    // Меняем надпись на тулбаре
                    toolBarText.setText(R.string.appbar_recipes);
                    // Меняем активити в фрагменте
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.contentContainer, recipes);
                    transaction.commit();
                } else if (menuItem.getItemId() == R.id.action_settings) {
                    // Меняем надпись на тулбаре
                    toolBarText.setText(R.string.appbar_settings);
                    // Меняем активити в фрагменте
                    transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.contentContainer, settings);
                    transaction.commit();
                }
                return false;
            }
        });

        // Меняем надпись на тулбаре
        toolBarText.setText(R.string.appbar_products);

        // Устанавливаем активити в фрагменте
        transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contentContainer, products);
        transaction.commit();
    }

    public void onButton(View view){
        final Toast toast = Toast.makeText(getApplicationContext(),
                "Заработало", Toast.LENGTH_SHORT);
        toast.show();
    }

}