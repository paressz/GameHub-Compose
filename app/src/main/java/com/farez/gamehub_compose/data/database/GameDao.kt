package com.farez.gamehub_compose.data.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.farez.gamehub_compose.data.model.Game
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    @Query("SELECT * FROM game ORDER BY nama")
    fun getAllGame(): Flow<List<Game>>

    @Query("SELECT * FROM game WHERE isGameDewasa=0 ORDER BY nama")
    fun getSafeGames(): Flow<List<Game>>


    @Insert
    fun insert(game: Game)

}
