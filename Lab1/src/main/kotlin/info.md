Study register
Implement a simple study register. Following classes/structs are needed: Major, Human,
Student (which inherits from Human) and CourseRecord. The classes/structs should have at least the following properties and methods:
● Human:
    ○ name
    ○ age
    ○ getOlder()
● CourseRecord:
    ○ name
    ○ yearCompleted
    ○ credits
    ○ grade
● Student:
    ○ courses (a collection of CourseRecord instances)
    ○ addCourse(course)
    ○ weightedAverage() - average of grades weighted by credits
    ○ weightedAverage(year) - as previous but for a specific year only
    ○ minMaxGrades() - returns minimum and maximum of grades
● Major:
    ○ name
    ○ students (a collection of Student instances)
    ○ addStudent(student)
    ○ stats() - returns the smallest, highest, and average of averages for students
    ○ stats(courseName) - like previous but for only course courseName