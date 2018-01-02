package org.home.brinck

import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

fun main(args: Array<String>) {
    val response = WebServiceInterface.signIn("sambrinck",
                                            """oEqa8t3T1NWyJIWWcpQY""")
    println(response)

//    println(URL(Config[Config.SERVICES.CURRENT_ID]).readText())
    enumerateStakeCallings()
}

/**
 * Enumerate the callings in a stake
 */
fun enumerateStakeCallings() {
    val json = JSONArray(URL(Config[Config.SERVICES.CURRENT_USER_UNITS])
            .readText()).getJSONObject(0)
    json.getJSONArray("wards")
        .map { it as JSONObject }
        .forEach({
            println(it.getInt("wardUnitNo").toString() + ": " + it.getString("wardName"))
            enumerateWardCallings(it.getInt("wardUnitNo"))
        })
}


/**
 * Enumerate the callings in a ward
 */
fun enumerateWardCallings(wardId: Int) {
    println(" WARD: $wardId - " + Config[Config.SERVICES.CALLINGS, wardId])
    val json = JSONArray(URL(Config[Config.SERVICES.CALLINGS, wardId])
            .readText())

    json.map { it as JSONObject }.forEach({
        println("Name: ${it["spokenName"]}\tCalling: ${it["position"]}")
    })
}