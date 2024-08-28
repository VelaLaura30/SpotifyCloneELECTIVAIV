package com.example.spotifycloneelectivaiv.rv_activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifycloneelectivaiv.R
import com.example.spotifycloneelectivaiv.SongHome

class RVAdapterSongs(private val songs: List<SongHome>) :
    RecyclerView.Adapter<RVAdapterSongs.PostViewHolder>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvSongName: TextView = view.findViewById(R.id.tv_infoSong)
    }
    

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val songView = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_song_spotify, parent, false)
        return PostViewHolder(songView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.tvSongName.text = songs[position].songName
    }

    override fun getItemCount(): Int = songs.size

}
