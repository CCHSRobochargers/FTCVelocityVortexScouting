package org.robochargers.velocity.vortex.settings;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        final ArrayList<String> list = ReadWrite.readFromFile(Variables.TEAM_LIST_FILE_NAME, getBaseContext());
        String finalList = "";
        for (int c = 0; c < list.size(); c++) {
            finalList = finalList + list.get(c) + "\n";
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view, list);
        ListView view = (ListView) findViewById(R.id.team_list);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Variables.TEAM_DATA_NAME = list.get(position);
                Intent intent = new Intent(getBaseContext(), EnterDataTeamsSettingsActivity.class);
                startActivity(intent);

            }
        });
    }
}
