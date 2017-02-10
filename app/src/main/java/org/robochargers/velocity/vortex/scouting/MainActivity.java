package org.robochargers.velocity.vortex.scouting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import org.robochargers.velocity.vortex.rw.ReadWrite;
import org.robochargers.velocity.vortex.settings.AddTeamsSettingsActivity;
import org.robochargers.velocity.vortex.settings.GetTeamsSettingsActivity;
import org.robochargers.velocity.vortex.varibles.Variables;

import java.util.ArrayList;

public class MainActivity extends Activity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onOpenSettings(View view) {
        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(this);
        MenuInflater inflater = menu.getMenuInflater();
        inflater.inflate(R.menu.menu, menu.getMenu());
        menu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_teams:
                Intent intent = new Intent(this, AddTeamsSettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.get_teams:
                intent = new Intent(this, GetTeamsSettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.set_prematch_data:

                return true;
            case R.id.about:
                return true;
            case R.id.delete:
                ArrayList<String> empty = new ArrayList<>();
                ReadWrite.writeToFile(Variables.TEAM_LIST_FILE_NAME, empty, getBaseContext());
                return true;
            default:
                return false;
        }
    }
}
