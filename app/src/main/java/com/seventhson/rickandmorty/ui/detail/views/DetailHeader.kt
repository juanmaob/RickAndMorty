package com.seventhson.rickandmorty.ui.detail.views
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.seventhson.rickandmorty.ui.common.BackButton
import com.seventhson.rickandmorty.ui.ui.theme.Black70

@Composable
fun DetailHeader(
    name: String,
    picture: String,
    onClickBack: () -> Unit
) {
    val headerHeight = 300.dp

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(headerHeight)
    ) {
        Image(
            painter = rememberImagePainter(picture) {
                crossfade(true)
            },
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        GradientText(
            text = name,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(headerHeight.div(3))
        )

        BackButton(
            modifier = Modifier,
            onClick = onClickBack
        )
    }

}

@Composable
fun GradientText(modifier: Modifier, text: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Black70
                    )
                )
            )
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
fun DetailHeaderPreview() {
    DetailHeader(name = "Nombre de personaje", picture = "", onClickBack = {})
}