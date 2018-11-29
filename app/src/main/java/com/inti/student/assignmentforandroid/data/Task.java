package com.inti.student.assignmentforandroid.data;
import android.database.Cursor;

import static com.inti.student.assignmentforandroid.data.TaskContract.getColumnInt;
import static com.inti.student.assignmentforandroid.data.TaskContract.getColumnLong;
import static com.inti.student.assignmentforandroid.data.TaskContract.getColumnString;

/**
 * Created by Teh on 29/11/2018.
 */

public class Task {


    public static final long NO_DATE = Long.MAX_VALUE;
    public static final long NO_ID = -1;


    public long id;
    public final String description;
    public final boolean isComplete;
    public final boolean isPriority;
    public final long dueDateMillis;


    public Task(String description, boolean isComplete, boolean isPriority, long dueDateMillis) {
        this.id = NO_ID;
        this.description = description;
        this.isComplete = isComplete;
        this.isPriority = isPriority;
        this.dueDateMillis = dueDateMillis;
    }

    public Task(String description, boolean isComplete, boolean isPriority) {
        this(description, isComplete, isPriority, NO_DATE);
    }

    public Task(Cursor cursor) {
        this.id = getColumnLong(cursor, TaskContract.TaskColumns._ID);
        this.description = getColumnString(cursor, TaskContract.TaskColumns.DESCRIPTION);
        this.isComplete = getColumnInt(cursor, TaskContract.TaskColumns.IS_COMPLETE) == 1;
        this.isPriority = getColumnInt(cursor, TaskContract.TaskColumns.IS_PRIORITY) == 1;
        this.dueDateMillis = getColumnLong(cursor, TaskContract.TaskColumns.DUE_DATE);
    }

    public boolean hasDueDate() {
        return this.dueDateMillis != Long.MAX_VALUE;
    }

}

