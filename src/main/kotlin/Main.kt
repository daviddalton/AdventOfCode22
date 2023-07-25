import java.io.File

const val INPUT_FILE = 0
const val TEST_INPUT_FILE = 1

fun readFileAsTextUsingInputStream(fileName: String) = File(fileName).inputStream().readBytes().toString(Charsets.UTF_8)

fun main(args: Array<String>) {
    println("Counting elves...")
    println("Gathering equipment...")
    println("Compiling data...")

    val data = readFileAsTextUsingInputStream(args[INPUT_FILE])
    val dayOne = DayOne(data)
    val dayTwo = DayTwo(data)
    val day = args[2]
    val part = args[3]

    if (day == "1") {
        if (part == "1") {
            println("Executing Day 1 Part 1....")
            print("Solution: " + dayOne.partOne())
        } else {
            println("Executing Day 1 Part 2....")
            print("Solution: " + dayOne.partTwo())
        }
    } else if (day == "2") {
        if (part == "1") {
            println("Executing Day 2 Part 1....")
            print("Solution: " + dayTwo.partOne())
        } else {
            println("Executing Day 2 Part 2....")
            print("Solution: " + dayTwo.partTwo())
        }
    }
}
