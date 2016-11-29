package com.assessment.course.moderuiart;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;


public class MainActivity extends Activity implements FragmentAlertDialog{

    private static final String TAG = MainActivity.class.getName();
    private RelativeLayout palette;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        palette = (RelativeLayout)findViewById(R.id.palette);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                for (int i = 0; i < palette.getChildCount(); i++) {
                    View child = palette.getChildAt(i);

                    int originalColor = Color.parseColor((String) child.getTag());
                    int invertedColor = (0x00FFFFFF - (originalColor | 0xFF000000)) |
                            (originalColor & 0xFF000000);

                    if (getResources().getColor(R.color.white) != originalColor &&
                            getResources().getColor(R.color.lightgray) != originalColor) {

                        int origR = (originalColor >> 16) & 0x000000FF;
                        int origG = (originalColor >> 8) & 0x000000FF;
                        int origB = originalColor & 0x000000FF;

                        int invR = (invertedColor >> 16) & 0x000000FF;
                        int invG = (invertedColor >> 8) & 0x000000FF;
                        int invB = invertedColor & 0x000000FF;

                        child.setBackgroundColor(Color.rgb(
                                (int) (origR + (invR - origR) * (progress / 100f)),
                                (int) (origG + (invG - origG) * (progress / 100f)),
                                (int) (origB + (invB - origB) * (progress / 100f))));
                        child.invalidate();
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showDialog(MenuItem item) {
        new MoreInformationDialog().show( getFragmentManager(), TAG );

    }

    @Override
    public void doPositiveClick() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
        Intent chooser = Intent.createChooser(intent,getResources().getString(R.string.open_with));
        startActivity(intent);
    }

    @Override
    public void doNegativeClick() {

    }
}
