package com.example.spotifycloneelectivaiv.rv_activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifycloneelectivaiv.R
import com.example.spotifycloneelectivaiv.SongHome

class RVAdapterSongs(private var songs: List<SongHome>) : RecyclerView.Adapter<RVAdapterSongs.SongViewHolder>() {

    class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvSongName: TextView = view.findViewById(R.id.tv_infoSong)
    }
    

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val songView = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_song_spotify, parent, false)
        return SongViewHolder(songView)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.tvSongName.text = songs[position].songName
    }

    override fun getItemCount(): Int = songs.size

    fun updateSongs(newSongs: List<SongHome>) {
        this.songs = newSongs
        notifyDataSetChanged()
    }

}

