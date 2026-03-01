package model

// Representa un projecte de construcció amb un conjunt de tasques.
// Permet afegir, obtenir, cercar i eliminar tasques.

class Projecte(
    val id: String,
    var nom: String,
    var descripcio: String,
    var estat: String
) {
    val tasques: MutableList<Tasca> = mutableListOf()

    fun afegirTasca(tasca: Tasca) {
        tasques.add(tasca)
    }

    fun obtenirTasques(): List<Tasca> {
        return tasques
    }

    // Retorna una tasca segons el seu id
    fun buscarTasca(id: String): Tasca? {
        return tasques.find { it.id == id }
    }

    // Elimina una tasca segons el seu id
    fun eliminarTasca(id: String) {
        tasques.removeIf { it.id == id }
    }
}
