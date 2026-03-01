package model

fun main() {

    println("===== INICI DEL SISTEMA BUILDTRACK – CLIMATITZACIÓ =====")

    // ================= Crear usuaris ==================
    val admin = Administrador(
        id = "A1",
        nom = "Ayoub",
        email = "ayoub@empresa.com",
        rol = "Manager"
    )

    val empleat = Empleat(
        id = "E1",
        nom = "Pablo",
        email = "pablo@empresa.com",
        especialitat = "Tècnic en climatització"
    )

    // ================= Crear projecte ==================
    val projecte = Projecte(
        id = "P1",
        nom = "Instal·lació de Climatitzadors ACME",
        descripcio = "Instal·lació i manteniment de sistemes de climatització",
        estat = EstatTasca.EN_PROGRES.name
    )

    val projectes = mutableListOf<Projecte>()
    admin.crearProjecte(projectes, projecte) // Afegir projecte
    println("\n Projectes disponibles:")
    admin.consultarProjectes(projectes).forEach { println("- ${it.nom}") }

    // ================= Crear tasques ==================
    val tasca1 = Tasca(
        id = "T1",
        titol = "Instal·lació unitat interior",
        descripcio = "Instal·lar la unitat interior del sistema AC",
        estat = EstatTasca.PENDENT
    )

    val tasca2 = Tasca(
        id = "T2",
        titol = "Instal·lació unitat exterior",
        descripcio = "Instal·lar la unitat exterior del sistema AC",
        estat = EstatTasca.PENDENT
    )

    val tasca3 = Tasca(
        id = "T3",
        titol = "Manteniment filtres",
        descripcio = "Netejar i revisar els filtres de les unitats",
        estat = EstatTasca.PENDENT
    )

    // Administrador crea les tasques dins del projecte
    admin.crearTasca(projecte, tasca1)
    admin.crearTasca(projecte, tasca2)
    admin.crearTasca(projecte, tasca3)

    // Assignar empleat a totes les tasques
    tasca1.assignarEmpleat(empleat)
    tasca2.assignarEmpleat(empleat)
    tasca3.assignarEmpleat(empleat)

    println("\n Tasques del projecte '${projecte.nom}':")
    projecte.obtenirTasques().forEach {
        println("- ${it.titol} (Assignat: ${it.empleatAssignat?.nom})")
    }

    // ================= Veure tasques assignades ==================
    println("\n Tasques assignades a ${empleat.nom}:")
    empleat.veureTasquesAssignades(projecte.obtenirTasques()).forEach { println("- ${it.titol}") }

    // ================= Registrar treball ==================
    val material1 = Material("M1", "Unitat interior AC", 1)
    val material2 = Material("M2", "Unitat exterior AC", 1)
    val material3 = Material("M3", "Tubs de refrigerant", 5)
    val material4 = Material("M4", "Cables elèctrics", 20)

    // Registrar treball a cada tasca amb hores i materials
    empleat.registrarTreball(tasca1, 4.0, "2026-03-22", listOf(material1, material4))
    empleat.registrarTreball(tasca2, 5.0, "2026-03-22", listOf(material2, material3))
    empleat.registrarTreball(tasca3, 2.0, "2026-03-23", listOf(material4))

    // Exemple: Actualitzar quantitat d’un material
    material3.actualitzarQuantitat(3) // S’ha utilitzat part dels tubs

    println("\n Registres de treball amb materials actualitzats:")
    projecte.obtenirTasques().forEach { t ->
        println("- ${t.titol}:")
        t.registres.forEach { r ->
            println("   • ${r.horesTreballades}h el ${r.data} | Materials: ${r.materials.map { it.nom + " (" + it.quantitat + ")" }}")
        }
    }

    // ================= Marcar tasques com completades ==================
    tasca1.marcarCompletada()
    tasca2.marcarCompletada()

    println("\n Estat de les tasques després de completar algunes tasques:")
    projecte.obtenirTasques().forEach { println("- ${it.titol}: ${it.estat}") }

    // ================= Cercar i eliminar tasca ==================
    val tascaTrobada = projecte.buscarTasca("T3")
    println("\n Tasca trobada amb ID=T3: ${tascaTrobada?.titol}")

    projecte.eliminarTasca("T3")
    println("\n Tasques després d'eliminar T3:")
    projecte.obtenirTasques().forEach { println("- ${it.titol}") }

    println("\n ===== FINAL DEL SISTEMA =====")
}