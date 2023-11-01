package com.example.roomcompose2.presentation

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
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
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DetailsScreen(navigation: NavHostController, modelID: Long, startScreenViewModel: StartScreenViewModel) {

    val myNote = remember {
        mutableStateOf(NoteModel())
    }




    val themeNoteStateDetails: MutableState<String> = remember {
        mutableStateOf("")
    }

    val textNoteStateDetails: MutableState<String> = remember {
        mutableStateOf("")
    }

    SideEffect {
        Log.d("myNoteTag", "${myNote.value}")
        Log.d("myNoteTagID", "${modelID}")
    }

    LaunchedEffect(key1 = true){
        myNote.value = startScreenViewModel.getNoteById(modelID, onSuccess = {}, onFail = {}).value ?: NoteModel()
        delay(1000)
        themeNoteStateDetails.value = myNote.value.noteTheme
        textNoteStateDetails.value = myNote.value.noteText
    }


    Column(modifier = Modifier.fillMaxSize(1f)) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .weight(3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            OutlinedTextField(value = themeNoteStateDetails.value,
                onValueChange = { inputText -> themeNoteStateDetails.value = inputText })

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = textNoteStateDetails.value,
                onValueChange = { inputText -> textNoteStateDetails.value = inputText },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(500.dp)
            )


            Button(onClick = { /*TODO*/ }) {
                Text(text = "Edit note")

            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = "Delete note")
            }

            Button(onClick = { navigation.navigate(AllScreens.StartScreen.route)}) {
                Text(text = "Back")
            }

        }

    }
}