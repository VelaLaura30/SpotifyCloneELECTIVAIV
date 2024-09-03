package com.example.spotifycloneelectivaiv.rv_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spotifycloneelectivaiv.SongHome
import kotlin.random.Random

class RecyclerViewViewModel : ViewModel() {

    private val _songs = MutableLiveData<List<SongHome>>(arrayListOf())
    val songs: LiveData<List<SongHome>> get() = _songs

    fun fillSongList() {
        val newSongs = mutableListOf<SongHome>()
        for (i in 0 until 4) {
            val songName = "Nombre Canción $i"
            val artistName = "Artista X"
            val info = "$songName - $artistName"
            newSongs.add(SongHome(info))
        }
        _songs.value = newSongs
    }

    fun removeSong() {
        _songs.value?.let {
            val songList = it.toMutableList()
            val songToRemoveIndex = Random.nextInt(from = 0, until = songList.size)
            songList.removeAt(songToRemoveIndex)
            _songs.value = songList
        }
    }

    fun modifySong() {
        _songs.value?.let {
            val songList = it.toMutableList()
            val songToUpdateIndex = Random.nextInt(from = 0, until = songList.size)
            val song = songList[songToUpdateIndex].copy(
                songName = "Nombre Canción #$songToUpdateIndex modificado"
            )
            songList[songToUpdateIndex] = song
            _songs.value = songList
        }
    }
}
