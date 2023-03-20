//package com.company.appfood.component
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CornerSize
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material.icons.filled.Edit
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//import com.company.appfood.domain.model.UserModel
//import com.company.appfood.ui.theme.AppFoodTheme
//
//@Composable
//fun UserItem(
//    modifier: Modifier = Modifier,
//    user: UserModel,
//    onEditUser: () -> Unit,
//    onDeleteUser: () -> Unit
//) {
//    Card(
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(horizontal = 14.dp, vertical = 12.dp),
//        elevation = 3.dp,
//        shape = RoundedCornerShape(corner = CornerSize(16.dp))
//    ) {
//        Row(
//            modifier = Modifier.padding(16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Column(verticalArrangement = Arrangement.Center) {
//                Text(
//                    text = "${user.name} ",
//                    style = MaterialTheme.typography.h6
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = user.phone.toString(),
//                    style = MaterialTheme.typography.caption.copy(color = Color.DarkGray)
//                )
//                Spacer(modifier = Modifier.height(4.dp))
//                Text(
//                    text = "${user.email}, ${user.password}",
//                    style = MaterialTheme.typography.h6
//                )
//            }
//            Row {
//                IconButton(onClick = onEditUser) {
//                    Icon(
//                        imageVector = Icons.Filled.Edit,
//                        contentDescription = null,
//                        tint = Color.Green
//                    )
//                }
//                IconButton(onClick = onDeleteUser) {
//                    Icon(
//                        imageVector = Icons.Filled.Delete,
//                        contentDescription = null,
//                        tint = Color.Red
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewUserItem() {
//    AppFoodTheme {
//        UserItem(
//            user = UserModel(name = "Abdel", email = "abdel@gmail.com", phone = "691093443", password = "koire_dev"),
//            onEditUser = {},
//            onDeleteUser = {}
//        )
//    }
//}