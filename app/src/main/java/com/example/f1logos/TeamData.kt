package com.example.f1logos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamData(
    val description: String,
    val name: String,
    val image: Int
) : Parcelable

val teamCard = mutableListOf (

    TeamData(
        "misho",
        "oto",
        R.drawable.ic_launcher_background

    ),
    TeamData(
        "Here Goes Formula One Team History",
        "alfa",
        R.drawable.alfa_romeo_seeklogo_com
    ),


    TeamData(
        "Here Goes Formula One Team History",
        "alpine",
        R.drawable.alpine_seeklogo_com

    ),

    TeamData(
        "Here Goes Formula One Team History",
        "aston martin",
        R.drawable.aston_martin_seeklogo_com

    ),



    TeamData(
        "Here Goes Formula One Team History",
        "ferrari",
        R.drawable.ferrari_emblem_seeklogo_com

    ),


    TeamData(
        "Here Goes Formula One Team History",
        "haas",
        R.drawable.haas_f1_team_seeklogo_com

    ),


    TeamData(
        "Here Goes Formula One Team History",
        "mclaren",
        R.drawable.mclaren_formula_1_team_seeklogo_com

    ),


    TeamData(
        "Here Goes Formula One Team History",
        "redbull",
        R.drawable.red_bull_racing_logo___brandlogos_net

    ),


    TeamData(
        "Here Goes Formula One Team History",
        "alpha tauri",
        R.drawable.scuderia_alpha_tauri_1

    ),


    TeamData(
        "Here Goes Formula One Team History",
        "williams racing",
        R.drawable.williams_racing_seeklogo_com

    )
)
