package com.example.aquarium

fun main (args: Array<String>) {
    buildAquarium()
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    println(
        "Length: ${myAquarium.length} " +
        "Width: ${myAquarium.width} " +
        "Height: ${myAquarium.height}"
    )

    myAquarium.height = 80

    println(
        "Height: ${myAquarium.height} cn"
    )

    println(
        "Volume: ${myAquarium.volume} liters"
    )

    val smallAquarium = Aquarium(
        length = 20,
        width = 15,
        height = 30,
    )

    println("Small aquarium: ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish  = 9)

    println(
        "Small Aquarium2: ${myAquarium2.volume} liters with" +
                "length ${myAquarium2.length}" +
                "width ${myAquarium2.width}" +
                "height ${myAquarium2.height}"
    )

}
