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

import br.uff.labmoveis.sobrazero.Models.DataConsuming;
import br.uff.labmoveis.sobrazero.Models.IScreen;

public class StatisticsScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, IScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_screen);

        ManagerActivity.setCurrentActivity(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_statistics_screen);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button bExit = (Button) findViewById(R.id.btnExit);
        bExit.setOnClickListener(getExitListener(this));

        InitComponents();

    }

    private void InitComponents() {
        TextView tv1 = (TextView) findViewById(R.id.vot1);
        TextView tv2 = (TextView) findViewById(R.id.vot2);
        TextView tv3 = (TextView) findViewById(R.id.vot3);

        DataConsuming dc = DataConsuming.getINSTANCE();

        if (dc.getTotalVotos() > 0)
        {
            double porcentagem1 = ((float)dc.getVotosAliment1()/(float)dc.getTotalVotos())*100;
            double porcentagem2 = ((float)dc.getVotosAliment2()/(float)dc.getTotalVotos())*100;
            double porcentagem3 = ((float)dc.getVotosAliment3()/(float)dc.getTotalVotos())*100;
            tv1.setText(dc.getAlimento1() + " " + porcentagem1 + " %");
            tv2.setText(dc.getAlimento2() + " " + porcentagem2 + " %");
            tv3.setText(dc.getAlimento3() + " " + porcentagem3 + " %");
        }
        else
        {
            tv1.setText("");
            tv2.setText("");
            tv3.setText("");
        }
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
            Toast.makeText(this, "Você já está na Tela de estatistica", Toast.LENGTH_SHORT );
        } else if (id == R.id.edit_saudacao) {
            Intent intent = new Intent(StatisticsScreen.this, SaudacaoEdicao.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.edit_votacao) {
            Intent intent = new Intent(StatisticsScreen.this, VotacaoAdmin.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.home) {
            Intent intent = new Intent(StatisticsScreen.this, HomeAdmin.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.logout_admin) {
            Intent intent = new Intent(StatisticsScreen.this, HomeScreen.class);
            startActivity(intent);
            finishActivity();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_statistics_screen);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void finishActivity() {
        finish();
    }
}
