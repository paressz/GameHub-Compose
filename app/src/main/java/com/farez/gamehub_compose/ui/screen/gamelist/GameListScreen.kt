package com.farez.gamehub_compose.ui.screen.gamelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.farez.gamehub_compose.AppViewModel

@Composable
fun GameListScreen(
    modifier: Modifier = Modifier,
    appViewModel: AppViewModel,
    navigateToDetail: (String) -> Unit
) {
    val games = appViewModel.getGames().collectAsState(initial = emptyList())
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(300.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(games.value) {
            GameItem(
                it.nama,
                it.imageUrl,
                it.deskripsi,
                it.id.toString(),
                navigateToDetail = navigateToDetail
            )
        }
    }
}


//@Preview
//@Composable
//fun PrevGameItem() {
//    GameListScreen()
//}