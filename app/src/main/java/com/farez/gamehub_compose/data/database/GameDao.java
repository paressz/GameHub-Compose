package com.farez.gamehub_compose.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.farez.gamehub_compose.data.model.Game;

import java.util.List;

@Dao
public interface GameDao {
    @Query("SELECT * FROM game ORDER BY nama")
    List<Game> getAllGame();

    @Insert
    void insert(Game game);

}
