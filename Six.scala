package Euler

/*The sum of the squares of the first ten natural numbers is, 12 + 22 +...+ 102 = 385
The square of the sum of the first ten natural numbers is, (1 + 2 +...+ 10) 2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 385 = 2640.
Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/
//A: 25164150
object Six {
  def main(args:Array[String]){
    val a = sumOfSquares(100) - squareOfSums(100)
    println(math.abs(a))
  }

  def sumOfSquares(l:Int):Int = {
    (1 to l).map(x=>x*x).sum
  }

  def squareOfSums(l:Int): Int = {
    math.pow((1 to l).sum,2).toInt
  }
}
