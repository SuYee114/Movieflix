package org.example.moviekmm

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moviekmm.composeapp.generated.resources.Res
import moviekmm.composeapp.generated.resources.compose_multiplatform
import moviekmm.composeapp.generated.resources.movie1
import moviekmm.composeapp.generated.resources.movie2
import moviekmm.composeapp.generated.resources.movie3
import moviekmm.composeapp.generated.resources.movie4
import moviekmm.composeapp.generated.resources.movie5
import org.example.moviekmm.Model.MovieData
import org.example.moviekmm.View.MovieItemView


@Composable
fun HomePage(){
    var searchQuery= remember { mutableStateOf("") }
    val items = listOf(
        MovieData("Title1","Luca", Res.drawable.movie1),
        MovieData("Title2","Boss Baby",Res.drawable.movie2),
        MovieData("Title5","Elemental",Res.drawable.movie5),
        MovieData("Title3","Moana 2",Res.drawable.movie3),
        MovieData("Title4","Despicable Me 4",Res.drawable.movie4),
    )

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
    ){
        LazyColumn (//column is very important because each view will appears as
            // column view so overlapping will be reduced
            modifier = Modifier.fillMaxWidth(),
        )
        {
            item {
                Text(
                    text = "Welcome To Movieflix",
                    color = Color.White,
                    fontSize = 21.sp,
                    textAlign = TextAlign.Center, // Centers the text content
                    modifier = Modifier
                        .fillMaxWidth() // Allows centering within the available width
                        .padding(start = 8.dp, top = 10.dp, end = 8.dp, bottom = 8.dp)
                )

            }
            item {
                //Search View
                BasicTextField(
                    value = searchQuery.value,
                    onValueChange = {searchQuery.value=it},
                    modifier = Modifier.fillMaxWidth()
                        .padding(8.dp)
                        .height(45.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .border(1.dp,Color.Gray, RoundedCornerShape(8.dp))
                        .padding(12.dp)
                )
            }
            item {
                Text(
                    text = "Trending Movies",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
                )
                CustomMovieListViewHorizontal(items)
                //To make space between this view
                Spacer(modifier = Modifier.height(10.dp))
                //CustomMovieListViewVerticle(items)
            }
            item {
                Text(
                    text = "Upcoming Movies",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
                )//Title
                CustomMovieListViewHorizontal(items)//image and movie names
                //To make space between this view
                Spacer(modifier = Modifier.height(10.dp))
            }
            item {
                Text(
                    text = "Top related Movies",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
                )
                CustomMovieListViewHorizontal(items)
                //To make space between this view
                Spacer(modifier = Modifier.height(10.dp))
            }

        }
    }

}
//Lazy column is verticle and Row is horizontal
//@Composable
//fun CustomMovieListViewVerticle(movie: List<MovieData>){
//    LazyColumn {
//        items(movie) {
//            MovieItemView(it) // Pass true for vertical layout
//        }
//    }
//}

@Composable
fun CustomMovieListViewHorizontal(movie: List<MovieData>){
    LazyRow {
        items(movie) {
            MovieItemView(it) // Pass false for horizontal layout
        }
    }
}