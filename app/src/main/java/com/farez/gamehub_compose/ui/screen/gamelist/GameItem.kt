package com.farez.gamehub_compose.ui.screen.gamelist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.farez.gamehub_compose.R
import com.farez.gamehub_compose.data.model.Game
import com.farez.gamehub_compose.ui.theme.darker_biru_muda


@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun GameItem(nama : String, imageUrl : String, deskripsi : String, id : String, navigateToDetail : (String) -> Unit) {
    val placeholder = placeholder(R.drawable.no_image)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(
            4.dp
        ),
        onClick = { navigateToDetail(id) }
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            GlideImage(
                model = imageUrl,
                contentDescription = "Game ${nama}",
                loading = placeholder,
                failure = placeholder,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(0.4f)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column (
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = nama,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = true,
                    modifier = Modifier
                        .padding(top = 8.dp, end = 8.dp)
                )
                Text(
                    text = deskripsi,
                    maxLines = 3,
                    fontSize = 13.sp,
                    softWrap = true,
                    lineHeight = 18.sp,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(end = 8.dp)
                    )
                Box(
                    modifier = Modifier
                        .fillMaxHeight(0.35f)
                        .fillMaxWidth(0.2f)
                        .clip(RoundedCornerShape(topStart = 12.dp))
                        .background(darker_biru_muda)
                        .align(Alignment.End)
                ) {
                    Icon(
                        Icons.Rounded.ArrowForward,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun item() {
    GameItem(nama = Game.sampleGameList()[3].nama, imageUrl =  Game.sampleGameList()[3].imageUrl, id = Game.sampleGameList()[3].id.toString(), deskripsi =  Game.sampleGameList()[3].deskripsi, navigateToDetail = {})
}
