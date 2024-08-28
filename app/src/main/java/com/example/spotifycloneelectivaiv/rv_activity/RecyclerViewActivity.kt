package com.example.spotifycloneelectivaiv.rv_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifycloneelectivaiv.R
import com.example.spotifycloneelectivaiv.SongHome
import com.example.spotifycloneelectivaiv.rv_activity.adapters.RVAdapterSongs

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvSongs: RecyclerView
    private val songList = arrayListOf<SongHome>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        fillSongList()
        initViews()
    }

    private fun initViews() {
        rvSongs = findViewById(R.id.rv_Song)
        rvSongs.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = RVAdapterSongs(songList)
        }
    }

    private fun fillSongList() {
        for (i in 0 until 10) {
            val songName = "Nombre Canción $i"
            val artistName = "Artista X"
            val info = "$songName - $artistName"
            songList.add(SongHome(info))
        }
    }
}