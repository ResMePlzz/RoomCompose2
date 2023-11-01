package com.example.roomcompose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.roomcompose2.Navigation.MyNavHost
import com.example.roomcompose2.data.NoteDataBase
import com.example.roomcompose2.data.NoteRepository
import com.example.roomcompose2.domain.NoteModel
import com.example.roomcompose2.presentation.viewModels.StartScreenViewModel
import com.example.roomcompose2.presentation.viewModels.ViewModelFactory
import com.example.roomcompose2.ui.theme.RoomCompose2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val roomDB = NoteDataBase.getDatabase(this)
            val noteDao = roomDB.getNoteDao()
            val noteRepository = NoteRepository(noteDao)
            val viewModel: StartScreenViewModel =
                viewModel(factory = ViewModelFactory(noteRepository))

            val navigation = rememberNavController()


            MyNavHost(navigation = navigation, viewModel)

        }

    }
}