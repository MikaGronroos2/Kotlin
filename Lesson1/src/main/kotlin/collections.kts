val a1 = Pair(1, "one")
val a2 = 2 to "two"
a1
a2

val a = a1.second
a
val (a11, a21) = a1
a11
a21

val b1 = Triple(1, "eng", "one")
val b = b1.third
b
val (b11, _, b13) = b1
b11
b13

val myList = listOf("John", "Jill", "Adam", "John", "Roberta", "Agnes")

println("myList: $myList") // [John, Jill, Adam, John, Roberta, Agnes]
println("myList.size: ${myList.size}") // 6
println("myList[ 2 ]: ${myList[ 2 ]}") // Adam
println("myList.contains(\"Adam\"): ${myList.contains("Adam")}") // true

for(s in myList) {
    println(s)
}

for(i in myList.indices) {
    println("$i: ${myList[ i ]}")
}

var esim: List<Int?>? = listOf(1,2,3,null,6)
esim

val myMutableList = mutableListOf("John", "Jill", "Adam", "John", "Roberta", "Agnes")

myMutableList.add(2, "Eve")
println("myMutableList: $myMutableList") // [John, Jill, Eve, Adam, John, Roberta, Agnes]

myMutableList.add("Jill")
println("myMutableList: $myMutableList") // [John, Jill, Eve, Adam, John, Roberta, Agnes, Jill]

myMutableList.removeAt(4)
println("myMutableList: $myMutableList") // [John, Jill, Eve, Adam, Roberta, Agnes, Jill]

myMutableList.remove("Agnes")
println("myMutableList: $myMutableList") // [John, Jill, Eve, Adam, Roberta, Jill]

val mySet = setOf("John", "Jill", "Adam", "John", "Roberta", "Agnes")

println("mySet: $mySet") // [John, Jill, Adam, Roberta, Agnes]
println("mySet.size: ${mySet.size}") // 5
//println("mySet[ 2 ]: ${mySet[ 2 ]}") // can’t do this
println("mySet.contains(\"Adam\"): ${mySet.contains("Adam")}") // true
val anotherSet = listOf("Adam", "Eve")
mySet.union(anotherSet) // [John, Jill, Adam, Roberta, Agnes, Eve]
mySet.intersect(anotherSet) // [Adam]
mySet.minus(anotherSet) // [John, Jill, Roberta, Agnes]

for(s in mySet) {
    println(s)
}

for(s in mySet.minus(anotherSet)) {
    println(s)
}

var myMutableSet = mutableSetOf("John", "Jill", "Adam", "John", "Roberta", "Agnes")

//myMutableSet.add(2, "Eve")
println("myMutableSet: $myMutableSet") // [John, Jill, Adam, Roberta, Agnes]

myMutableSet.add("Jill")
println("myMutableSet: $myMutableSet") // [John, Jill, Adam, Roberta, Agnes]

//myMutableSet.removeAt(4)
//println("myMutableSet: $myMutableSet")

myMutableSet.remove("Agnes")
println("myMutableSet: $myMutableSet") // [John, Jill, Adam, Roberta]

val myList1: MutableList<String> = myMutableSet.toMutableList()
myList1.add("John")
myList1
myMutableSet = myList1.toMutableSet()
myMutableSet
listOf(1,1,1,2,3,4,4,2,3,4,5,4,4,3).toSet().size

val myMap = mapOf(Pair("One", 1), Pair("Two", 2),
    Pair("Deux", 2), Pair("Three", 3),
    Pair("Many", 10), Pair("Many", 20))
println("myMap: $myMap") // {One=1, Two=2, Deux=2, Three=3, Many=20}

println("myMap[ \"Three\" ]: ${myMap[ "Three" ]}") // 3
println("myMap.keys ${myMap.keys}") // [One, Two, Deux, Three, Many]
println("myMap.values ${myMap.values}") // [1, 2, 2, 3, 20]
val aaa = myMap[ "One" ]

val myMutableMap = myMap.toMutableMap()
myMutableMap[ "Five" ] = 5
myMutableMap.remove("Many")
println("myMutableMap: $myMutableMap") // {One=1, Two=2, Deux=2, Three=3, Five=5}

val numerot = mapOf(
    "nolla" to 0, "yksi" to 1, "kaksi" to 2, "kolme" to 3, "neljä" to 4,
    "viisi" to 5, "kuusi" to 6, "seitsemän" to 7, "kahdeksan" to 8, "yhdeksän" to 9
)

val nimet = numerot.map { (key,value) -> value to key }.toMap()
nimet
