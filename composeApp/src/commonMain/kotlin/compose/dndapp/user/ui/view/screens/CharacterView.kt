package compose.dndapp.user.ui.view.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dndappmp.composeapp.generated.resources.Res
import dndappmp.composeapp.generated.resources.agility_statsicon
import dndappmp.composeapp.generated.resources.charisma_statsicon
import dndappmp.composeapp.generated.resources.constitution_statsicon
import dndappmp.composeapp.generated.resources.intelligence_statsicon
import dndappmp.composeapp.generated.resources.luck_statsicon
import dndappmp.composeapp.generated.resources.spirit_statsicon
import dndappmp.composeapp.generated.resources.strength_statsicon
import org.jetbrains.compose.resources.painterResource

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.VerticalAlignmentLine
import kotlin.math.log

data class Class(val name: String)

fun classes() = listOf(
    Class("Fighter"),
    Class("Rogue"),
    Class("Mage"),
    Class("Bard"),
    Class("Priest")
)

@Composable
fun CharacterView(){

    val verticalScrollState: ScrollState = rememberScrollState()
    val boxScrollableState: ScrollableState = rememberScrollableState { 2.0F }

    var charInfoEditState by remember { mutableStateOf(false) }
    val firstBoxEditIcon: ImageVector = if(!charInfoEditState) Icons.Default.Edit else Icons.Default.Check

    var nameText by remember { mutableStateOf("DnDude Name-o") }
    var ageText by remember { mutableIntStateOf(1) }
    var ancestryText by remember { mutableStateOf("Tashi (The Cunning)") }
    var levelText by remember { mutableIntStateOf(1) }

    var classText by remember { mutableStateOf("Class Sample") }
    var classExpanded by remember { mutableStateOf(false) }

    var healthText by remember { mutableIntStateOf(0) }
    var strText by remember { mutableIntStateOf(0) }
    var intText by remember { mutableIntStateOf(0) }
    var conText by remember { mutableIntStateOf(0) }
    var sptText by remember { mutableIntStateOf(0) }
    var agiText by remember { mutableIntStateOf(0) }
    var chrText by remember { mutableIntStateOf(0) }
    var lckText by remember { mutableIntStateOf(0) }

    var exhaustCount by remember { mutableIntStateOf(0) }


    Box(modifier = Modifier
        .padding(8.dp)
        .verticalScroll(verticalScrollState, enabled = true)
        .scrollable(boxScrollableState, orientation = Orientation.Vertical, enabled = true)
        .fillMaxSize()
    ){
        Column (modifier = Modifier
            .fillMaxSize()
        ){
            // CHARACTER INFO //
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(BorderStroke(2.dp, Color.Black),
                        shape = RoundedCornerShape(percent = 5))
                    .padding(8.dp)
            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ){
                    Row ( //Character Info Label and Edit/Save Icon
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.SpaceAround
                    ){
                        Text(
                            modifier = Modifier,
                            text = "Profile",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 2.dp, top = 8.dp),
                            contentAlignment = Alignment.TopEnd
                        ){
                            IconButton( //Edit Button
                                modifier = Modifier
                                    .size(20.dp),
                                onClick = {
                                    charInfoEditState = (!charInfoEditState)
                                }
                            ) {
                                Icon(
                                    imageVector = firstBoxEditIcon,
                                    contentDescription = null
                                )
                            }
                        }
                    }

                    Row( //Character Info 1st Row
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .heightIn(min = 32.dp, max = 60.dp),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        IconButton( //Player Portrait
                            modifier = Modifier
                                .heightIn(min = 60.dp, max = 120.dp)
                                .weight(1.5f),
                            onClick = { }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Face,
                                contentDescription = null
                            )
                        }

                        Spacer(modifier = Modifier.width(20.dp))

                        TextField( //Name
                            modifier = Modifier
                                .weight(2.5f),
                            value = nameText,
                            enabled = charInfoEditState,
                            onValueChange = {
                                if (it.length <= 100) nameText = it
                            },
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Text
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                disabledTextColor = Color.Black,
                                disabledLabelColor = Color.Blue,
                                disabledIndicatorColor = Color.Transparent,
                                backgroundColor = Color.Transparent
                            ),
                            singleLine = true,
                            textStyle = TextStyle(),
                            label = {
                                Text(
                                    text = "Name",
                                    fontSize = 12.sp
                                )
                            }
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        TextField( //Age
                            modifier = Modifier
                                .weight(0.7f),
                            value = ageText.toString(),
                            enabled = charInfoEditState,
                            onValueChange = {
                                try{
                                    if (it.length <= 4) ageText = it.toInt()
                                }
                                catch (_: Exception){

                                }
                            },
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                disabledTextColor = Color.Black,
                                disabledLabelColor = Color.Blue,
                                disabledIndicatorColor = Color.Transparent,
                                backgroundColor = Color.Transparent
                            ),
                            textStyle = TextStyle(
                                textAlign = TextAlign.Center
                            ),
                            singleLine = true,
                            label = {
                                Text(
                                    text = "Age",
                                    fontSize = 12.sp
                                )
                            }
                        )
                    }

                    Row( //Character Info 2nd Row
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .heightIn(min = 32.dp, max = 60.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        TextField( //Ancestry
                            modifier = Modifier
                                .weight(2f),
                            value = ancestryText,
                            enabled = charInfoEditState,
                            onValueChange = {
                                if (it.length <= 20) ancestryText = it
                            },
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Text
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                disabledTextColor = Color.Black,
                                disabledLabelColor = Color.Blue,
                                disabledIndicatorColor = Color.Transparent,
                                backgroundColor = Color.Transparent
                            ),
                            singleLine = true,
                            label = {
                                Text(
                                    text = "Ancestry",
                                    fontSize = 12.sp
                                )
                            }
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        TextField( //Class
                            modifier = Modifier
                                .weight(2f),
                            value = classText,
                            enabled = charInfoEditState,
                            onValueChange = {
                                if (it.length <= 20) classText = it
                            },
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Text
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                disabledTextColor = Color.Black,
                                disabledLabelColor = Color.Blue,
                                disabledIndicatorColor = Color.Transparent,
                                backgroundColor = Color.Transparent
                            ),
                            singleLine = true,
                            label = {
                                Text(
                                    text = "Class",
                                    fontSize = 12.sp
                                )
                            }
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        TextField( //Level
                            modifier = Modifier
                                .weight(0.6f),
                            value = levelText.toString(),
                            enabled = charInfoEditState,
                            onValueChange = {
                                try{
                                    if (it.length <= 2) levelText = it.toInt()
                                }
                                catch (_: Exception){

                                }
                            },
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
                                disabledTextColor = Color.Black,
                                disabledLabelColor = Color.Blue,
                                disabledIndicatorColor = Color.Transparent,
                                backgroundColor = Color.Transparent
                            ),
                            textStyle = TextStyle(
                                textAlign = TextAlign.Center
                            ),
                            singleLine = true,
                            label = {
                                Text(
                                    text = "Level",
                                    fontSize = 12.sp
                                )
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))

            // STATS //
            Box (
                modifier = Modifier
                    .fillMaxSize()
                    .border(BorderStroke(2.dp, Color.Black),
                        shape = RoundedCornerShape(percent = 5))
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Row(
                        modifier = Modifier
                            .heightIn(min = 24.dp, max = 52.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Stats",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start
                        )
                    }

                    Row(
                        modifier = Modifier
                            .heightIn(min = 24.dp, max = 102.dp)
                    ) {
                        Column(

                        ){
                            TextField(
                                modifier = Modifier
                                    .size(width = 78.dp, height = 52.dp),
                                value = healthText.toString(),
                                onValueChange = {
                                    if (it.length <= 3) healthText = it.toInt()
                                    if (it < 0.toString()) healthText = 0
                                },
                                textStyle = TextStyle(
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center
                                ),
                                keyboardOptions = KeyboardOptions(
                                    capitalization = KeyboardCapitalization.None,
                                    autoCorrectEnabled = false,
                                    keyboardType = KeyboardType.Number
                                ),
                                colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                singleLine = true
                            )

                            Text(
                                text = "Hit Points(HP)",
                                fontSize = 20.sp
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .heightIn(min = 24.dp, max = 52.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.strength_statsicon),
                            tint = Color.LightGray,
                            contentDescription = null
                        )
                        Text(
                            text = "Strength:",
                            fontSize = 20.sp
                        )
                        TextField(
                            modifier = Modifier
                                .size(width = 48.dp, height = 52.dp),
                            value = strText.toString(),
                            onValueChange = {
                                if (it.length <= 2) strText = it.toInt()
                            },
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            ),
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )
                        Text(
                            text = "(" + calculateModifiers(strText) + ")",
                            fontSize = 20.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .heightIn(min = 24.dp, max = 52.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.intelligence_statsicon),
                            tint = Color.LightGray,
                            contentDescription = null
                        )
                        Text(
                            text = "Intelligence:",
                            fontSize = 20.sp
                        )
                        TextField(
                            modifier = Modifier
                                .size(width = 48.dp, height = 52.dp),
                            value = intText.toString(),
                            onValueChange = {
                                if (it.length <= 2) intText = it.toInt()
                            },
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            ),
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )
                        Text(
                            text = "(" + calculateModifiers(intText) + ")",
                            fontSize = 20.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .heightIn(min = 24.dp, max = 52.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.constitution_statsicon),
                            tint = Color.LightGray,
                            contentDescription = null
                        )
                        Text(
                            text = "Constitution:",
                            fontSize = 20.sp
                        )
                        TextField(
                            modifier = Modifier
                                .size(width = 48.dp, height = 52.dp),
                            value = conText.toString(),
                            onValueChange = {
                                if (it.length <= 2) conText = it.toInt()
                            },
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            ),
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )
                        Text(
                            text = "(" + calculateModifiers(conText) + ")",
                            fontSize = 20.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .heightIn(min = 24.dp, max = 52.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.spirit_statsicon),
                            tint = Color.LightGray,
                            contentDescription = null
                        )
                        Text(
                            text = "Spirit:",
                            fontSize = 20.sp
                        )
                        TextField(
                            modifier = Modifier
                                .size(width = 48.dp, height = 52.dp),
                            value = sptText.toString(),
                            onValueChange = {
                                if (it.length <= 2) sptText = it.toInt()
                            },
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            ),
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )
                        Text(
                            text = "(" + calculateModifiers(sptText) + ")",
                            fontSize = 20.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .heightIn(min = 24.dp, max = 52.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.agility_statsicon),
                            tint = Color.LightGray,
                            contentDescription = null
                        )
                        Text(
                            text = "Agility:",
                            fontSize = 20.sp
                        )
                        TextField(
                            modifier = Modifier
                                .size(width = 48.dp, height = 52.dp),
                            value = agiText.toString(),
                            onValueChange = {
                                agiText = it.toInt()
                            },
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            ),
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )
                        Text(
                            text = "(" + calculateModifiers(agiText) + ")",
                            fontSize = 20.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .heightIn(min = 24.dp, max = 52.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.charisma_statsicon),
//                            tint = Color.LightGray,
                            contentDescription = null
                        )
                        Text(
                            text = "Charisma:",
                            fontSize = 20.sp
                        )
                        TextField(
                            modifier = Modifier
                                .size(width = 48.dp, height = 52.dp),
                            value = chrText.toString(),
                            onValueChange = {
                                chrText = it.toInt()
                            },
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            ),
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )
                        Text(
                            text = "(" + calculateModifiers(chrText) + ")",
                            fontSize = 20.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .heightIn(min = 24.dp, max = 52.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.luck_statsicon),
                            tint = Color.LightGray,
                            contentDescription = null
                        )
                        Text(
                            text = "Luck:",
                            fontSize = 20.sp
                        )
                        TextField(
                            modifier = Modifier
                                .size(width = 48.dp, height = 52.dp),
                            value = lckText.toString(),
                            onValueChange = {
                                lckText = it.toInt()
                            },
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            ),
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )
                        Text(
                            text = "(" + calculateModifiers(lckText) + ")",
                            fontSize = 20.sp
                        )
                    }
                }//*
            }

            Spacer(modifier = Modifier.padding(8.dp))

            // COUNTERS //
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(BorderStroke(2.dp, Color.Black),
                        shape = RoundedCornerShape(percent = 5))
                    .padding(8.dp)
            ){
                Column(
                    modifier = Modifier.fillMaxSize()
                ){
                    Row(
                        modifier = Modifier
                            .heightIn(min = 24.dp, max = 52.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Counters",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }

                    Row(
                        modifier = Modifier
                            .heightIn(min = 16.dp, max = 32.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = "Exhaustion",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }

                    Row {
                        IconButton(
                            modifier = Modifier
                                .weight(1.3f),
                            onClick = { exhaustCount-- }
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }

                        TextField(
                            modifier = Modifier
                                .size(width = 48.dp, height = 52.dp),
                            value = exhaustCount.toString(),
                            onValueChange = {
                                if (it.length <= 2 && it.toInt() >= 0) exhaustCount = it.toInt()
                            },
                            textStyle = TextStyle(
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            ),
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.NumberPassword
                            ),
                            colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )

                        IconButton(
                            modifier = Modifier
                                .weight(1.3f),
                            onClick = { exhaustCount++ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowUp,
                                contentDescription = null
                            )
                        }
                    }


                    Row(
                        modifier = Modifier
                            .heightIn(min = 16.dp, max = 32.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(text = "Death Counters:")
                        TextField(
                            modifier = Modifier
                                .size(width = 16.dp, height = 32.dp),
                            value = strText.toString(),
                            onValueChange = {
                                strText = it.toInt()
                            },
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            singleLine = true
                        )
                    }

                    Row(
                        modifier = Modifier
                            .heightIn(min = 16.dp, max = 32.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Text(text = "Strength:")
                        TextField(
                            modifier = Modifier
                                .size(width = 16.dp, height = 32.dp),
                            value = strText.toString(),
                            onValueChange = {
                                strText = it.toInt()
                            },
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.None,
                                autoCorrectEnabled = false,
                                keyboardType = KeyboardType.Number
                            ),
                            colors = TextFieldDefaults.textFieldColors(
//                                unfocusedContainerColor = Color.Transparent,
//                                focusedContainerColor = Color.Black
                            ),
                            singleLine = true
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.padding(8.dp))
            Divider(thickness = 2.dp, color = Color.LightGray)
        }
    }
}

fun calculateModifiers(value: Int):String {
    val modifier:String = when(value){
        in 1..4 -> "-2"
        in 5..8 -> "-1"
        in 9..12 -> "0"
        in 13..16 -> "+1"
        in 17..20 -> "+2"
        else -> "0"
    }
    return modifier
}


@Composable
@Preview
fun CharacterPreview(){
    CharacterView()
}