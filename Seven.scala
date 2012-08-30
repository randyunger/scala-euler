package Euler

import annotation.tailrec

/* By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
What is the 10001st prime number?
 */
//A: 104743
object Seven {
  def main(args:Array[String]){
    var i=0
    val s = System.currentTimeMillis()
    val last = PrimeStream().take(10001).last //foreach(x=> {i+=1;println(i+"::"+x) })
    val e = System.currentTimeMillis()
    println(last)
    print(e - s + "ms")
  }
}

object PrimeStream {
  //def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)
  def apply(): Stream[BigInt] = xxx
  val xxx = 2 #:: startFrom(BigInt(3))
  def startFrom(n:BigInt):Stream[BigInt] = {
    val nx = nextPrime(n)
    Stream.cons(nx, startFrom(nx+2))
  }
  var primes: Vector[BigInt] = Vector(2)

  @tailrec
  def nextPrime(i: BigInt): BigInt = {
    val prime = primes.forall(p => i % p != 0)
//    val prime = xxx.forall(p => i % p != 0)
    if (prime) {
      primes = primes :+ i
      i
    }
    else nextPrime(i + 2)
  }
}

