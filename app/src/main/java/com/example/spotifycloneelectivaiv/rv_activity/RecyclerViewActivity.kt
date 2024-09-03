package com.example.spotifycloneelectivaiv.rv_activity

import android.os.Bundle
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifycloneelectivaiv.R
import com.example.spotifycloneelectivaiv.rv_activity.adapters.RVAdapterSongs

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvSongs: RecyclerView
    private lateinit var btnObtainSongs: Button
    private lateinit var btnRemoveSong: Button
    private lateinit var btnModifySong: Button
    private lateinit var rvAdapterSong: RVAdapterSongs

    private val viewModel: RecyclerViewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initViews()

        viewModel.songs.observe(this, Observer { songs ->
            rvAdapterSong.updateSongs(songs)
        })
    }

    private fun initViews() {
        btnObtainSongs = findViewById(R.id.btnFillSongList)
        btnObtainSongs.setOnClickListener {
            viewModel.fillSongList()
        }

        btnRemoveSong = findViewById(R.id.btnRemovePost)
        btnRemoveSong.setOnClickListener {
            viewModel.removeSong()
        }

        btnModifySong = findViewById(R.id.btnModifyPost)
        btnModifySong.setOnClickListener {
            viewModel.modifySong()
        }

        rvSongs = findViewById(R.id.rv_songs)
        initRV()
    }

    private fun initRV() {
        rvAdapterSong = RVAdapterSongs(songs = emptyList())
        rvSongs.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = rvAdapterSong
        }
    }
}
