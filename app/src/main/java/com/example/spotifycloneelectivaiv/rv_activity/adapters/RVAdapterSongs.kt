package com.example.spotifycloneelectivaiv.rv_activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifycloneelectivaiv.SongHome
import com.example.spotifycloneelectivaiv.databinding.HomeSongSpotifyBinding

class RVAdapterSongs(private var songs: List<SongHome>) : RecyclerView.Adapter<RVAdapterSongs.SongViewHolder>() {

    class SongViewHolder(val binding: HomeSongSpotifyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(song: SongHome) {
            binding.tvInfoSong.text = song.songName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = HomeSongSpotifyBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return SongViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(songs[position])
    }

    override fun getItemCount(): Int = songs.size

    fun updateSongs(newSongs: List<SongHome>) {
        this.songs = newSongs
        notifyDataSetChanged()
    }
}
