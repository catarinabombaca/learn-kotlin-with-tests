import com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersonTest {
    @Test
    fun `when creating a person, then information of their name and surname is printed out`() {
        // How to test the console output: https://blog.mestwin.net/test-the-console-output-println-in-kotlin/
        val output = tapSystemOut {
            Person("Catarina", "Bombaca")
        }

        assertEquals(
            "Hi, my name is Catarina Bombaca.",
            output.trim()
        )
    }

    @Test
    fun `when requesting the full name, then we get the first and last name`() {
        val name = "Catarina"
        val surname = "Bombaca"

        val fullName = Person(name, surname).fullName()

        assertEquals("Catarina Bombaca", fullName)
    }

    @Test
    fun `when requesting to add children, then a person has a child associated`() {
        val parent = Person("Catarina", "Bombaca")
        val child = Person("Wenqing", "Bombaca")

        parent.addChild(child)

        assertEquals(1, parent.children.size)
        assertEquals(child.fullName(), parent.children[0].fullName())
    }

    @Test
    fun `when creating a child, then the child is automatically associated to their parent`() {
        val parent = Person("Catarina", "Bombaca")

        val child = Person("Wenqing", "Bombaca", parent)

        assertEquals(1, parent.children.size)
        assertEquals(child.fullName(), parent.children[0].fullName())
    }
}