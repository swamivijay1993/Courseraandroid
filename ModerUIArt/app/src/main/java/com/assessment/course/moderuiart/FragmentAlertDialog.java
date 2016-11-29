package com.assessment.course.moderuiart;

import android.view.MenuItem;

/**
 * Created by Swami on 7/16/2015.
 */
public interface FragmentAlertDialog {
    void showDialog ( MenuItem item );
    void doPositiveClick();
    void doNegativeClick();
}
