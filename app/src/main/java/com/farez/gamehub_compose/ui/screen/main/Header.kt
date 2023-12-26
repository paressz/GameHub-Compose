package com.farez.gamehub_compose.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farez.gamehub_compose.R
import com.farez.gamehub_compose.ui.theme.FontIceberg
import com.farez.gamehub_compose.ui.theme.biruMuda
import com.farez.gamehub_compose.ui.theme.darker_biru_muda


@Composable
fun Header(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(
                RoundedCornerShape(
                    bottomEndPercent = 50,
                    bottomStartPercent = 50
                )
            )
            .shadow(6.dp)
            .background(darker_biru_muda)
            .clip(
                RoundedCornerShape(
                    bottomEndPercent = 50,
                    bottomStartPercent = 50
                )
            )
    ) {
        Icon(
            painter = painterResource(id = R.drawable.stikps),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 2.dp)
                .align(Alignment.TopEnd),
            tint = biruMuda
        )
        Text(
            text = buildAnnotatedString
            {
                withStyle(style = SpanStyle(color = Color.White)) { append("Game") }
                withStyle(style = SpanStyle(color = Color.Black)) { append("Hub") }
            },
            fontFamily = FontIceberg,
            fontSize = 52.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}