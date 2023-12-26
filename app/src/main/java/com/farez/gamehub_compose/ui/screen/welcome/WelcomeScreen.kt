package com.farez.gamehub_compose.ui.screen.welcome

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.farez.gamehub_compose.R
import com.farez.gamehub_compose.ui.navigation.Screen
import com.farez.gamehub_compose.ui.theme.FontJosefinSans
import com.farez.gamehub_compose.ui.theme.biruMuda
import com.farez.gamehub_compose.ui.theme.darker_biru_muda
import com.farez.projectsbp.activity.loginactivity.CurvedBackground

@Preview
@Composable
fun WelcomePrev() {
    WelcomeScreen(navController = rememberNavController())
}

@Composable
fun WelcomeScreen(
    navController: NavController
) {
    val onClick = {
        navController.popBackStack(Screen.Welcome.route, true)
        navController.navigate(Screen.Main.route)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        CurvedBackground()
        //TOP HALF
        when (LocalConfiguration.current.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                Column(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .height(120.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painterResource(id = R.drawable.logo),
                            contentDescription = "App Logo",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .size(120.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color.Black)) {
                                    append("Game")
                                }
                                withStyle(style = SpanStyle(color = biruMuda)) {
                                    append("Hub")
                                }
                            },
                            fontSize = 38.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(bottom = 16.dp)
                        )
                    }
                }
            }

            Configuration.ORIENTATION_PORTRAIT -> {
                Column(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .padding(start = 24.dp, top = 16.dp, bottom = 24.dp),
                    horizontalAlignment = Alignment.Start,
                ) {
                    Icon(
                        painterResource(id = R.drawable.logo),
                        contentDescription = "App Logo",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .size(120.dp)
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Black)) {
                                append("Game")
                            }
                            withStyle(style = SpanStyle(color = biruMuda)) {
                                append("Hub")
                            }
                        },
                        fontSize = 38.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontJosefinSans,
                        modifier = Modifier
                            .padding(bottom = 24.dp)
                    )
                    IntroText()
                }
            }
        }
        //BOTTOM HALF
        when (LocalConfiguration.current.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.5f)
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 24.dp)
                            .fillMaxWidth(0.9f)
                    ) {
                        IntroText(Color.White)
                    }
                    NextButton(onClick)
                }

            }

            Configuration.ORIENTATION_PORTRAIT -> {
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End
                ) {
                    IntroText()
                    NextButton(onClick)
                }

            }
        }
    }
}

@Composable
fun IntroText(
    color: Color = darker_biru_muda,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = "Bingung mau main game apa" +
                " yang PC-mu bisa mainkan" +
                " yuk cari di GameHub.",
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        lineHeight = 40.sp,
        textAlign = textAlign,
        fontFamily = FontJosefinSans,
        color = color,
        modifier = Modifier
            .padding(end = 24.dp)
            .fillMaxWidth()
    )
}

@Composable
fun NextButton(onClick: () -> Unit) {
    Button(
        shape = CircleShape,
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Gray
        ),
        elevation = ButtonDefaults.buttonElevation(4.dp, 4.dp, 4.dp, 4.dp, 4.dp),
        modifier = Modifier
            .size(62.dp)

    ) {
        Icon(
            painter = painterResource(id = R.drawable.round_navigate_next_24),
            contentDescription = "Navigate to home screen",
            tint = darker_biru_muda,
            modifier = Modifier
                .size(42.dp)
        )
    }
}
