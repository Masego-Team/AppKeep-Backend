useLogger(CustomEventLogger())

class CustomEventLogger() : BuildAdapter(), TaskExecutionListener {

    override fun beforeExecute(task: Task) {
    }

    override fun afterExecute(task: Task, state: TaskState) {
    }

    override fun buildFinished(result: BuildResult) {
        println("Test execution complete")
        if (result.failure != null) {
            println("Tests FAILED")
        }
    }
}

