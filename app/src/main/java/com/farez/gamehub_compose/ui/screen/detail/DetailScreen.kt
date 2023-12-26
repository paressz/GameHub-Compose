package com.farez.gamehub_compose.ui.screen.detail

import android.app.Application
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.farez.gamehub_compose.AppViewModel
import com.farez.gamehub_compose.R
import com.farez.gamehub_compose.ViewModelFactory
import com.farez.gamehub_compose.data.model.Game
import com.farez.gamehub_compose.data.repository.GameRepository
import com.farez.gamehub_compose.ui.theme.biruMuda


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(
    gameId: String,
    appViewModel: AppViewModel = viewModel(
        factory = ViewModelFactory(
            GameRepository.GetInstance(LocalContext.current.applicationContext as Application)
        )
    )
) {
    val games = appViewModel.getGames().collectAsState(initial = emptyList()).value
    val placeholder = placeholder(R.drawable.no_image)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val orientation = LocalConfiguration.current.orientation
        for (game in games) {
            if (game.id == gameId.toInt()) {
                GlideImage(
                    model = game.imageUrl,
                    loading = placeholder,
                    failure = placeholder,
                    contentScale = ContentScale.FillWidth,
                    contentDescription = game.nama,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                )
                Card(
                    elevation = CardDefaults.cardElevation(
                        6.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .align(
                            if (orientation == Configuration.ORIENTATION_LANDSCAPE)
                                Alignment.BottomCenter
                            else
                                Alignment.TopCenter
                        )
                        .padding(
                            top = if (orientation == Configuration.ORIENTATION_PORTRAIT)
                                150.dp
                            else
                                230.dp,
                            start = 24.dp,
                            end = 24.dp,
                            bottom = 16.dp
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            text = game.nama,
                            softWrap = true,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            modifier =
                            Modifier.padding(bottom = 8.dp)
                        )
                        Text(
                            text = game.deskripsi,
                            softWrap = true,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(end = 16.dp)
                        )
                        SpekItem(
                            item = "CPU",
                            spek = game.cpu,
                            iconId = R.drawable.cpu_svgrepo_com
                        )
                        SpekItem(
                            item = "VGA",
                            spek = game.vga,
                            iconId = R.drawable.gpu_svgrepo_com
                        )
                        SpekItem(
                            item = "RAM",
                            spek = game.ram.toString() + " GB",
                            iconId = R.drawable.ram_svgrepo_com
                        )
                        SpekItem(
                            item = "Storage",
                            spek = game.hdd.toString() + " GB",
                            iconId = R.drawable.ssd_svgrepo_com
                        )
                    }

                }
            }
        }

    }

}

@Composable
fun SpekItem(item: String, spek: String, iconId: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = biruMuda,
            modifier = Modifier
                .padding(end = 16.dp)
                .size(82.dp)
        )
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(
                text = item,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = spek,
                fontSize = 16.sp,
                softWrap = true
            )
        }
    }
}

@Preview
@Composable
fun DetailPrev() {
    DetailScreen(gameId = Game.sampleGameList()[2].id.toString())
}