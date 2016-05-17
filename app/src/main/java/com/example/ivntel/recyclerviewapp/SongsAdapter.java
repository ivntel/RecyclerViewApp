package com.example.ivntel.recyclerviewapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ivntel.recyclerviewapp.model.Song;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ivntel on 2016-04-24.
 */

//FOR LISTVIEW: public class SongsAdapter extends BaseAdapter {

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    //FOR LISTVIEW: private LayoutInflater mInflater;
    private List<Song> mSongs;
    private Context mContext;

    public static final String TAG = SongsAdapter.class.getSimpleName();

    public SongsAdapter(Context context, List<Song> songs) {
        mContext = context;
        //FOR LISTVIEW: mInflater = LayoutInflater.from(context);
        mSongs = songs;

    }

    public void updateData(List<Song> songs) {
        mSongs = songs;
        notifyDataSetChanged();
    }

    //FOR LISTVIEW:
    /*
    @Override
    public int getCount() {

        return mSongs.size();
    }
    */

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    @Override
    public long getItemId(int position) {

        //FOR LISTVIEW return position;
        return 0;
    }

    //FOR LISTVIEW
    /*
    @Override
    public Object getItem(int position) {

        return mSongs.get(position);
    }
    */

    // Create new views (invoked by the layout manager)
    //FOR LISTVIEW:
    /*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_song, parent, false);
        View view;
        ViewHolder holder;

        final Song song = mSongs.get(position);

        if (convertView == null){
            view = mInflater.inflate(R.layout.row_song, parent, false);
            holder = new ViewHolder();

            holder.rowArtist = (TextView)view.findViewById(R.id.row_artist);
            holder.rowImage = (ImageView)view.findViewById(R.id.row_image);
            holder.rowLayout = (RelativeLayout)view.findViewById(R.id.row_layout);
            holder.rowSong = (TextView)view.findViewById(R.id.row_song);
            view.setTag(holder);

        }
        else{
            view = convertView;
            holder = (ViewHolder) convertView.getTag();
        }

        holder.rowArtist.setText(song.getArtistName());
        holder.rowSong.setText(song.getSongName());
        Glide.with(mContext).load(song.getArtistUrl()).into(holder.rowImage);

        holder.rowLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Clicked on " + song.getSongName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(DetailActivity.ARG_SONG, song);
                mContext.startActivity(intent);
            }
        });


        return view;
    }
    */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_song, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    //Replace contents of a view(invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Song song = mSongs.get(position);
        holder.rowArtist.setText(song.getArtistName());
        holder.rowSong.setText(song.getSongName());
        Glide.with(mContext).load(song.getArtistUrl()).into(holder.rowImage);

        holder.rowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Clicked on " + song.getSongName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra(DetailActivity.ARG_SONG, song);
                mContext.startActivity(intent);
            }
        });

    }


    // Replace the contents of a view (invoked by the layout manager)


    // Return the size of your dataset (invoked by the layout manager)

    //FOR LISTVIEW:
    /*
    public static class ViewHolder {

        public RelativeLayout rowLayout;

        public ImageView rowImage;

        public TextView rowArtist;

        public TextView rowSong;
    }
    */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.row_layout)
        RelativeLayout rowLayout;

        @Bind(R.id.row_image)
        ImageView rowImage;

        @Bind(R.id.row_artist)
        TextView rowArtist;

        @Bind(R.id.row_song)
        TextView rowSong;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

}
