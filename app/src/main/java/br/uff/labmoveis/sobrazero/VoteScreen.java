package br.uff.labmoveis.sobrazero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.uff.labmoveis.sobrazero.Listeners.IScreen;

public class VoteScreen extends AppCompatActivity implements IScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_screen);

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

    @Override
    public void finishActivity() {
        finish();
    }
}
