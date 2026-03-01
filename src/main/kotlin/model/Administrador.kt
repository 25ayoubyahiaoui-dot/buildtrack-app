package model

// Subclasse de Persona que representa el responsable del projecte.
// Té funcions per crear projectes i tasques i consultar els projectes existents.

class Administrador(
    id: String,
    nom: String,
    email: String,
    var rol: String
) : Persona(id, nom, email) {

    // Afegeix un projecte a la llista de projectes del sistema
    fun crearProjecte(projectes: MutableList<Projecte>, projecte: Projecte) {
        projectes.add(projecte)
    }

    // Retorna la llista de projectes existents
    fun consultarProjectes(projectes: MutableList<Projecte>): List<Projecte> {
        return projectes
    }

    // Crea i afegeix una tasca a un projecte específic
    fun crearTasca(projecte: Projecte, tasca: Tasca) {
        projecte.afegirTasca(tasca)
    }
}
