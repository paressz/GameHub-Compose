package com.farez.gamehub_compose.data.repository

import android.app.Application
import com.farez.gamehub_compose.data.database.GameDao
import com.farez.gamehub_compose.data.database.GameDatabase
import com.farez.gamehub_compose.data.model.Game
import kotlinx.coroutines.flow.Flow

class GameRepository(application: Application) {
    private val gameDao: GameDao

    init {
        gameDao = GameDatabase.getInstance(application).gameDao()
    }

    fun getAllGames(): Flow<List<Game>> {
        return gameDao.getAllGame()
    }

    fun getSafeGames(): Flow<List<Game>> {
        return gameDao.getSafeGames()
    }

    companion object {
        @Volatile
        private var INSTANCE: GameRepository? = null
        fun GetInstance(application: Application): GameRepository = INSTANCE ?: synchronized(this) {
            INSTANCE ?: GameRepository(application)
        }.also { INSTANCE = it }
    }
}