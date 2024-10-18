package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.data.model.CardInformation

@Composable
fun CustomCard(cardInformation: CardInformation, navController: NavController, size: Int) {
    Card(
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.size(size.dp),
        onClick = { navController.navigate(cardInformation.appScreen) }
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                modifier = Modifier.size(50.dp),
                painter = painterResource(id = cardInformation.icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = cardInformation.title)
        }
    }
}