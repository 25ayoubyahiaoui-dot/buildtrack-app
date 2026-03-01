package model

// Representa una tasca dins d’un projecte.
// Conté informació de l’estat, l’empleat assignat i els registres de treball.

class Tasca(
    val id: String,
    var titol: String,
    var descripcio: String,
    var estat: EstatTasca // ara utilitza l'enum
) {
    var empleatAssignat: Empleat? = null // Pot ser null si encara no hi ha empleat assignat
    val registres: MutableList<RegistreTreball> = mutableListOf()

    fun assignarEmpleat(empleat: Empleat) {
        empleatAssignat = empleat
    }

    fun marcarCompletada() {
        estat = EstatTasca.COMPLETADA
    }

    fun afegirRegistre(registre: RegistreTreball) {
        registres.add(registre)
    }
}