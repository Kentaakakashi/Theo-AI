package com.kenta.theo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowUpward
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Night = Color(0xFF070A12)
private val Panel = Color(0xFF111827)
private val Cyan = Color(0xFF69F5FF)
private val Violet = Color(0xFF9B7BFF)
private val Muted = Color(0xFF8B96AB)
private val White = Color(0xFFF4F7FF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = android.graphics.Color.rgb(7, 10, 18)
        window.navigationBarColor = android.graphics.Color.rgb(7, 10, 18)
        window.decorView.systemUiVisibility = 0
        setContent {
            MaterialTheme {
                TheoHome()
            }
        }
    }
}

@Composable
private fun TheoHome() {
    var prompt by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize(), color = Night) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF11152B), Night, Color(0xFF080B14))
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 22.dp, vertical = 18.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .background(Brush.linearGradient(listOf(Cyan, Violet))),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Rounded.Bolt, contentDescription = null, tint = Night, modifier = Modifier.size(25.dp))
                    }
                    Spacer(Modifier.width(11.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text("THEO", color = White, fontSize = 19.sp, fontWeight = FontWeight.Black, letterSpacing = 3.sp)
                        Text("PERSONAL INTELLIGENCE", color = Muted, fontSize = 9.sp, letterSpacing = 1.5.sp)
                    }
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(Color.White.copy(alpha = 0.04f))
                            .border(1.dp, Color.White.copy(alpha = 0.09f), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Rounded.Settings, contentDescription = "Settings", tint = Muted)
                    }
                }

                Spacer(Modifier.height(36.dp))
                Box(contentAlignment = Alignment.Center, modifier = Modifier.size(220.dp)) {
                    Box(
                        modifier = Modifier
                            .size(210.dp)
                            .border(1.dp, Cyan.copy(alpha = 0.12f), CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .size(174.dp)
                            .border(1.dp, Violet.copy(alpha = 0.20f), CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .size(138.dp)
                            .shadow(32.dp, CircleShape, ambientColor = Cyan.copy(alpha = 0.28f), spotColor = Violet.copy(alpha = 0.25f))
                            .background(Brush.radialGradient(listOf(Color(0xFF8EF9FF), Color(0xFF5267D9), Color(0xFF6A35B5), Color(0xFF17162F))), CircleShape)
                            .border(1.dp, Color.White.copy(alpha = 0.38f), CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .size(66.dp)
                            .background(Brush.radialGradient(listOf(Color.White.copy(alpha = 0.85f), Cyan.copy(alpha = 0.25f), Color.Transparent)), CircleShape)
                    )
                }

                Spacer(Modifier.height(16.dp))
                Text("Your world. In sync.", color = White, fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(8.dp))
                Text(
                    "A personal AI that learns your flow
and helps you get things done.",
                    color = Muted,
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                Spacer(Modifier.height(24.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    StatusChip("CORE", "STANDBY", Cyan)
                    StatusChip("MEMORY", "LOCAL", Violet)
                }

                Spacer(Modifier.height(28.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(24.dp))
                        .background(Brush.linearGradient(listOf(Color(0xFF171E32), Color(0xFF101522))))
                        .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(24.dp))
                        .padding(18.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.History, contentDescription = null, tint = Cyan, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("READY WHEN YOU ARE", color = Cyan, fontSize = 10.sp, fontWeight = FontWeight.Bold, letterSpacing = 1.4.sp)
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(
                        "Theo's Android core is online. AI connections are the next setup step.",
                        color = White.copy(alpha = 0.86f),
                        fontSize = 13.sp,
                        lineHeight = 19.sp
                    )
                }

                Spacer(Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(22.dp))
                        .background(Color(0xFF151B2B))
                        .border(1.dp, Color.White.copy(alpha = 0.12f), RoundedCornerShape(22.dp))
                        .padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        BasicTextField(
                            value = prompt,
                            onValueChange = { prompt = it },
                            modifier = Modifier.weight(1f).padding(vertical = 12.dp),
                            textStyle = TextStyle(color = White, fontSize = 14.sp),
                            cursorBrush = Brush.verticalGradient(listOf(Cyan, Violet)),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                            keyboardActions = KeyboardActions(onSend = { prompt = "" }),
                            decorationBox = { inner ->
                                Box {
                                    if (prompt.isEmpty()) Text("Talk to Theo…", color = Muted, fontSize = 14.sp)
                                    inner()
                                }
                            }
                        )
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(RoundedCornerShape(15.dp))
                                .background(Brush.linearGradient(listOf(Cyan, Violet))),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Rounded.ArrowUpward, contentDescription = "Send", tint = Night)
                        }
                    }
                }
                Spacer(Modifier.height(10.dp))
                Text("PRIVATE BY DESIGN  •  BUILT FOR YOUR PHONE", color = Color(0xFF626D83), fontSize = 9.sp, letterSpacing = 1.2.sp)
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun StatusChip(label: String, value: String, accent: Color) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(accent.copy(alpha = 0.07f))
            .border(1.dp, accent.copy(alpha = 0.22f), RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.size(5.dp).background(accent, CircleShape))
        Spacer(Modifier.width(7.dp))
        Text("$label  ", color = Muted, fontSize = 9.sp, letterSpacing = 0.8.sp)
        Text(value, color = accent, fontSize = 9.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp)
    }
}
