package com.farez.gamehub_compose.ui.screen.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farez.gamehub_compose.ui.theme.darker_biru_muda


@Composable
fun BottomNavItem(
    iconId: Int,
    title: String,
    selected: Boolean = false,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(64.dp)
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = title,
            tint = if (selected) darker_biru_muda else Color.LightGray,
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = title,
            fontSize = 12.sp,
            color = if (selected) darker_biru_muda else Color.LightGray,
            fontFamily = FontFamily.Default,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
