package com.example.roomcompose2.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.roomcompose2.domain.NoteModel
import com.example.roomcompose2.presentation.viewModels.StartScreenViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNoteScreen(navigation: NavHostController, startScreenViewModel: StartScreenViewModel) {

    val themeNoteState: MutableState<String> = remember {
        mutableStateOf("")
    }

    val textNoteState: MutableState<String> = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Your note", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(3.dp))
            OutlinedTextField(value = themeNoteState.value,
                onValueChange = { inputText -> themeNoteState.value = inputText },
                placeholder = { Text(text = "Theme note") })

            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = textNoteState.value,
                onValueChange = { inputText -> textNoteState.value = inputText },
                placeholder = { Text(text = "Text note") },
                modifier = Modifier.height(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                startScreenViewModel.addNote(
                    noteModel = NoteModel(
                        noteText = textNoteState.value,
                        noteTheme = themeNoteState.value
                    ), onFailAddNote = { Log.d("insertNoteTag", "fail") },
                    onSuccessAddNote = { Log.d("insertNoteTag", "success") }
                )
            }) {
                Text(text = "Add note")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "home screen", modifier = Modifier.clickable {
                navigation.popBackStack()
            })

        }
    }
}