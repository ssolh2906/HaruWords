package com.holsui.haruwords.feature.wordslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.holsui.haruwords.feature.R
import com.holsui.haruwords.feature.util.ActionListener
import com.holsui.haruwords.feature.util.EmptyListener

@Composable
fun Menu(
    actionListener: ActionListener,
    onDismiss: () -> Unit
) {
    Surface(
        modifier = Modifier
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(4.dp))
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextButton(onClick = {
                actionListener.onClick(WordListActions.OnDeleteWordClick)
                onDismiss.invoke()
            }) {
                Text(
                    text = stringResource(id = R.string.word_list_menu_delete),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewMenu() {
    Menu(actionListener = EmptyListener, {})
}