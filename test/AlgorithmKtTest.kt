import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension
import uk.org.webcompere.systemstubs.stream.SystemIn
import uk.org.webcompere.systemstubs.stream.SystemOut

@ExtendWith(SystemStubsExtension::class)
class AlgorithmKtTest {

    private val numberPair = 8
    private val numberNotPair = 7
    private val numberPositive = 1
    private val numberNegative = -1

    @Test
    fun readNumberTestPositiveIntNumber() {
        //Arr
        val input = SystemIn("$numberPositive\n")
        var result = 0
        //Act
        input.execute {
            result = readNumber()
        }
        //Ass
        assertEquals(numberPositive, result)
    }

    @Test
    fun readNumberTestNegativeIntNumber() {
        //Arr
        val input = SystemIn("$numberNegative\n$numberPositive\n")
        val output = SystemOut()
        var result = 0
        //Act
        input.execute {
            output.execute {
                result = readNumber()
            }
        }
        //Ass
        assertEquals(numberPositive, result)
        assertTrue(output.text.contains("Debe introducir un número positivo mayor que 0."))
    }


    @Test
    fun readNumberTestZeroNumber() {
        //Arr
        val input = SystemIn("0\n$numberPositive\n")
        val output = SystemOut()
        var result = 0
        //Act
        input.execute {
            output.execute {
                result = readNumber()
            }
        }
        //Ass
        assertEquals(numberPositive, result)
        assertTrue(output.text.contains("Debe introducir un número positivo mayor que 0."))
    }

    @Test
    fun readNumberTestDoubleNumber() {
        //Arr
        val input = SystemIn("5.5\n$numberPositive\n")
        val output = SystemOut()
        var result = 0
        //Act
        input.execute {
            output.execute {
                result = readNumber()
            }
        }
        //Ass
        assertEquals(numberPositive, result)
        assertTrue(output.text.contains("Debe introducir un número válido."))
    }

    @Test
    fun readNumberTestCharactersNumber() {
        //Arr
        val input = SystemIn("letras\n$numberPositive\n")
        val output = SystemOut()
        var result = 0
        //Act
        input.execute {
            output.execute {
                result = readNumber()
            }
        }
        //Ass
        assertEquals(numberPositive, result)
        assertTrue(output.text.contains("Debe introducir un número válido."))
    }


    @Test
    fun isNumberPositiveTestTrue() {
        //Arr
        //Act
        val result = isNumberPositive(numberPositive)
        //Ass
        assertTrue(result)
    }

    @Test
    fun isNumberPositiveTestFalse() {
        //Arr
        //Act
        val result = isNumberPositive(numberNegative)
        //Ass
        assertFalse(result)
    }

    @Test
    fun isNumberPairTestTrue() {
        //Arr
        //Act
        val result = isNumberPair(numberPair)
        //Ass
        assertTrue(result)
    }

    @Test
    fun isNumberPairTestFalse() {
        //Arr
        //Act
        val result = isNumberPair(numberNotPair)
        //Ass
        assertFalse(result)
    }

    @Test
    fun printTituleTestWithPairNumber() {
        //Arr
        val titule = "Serie del número par $numberPair\r\n"
        val output = SystemOut()
        //Act
        output.execute {
            printTitule(numberPair)
        }
        //Ass
        assertEquals(titule,output.text)
    }

    @Test
    fun printTituleTestWithNotPairNumber() {
        //Arr
        val titule = "Serie del número impar $numberNotPair\r\n"
        val output = SystemOut()
        //Act
        output.execute {
            printTitule(numberNotPair)
        }
        //Ass
        assertEquals(titule,output.text)
    }

    @Test
    fun printNumbersTestWithPairNumber() {
        //Arr
        val expected = "Serie del número par 8\r\n8\r\n6\r\n4\r\n2\r\n"
        val output = SystemOut()
        //Act
        output.execute {
            printNumbers(numberPair)
        }
        //Ass
        assertEquals(expected,output.text)

    }

    @Test
    fun printNumbersTestWithNotPairNumber() {
        //Arr
        val expected = "Serie del número impar 7\r\n7\r\n5\r\n3\r\n1\r\n"
        val output = SystemOut()
        //Act
        output.execute {
            printNumbers(numberNotPair)
        }
        //Ass
        assertEquals(expected,output.text)
    }
}