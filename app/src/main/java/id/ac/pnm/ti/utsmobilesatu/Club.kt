package id.ac.pnm.ti.utsmobilesatu

// data class Club
data class Club(
    val name: String,
    val epl: Int,
    val fa: Int,
    val efl: Int,
    val ucl: Int,
    val uela: Int
) {
    val totalTrophy: Int
        get() = epl + fa + efl + ucl + uela
}

// extension function recap
fun Club.recap(): String {
    return "($name berhasil meraih $epl trofi Liga Primer Inggris, $fa trofi FA, $efl trofi EFL, $ucl trofi Liga Champions, dan $uela trofi Liga Eropa UEFA)"
}
