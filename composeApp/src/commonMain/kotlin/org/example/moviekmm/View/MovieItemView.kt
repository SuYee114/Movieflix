package org.example.moviekmm.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.moviekmm.Model.MovieData
import org.jetbrains.compose.resources.painterResource

@Composable


fun MovieItemView(movie: MovieData) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp)) // Add rounded corners with 8.dp radius
                .background(Color.Black)
                .border(1.dp,Color.Black, RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painterResource(movie.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Text(
                text = movie.description,
                color = Color.White,
                fontSize = 14.sp, // Adjust the font size for the description
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 10.dp, end = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
}


