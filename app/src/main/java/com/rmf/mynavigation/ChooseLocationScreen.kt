package com.rmf.mynavigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.result.ResultBackNavigator

@OptIn(ExperimentalFoundationApi::class)
@Destination
@Composable
fun ChooseLocationScreen(
    resultBackNavigator: ResultBackNavigator<String>
) {
    val listLocation = remember {
        listOf("Bandung", "Cianjur", "Ciamis", "Tangerang", "Sukabumi", "Jakarta")
    }

    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)) {
        stickyHeader {
            Text(text = "Pilih Lokasi", fontSize = 24.sp)
        }
        item { Spacer(modifier = Modifier.height(24.dp)) }

        items(listLocation) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .clickable {
                        resultBackNavigator.navigateBack(item)
                    }
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 16.dp)
            )

            if (item != listLocation.last())
                Divider(modifier = Modifier.fillMaxWidth())
        }

    }
}