package model

// Classe base que representa qualsevol usuari del sistema.
// Conté propietats comunes a tots els usuaris: id, nom i email.
// Es declara abstracta perquè no es poden crear instàncies directes de Persona.
// Les subclasses concretes (Administrador i Empleat) hereten aquestes propietats i afegeixen funcionalitats específiques.

abstract class Persona(
    val id: String,
    var nom: String,
    var email: String
) {
    open fun getInfo(): String {
        return "$nom ($email)"
    }
}
