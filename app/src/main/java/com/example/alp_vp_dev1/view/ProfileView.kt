package com.example.alp_vp_dev1.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Badge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardBackspace
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.alp_vp_dev1.data.DataStoreManager
import com.example.alp_vp_dev1.model.User
import com.example.alp_vp_dev1.viewmodel.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileView(
    user: User,
    navController: NavController,
    dataStore: DataStoreManager,
    profileViewModel: ProfileViewModel
) {

    val pages = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "History",
            selectedIcon = Icons.Filled.DirectionsCar,
            unselectedIcon = Icons.Outlined.DirectionsCar,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Profile",
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle,
            hasNews = false,
        )
    )

    val selectedItemByIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.White,
                modifier = Modifier
                    .shadow(48.dp)
                    .clip(RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp))
            ) {
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate(ListScreen.Home.name)
                    },
                    icon = {
                        BadgedBox(
                            badge = {  }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Home,
                                contentDescription = "Home"
                            )
                        }
                    },
                    label = {
                        Text(text = "Home")
                    },
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate(ListScreen.History.name + "/" + user.user_id)
                    },
                    icon = {
                        BadgedBox(
                            badge = {  }
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.DirectionsCar,
                                contentDescription = "History"
                            )
                        }
                    },
                    label = {
                        Text(text = "History")
                    },
                )
                NavigationBarItem(
                    selected = true,
                    onClick = {
                        navController.navigate(ListScreen.Profile.name)
                    },
                    icon = {
                        BadgedBox(
                            badge = {  }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.AccountCircle,
                                contentDescription = "Profile"
                            )
                        }
                    },
                    label = {
                        Text(text = "Profile")
                    },
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .background(Color(0xFFD0FF00))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 25.dp, top = 25.dp, end = 25.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardBackspace,
                        contentDescription = "Back",
                        modifier = Modifier
                            .clickable {
                                navController.popBackStack()
                            }
                            .size(28.dp)
                    )

                    Text(
                        text = "Ride Destination",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )
                }

                Text(
                    modifier = Modifier
                        .padding(top = 5.dp, end = 25.dp)
                        .fillMaxWidth(),
                    text = user.name,
                    textAlign = TextAlign.Right,
                    fontSize = 18.sp
                )

//                Column(
//                    modifier = Modifier
//                        .padding(top = 25.dp)
//                        .fillMaxSize()
//                        .background(Color(0XFFFFFFFF), RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp)),
//                    verticalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                    ) {
//                    }
//
//                    Surface {
//                        Column{
//                            Row(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(24.dp, 8.dp),
//                                horizontalArrangement = Arrangement.SpaceBetween
//                            ) {
//                                Text(
//                                    text = "Total : ",
//                                    fontSize = 20.sp,
//                                    fontWeight = FontWeight.Bold
//                                )
//
//                                Text(
//                                    text = "Rp 12.000",
//                                    fontSize = 20.sp,
//                                    fontWeight = FontWeight.Bold
//                                )
//                            }
//
//                            Button(onClick = {
//                                println("button logout dipencet di proffile view")
//                                profileViewModel.logout(
//                                    dataStore,
//                                    navController
//                                )
//                            }) {
//                                Text(
//                                    text = "Logout",
//                                    fontSize = 18.sp,
//                                    fontWeight = FontWeight.ExtraBold
//                                )
//                            }
//                        }
//                    }
//                }
            }
        }
    }
}