package Euler

//A palindromic number reads the same both ways. The largest palindrome formed by the product of two 2-digit numbers is 9009 = 91 x 99.
//Find the largest palindrome formed by the product of two 3 - digit numbers.
//A: 906609
object Four {
  def main(args:Array[String]){
    def isPalindrome(x: Int) = {
      x.toString == x.toString.reverse
    }

    val startTime = System.currentTimeMillis()
    val dromes = for (
      i <- 999 to 900 by -1
      ; j <- 999 to 900 by -1
    ;  if (isPalindrome(i*j))
    ) yield i*j //yield ((i,j),i*j)
    println(dromes.max) //337ms
//    println(dromes.sortBy(_._2).reverse)


//    println(countFrom(999,999))

    val endTime = System.currentTimeMillis()
    println(endTime - startTime + "ms")

//    def countFrom(x:Int, y:Int):Int = {
//      if (isPalindrome(x*y)) x*y
//      else if(x > y) countFrom(x-1,y)
//      else countFrom(x,y-1)
//    }
  }

}
