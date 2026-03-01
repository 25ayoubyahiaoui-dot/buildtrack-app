package model

// Representa les hores treballades i materials utilitzats per un empleat en una tasca

class RegistreTreball(
    val id: String,
    var horesTreballades: Double,
    var data: String
) {
    val materials: MutableList<Material> = mutableListOf()

    fun afegirMaterial(material: Material) {
        materials.add(material)
    }
}
