package delta.nitt.com.censusx;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class IntialActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intial);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try
        {
            getSupportActionBar().hide();
        }
        catch (Exception e)
        {
            Log.d(Utilities.getTAG(),"Exception : "+e);
        }
        new WaitingSplashscreen().execute();
        FrameLayout fl = (FrameLayout)findViewById(R.id.fullscreen_layout);
        fl.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public class WaitingSplashscreen extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... params)
        {
            try
            {
                Thread.sleep(3000);
            } catch (InterruptedException e)
            {
                Log.e(Utilities.getTAG(),"Exception : "+e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);
            //Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            Intent intent = new Intent(getApplicationContext(),CensusActivity.class);
            startActivity(intent);
        }
    }
}


