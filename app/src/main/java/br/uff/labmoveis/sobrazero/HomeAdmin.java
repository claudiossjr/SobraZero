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
import android.widget.Toast;

import br.uff.labmoveis.sobrazero.Models.IScreen;

public class HomeAdmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, IScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        ManagerActivity.setCurrentActivity(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_home_admin);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    Button bExit = (Button) findViewById(R.id.btnExit);
    bExit.setOnClickListener(getExitListener(this));
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

    public void onClickStats (View v ) {
        Intent intent = new Intent(HomeAdmin.this, StatisticsScreen.class);
        startActivity(intent);
        finishActivity();
    }

    public void onClickEditSaud (View v ) {
        Intent intent = new Intent(HomeAdmin.this, SaudacaoEdicao.class);
        startActivity(intent);
        finishActivity();
    }

    public void onClickVoteAdmin (View v ) {
        Intent intent = new Intent(HomeAdmin.this, VotacaoAdmin.class);
        startActivity(intent);
        finishActivity();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.statistics) {
            Intent intent = new Intent(HomeAdmin.this, StatisticsScreen.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.edit_saudacao) {
            Intent intent = new Intent(HomeAdmin.this, SaudacaoEdicao.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.edit_votacao) {
            Intent intent = new Intent(HomeAdmin.this, VotacaoAdmin.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.home) {
            Toast.makeText(this, "Você já está na Home", Toast.LENGTH_SHORT );
        } else if (id == R.id.logout_admin) {
            Intent intent = new Intent(HomeAdmin.this, HomeScreen.class);
            startActivity(intent);
            finishActivity();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_home_admin);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void finishActivity() {
        finish();
    }
}
