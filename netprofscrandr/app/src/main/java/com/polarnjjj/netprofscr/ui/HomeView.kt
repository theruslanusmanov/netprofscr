package com.polarnjjj.netprofscr.ui

import android.R.attr.fontWeight
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomeView(innerPadding: PaddingValues) {
    var targetValue by remember { mutableStateOf(0) }

    val animatedValue by animateIntAsState(
        targetValue = targetValue,
        animationSpec = tween(durationMillis = 1000) // 2 seconds duration
    )

    LaunchedEffect(Unit) {
        targetValue = 38915
    }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonSketch()
            ButtonSketch()
        }
        // Header text
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Net profit",
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 48.sp
                ),
            )
            Text(
                text = "May 9",
                style = TextStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 18.sp
                ),
            )
        }
        val numberFormatter = remember { NumberFormat.getNumberInstance(Locale.getDefault()) }
        val formattedText = numberFormatter.format(animatedValue)
        Text(
            text = buildAnnotatedString {
                append("$formattedText")
                withStyle(
                    style = SpanStyle(
                        fontSize = 24.sp,
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("$")
                }
            },
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp
            ),
        )
        // Diagrams
        Row(
            modifier = Modifier.padding(top = 24.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            DiagramColumn(
                modifier = Modifier.weight(1f),
                title = "Daily revenue",
                amount = 37100,
                symbol = "$",
                height = 240.dp,
            )
            DiagramColumn(
                modifier = Modifier.weight(1f),
                alpha = 0.7f,
                title = "Daily spend",
                amount = 12205,
                symbol = "$",
                height = 120.dp,
            )
            DiagramColumn(
                modifier = Modifier.weight(1f),
                alpha = 0.3f,
                title = "Taxes",
                amount = 17,
                symbol = "%",
                height = 60.dp,
            )
        }
        // Transactions
        Row(
            modifier = Modifier
                .padding(vertical = 24.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.width(150.dp),
                text = "Completed Transactions",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp
                ),
            )
            ButtonSketch()
        }
        Column() {
            repeat(2) {
                Box(
                    modifier = Modifier
                        .padding(vertical = 1.dp)
                        .clip(RoundedCornerShape(percent = 100))
                        .fillMaxWidth()
                        .height(64.dp)
                        .background(Color(16, 172, 98))
                )
            }
        }
    }
}


@Composable
fun ButtonSketch() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(percent = 100))
            .width(64.dp)
            .height(64.dp)
            .background(Color(16, 172, 98))
    )
}

@Composable
fun DiagramColumn(
    modifier: Modifier,
    alpha: Float = 1f,
    title: String,
    amount: Int,
    symbol: String,
    height: Dp,
) {
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        expanded = true
    }

    var targetValue by remember { mutableIntStateOf(0) }

    val animatedValue by animateIntAsState(
        targetValue = targetValue,
        animationSpec = tween(durationMillis = 1000) // 2 seconds duration
    )

    LaunchedEffect(Unit) {
        targetValue = amount
    }

    Column(modifier = modifier
        .padding(1.dp)
        .height(height + 50.dp), verticalArrangement = Arrangement.Bottom) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),
            )
            val numberFormatter = remember { NumberFormat.getNumberInstance(Locale.getDefault()) }
            val formattedText = numberFormatter.format(animatedValue)
            Text(
                text = buildAnnotatedString {
                    append("$formattedText")
                    withStyle(
                        style = SpanStyle(
                            fontSize = 12.sp,
                            baselineShift = BaselineShift.Superscript
                        )
                    ) {
                        append(symbol)
                    }
                },
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                ),
            )
        }
        Box(
            modifier = Modifier
                .alpha(alpha)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(14, 35, 26))
                .fillMaxWidth()
                .padding(top = if (expanded) 0.dp else height)
                .animateContentSize()
                .height(if (expanded) height else 0.dp),
        )
    }
}