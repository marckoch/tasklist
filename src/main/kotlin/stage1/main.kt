package stage1

fun main() {
    val tasks = readTasks()

    printTasks(tasks)
}

fun readTasks(): List<String> {
    println("Input the tasks (enter a blank line to end):")

    val tasks = mutableListOf<String>()
    while (true) {
        val input = readLine()!!.trim()
        if (input.isEmpty()) {
            break
        } else {
            tasks.add(input)
        }
    }
    return tasks
}

fun printTasks(tasks: List<String>) {
    if (tasks.isEmpty()) {
        println("No tasks have been input.")
        return
    }

    tasks.forEachIndexed { i, task ->
        val index = (i + 1).toString().padEnd(2, ' ')
        println("$index $task")
    }
}