package org.robochargers.velocity.vortex.settings;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.robochargers.velocity.vortex.rw.ReadWrite;
import org.robochargers.velocity.vortex.scouting.MainActivity;
import org.robochargers.velocity.vortex.scouting.R;
import org.robochargers.velocity.vortex.varibles.Variables;

import java.util.ArrayList;

public class AddTeamsSettingsActivity extends Activity {
    EditText number;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teams_settings);
        number = (EditText) findViewById(R.id.team_number);
        name = (EditText) findViewById(R.id.team_name);
    }

    public void onSave(View view) {
        Variables.TEAM_LIST = ReadWrite.readFromFile(Variables.TEAM_LIST_FILE_NAME, getBaseContext());
        Variables.TEAM_LIST.add(String.valueOf(number.getText()));

        ReadWrite.writeToFile(Variables.TEAM_LIST_FILE_NAME, Variables.TEAM_LIST, getBaseContext());

        ArrayList<String> st = ReadWrite.readFromFile(Variables.TEAM_LIST_FILE_NAME, getBaseContext());
        Log.i("Length", String.valueOf(st.size()));
        for (int c = 0; c < st.size(); c++) {
            Log.i(String.valueOf(c) + "a", st.get(c));
        }



        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCancel(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
