package com.example.spotifycloneelectivaiv


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.spotifycloneelectivaiv.databinding.ActivityMainBinding
import com.example.spotifycloneelectivaiv.rv_activity.RecyclerViewActivity

class MainActivity : AppCompatActivity() {

    private lateinit var bindingSpotify: ActivityMainBinding
    private lateinit var llSongs: LinearLayout
    private val songList = arrayListOf<SongHome>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSpotify = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingSpotify.root)
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
        findViewById<Button>(R.id.btn_rv).setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }
}
