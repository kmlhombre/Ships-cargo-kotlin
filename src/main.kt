fun main() {
    val ship = Ship("MS1", 1000)

    try {
        ship.loading("kiwi", 10, 100)
    }
    catch (e: Exception) {
        println(e.message)
    }
    finally {
        ship.display()
    }

    try {
        ship.loading("banana", 2, 500)
    }
    catch (e: Exception) {
        println(e.message)
    }
    finally {
        ship.display()
    }

    try {
        ship.unloading("banana", 2)
    }
    catch (e: Exception) {
        println(e.message)
    }
    finally {
        ship.display()
    }

    try {
        ship.unloading("kiwi", 8)
    }
    catch (e: Exception) {
        println(e.message)
    }
    finally {
        ship.display()
    }
}