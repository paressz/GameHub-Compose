package com.farez.gamehub_compose

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.farez.gamehub_compose.data.database.GameDao
import com.farez.gamehub_compose.data.database.GameDatabase
import com.farez.gamehub_compose.data.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {
    private var gameDatabase : GameDatabase
    private var gameDao: GameDao
    private lateinit var gameList : List<Game>
    private val gameFromSpek = MutableLiveData<List<Game>>()
    private val safeGame = MutableLiveData<List<Game>>()

    init {
        gameDatabase = GameDatabase.getInstance(application.applicationContext)
        gameDao = gameDatabase.gameDao()
        if (gameList.isEmpty()) {
            viewModelScope.launch(Dispatchers.IO) { gameList = gameDao.allGame }
        }

    }

    fun getGameFromSpek(cpu : String, sRam : String, sHdd : String, vga : String) : LiveData<List<Game>> {
        val ram = sRam.toInt()
        val hdd  = sHdd.toInt()
        val list = gameList.filter { game -> game.cpu == cpu && game.ram <= ram && game.hdd <= hdd && game.vga == vga  }
        gameFromSpek.value = list
        return gameFromSpek
    }

    fun getSafeGame(): LiveData<List<Game>> = safeGame.also {
        it.value = gameList.filter { game -> game.isGameDewasa.not() }
    }
    fun getGameFromName(name : String) : Game = gameList.first { game -> game.nama == name }
}