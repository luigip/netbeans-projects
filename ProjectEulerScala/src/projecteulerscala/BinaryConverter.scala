
package projecteulerscala

object BinaryConverter {

  def parseBinary(s: String) = {
    if (s.length > 31)
      throw new IllegalArgumentException("Binary too long")
    s.scanRight(0, 1){ 
      case (x, (result, multiplier)) => {
        val d = x - '0'
        if (d < 0 || d > 1)
          throw new NumberFormatException("Invalid digits detected")
        (result + d * multiplier, multiplier * 2)
      }
    }.head._1
  }
  
  
  def main(args: Array[String]) {
    println(parseBinary("101")) // 5
    println(parseBinary("10101010")) // 170
    try {
        println(parseBinary("10301")) // Invalid digit
    }
    catch {case e =>
        println(e.getMessage())
    }
  }
}
