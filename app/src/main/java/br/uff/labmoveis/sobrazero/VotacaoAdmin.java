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
import android.widget.EditText;
import android.widget.Toast;

import br.uff.labmoveis.sobrazero.Models.DataConsuming;
import br.uff.labmoveis.sobrazero.Models.IScreen;

public class VotacaoAdmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, IScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacao_admin);

        ManagerActivity.setCurrentActivity(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_votacao_admin);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button bExit = (Button) findViewById(R.id.btnExit);
        bExit.setOnClickListener(getExitListener(this));

        Button bSalvarVotacao = (Button) findViewById(R.id.btnSalvarVotacao);
        bSalvarVotacao.setOnClickListener(getSalvarVotacaoListener());

    }

    private View.OnClickListener getSalvarVotacaoListener() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DataConsuming dc = DataConsuming.getINSTANCE();

                EditText edAlimento1 = (EditText) findViewById(R.id.etAliemento1);
                EditText edAlimento2 = (EditText) findViewById(R.id.etAliemento2);
                EditText edAlimento3 = (EditText) findViewById(R.id.etAliemento3);

                dc.setAlimento1(edAlimento1.getText().toString());
                dc.setAlimento2(edAlimento2.getText().toString());
                dc.setAlimento3(edAlimento3.getText().toString());

                Intent intent = new Intent(VotacaoAdmin.this, HomeAdmin.class);
                startActivity(intent);
                finishActivity();

            }
        };

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.statistics) {
            Intent intent = new Intent(VotacaoAdmin.this, StatisticsScreen.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.edit_saudacao) {
            Intent intent = new Intent(VotacaoAdmin.this, SaudacaoEdicao.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.edit_votacao) {
            Toast.makeText(this, "Você já está na Home", Toast.LENGTH_SHORT );
        } else if (id == R.id.home) {
            Intent intent = new Intent(VotacaoAdmin.this, HomeAdmin.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.logout_admin) {
            Intent intent = new Intent(VotacaoAdmin.this, HomeScreen.class);
            startActivity(intent);
            finishActivity();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_votacao_admin);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void finishActivity() {
        finish();
    }
}
