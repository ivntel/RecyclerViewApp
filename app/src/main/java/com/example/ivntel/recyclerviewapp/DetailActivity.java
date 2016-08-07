package com.example.ivntel.recyclerviewapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ivntel.recyclerviewapp.model.Song;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ivntel on 2016-04-24.
 */
public class DetailActivity extends ActionBarActivity {

    public static final String ARG_SONG = "ARG_SONG";


    @Bind(R.id.detail_image)
    ImageView detailImage;
    @Bind(R.id.detail_artist)
    TextView detailArtist;
    @Bind(R.id.detail_song)
    TextView detailSong;
    @Bind(R.id.collection_name)
    TextView collectionName;
    @Bind(R.id.track_price)
    TextView trackPrice;
    @Bind(R.id.song_length)
    TextView songLength;
    @Bind(R.id.song_genre)
    TextView songGenre;
    @Bind(R.id.album_price)
    TextView albumPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        if(intent != null) {
            Song song = (Song) intent.getSerializableExtra(ARG_SONG);

            if (song != null) {

                detailArtist.setText("Artist: " + song.getArtistName());
                detailSong.setText("Song name: " + song.getSongName());
                collectionName.setText("Album name: " + song.getCollectionName());
                trackPrice.setText("Song Price: " + "$" + song.getTrackPrice());
                songGenre.setText("Genre: " + song.getGenreName());
                albumPrice.setText("Album price: " + "$" + song.getAlbumPrice());
                //Convert songlength to minutes
                int songLengthSeconds = song.getSongLength() / 1000;
                int songLengthMinutes = songLengthSeconds / 60;
                songLengthSeconds = songLengthSeconds % 60;
                songLength.setText("Song length: " + songLengthMinutes + " minutes & " + songLengthSeconds + " seconds");
                Glide.with(this).load(song.getArtistUrl()).into(detailImage);
            }
        }
    }
}