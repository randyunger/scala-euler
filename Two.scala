package Euler

//Find the sum of all the even-valued terms in the Fibonacci sequence which do not exceed four million
//A: 4613732
object Two {
  def main(args: Array[String]) {
    def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)
    val fibs = fibFrom(1, 1)
    val sum = fibs.takeWhile(_<4000000).filter(_%2==0).sum
    println(sum)
  }
}

//1 1 2 3 5 8 13 21 34
// 2 8