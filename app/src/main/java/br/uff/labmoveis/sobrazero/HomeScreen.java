package br.uff.labmoveis.sobrazero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Sobra Zero");
        setContentView(R.layout.activity_home_screen);
    }


    public void onClickSobras (View v ) {
        Intent intent = new Intent(HomeScreen.this, TelaSobras.class);
        startActivity(intent);
    }

    public void onClickVote (View v ) {
        Intent intent = new Intent(HomeScreen.this, VoteScreen.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_screens; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_screens, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        // Call Vote Screen
        else if (id == R.id.action_settings) {
            return true;
        }
        // Call tell us screen
        else if (id == R.id.action_user) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}