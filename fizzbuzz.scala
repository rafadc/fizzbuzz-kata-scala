import org.specs.Specification

object Fizzbuzz {
  def apply(parameter : Int) = parameter match {
    case number if number % 3 == 0 => "fizz"
    case number if number % 5 == 0 => "buzz"    
    case _ => parameter
  }
}

class fizzBuzzSpec extends Specification {

  "fizzBuzz function" should {
    "return itself if parameter non divisible by neither 3 nor 5" in {
       Fizzbuzz(1) must_== 1
    }

    "return 'fizz' if parameter divisible by 3" in {
       Fizzbuzz(6) must_== "fizz"
    }

    "return 'buzz' if parameter divisible by 5" in {
       Fizzbuzz(20) must_== "buzz"
    }

    "return 'fizzbuzz' if parameter divisible by 3 and 5" in {
       Fizzbuzz(15) must_== "fizzbuzz"
    }

  }
}

