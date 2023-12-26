package com.farez.gamehub_compose.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import com.farez.gamehub_compose.AppViewModel
import com.farez.gamehub_compose.R
import com.farez.gamehub_compose.ui.screen.gamelist.GameListScreen
import com.farez.gamehub_compose.ui.screen.inputspek.InputSpekScreen

@Composable
fun MainScreen(
    navController: NavHostController,
    appViewModel: AppViewModel,
    navigateToDetail: (String) -> Unit
) {

    var isInputScreenSelected by remember { mutableStateOf(false) }
    val onClick: (Boolean) -> Unit = {
        isInputScreenSelected = it
    }
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (navBar, inputSc, gameListSc, header) = createRefs()

        Header(
            modifier = Modifier
                .constrainAs(header) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.wrapContent

                }
        )
        if (isInputScreenSelected) {
            InputSpekScreen(
                navController = navController,
                appViewModel = appViewModel,
                modifier = Modifier
                    .constrainAs(inputSc) {
                        top.linkTo(header.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(navBar.top)
                        height = Dimension.fillToConstraints
                    }
            )
        } else {
            GameListScreen(
                appViewModel = appViewModel,
                navigateToDetail = navigateToDetail,
                modifier = Modifier
                    .constrainAs(gameListSc) {
                        top.linkTo(header.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                    }
            )
        }
        BottomNavBar(
            navController = navController,
            onClick = onClick,
            modifier = Modifier
                .constrainAs(navBar) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        )
    }
}


@Composable
fun BottomNavBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onClick: (Boolean) -> Unit
) {
    var isInputSelected by remember { mutableStateOf(false) }
    val changeInput: (Boolean) -> Unit = { isInputSelected = it }
    Box(
        modifier = modifier
            .navigationBarsPadding()
            .fillMaxWidth(0.65f)
            .shadow(2.dp, CircleShape)
            .clip(CircleShape)
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        BottomNavItem(
            iconId = R.drawable.iconstkps,
            title = "Game",
            selected = !isInputSelected,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 32.dp)
                .clickable {
                    onClick(false)
                    changeInput(false)
                }
        )
        BottomNavItem(
            iconId = R.drawable.monitor,
            title = "PC",
            selected = isInputSelected,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 32.dp)
                .clickable {
                    onClick(true)
                    changeInput(true)
                }
        )
    }
}

//@Preview
//@Composable
//fun navbar() {
//    MainScreen(rememberNavController(), appViewModel = app)
//}