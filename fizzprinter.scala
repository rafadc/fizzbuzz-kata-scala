import org.specs.Specification
import org.specs.mock.Mockito

class FizzPrinter(calculator : FizzCalculator){

  def printFrom1To100 {
    (1 until 100 inclusive) foreach { value => println(calculator.calculate(value)) }
  }
}

class fizzPrinterSpec extends Specification with Mockito {
  "Fizzprinter" should {
    "print fizzbuzz for numbers for 1 to 100" in {
       val fizzCalculator = mock[FizzCalculator]

       val fizzPrinter = new FizzPrinter(fizzCalculator)

       fizzPrinter.printFrom1To100

       (1 until 100 inclusive) foreach { value => there was one(fizzCalculator).calculate(value) } 
    }
  }
}
