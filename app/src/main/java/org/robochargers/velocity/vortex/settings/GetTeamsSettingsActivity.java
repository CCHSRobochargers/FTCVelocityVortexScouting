package org.robochargers.velocity.vortex.settings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


import org.robochargers.velocity.vortex.rw.ReadWrite;
import org.robochargers.velocity.vortex.scouting.R;
import org.robochargers.velocity.vortex.varibles.Variables;

import java.util.ArrayList;


public class GetTeamsSettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_teams_settings);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayList<String> list = ReadWrite.readFromFile(Variables.TEAM_LIST_FILE_NAME, getBaseContext());
        String finalList = "";
        for (int c = 0; c < list.size(); c++) {
            finalList = finalList + list.get(c) + "\n";
        }

        TextView teamView = (TextView) findViewById(R.id.team_list_view);
        teamView.setText(finalList);
    }
}
