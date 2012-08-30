package Euler

//Add all natural numbers less than a thousand that are multiples of 3 or 5.
//A: 233168
object One {
  def main(args:Array[String]) {
    val total = (1 to 999).filter(i => i%3==0 || i%5==0).sum
    println(total)
  }
}
