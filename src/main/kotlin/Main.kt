import java.time.Duration
import java.time.Instant
import kotlin.random.Random

fun main(array:Array<String>){
    setData()
}

fun setData(){
    var ans: String?

    print("How many members would you like your array to have? ")
    var am = readln().toInt()

    print("\nWould you like to fill the array with your own custom numbers (enter M)," +
            " or would you prefer it to be filled with random numbers (enter A)? ")
    ans = readln().toString().uppercase()

    linearSearchArray(fillArray(ans,am))

}

fun fillArray(mOrA:String, arrayMembers: Int):Array<Int>{
    var tempArray = Array(arrayMembers){0}

    if(mOrA == "A"){
        for (i in 0 until arrayMembers){
            tempArray[i] = Random.nextInt()
            println("Number $i: ${tempArray[i]}")
        }
    }else{
        for(j in 0 until arrayMembers){
            print("\nEnter number $j : ")
            tempArray[j] = readln()!!.toInt()
        }
    }
    return tempArray
}

fun linearSearchArray(array:Array<Int>){
    print("\nPlease enter the number you are searching for: ")
    var targetNumber = readln().toInt()
    var index = -1
    val start = Instant.now()

    for(i in 0 until array.size){
        if(targetNumber == array[i]){
            index = i
        }
    }

    val end = Instant.now()
    val duration = Duration.between(start, end)

    if (index != -1){
        println("The number ($targetNumber) you were looking for has been found at index $index.")
    }else{println("Sorry! Not Found!!!")}

    println("The SEARCHING execution time was ${duration.toMillis()} milliseconds.")

}