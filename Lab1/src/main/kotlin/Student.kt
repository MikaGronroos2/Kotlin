package org.example


class Student(name: String, age: Int, val courses: MutableList<CourseRecord> = mutableListOf()) :
      Human(name, age) {

    fun addCourse(course: CourseRecord) {
        courses.add(course)
    }

    fun weightedAverage(): Double {
        var grade: Double = 0.0
        var counter = 0
        var totalCredits: Double = 0.0
        for (course in courses) {
            grade += course.grade * course.credits
            totalCredits += course.credits
        }

        return if(totalCredits > 0) grade / totalCredits else 0.0
    }

    fun weightedAverage(year: Int): Double {
        var grade: Double = 0.0
        var counter = 0
        var totalCredits: Double = 0.0
        for (course in courses) {
            if (course.yearCompleted == year) {
                grade += course.grade * course.credits
                totalCredits += course.credits
            }
        }

        return if(totalCredits > 0) grade / totalCredits else 0.0
    }

    fun minMaxGrades() : Pair<Double, Double> {
        var minGrade: Double = 0.0
        var maxGrade: Double = 0.0

        for (course in courses) {
            if (minGrade == 0.0 || course.grade < minGrade) {
                minGrade = course.grade
            }
            if (maxGrade == 0.0 || course.grade > maxGrade) {
                maxGrade = course.grade
            }
        }

        return Pair(minGrade, maxGrade)
    }
}
