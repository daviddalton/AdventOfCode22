import java.io.File

class DayOne {

    private val input = "src/main/data/day1/input.txt"
    private val inputTest = "src/main/data/day1/inputTest.txt"

    private fun readFileAsTextUsingInputStream(fileName: String) = File(fileName).inputStream().readBytes().toString(Charsets.UTF_8)
    private var data: String = readFileAsTextUsingInputStream(input)
    private val elves = data.split("\n\n")

    fun partOne(): Int {
        var largest = 0

        elves.forEach {
            val items = it.split("\n")
            var calories = 0

            items.forEachIndexed { index, _ ->
                calories += Integer.parseInt(items[index])
            }

            if (calories > largest) {
                largest = calories
            }
        }
        return largest
    }

    fun partTwo(): Int {
        val counts = mutableListOf<Int>()

        elves.forEach {
            val items = it.split("\n")
            var calories = 0

            items.forEachIndexed { index, s ->
                calories += Integer.parseInt(items[index])
            }
            counts.add(calories)
        }
        val sortedList = counts.sortedDescending()
        return sortedList[0] + sortedList[1] + sortedList[2]
    }
}