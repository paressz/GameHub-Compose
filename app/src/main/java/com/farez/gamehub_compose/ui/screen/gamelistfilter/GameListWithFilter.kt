package com.farez.gamehub_compose.ui.screen.gamelistfilter

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.farez.gamehub_compose.AppViewModel
import com.farez.gamehub_compose.ui.screen.gamelist.GameItem

@Composable
fun GameListWithFilter(
    modifier: Modifier = Modifier,
    appViewModel: AppViewModel,
    navigateToDetail : (String) -> Unit
) {
    val cpu = appViewModel.cpu
    val ram = appViewModel.ram
    val hdd = appViewModel.hdd
    val vga = appViewModel.vga
    val games = appViewModel.getGames().collectAsState(initial = emptyList())


    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        columns = GridCells.Adaptive(300.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        games.value.forEach { game ->
            if (game.cpu.contains(cpu) && game.vga.contains(vga) && game.hdd < hdd.toInt() && game.ram < ram.toInt())
                item {
                    GameItem(
                        game.nama,
                        game.imageUrl,
                        game.deskripsi,
                        game.id.toString(),
                        navigateToDetail = navigateToDetail
                    )
                }
        }
    }
}
