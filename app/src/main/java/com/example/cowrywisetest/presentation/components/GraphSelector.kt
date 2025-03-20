package com.example.cowrywisetest.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cowrywisetest.R
import com.example.cowrywisetest.ui.theme.CowryWiseLightBlue
import com.example.cowrywisetest.ui.theme.SansTypography
import com.example.cowrywisetest.utils.GraphType

/**
 * This is a mini tab used to select the Graph Type [GraphType]
 * This Composable shows Two item that can be selected and switched
 * @param onGraphSelectionAction - this return the graph that was selected
 */
@Composable
fun GraphTypeSelector(
    modifier: Modifier = Modifier,
    onGraphSelectionAction : (String)-> Unit
){
    val options = listOf("Past 30 days", "Past 90 days")
    var selectedGraphOption by remember { mutableStateOf(options.first()) }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(options){
            Column(modifier = modifier
                .clickable {
                    selectedGraphOption = it
                    onGraphSelectionAction(it)
                },
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    fontFamily = FontFamily(Font(R.font.josefin_sans)),
                    style = SansTypography.displayLarge.copy(
                        color = if(selectedGraphOption == it) Color.White else CowryWiseLightBlue,
                        fontSize = 21.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight.W900
                    ),
                    text = it,
                )

                if (selectedGraphOption == it) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .background(Color.Green, shape = CircleShape)
                    )
                }
            }
        }
    }
}
