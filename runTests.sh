rm -rf classes
mkdir classes
scalac -deprecation -cp specs_2.8.1-1.6.7.jar:mockito-all-1.8.5.jar -d classes fizzbuzz.scala fizzprinter.scala
scala -cp specs_2.8.1-1.6.7.jar:mockito-all-1.8.5.jar:classes run fizzBuzzSpec
scala -cp specs_2.8.1-1.6.7.jar:mockito-all-1.8.5.jar:classes run fizzPrinterSpec

