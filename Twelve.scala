package Euler

import annotation.tailrec

/*
The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?
* */
//    214980480
 //A: 76576500  //176723ms! too long
object Twelve {

  val divs = 500

  def main(a:Array[String]){
    val s = System.currentTimeMillis()
    val x = TriangleNumberStream().find(x => Divisors(x).size > divs-1)//takeWhile(x => Divisors(x).size < divs)
//    val x = TriangleNumberStream().find(x => x == 73920) //takeWhile(x => Divisors(x).size < divs)
//    val x = TriangleNumberStream().take(10).map(x => Divisors(x)) //takeWhile(x => Divisors(x).size < divs)
    println(x)
//    Divisors(36).foreach(println)
//    Factorizer(36).sorted.foreach(println)
//    val facs = Factorizer(36)
//    (1 to facs.length) foreach(i=> facs.combinations(i).foreach(j=>println(j.product)))


    val e = System.currentTimeMillis()
    print(e - s + "ms")
  }
}

object Factorizer2 {  //arggg... not working
  var primes: List[BigInt] = Nil
  var knownFacs:List[(BigInt,List[BigInt])] = Nil

  def apply(limit: BigInt): List[BigInt] = {
    val res = primeFac(limit)
    knownFacs = (limit, res) :: knownFacs
    res
  }
//    knownFacs.get(limit).getOrElse({
//      val res = primeFac(limit)
//      knownFacs = knownFacs + (limit, res)
//      res
//    })
//  }

  @tailrec
  def primeFac(limit: BigInt, divisors: List[BigInt] = Nil): List[BigInt] = {
    if (limit == 1) return divisors
//    knownFacs.get(limit).foreach(l => return l union divisors)
//    val k = knownFacs.get(limit)
//    if (k.isDefined) {
//      return k.get union divisors
//    }
//    knownFacs.keysIterator.toList.sorted.reverse.find(limit % _ == 0) match {
//    knownFacs.partition()

    knownFacs.find(limit % _._1 ==0) match {
      case Some(x) => {
        primeFac(limit / x._1, x._2 union divisors)
      }
      case None => {
        limit :: divisors
      }
    }
  }

//    if (limit % i == 0) {
//      primeFac(i, limit / i, i :: divisors)
//    }
//    else {
//      val currP = nextPrime(i)
//      if (limit % currP == 0) {
//        primeFac(currP, limit / currP, currP :: divisors)
//      }
//      else {
//        primeFac(currP, limit, divisors)
//      }
//    }
//  }

//  @tailrec
//  def nextPrime(i: BigInt): BigInt = {
//    if (!primes.isEmpty && i < primes.max) {
//      return primes.reverse.find(_ > i).get
//    }
//    val prime = primes.forall(p => i % p != 0)
//    if (prime) {
//      primes = i :: primes
//      i
//    }
//    else nextPrime(i + 1)
//  }
}

object TriangleNumberStream {
  var nums:List[BigInt] = BigInt(0) :: Nil

  def apply():Stream[BigInt] = startFrom(BigInt(1))

  def startFrom(n: BigInt):Stream[BigInt] = {
    val next = nextTri(n)
    Stream.cons(next, startFrom(next+1))
  }

  def nextTri(n: BigInt) = {
    nums = nums.head + nums.size :: nums
    nums.head
  }
}

object Divisors { //Divisors are just prime factors combined
  def apply(n:BigInt):List[BigInt] = {
    if (n==1) return List(BigInt(1))
    val facs = Factorizer(n)
    val combos = facs.foldLeft(1, Nil:List[BigInt])((a,x)=>{
      (a._1+1, facs.combinations(a._1).toList.map(_.product).union(a._2))
    })//._2.flatten
//    combos._2 foreach println
    combos._2
//    ((1 to facs.length) foreach (i => facs.combinations(i).foreach(_.product))).sorted
  }
}

//  def apply(n: BigInt): Set[BigInt] = {
//    val res = (BigInt(1) to n/2).filter(i => n%i==0).toSet + n
////    println(res)
//    res
//  }
//Premature optimization
//  def apply(n:BigInt):Set[BigInt] = {
//    divisorStream(n)
//  }
//  val divisorStream:Stream[List[BigInt]] =
//}
