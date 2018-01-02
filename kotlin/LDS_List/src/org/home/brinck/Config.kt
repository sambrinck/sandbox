package org.home.brinck

import org.json.JSONException
import org.json.JSONObject

import java.net.URL

/**
* Created by sambr on 4/3/2016.
*/
object Config {
    private var json: JSONObject? = null

    enum class SERVICES (internal var key: String) {
        SIGN_IN("auth-url"),
        CURRENT_ID("current-user-id"),
        CURRENT_USER_UNITS("current-user-units"),
        UNIT_MEMBERS_AND_CALLINGS("unit-members-and-callings"),
        CALLINGS("callings-with-dates")
    }

    init {
        val values = URL("https://tech.lds.org/mobile/ldstools/config.json").readText()
        json = JSONObject(values)
    }

    @Throws (JSONException::class)
    operator fun get(service: SERVICES): String {
        return json!!.getString(service.key)
    }

    operator fun get(service: SERVICES, unit : Int): String {
        return json!!.getString(service.key).replace("%@", unit.toString())
    }
}
