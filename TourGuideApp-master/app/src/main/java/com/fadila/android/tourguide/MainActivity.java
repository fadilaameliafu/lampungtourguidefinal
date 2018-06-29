package com.fadila.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_LOSS;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private boolean flag;

    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int audioFocusChange) {
            if (audioFocusChange == AUDIOFOCUS_GAIN) {
                mMediaPlayer.setVolume(1.0f, 1.0f);
                mMediaPlayer.start();
            }else if (audioFocusChange == AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }else if (audioFocusChange == AUDIOFOCUS_LOSS_TRANSIENT) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }else if (audioFocusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.setVolume(0.2f, 0.2f);
            }
        }
    };

    private int mCurrentImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        final ImageView panorama = (ImageView) findViewById(R.id.panorama_view); //menampilkan slide images dengan panorama view
        panorama.setImageResource(R.drawable.images2); //set image 2
        panorama.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mCurrentImage++;
                switch (mCurrentImage) {
                    case 1: panorama.setImageResource(R.drawable.images2); //berpindah ke image 2
                        break;
                    case 2: panorama.setImageResource(R.drawable.images6); //berpindah ke image 6
                        break;
                    case 3: panorama.setImageResource(R.drawable.images7); //berpindah ke image 7
                        break;
                    case 4: panorama.setImageResource(R.drawable.images8); //berpindah ke image 8 yang diatur fix pada layar
                            panorama.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            mCurrentImage = 0;
                        break;
                }
            }
        });

        RelativeLayout mapButton = (RelativeLayout) findViewById(R.id.map_button); //mengatur button city map
        mapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MapsActivity.class);


                startActivity(intent);
            }
        });

        RelativeLayout toSeeButton = (RelativeLayout) findViewById(R.id.to_see_button); //mengatur button signature
        toSeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ToSeeActivity.class);
                startActivity(i);
            }
        });

        final RelativeLayout restaurantsButton = (RelativeLayout) findViewById(R.id.restaurants_button); //mengatur button restaurant
        restaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), RestaurantsActivity.class);
                startActivity(i);
            }
        });

        RelativeLayout photosButton = (RelativeLayout) findViewById(R.id.photos_button); //mengatur button transportation
        photosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), RestaurantsActivity.class);
                startActivity(i);
            }
        });


        RelativeLayout appInfoButton = (RelativeLayout) findViewById(R.id.app_info_button); //mengatur button app info
        appInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), AppInfoActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        flag = false;
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
