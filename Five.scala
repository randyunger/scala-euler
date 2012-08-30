package Euler

import annotation.tailrec

//2520 is the smallest number that can be divided between each of the numbers from 1 to 10 without getting any remainder.
//What is the smallest positive number that is divisible by all numbers from 1 to 20 ?
//A:232792560  //295ms
object Five {
  def main(args:Array[String]){
    val s = System.currentTimeMillis()
    val facs = for (i <- 2 to 20) yield Factorizer2(i)
    val flat = facs.flatten
    val set = flat.toSet  //unique factors
    val lcm = set.foldLeft(BigInt(1))((a,x)=>{   //need to collect greatest num of factors
      val pow = longestStringOf(x, flat.toList)
//      if (pow > 1) println(x+"::"+pow)
//      println(a+"("+x+"^"+pow +") * ")
      a * x.pow(pow)//math.pow(x.toDouble,pow)
    })
    println(lcm)
    val e = System.currentTimeMillis()
    print(e - s + "ms")
  }

  def longestStringOf(x:BigInt, list:List[BigInt]):Int = {
    val runs = for (i <- 0 to list.length) yield list.segmentLength(_ == x, i)
    runs.max
  }
}

object Factorizer{
  var primes: List[BigInt] = Nil
  def apply(limit: BigInt): List[BigInt] = {
    primeFac(2,limit)
  }

  @tailrec
  def primeFac(i: BigInt, limit: BigInt, divisors: List[BigInt] = Nil): List[BigInt] = {
    if (limit == 1) return divisors
    if (limit % i == 0) {
      primeFac(i, limit / i, i :: divisors)
    }
    else {
      val currP = nextPrime(i)
      if (limit % currP == 0) {
        primeFac(currP, limit / currP, currP :: divisors)
      }
      else {
        primeFac(currP, limit, divisors)
      }
    }
  }
  @tailrec
  def nextPrime(i: BigInt): BigInt = {
    if (!primes.isEmpty && i < primes.max) {
      return primes.reverse.find(_ > i).get
    }
    val prime = primes.forall(p => i % p != 0)
    if (prime) {
      primes = i :: primes
      i
    }
    else nextPrime(i + 1)
  }
}
