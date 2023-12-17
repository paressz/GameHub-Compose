package com.farez.gamehub_compose

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.farez.gamehub_compose.data.database.GameDao
import com.farez.gamehub_compose.data.database.GameDatabase
import com.farez.gamehub_compose.data.model.Game

class AppViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var gameDatabase : GameDatabase
    lateinit var gameDao: GameDao
    lateinit var gameList : List<Game>
    init {
        gameDatabase = GameDatabase.getInstance(application.applicationContext)
        gameDao = gameDatabase.gameDao()
        gameList = gameDao.allGame
    }

    fun getGameFromSpek(cpu : String, sRam : String, sHdd : String, vga : String) : LiveData<List<Game>> {
        val ram = sRam.toInt()
        val hdd  = sHdd.toInt()
        val list = gameList.filter { game -> game.cpu == cpu && game.ram <= ram && game.hdd <= hdd && game.vga == vga  }
        return list
    }

    fun getGame
}