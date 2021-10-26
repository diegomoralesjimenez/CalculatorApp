package com.vulcuscr.calculator.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.Uri;
import android.widget.Toast;

import com.microsoft.appcenter.distribute.Distribute;
import com.microsoft.appcenter.distribute.DistributeListener;
import com.microsoft.appcenter.distribute.ReleaseDetails;
import com.microsoft.appcenter.distribute.UpdateAction;

import com.vulcuscr.calculator.R;


public class AppCenterDistributeListener  implements DistributeListener {
    public AppCenterDistributeListener(boolean isManual){
        this.isManual = isManual;
    }
    public AppCenterDistributeListener(){
        this(false);
    }
    @Override
    public boolean onReleaseAvailable(Activity activity, ReleaseDetails releaseDetails) {

        // Look at releaseDetails public methods to get version information, release notes text or release notes URL
        String versionName = releaseDetails.getShortVersion();
        int versionCode = releaseDetails.getVersion();
        String releaseNotes = releaseDetails.getReleaseNotes();
        Uri releaseNotesUrl = releaseDetails.getReleaseNotesUrl();

        // Build our own dialog title and message
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);

        dialogBuilder.setTitle(activity.getString(com.microsoft.appcenter.distribute.R.string.appcenter_distribute_update_dialog_title) + " ["+versionName+"]");
        dialogBuilder.setMessage(releaseNotes);

        // Mimic default SDK buttons
        dialogBuilder.setPositiveButton(com.microsoft.appcenter.distribute.R.string.appcenter_distribute_update_dialog_download, (dialog, which) -> {

            // This method is used to tell the SDK what button was clicked
            Distribute.notifyUpdateAction(UpdateAction.UPDATE);
        });

        // We can postpone the release only if the update isn't mandatory
        if (!releaseDetails.isMandatoryUpdate()) {
            dialogBuilder.setNegativeButton(com.microsoft.appcenter.distribute.R.string.appcenter_distribute_update_dialog_postpone, (dialog, which) -> {

                // This method is used to tell the SDK what button was clicked
                Distribute.notifyUpdateAction(UpdateAction.POSTPONE);
            });
        }
        dialogBuilder.setCancelable(false); // if it's cancelable you should map cancel to postpone, but only for optional updates
        dialogBuilder.create().show();

        // Return true if you're using your own dialog, false otherwise
        return true;
    }

    @Override
    public void onNoReleaseAvailable(Activity activity) {
        if (isManual){
            Toast.makeText(activity, activity.getString(R.string.no_updates_available), Toast.LENGTH_LONG).show();
        }
    }

    private  boolean isManual;
}
