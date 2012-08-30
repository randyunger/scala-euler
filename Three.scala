package Euler

import annotation.tailrec

//The prime factors of 13195 are 5, 7, 13 and 29.
//What is the largest prime factor of the number 600851475143 ?
//A: 6857
object Three {

  val max = BigInt("600851475143")
  var primes: List[BigInt] = Nil

  def main(args:Array[String]){
    val x = primeFac(2, max)
    println(x)
    println(x.max)
  }

  @tailrec
  def primeFac(i:BigInt, limit:BigInt, divisors:List[BigInt] = Nil):List[BigInt] = {
    if (limit == 1){
      return divisors
    }
    val currP = nextPrime(i)
    if (limit % currP == 0) {
      primeFac(currP+1, limit/currP, currP :: divisors)
    }
    else {
      primeFac(currP+1, limit, divisors)
    }
  }

  @tailrec
  def nextPrime(i: BigInt): BigInt = {
    val prime = primes.forall(p => i % p != 0)
    if (prime) {
      primes = i :: primes
      i
    }
    else nextPrime(i + 1)
  }
}
//  class PipedObject[T] private[Three](value: T) {
//    def |>[R](f: T => R) = f(this.value)
//  }
//
//  implicit def toPiped[T](value: T) = new PipedObject[T](value)
//
//  val sieve = (n: BigInt) => (BigInt(3) to n by 2) |> (r => r.foldLeft(r.toSet)((ps, x) => {
//    if (ps(x)) {
//      ps -- (x * x to n by x)
//    }
//    else ps
//  }))
//
//  val max = BigInt("600851475143")
//  def main(args: Array[String]) {
//    val x = sieve(max/2)  //prime nums less than half of max
//    val y = x.filter(max%_==0)
//    println(y.toList.sorted.last)
//  }

//  val max = BigInt("600851475143")
//  def main(args:Array[String]){
//    var i = BigInt(2)
//    var divisors: List[BigInt] = Nil
//    while(i< max/2){
//      if(max%i==0) {
//        println("DIV: "+i)
//        divisors = i :: divisors
//      }
//      i+=1
//    }
//
//    val primes = divisors.foldLeft(divisors.toSet)((set, x) => {
//      println("SET: "+set)
//      println("X: "+x)
//
//      val isPrime = set.forall(n =>{
//        println("N: " + n)
//        if (x%n == 0 && n!=x) {
//          false
//        }
//        else true
//      })
//
//      if (!isPrime) set - x
//      else set
//    })
//      set.foreach(n => {
//        println("N: "+n)
//        if (x%n == 0 && n!=x){
//          set - x
//        }
//        else set
//      })
//      val xx = set.foldLeft(x)(op = n:BigInt => {
//
//      })

//      println("XX: "+xx)


//      println("afterSET: " + set)
//      set


//    println(primes)

//    divisors.foldLeft(divisors.toSet)((ps,x) => {
//      if (ps(x)) {
//        ps -- (x * x to n by x)
//      }
//      else ps
//    })

//    println(divisors)
//  }

//}
