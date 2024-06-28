package com.prasanna.easycashbook.ui.cashbooklist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prasanna.easycashbook.local.Cashbook
import com.prasanna.easycashbook.ui.theme.light
import com.prasanna.easycashbook.ui.theme.secondaryBg
import com.prasanna.easycashbook.ui.theme.tertiaryBg

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CashbookListItem(cashbook:Cashbook){
    Column(modifier = Modifier.fillMaxWidth().background(shape = RoundedCornerShape(16.dp), color = MaterialTheme.colors.secondary).padding(8.dp)) {
        Text(cashbook.name, color = MaterialTheme.colors.onSecondary)
        FlowRow(modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.SpaceAround
            ) {
            cashbook.tags.forEach{
                if(it.isNotBlank()){
                    Text(text = it,
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colors.secondaryVariant,
                                shape = RoundedCornerShape(5.dp)
                            )
                            .padding(3.dp),
                        color = MaterialTheme.colors.onSecondary,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                }
            }

        }
        Text(cashbook.createdDate, color = light)

    }
}