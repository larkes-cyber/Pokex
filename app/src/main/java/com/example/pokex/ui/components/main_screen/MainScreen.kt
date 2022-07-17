package com.example.pokex.ui.components.main_screen

import android.graphics.fonts.FontStyle
import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pokex.ui.theme.LightBlue
import com.example.pokex.ui.theme.TypeNormal
import com.example.pokex.ui.view_model.main_screen_view_model.MainScreenViewModel

@Composable
fun MainScreen(navHostController: NavHostController,vm:MainScreenViewModel){

    val state = vm.state.value

    if(state.error.isNotBlank()){
        Log.d("data",state.error)
    }
    if(state.isLoading){
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }
    if(state.info.isNotEmpty()){

        state.info.forEach{
            Log.d("data","info:${it.name}")
        }

        Surface(modifier = Modifier
            .fillMaxSize(),
            color = LightBlue
        ) {
            Column {
                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = com.example.pokex.R.drawable.ic_international_pok_mon_logo),
                    contentDescription = "Poke",
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                SearchBar("Search..."){

                }
                LazyColumn(){
                    itemsIndexed(
                        state.info
                    ){index,string ->
                        Text(
                            text = string.name,
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 20.sp
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp)
                        )
                    }
                }
            }
        }
    }






}

@Composable
fun SearchBar(
    hint:String = "",
    onChange:(String) -> Unit = {}
){

    val state = remember{
        mutableStateOf("")
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp,vertical = 20.dp)
    ) {
        TextField(
        value = state.value,
        label = {Text(text = hint)},
        onValueChange = {
            state.value = it
            onChange(it)
        },
        singleLine = true,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .shadow(elevation = 5.dp, CircleShape)
            .background(Color.White, CircleShape)
    )
    }

}