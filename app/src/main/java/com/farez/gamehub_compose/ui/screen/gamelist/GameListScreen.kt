package com.farez.gamehub_compose.ui.screen.gamelist

import android.app.Application
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.farez.gamehub_compose.AppViewModel
import com.farez.gamehub_compose.R
import com.farez.gamehub_compose.ViewModelFactory
import com.farez.gamehub_compose.data.model.Game
import com.farez.gamehub_compose.data.repository.GameRepository

@Composable
fun GameListScreen(
    appViewModel: AppViewModel = viewModel(
        factory = ViewModelFactory(
            GameRepository(LocalContext.current.applicationContext as Application)
        )
    )
) {
    val games = appViewModel.getSafeGames().collectAsState(initial = emptyList()).value
    LazyVerticalGrid(
        modifier = Modifier,
        columns = GridCells.Adaptive(200.dp),
    ) {
        games.forEach {
            item {
                GameItem(game = it)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun GameItem(game: Game) {
    val placeholder = placeholder(R.drawable.no_image)
    Card(
        modifier = Modifier
            .padding(16.dp)
            .height(140.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = { /*TODO*/ }
    ) {
        Box {
            GlideImage(
                model = game.imageUrl,
                contentDescription = "Game ${game.nama}",
                loading = placeholder,
                failure = placeholder,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            )
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    ),
                color = Color.Transparent
            ) {

                Text(
                    text = game.nama,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PrevGameItem() {
    GameListScreen()
}