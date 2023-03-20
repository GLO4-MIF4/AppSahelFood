package com.company.appfood.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.company.appfood.ui.theme.dark_gray


@Composable
fun PageIndicator(pageCount: Int, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(if (pageCount == 0) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 0) dark_gray else Color.LightGray)
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 1) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 1) dark_gray else Color.LightGray)
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Box(
                modifier = Modifier
                    .size(if (pageCount == 2) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 2) dark_gray else Color.LightGray)
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))

            Box(
                modifier = Modifier
                    .size(if (pageCount == 3) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 3) dark_gray else Color.LightGray)
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))

            Box(
                modifier = Modifier
                    .size(if (pageCount == 4) 10.dp else 8.dp)
                    .clip(CircleShape)
                    .background(if (pageCount == 4) dark_gray else Color.LightGray)
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))


        }


    }
}
