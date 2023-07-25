fun main(args: Array<String>) {
    println("Counting elves...")
    println("Gathering equipment...")
    println("Compiling data...")

    val dayOne = DayOne()
    val dayTwo = DayTwo()
    val dayThree = DayThree()
    val day = args[0]
    val part = args[1]

    when (day) {
        "1" -> {
            if (part == "1") {
                println("Executing Day 1 Part 1....")
                print("Solution: " + dayOne.partOne())
            } else {
                println("Executing Day 1 Part 2....")
                print("Solution: " + dayOne.partTwo())
            }
        }
        "2" -> {
            if (part == "1") {
                println("Executing Day 2 Part 1....")
                print("Solution: " + dayTwo.partOne())
            } else {
                println("Executing Day 2 Part 2....")
                print("Solution: " + dayTwo.partTwo())
            }
        }
        "3" -> {
            if (part == "1") {
                println("Executing Day 3 Part 1....")
                print("Solution: " + dayThree.partOne())
            } else {
                println("Executing Day 3 Part 2....")
                print("Solution: " + dayThree.partTwo())
            }
        }
    }
}
