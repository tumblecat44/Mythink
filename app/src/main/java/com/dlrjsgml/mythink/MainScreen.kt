package com.dlrjsgml.mythink

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.room.Room
import com.dlrjsgml.mythink.room.AppDataBase
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val datePickerState = rememberDatePickerState()
    var showModal by remember { mutableStateOf(false) }
    val selectedDate = datePickerState.selectedDateMillis

    val context = LocalContext.current.applicationContext

    // 날짜가 선택되면 모달 보여주기
    LaunchedEffect(selectedDate) {
        if (selectedDate != null) {
            showModal = true
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            DatePicker(
                modifier = Modifier.align(Alignment.Center),
                state = datePickerState,
            )

            if (showModal && selectedDate != null) {
                val formattedDate = remember(selectedDate) {
                    SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date(selectedDate))
                }


                Dialog(onDismissRequest = { showModal = false }) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.4f)
                            .background(Color.White)
                            .padding(16.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxSize()) {
                            // 날짜 텍스트 (왼쪽 위)
                            Text(
                                text = formattedDate,
                                color = Color.Black,
                                modifier = Modifier.align(Alignment.Start)
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            LazyColumn(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {

                            }

                            val text = remember { mutableStateOf("") }

                            TextField(
                                value = text.value,
                                onValueChange = { newText -> text.value = newText }
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun BoxModal(
        selectedDate: Long,
        onDismiss: () -> Unit,
    ) {

    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
