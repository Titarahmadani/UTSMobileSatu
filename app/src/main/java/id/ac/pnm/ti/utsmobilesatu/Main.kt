package id.ac.pnm.ti.utsmobilesatu

fun main() {
    // Inisialisasi mutableList dan tambah data List
    val clubs = mutableListOf<Club>()
    println("+=========================================================================================================================================+")
    clubs.add(Club("Liverpool", 19, 8, 9, 6, 3))
    clubs.add(Club("Manchester United", 20, 12, 6, 3, 0))
    clubs.add(Club("Chelsea", 6, 6, 5, 2, 2))
    clubs.add(Club("Manchester City", 8, 8, 8, 0, 0))
    clubs.add(Club("Arsenal", 13, 14, 2, 0, 0))
    clubs.add(Club("UEFA", 3, 1, 2, 0, 0))

    // Passing a named function ::sortByNumb erTrophyTotal
    val sortedClubs = filterAndSort(clubs, ::sortByNumberTrophyTotal)
    // Hasil sorting total trofi
    println("Urutan klub berdasarkan jumlah total trofi:")
    println("+=========================================================================================================================================+")
    for (club in sortedClubs) {
        println("${club.name} - ${club.totalTrophy}")
    }

    // Passing a named function ::filterByEuropeanTrophy
    val filteredClubs = filterAndSort(clubs, ::filterByEuropeanTrophy)
    // Hasil filtering klub yang belum pernah memenangkan UCL dan UEL
    println("+=========================================================================================================================================+")
    println("Klub yang belum pernah memenangkan UCL dan UEL:")
    println("+=========================================================================================================================================+")
    for (club in filteredClubs) {
        println("${club.name} - ${club.totalTrophy}")
    }

    // Panggil extension function Club recap
    println("+=========================================================================================================================================+")
    println(clubs[0].recap())
    println("+=========================================================================================================================================+")
}

// High order function filter and sort
fun filterAndSort(clubs: List<Club>, options: (List<Club>) -> List<Club>): List<Club> {
    return options(clubs)
}

// Fungsi sorting
fun sortByNumberTrophyTotal(clubs: List<Club>): List<Club> {
    val sortedClubs = clubs.sortedByDescending { it.totalTrophy }
    return sortedClubs

}

// Fungsi filter
fun filterByEuropeanTrophy(clubs: List<Club>): List<Club> {
    val filteredClubs = clubs.filter { (it.ucl + it.uela) == 0 }
    return filteredClubs
}