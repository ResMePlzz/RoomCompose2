package com.example.roomcompose2.tools

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.roomcompose2.domain.NoteModel

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ItemNote(noteModel: NoteModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(100.dp),
        shape = RoundedCornerShape(20)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text(text = noteModel.noteTheme)
        }

    }


}