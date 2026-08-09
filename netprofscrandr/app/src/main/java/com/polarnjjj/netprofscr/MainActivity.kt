package com.polarnjjj.netprofscr

import android.R.attr.fontWeight
import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
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
                        modifier = Modifier.padding(innerPadding).padding(24.dp)
                    ) {
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
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetprofscrTheme {
        Greeting("Android")
    }
}