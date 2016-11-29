package com.assessment.course.moderuiart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Swami on 7/16/2015.
 */
public class MoreInformationDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage( R.string.dialog_text ).setPositiveButton(R.string.dialog_visit,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        ((FragmentAlertDialog) getActivity()).doPositiveClick();
                    }
                }).setNegativeButton(R.string.dialog_not_now,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id ) {

                        ((FragmentAlertDialog)getActivity()).doNegativeClick();
                    }
                }  );

        return builder.create();
    }
}
