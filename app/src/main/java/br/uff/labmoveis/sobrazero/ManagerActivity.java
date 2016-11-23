package br.uff.labmoveis.sobrazero;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.uff.labmoveis.sobrazero.Listeners.IScreen;

public class ManagerActivity extends AppCompatActivity implements IScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        ManagerActivity.initializeClass();

        ManagerActivity.setCurrentActivity(this);

        Runnable ru = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(ManagerActivity.this, HomeScreen.class);
                startActivity(intent);
                ManagerActivity.closeLast();
            }
        };

        ru.run();

    }

    private static void closeLast() {
        lastActivity.finishActivity();
    }

    private static IScreen currentActivity;
    private static IScreen lastActivity;

    public static void setCurrentActivity(IScreen current)
    {
        if( lastActivity == null ) lastActivity = current;
        else lastActivity = current;
        currentActivity = current;
    }

    public static void initializeClass() {

    }


    @Override
    public void finishActivity() {
        finish();
    }
}
