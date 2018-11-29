package com.inti.student.assignmentforandroid.data;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Teh on 29/11/2018.
 */

public class TaskContract {
    public static final String TABLE_TASKS = "tasks";
    public static final String CONTENT_AUTHORITY = "com.inti.student.assignmentforandroid";
    public static final String DEFAULT_SORT = String.format("%s ASC, %s DESC, %s ASC",
            TaskColumns.IS_COMPLETE, TaskColumns.IS_PRIORITY, TaskColumns.DUE_DATE);
    public static final String DATE_SORT = String.format("%s ASC, %s ASC, %s DESC",
            TaskColumns.IS_COMPLETE, TaskColumns.DUE_DATE, TaskColumns.IS_PRIORITY);
    public static final Uri CONTENT_URI = new Uri.Builder().scheme("content")
            .authority(CONTENT_AUTHORITY)
            .appendPath(TABLE_TASKS)
            .build();

    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString( cursor.getColumnIndex(columnName) );
    }

    public static int getColumnInt(Cursor cursor, String columnName) {
        return cursor.getInt( cursor.getColumnIndex(columnName) );
    }

    public static long getColumnLong(Cursor cursor, String columnName) {
        return cursor.getLong( cursor.getColumnIndex(columnName) );
    }



    public static final class TaskColumns implements BaseColumns {

        public static final String DESCRIPTION = "description";

        public static final String IS_COMPLETE = "is_complete";

        public static final String IS_PRIORITY = "is_priority";

        public static final String DUE_DATE = "due_date";
    }


}
