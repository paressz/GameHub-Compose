package com.farez.gamehub_compose.ui.screen.inputspek

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.farez.gamehub_compose.R
import com.farez.gamehub_compose.ui.theme.FontIceberg
import com.farez.gamehub_compose.ui.theme.biruMuda
import com.farez.gamehub_compose.ui.theme.biruMuda100
import com.farez.gamehub_compose.ui.theme.darker_biru_muda

@Composable
fun InputSpekScreen() {
    var cpu by remember { mutableStateOf("") }
    var vga by remember { mutableStateOf("") }
    var hdd by remember { mutableStateOf("") }
    var ram by remember { mutableStateOf("") }

    ConstraintLayout (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        val (cpuC, vgaC, hddC, ramC,cariC, headerC) = createRefs()
        Header(
            modifier = Modifier
                .constrainAs(headerC) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        CustomiezedTextField(
            text = cpu,
            onValueChanged = {cpu = it},
            label = "CPU",
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .constrainAs(cpuC) {
                    top.linkTo(headerC.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                },
        )
        CustomiezedTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .constrainAs(ramC) {
                    top.linkTo(cpuC.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                },
            text = ram,
            label = "RAM",
            onValueChanged = {ram = it},
            keyboardType = KeyboardType.Number
        )
        CustomiezedTextField(
            keyboardType = KeyboardType.Number,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .constrainAs(hddC) {
                    top.linkTo(ramC.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                },
            text = hdd,
            label = "HDD",
            onValueChanged = {hdd = it}
        )
        CustomiezedTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .constrainAs(vgaC) {
                    top.linkTo(hddC.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                },
            text = vga,
            label = "VGA",
            onValueChanged = {vga = it})
        Button(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
                .height(48.dp)
                .constrainAs(cariC) {
                    top.linkTo(vgaC.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = biruMuda,
                contentColor = Color.White
            ),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Cari Game", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun CustomiezedTextField(
    modifier: Modifier,
    text : String,
    label : String,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChanged : (String) -> Unit
    ) {
   OutlinedTextField(
       value = text,
       onValueChange = onValueChanged,
       singleLine = true,
       label = {
           Text(text = label)
       },
       keyboardOptions = KeyboardOptions(
           imeAction = ImeAction.Done,
           keyboardType = keyboardType,
           autoCorrect = false,
       ),
       modifier = modifier,
       colors = OutlinedTextFieldDefaults.colors(
           focusedBorderColor = darker_biru_muda,
           focusedLabelColor = darker_biru_muda,
           cursorColor = darker_biru_muda,
       )
   )
}

@Composable
fun Header(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(bottomEndPercent = 50, bottomStartPercent = 50))
            .shadow(6.dp)
            .background(biruMuda)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.stikps),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 2.dp)
                .align(Alignment.TopEnd),
            tint = darker_biru_muda
        )
        Text(
            text = buildAnnotatedString
            {
                withStyle(style = SpanStyle(color = Color.White)) {append("Game")}
                withStyle(style = SpanStyle(color = Color.Black)) {append("Hub")}
            },
            fontFamily = FontIceberg,
            fontSize = 52.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun InputSpekPrev() {
    InputSpekScreen()
}