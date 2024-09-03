package com.example.spotifycloneelectivaiv.rv_activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotifycloneelectivaiv.R
import com.example.spotifycloneelectivaiv.SongHome
import com.example.spotifycloneelectivaiv.rv_activity.adapters.RVAdapterSongs
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvSongs: RecyclerView
    private lateinit var btnObtainSongs: Button
    private lateinit var btnRemoveSong: Button
    private lateinit var btnModifySong: Button
    private lateinit var rvAdapterSong: RVAdapterSongs
    private val songList = arrayListOf<SongHome>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initViews()
    }

    private fun initViews() {

        btnObtainSongs = findViewById(R.id.btnFillSongList)
        btnObtainSongs.setOnClickListener{
            fillSongList()
            rvAdapterSong.notifyDataSetChanged()
        }


        btnRemoveSong = findViewById(R.id.btnRemovePost)
        btnRemoveSong.setOnClickListener {
            val songToRemoveIndex = Random.nextInt(from = 0, until = songList.size)
            songList.removeAt(songToRemoveIndex)
            rvAdapterSong.notifyItemRemoved(songToRemoveIndex)
        }

        btnModifySong = findViewById(R.id.btnModifyPost)
        btnModifySong.setOnClickListener {
            val songToUpdateIndex = Random.nextInt(from = 0, until = songList.size)
            val song =
                songList[songToUpdateIndex]
                    .copy(
                        songName = " Nombre Cancion #$songToUpdateIndex modificado"
                    )
            songList[songToUpdateIndex] = song
            rvAdapterSong.notifyItemChanged(songToUpdateIndex)
        }

        rvSongs = findViewById(R.id.rv_songs)
        initRV()

    }

    private fun initRV() {
        rvAdapterSong = RVAdapterSongs(songs = songList)
        rvSongs.apply {
            layoutManager =
                LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = rvAdapterSong
        }
    }

    private fun fillSongList() {
        for (i in 0 until 4) {
            val songName = "Nombre Canción $i"
            val artistName = "Artista X"
            val info = "$songName - $artistName"
            songList.add(SongHome(info))
        }
    }
}