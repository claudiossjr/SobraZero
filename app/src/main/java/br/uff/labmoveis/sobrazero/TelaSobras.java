package br.uff.labmoveis.sobrazero;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.uff.labmoveis.sobrazero.Models.IScreen;

public class TelaSobras extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, IScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_sobras);

        ManagerActivity.setCurrentActivity(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_tela_sobras);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button bExit = (Button) findViewById(R.id.btnExit);
        bExit.setOnClickListener(getExitListener(this));

        TextView tView = (TextView) findViewById(R.id.textView);
        tView.setOnClickListener(getSaibaMaisListener(this));
    }

    private View.OnClickListener getSaibaMaisListener(final IScreen homeScreen) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaSobras.this, SaibaMais.class);
                startActivity(intent);
                homeScreen.finishActivity();
            }
        };
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.ver_resto) {
            Toast.makeText(this, "Você já está na tela de sobras", Toast.LENGTH_SHORT);
        } else if (id == R.id.vote_refeicao) {
            Intent intent = new Intent(TelaSobras.this, VoteScreen.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.fale_conosco) {
            Intent intent = new Intent(TelaSobras.this, ContactScreen.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.home) {
            Intent intent = new Intent(TelaSobras.this, HomeScreen.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.login_admin) {
            Intent intent = new Intent(TelaSobras.this, HomeAdmin.class);
            startActivity(intent);
            finishActivity();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_tela_sobras);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public View.OnClickListener getExitListener(final IScreen hmScreen)
    {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                hmScreen.finishActivity();
            }
        };
    }



    @Override
    public void finishActivity() {
        finish();
    }
}
