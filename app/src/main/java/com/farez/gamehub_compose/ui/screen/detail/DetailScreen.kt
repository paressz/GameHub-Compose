package com.farez.gamehub_compose.ui.screen.detail

import android.app.Application
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.farez.gamehub_compose.AppViewModel
import com.farez.gamehub_compose.ViewModelFactory
import com.farez.gamehub_compose.data.repository.GameRepository

@Composable
fun DetailScreen(
    gameId : String,
    appViewModel: AppViewModel = viewModel(
        factory = ViewModelFactory(
            GameRepository.GetInstance(LocalContext.current.applicationContext as Application)
        )
    )
) {
    val games = appViewModel.getGames().collectAsState(initial = emptyList()).value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Card {
            Column {
                games.forEach { game -> if (game.id == gameId.toInt()){

                    Text(text = game.nama)
                    Text(text = game.deskripsi)
                } }
            }
        }
    }
}