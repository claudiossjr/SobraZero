package br.uff.labmoveis.sobrazero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.uff.labmoveis.sobrazero.Listeners.IScreen;

public class ContactScreen extends AppCompatActivity implements IScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_screen);

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

    public void apertarBotao(View view){
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText("BIRLLLLLLL");
    }

    @Override
    public void finishActivity() {
        finish();
    }
}
