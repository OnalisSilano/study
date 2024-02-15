package com.example.curry

class Spice(name: String, spiciness: String = "mild") {
    val heat : Int
    get() {return 5}

    val level = Spice(
        "cinnamon",
        heat.toString()
    )
    
    init {
        println(
            "saccs ${level.heat}"
        )
    }
}