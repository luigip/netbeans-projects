
package scalaexperiments

object P053 {
  def main(args:Array[String]){
    for 
  }
  
  def factorial(n:BigInt):BigInt = {
    if(n < 1) 1
    if(n == 1) n
    else n * factorial(n - 1)
  }
  
  def multifact(n:BigInt, m:BigInt):BigInt = {
    if(n < 1 || m < 1 || m >= n) 1
    if(n == m + 1) n
    else n * multifact(n - 1, m)
  }
  
}
