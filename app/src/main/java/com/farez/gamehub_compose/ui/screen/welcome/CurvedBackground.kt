package com.farez.projectsbp.activity.loginactivity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.farez.gamehub_compose.ui.theme.biruMuda

@Preview
@Composable
fun CurvedBackground() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        TopCurvedContainer(
            alignment = Alignment.TopCenter,
            fracttion = 0.5f,
            containerColor = Color.White,
            backgroundColor = biruMuda,
            contentColor = biruMuda
        )
        BottomCurvedContainer(
            fraction = 0.5f,
            alignment = Alignment.BottomCenter,
            containerColor = biruMuda,
            backgroundColor = Color.White,
            contentColor = Color.Black
        )
    }
}

@Composable
fun TopCurvedContainer(
    fracttion: Float,
    alignment: Alignment,
    containerColor: Color,
    backgroundColor: Color,
    contentColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(alignment)
                .fillMaxWidth()
                .fillMaxHeight(fracttion)
                .background(backgroundColor)
        ) {

        }
        Card(
            shape = RoundedCornerShape(bottomEndPercent = 30),
            colors = CardDefaults.cardColors(
                containerColor = containerColor,
                contentColor = contentColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fracttion)
                .align(alignment)
        ) {

        }
    }
}

@Composable
fun BottomCurvedContainer(
    fraction: Float,
    alignment: Alignment,
    containerColor: Color,
    backgroundColor: Color,
    contentColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(alignment)
                .fillMaxWidth()
                .fillMaxHeight(fraction)
                .background(backgroundColor)
        ) {

        }
        Card(
            shape = RoundedCornerShape(topStartPercent = 30),
            colors = CardDefaults.cardColors(
                containerColor = containerColor,
                contentColor = contentColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction)
                .align(alignment)
        ) {

        }
    }
}