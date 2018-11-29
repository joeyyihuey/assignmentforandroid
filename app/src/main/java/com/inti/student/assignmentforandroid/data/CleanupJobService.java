package com.inti.student.assignmentforandroid.data;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Teh on 29/11/2018.
 */

public class CleanupJobService extends JobService {
    private static final String TAG = CleanupJobService.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "Cleanup job started");
        new CleanupTask().execute(params);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    private class CleanupTask extends AsyncTask<JobParameters, Void, JobParameters> {

        @Override
        protected JobParameters doInBackground(JobParameters... params) {
            String where = String.format("%s = ?", TaskContract.TaskColumns.IS_COMPLETE);
            String[] args = {"1"};

            int count = getContentResolver().delete(TaskContract.CONTENT_URI, where, args);
            Log.d(TAG, "Cleaned up " + count + " completed tasks");

            return params[0];
        }

        @Override
        protected void onPostExecute(JobParameters jobParameters) {
            jobFinished(jobParameters, false);
        }
    }
}
