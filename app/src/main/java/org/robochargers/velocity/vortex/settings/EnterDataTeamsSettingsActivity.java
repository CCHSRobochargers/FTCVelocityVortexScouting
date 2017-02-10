package org.robochargers.velocity.vortex.settings;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.robochargers.velocity.vortex.scouting.R;
import org.robochargers.velocity.vortex.varibles.Variables;

public class EnterDataTeamsSettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data_teams_settings);
        TextView teamName =  (TextView) findViewById(R.id.team_name_data);
        teamName.setText(Variables.TEAM_DATA_NAME);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
