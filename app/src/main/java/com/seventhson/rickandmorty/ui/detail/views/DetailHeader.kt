package com.seventhson.rickandmorty.ui.detail.views
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.seventhson.rickandmorty.R
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

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(headerHeight.div(3))
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
                text = name,
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

        Image(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = Color.Black),
            modifier = Modifier
                .size(66.dp)
                .padding(16.dp)
                .background(shape = CircleShape, color = Color.White)
                .padding(4.dp)
                .align(Alignment.TopStart)
                .clip(shape = CircleShape)
                .clickable { onClickBack() }
        )
    }

}