package model

// Subclasse de Persona que representa un treballador assignat a tasques.
// Permet veure les tasques assignades i registrar el treball realitzat.

class Empleat(
    id: String,
    nom: String,
    email: String,
    var especialitat: String
) : Persona(id, nom, email) {

    // Funció per veure les tasques assignades
    fun veureTasquesAssignades(tasques: List<Tasca>): List<Tasca> {
        return tasques.filter { it.empleatAssignat == this }
    }

    // Permet registrar hores treballades i materials utilitzats en una tasca concreta
    fun registrarTreball(
        tasca: Tasca,
        horesTreballades: Double,
        data: String,
        materials: List<Material>
    ) {
        // Crear un nou registre de treball
        val registre = RegistreTreball(
            id = "R" + (tasca.registres.size + 1), // Generació simple d'id
            horesTreballades = horesTreballades,
            data = data
        )

        // Afegir els materials al registre
        materials.forEach { registre.afegirMaterial(it) }

        // Afegir el registre a la tasca
        tasca.afegirRegistre(registre)
    }
}
