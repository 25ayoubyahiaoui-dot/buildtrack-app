package model

// Representa un material utilitzat durant el treball d’una tasca

class Material(
    val id: String,
    var nom: String,
    var quantitat: Int
) {
    fun actualitzarQuantitat(novaQuantitat: Int) {
        quantitat = novaQuantitat
    }
}



