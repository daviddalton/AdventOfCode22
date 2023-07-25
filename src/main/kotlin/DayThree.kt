import java.io.File

class DayThree {

    private val input = "src/main/data/day3/input.txt"
    private val inputTest = "src/main/data/day3/inputTest.txt"

    private fun readFileAsTextUsingInputStream(fileName: String) = File(fileName).inputStream().readBytes().toString(Charsets.UTF_8)
    private var data: String = readFileAsTextUsingInputStream(input)
    private val sacks = data.split("\n")

    val chars = mapOf<Char, Int>(
        'a' to 1, 'b' to 2, 'c' to 3, 'd' to 4, 'e' to 5, 'f' to 6, 'g' to 7, 'h' to 8, 'i' to 9, 'j' to 10, 'k' to 11, 'l' to 12, 'm' to 13, 'n' to 14, 'o' to 15, 'p' to 16, 'q' to 17, 'r' to 18, 's' to 19, 't' to 20, 'u' to 21, 'v' to 22, 'w' to 23, 'x' to 24, 'y' to 25, 'z' to 26,
        'A' to 27, 'B' to 28, 'C' to 29, 'D' to 30, 'E' to 31, 'F' to 32, 'G' to 33, 'H' to 34, 'I' to 35, 'J' to 36, 'K' to 37, 'L' to 38, 'M' to 39, 'N' to 40, 'O' to 41, 'P' to 42, 'Q' to 43, 'R' to 44, 'S' to 45, 'T' to 46, 'U' to 47, 'V' to 48, 'W' to 49, 'X' to 50, 'Y' to 51, 'Z' to 52
    )

    fun partOne(): Int {

        var totalPoints = 0

        sacks.forEach { sack ->
            val mid: Int = sack.length / 2
            val left: Set<Char> = sack.substring(0, mid).toSet()
            val right: Set<Char> = sack.substring(mid).toSet()

            val duplicate = left.intersect(right).toList()[0]

            totalPoints += chars[duplicate]!!
        }

        return totalPoints
    }

    fun partTwo(): Int {

        var totalPoints = 0

        for (i in sacks.indices step 3) {
            val first: Set<Char> = sacks.get(i).toSet()
            val second: Set<Char> = sacks.get(i + 1).toSet()
            val third: Set<Char> = sacks.get(i + 2).toSet()

            val duplicate = first.intersect(second).intersect(third).toList()[0]

            totalPoints += chars[duplicate]!!
        }

        return totalPoints
    }
}