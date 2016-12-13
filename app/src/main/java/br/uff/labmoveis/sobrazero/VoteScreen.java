package br.uff.labmoveis.sobrazero;

import android.content.Intent;
import android.provider.ContactsContract;
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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import br.uff.labmoveis.sobrazero.Models.DataConsuming;
import br.uff.labmoveis.sobrazero.Models.IScreen;

public class VoteScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, IScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_screen);

        ManagerActivity.setCurrentActivity(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_vote_screen);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Button bExit = (Button) findViewById(R.id.btnExit);
        bExit.setOnClickListener(getExitListener(this));

        Button bSendVote = (Button) findViewById(R.id.btnSendVote);
        bSendVote.setOnClickListener(getSendVote());

        TextView tView = (TextView) findViewById(R.id.textView);
        tView.setOnClickListener(getSaibaMaisListener(this));

        InitComponent();
    }

    private void InitComponent() {
        DataConsuming dc = DataConsuming.getINSTANCE();

        RadioButton rdAliment1 = (RadioButton) findViewById(R.id.rbAlimento1);
        RadioButton rdAliment2 = (RadioButton) findViewById(R.id.rbAlimento2);
        RadioButton rdAliment3 = (RadioButton) findViewById(R.id.rbAlimento3);

        rdAliment1.setText(dc.getAlimento1());
        rdAliment2.setText(dc.getAlimento2());
        rdAliment3.setText(dc.getAlimento3());
    }

    private View.OnClickListener getSendVote() {
        return new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                RadioButton rdAlimento1 = (RadioButton) findViewById(R.id.rbAlimento1);
                RadioButton rdAlimento2 = (RadioButton) findViewById(R.id.rbAlimento2);
                RadioButton rdAlimento3 = (RadioButton) findViewById(R.id.rbAlimento3);

                DataConsuming dc = DataConsuming.getINSTANCE();

                if (rdAlimento1.isChecked()){
                    dc.incrementaVoto1();
                } else if (rdAlimento2.isChecked()){
                    dc.incrementaVoto2();
                } else if (rdAlimento3.isChecked()){
                    dc.incrementaVoto3();
                }

                Intent intent = new Intent(VoteScreen.this, HomeScreen.class);
                startActivity(intent);
                finishActivity();
            }
        };
    }

    private View.OnClickListener getSaibaMaisListener(final IScreen homeScreen) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VoteScreen.this, SaibaMais.class);
                startActivity(intent);
                homeScreen.finishActivity();
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

        if (id == R.id.ver_resto) {
            Intent intent = new Intent(VoteScreen.this, TelaSobras.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.vote_refeicao) {
            Toast.makeText(this, "Já está na tela de sobras", Toast.LENGTH_SHORT);
        } else if (id == R.id.fale_conosco) {
            Intent intent = new Intent(VoteScreen.this, ContactScreen.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.home) {
            Intent intent = new Intent(VoteScreen.this, HomeScreen.class);
            startActivity(intent);
            finishActivity();
        } else if (id == R.id.login_admin) {
            Intent intent = new Intent(VoteScreen.this, HomeAdmin.class);
            startActivity(intent);
            finishActivity();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_vote_screen);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void finishActivity() {
        finish();
    }
}
