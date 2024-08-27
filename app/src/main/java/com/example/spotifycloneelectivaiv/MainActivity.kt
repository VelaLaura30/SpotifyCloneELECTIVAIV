package com.example.spotifycloneelectivaiv


import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var llSongs: LinearLayout
    private val songList = arrayListOf<SongHome>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        fillSongList()
        addSongsToLL()
    }

    private fun fillSongList() {
        for (i in 0 until 10) {
            val songName = "Nombre Canción $i"
            val artistName = "Artista X"
            val info = "$songName - $artistName"
            songList.add(SongHome(info))
        }
    }

    private fun addSongsToLL() {
        songList.forEach { song ->
            val songView = layoutInflater.inflate(R.layout.home_song_spotify, null)
            val tvInfoSong: TextView = songView.findViewById(R.id.tv_infoSong)
            tvInfoSong.text = song.songName
            llSongs.addView(songView)
        }
    }

    private fun initViews() {
        llSongs = findViewById(R.id.ll_ListSong)
    }
}
