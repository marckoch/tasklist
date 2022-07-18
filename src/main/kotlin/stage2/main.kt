package stage2

class Task(private var lines: List<String>) {
    val isEmpty get() = lines.isEmpty()

    fun print(number: Int) {
        val n = number.toString().padEnd(3)
        println("$n${lines.first()}")

        lines.drop(1).forEach {
            println("   $it") // 3 blanks in front
        }
    }
}

fun main() {
    val tasks = mutableListOf<Task>()

    while (true) {
        println("Input an action (add, print, end):")

        when (readLine()!!.trim()) {
            "end" -> {
                println("Tasklist exiting!")
                return
            }
            "add" -> getNewTask().let { if (it.isEmpty) println("The task is blank") else tasks.add(it) }
            "print" -> printTasks(tasks)
            else -> println("The input action is invalid")
        }
    }
}

fun getNewTask(): Task {
    println("Input a new task (enter a blank line to end):")

    val lines = mutableListOf<String>()
    while (true) {
        val input = readLine()!!.trim()
        if (input.isEmpty()) {
            break
        } else {
            lines.add(input)
        }
    }

    return Task(lines)
}

fun printTasks(tasks: List<Task>) {
    if (tasks.isEmpty()) {
        println("No tasks have been input")
        return
    }

    tasks.forEachIndexed { i, task ->
        task.print(i + 1)
        println()
    }
}