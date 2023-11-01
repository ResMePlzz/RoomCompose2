package com.example.roomcompose2.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.roomcompose2.Navigation.AllScreens
import com.example.roomcompose2.domain.NoteModel
import com.example.roomcompose2.presentation.viewModels.StartScreenViewModel
import com.example.roomcompose2.tools.ItemNote


//@Preview(showSystemUi = true, showBackground = true)
@Composable()
fun StartScreen(navigation: NavHostController, startScreenViewModel: StartScreenViewModel) {


    val listNote = startScreenViewModel.listNote.observeAsState(listOf()).value

    Box(modifier = Modifier.fillMaxSize(1f)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(listNote) { note ->
                Row(modifier = Modifier.clickable {
                    navigation.navigate(
                        route = "${AllScreens.DetailsScreen.route}/${note.id}"
                    )
                }) {
                    ItemNote(noteModel = note)

                }

            }
        }

        FloatingActionButton(
            onClick = { navigation.navigate(AllScreens.AddNoteScreen.route) },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(5.dp)
        ) {
            Icon(Icons.Filled.Add, "")

        }

    }
}
