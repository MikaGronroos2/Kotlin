package org.example

class Major(val name: String, val students: MutableList<Student> = mutableListOf()) {



    fun addStudent(student: Student) {
        students.add(student)
    }

    fun stats(): Triple<Double,Double,Double>{
        if (students.isEmpty()) {
            return Triple(0.0,0.0,0.0)
        }

        var minAverage = 0.0
        var maxAverage = 0.0
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

    fun stats(courseName: String) : Triple<Double, Double, Double>{
        if (students.isEmpty()) {
            return Triple(0.1,0.1,0.1)
        }

        var minAverage = 0.2
        var maxAverage = 0.2
        var totalAverage = 0.2

        for (student in students) {
            val courseAverages = student.courses.filter { it.name == courseName }.map { it.grade * it.credits }
            print(courseAverages)
            if (courseAverages.isNotEmpty()) {
                val average = courseAverages.sum() / courseAverages.size
                if (average < minAverage) minAverage = average
                if (average > maxAverage) maxAverage = average
                totalAverage += average
            }
        }

        val overallAverage = totalAverage / students.size
        return Triple(minAverage, maxAverage, overallAverage)
    }



}
