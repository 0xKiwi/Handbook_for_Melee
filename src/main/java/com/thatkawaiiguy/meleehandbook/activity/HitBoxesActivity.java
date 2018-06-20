/*
    This file is part of Handbook for Melee.

    Handbook for Melee is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Handbook for Melee is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Handbook for Melee.  If not, see <http://www.gnu.org/licenses/>
 */

package com.thatkawaiiguy.meleehandbook.activity;

import android.app.DialogFragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thatkawaiiguy.meleehandbook.fragment.FrameInfoDialogFragment;
import com.thatkawaiiguy.meleehandbook.utils.ArrayHelper;
import com.thatkawaiiguy.meleehandbook.utils.HitboxesHelper;
import com.thatkawaiiguy.meleehandbook.utils.Preferences;
import com.thatkawaiiguy.meleehandbook.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class HitBoxesActivity extends AppCompatActivity {
    private int frame = 0;
    private int mTotal = 0;

    private ImageView nextBtn;
    private ImageView backBtn;
    private View playBtn;

    private boolean paused = false;
    private boolean running = false;

    private InputStream is = null;
    private String[] filelist = {"#@#", "#@$@#"};

    private Bitmap bitmap;

    private String movePicked = "";
    private String characterPicked = "";
    private String characterPickedTitle = "";

    private TextView iasa;
    private TextView frameNumber;
    private TextView totalFrame;
    private TextView landingLag;

    private ImageView frameImage;

    private final ClickListener listener = new ClickListener();
    private final LongClickListener longListener = new LongClickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(getIntent().hasExtra("bundle") && savedInstanceState == null)
            savedInstanceState = getIntent().getExtras().getBundle("bundle");
        Preferences.applyTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framedata_layout);

        Bundle mainData = getIntent().getExtras();
        if(mainData == null)
            return;
        characterPickedTitle = mainData.getString("option");
        movePicked = mainData.getString("frame");

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(characterPickedTitle + "'s " + movePicked);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        frameNumber = (TextView) findViewById(R.id.frameNumber);
        totalFrame = (TextView) findViewById(R.id.totalFrame);
        landingLag = (TextView) findViewById(R.id.landinglagText);
        iasa = (TextView) findViewById(R.id.iasaText);

        frameImage = (ImageView) findViewById(R.id.frameImage);

        backBtn = (ImageView) findViewById(R.id.backBtn);
        nextBtn = (ImageView) findViewById(R.id.nextBtn);
        playBtn = findViewById(R.id.playBtn);

        characterPicked = ArrayHelper.getFileName(characterPickedTitle);

        movePicked = HitboxesHelper.setShortMovePicked(movePicked);
        doStuff();
    }

    private void setFrame() {
        InputStream is = null;
        try {
            is = getResources().getAssets().open(characterPicked + File.separator +
                    movePicked + File.separator + frame + ".jpg");
        } catch(IOException e) {
            e.printStackTrace();
        }
        frameImage.setImageBitmap(BitmapFactory.decodeStream(is));
        frameNumber.setText(String.valueOf(frame + 1));
    }

    private void interruptPlay() {
        listener.getHandler().removeCallbacks(listener.getRunnable());
        longListener.getHandler().removeCallbacks(longListener.getRunnable());
        running = false;
    }

    private void doStuff() {
        new ASyncTask().execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                interruptPlay();
                this.finish();
                return true;
            case R.id.action_info:
                interruptPlay();
                DialogFragment newFragment = new FrameInfoDialogFragment();
                newFragment.show(getFragmentManager(), "Hitbox info");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStop() {
        interruptPlay();
        super.onStop();
    }

    private class ClickListener implements View.OnClickListener {

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(frame < Integer.parseInt((String) totalFrame.getText()) - 1) {
                    frame++;
                    setFrame();
                    running = true;
                } else {
                    paused = false;
                    running = false;
                    playBtn.performClick();
                }
            }
        };

        @Override
        public void onClick(View v) {
            if(!running) {
                if(paused) {
                    for(int i = frame; i < mTotal; i++)
                        handler.postDelayed(runnable, 51 * (i - (frame - 1)));
                } else {
                    frame = 0;
                    for(int i = frame; i < mTotal; i++)
                        handler.postDelayed(runnable, 51 * (i - (frame - 1)));
                }
            } else {
                interruptPlay();
                paused = true;
            }
        }

        public Handler getHandler() {return handler;}

        public Runnable getRunnable() {return runnable;}
    }

    private class LongClickListener implements View.OnLongClickListener {

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(frame < Integer.parseInt((String) totalFrame.getText()) - 1) {
                    frame++;
                    setFrame();
                    running = true;
                } else {
                    paused = false;
                    running = false;
                    playBtn.performLongClick();
                }
            }
        };

        @Override
        public boolean onLongClick(View v) {
            if(!running) {
                if(!paused) {
                    frame = 0;
                    for(int i = frame; i < mTotal; i++)
                        handler.postDelayed(runnable, 17 * (i - (frame - 1)));
                } else {
                    for(int i = frame; i < mTotal; i++)
                        handler.postDelayed(runnable, 17 * (i - (frame - 1)));
                }
            } else {
                interruptPlay();
                paused = true;
            }
            return true;
        }

        public Handler getHandler() {return handler;}

        public Runnable getRunnable() {return runnable;}
    }

    private class ASyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                is = getResources().getAssets().open(characterPicked + File.separator +
                        movePicked + File.separator + frame + ".jpg");
                filelist = getResources().getAssets().list(characterPicked + File.separator +
                        movePicked);
            } catch(IOException e) {
                e.printStackTrace();
            }

            bitmap = BitmapFactory.decodeStream(is);

            mTotal = filelist.length;
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            totalFrame.setText(String.valueOf(mTotal));

            frameImage.setImageBitmap(bitmap);

            landingLag.setText(HitboxesHelper.getLandLag(characterPickedTitle, movePicked));
            iasa.setText(HitboxesHelper.getIASA(characterPickedTitle, movePicked));

            backBtn.setOnClickListener(v -> {
                if(!running) {
                    if(frame > 0) {
                        frame--;
                        setFrame();
                    }
                } else {
                    interruptPlay();
                    backBtn.performClick();
                }
            });
            backBtn.setOnLongClickListener(v -> {
                if(!running) {
                    frame = 0;
                    setFrame();
                } else {
                    interruptPlay();
                    backBtn.performLongClick();
                }
                return true;
            });

            nextBtn.setOnClickListener(v -> {
                if(!running) {
                    if(frame < Integer.parseInt((String) totalFrame.getText()) - 1) {
                        frame++;
                        setFrame();
                    }
                } else {
                    interruptPlay();
                    nextBtn.performClick();
                }
            });
            nextBtn.setOnLongClickListener(v -> {
                if(!running) {
                    if(frame <= Integer.parseInt((String) totalFrame.getText()) - 11) {
                        frame += 10;
                        setFrame();
                    } else {
                        frame = Integer.parseInt((String) totalFrame.getText()) - 1;
                        setFrame();
                    }
                } else {
                    interruptPlay();
                    nextBtn.performLongClick();
                }
                return true;
            });

            playBtn.setOnClickListener(listener);
            playBtn.setOnLongClickListener(longListener);
        }
    }
}
