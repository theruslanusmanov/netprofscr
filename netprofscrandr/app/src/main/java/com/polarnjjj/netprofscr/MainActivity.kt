package com.polarnjjj.netprofscr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.polarnjjj.netprofscr.ui.theme.NetprofscrTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NetprofscrTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(24.dp)
                    ) {
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
                        Text(
                            text = buildAnnotatedString {
                                append("38,915$")
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
                        Row(verticalAlignment = Alignment.Bottom) {
                            DiagramColumn(
                                modifier = Modifier.weight(1f),
                                title = "Daily revenue",
                                amount = "37,100",
                                symbol = "$",
                                height = 240.dp,
                            )
                            DiagramColumn(
                                modifier = Modifier.weight(1f),
                                alpha = 0.7f,
                                title = "Daily spend",
                                amount = "12,205",
                                symbol = "$",
                                height = 120.dp,
                            )
                            DiagramColumn(
                                modifier = Modifier.weight(1f),
                                alpha = 0.3f,
                                title = "Taxes",
                                amount = "16.5",
                                symbol = "%",
                                height = 60.dp,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DiagramColumn(
    modifier: Modifier,
    alpha: Float = 1f,
    title: String,
    amount: String,
    symbol: String,
    height: Dp,
) {
    Column(modifier = modifier.padding(1.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),
            )
            Text(
                text = buildAnnotatedString {
                    append(amount)
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
                    fontSize = 18.sp
                ),
            )
        }
        Box(
            modifier = Modifier
                .alpha(alpha)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(14, 35, 26))
                .fillMaxWidth()
                .height(height)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DiagramColumnPreview() {
//    NetprofscrTheme {
//        DiagramColumn("Android")
//    }
//}