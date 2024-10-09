import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun `given a person I get the information of their name and surname`() {
        // How to test the console output: https://blog.mestwin.net/test-the-console-output-println-in-kotlin/
        val output = tapSystemOut {
            Person("Catarina", "Bombaca")
        }

        assertEquals(
            "Hi, my name is Catarina Bombaca.",
            output.trim()
        )
    }
}