package org.example

class Major(val name: String, val students: MutableList<Student> = mutableListOf()) {



    fun addStudent(student: Student) {
        students.add(student)
    }

    fun stats(): Triple<Double, Double, Double> {
        if (students.isEmpty()) {
            return Triple(0.0, 0.0, 0.0)
        }

        var minAverage = Double.MAX_VALUE
        var maxAverage = Double.MIN_VALUE
        var totalAverage = 0.0

        for (student in students) {
            val average = student.weightedAverage()
            if (average < minAverage) minAverage = average
            if (average > maxAverage) maxAverage = average
            totalAverage += average
        }

        val overallAverage = totalAverage / students.size
        return Triple(minAverage, maxAverage, overallAverage)
    }

    fun stats(courseName: String? = null): Triple<Double, Double, Double> {
        if (students.isEmpty()) return Triple(0.0, 0.0, 0.0)

        var minAverage = Double.MAX_VALUE
        var maxAverage = Double.MIN_VALUE
        var totalAverage = 0.0
        var count = 0

        for (student in students) {
            val averages = if (courseName == null) {
                listOf(student.weightedAverage())
            } else {
                student.courses.filter { it.name == courseName }.map { it.grade }
            }

            if (averages.isNotEmpty()) {
                val average = averages.average()
                if (average < minAverage) minAverage = average
                if (average > maxAverage) maxAverage = average
                totalAverage += average
                count++
            }
        }

        val overallAverage = if (count > 0) totalAverage / count else 0.0
        return Triple(minAverage, maxAverage, overallAverage)
    }



}
