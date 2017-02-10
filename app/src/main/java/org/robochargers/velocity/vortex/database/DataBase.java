package org.robochargers.velocity.vortex.database;

import android.provider.BaseColumns;

/**
 * Created by CAD1 on 2/8/2017.
 */

public class DataBase {
    private DataBase() {}
    public static final String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + DataEntry.TABLE_NAME + " (" +
        DataEntry._ID + " INTEGER PRIMARY KEY," +
        DataEntry.COLUMN_TEAM_NUMBER + " TEXT," +
        DataEntry.COLUMN_TEAM_NAME + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + DataEntry.TABLE_NAME;

    public static class DataEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_TEAM_NUMBER = "number";
        public static final String COLUMN_TEAM_NAME = "name";
    }
}
