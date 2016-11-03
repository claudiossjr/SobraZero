package sobrazero.sobrazero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickVisSobra(View v) {
        Intent intent = new Intent(MainActivity.this, TelaSobras.class);
        startActivity(intent);
    }
}
