package org.home.brinck

import javax.net.ssl.HttpsURLConnection
import java.io.*
import java.net.*
import java.util.HashMap

data class HttpReturn (val response : String = "",
                       val responseCode : Int = HttpsURLConnection.HTTP_NOT_FOUND)

/**
 * Created by sambr on 4/3/2016.
 */
object WebServiceInterface {

    private var currentUserId: String = ""
    init {
        CookieHandler.setDefault(CookieManager(null, CookiePolicy.ACCEPT_ALL))
    }

    fun signIn(username: String, password: String): Boolean {
        val params = HashMap<String, String>()
        params.put("username", username)
        params.put("password", password)
        val signIn = performPostCall(Config[Config.SERVICES.SIGN_IN], params)
        val success = signIn.responseCode == 200 && !signIn.response.contains("Sign in")
        if (success) {
            currentUserId = get(Config[Config.SERVICES.CURRENT_ID])
        }
        return success
    }

    //    @TargetApi(Build.VERSION_CODES.KITKAT)
    private fun performPostCall(requestURL: String,
                        postDataParams: Map<String, String>,
                        HTTP_TYPE: String = "POST"): HttpReturn {
        var response = ""
        var responseCode = 0
        try {
            val url = URL(requestURL)

            val connection = url.openConnection() as HttpURLConnection
            connection.readTimeout = 15000
            connection.connectTimeout = 15000
            connection.requestMethod = HTTP_TYPE
            connection.doInput = true
            connection.doOutput = true


            connection.outputStream.use { os ->

                val writer = BufferedWriter(
                        OutputStreamWriter(os, "UTF-8"))
                writer.write(getPostDataString(postDataParams))
                //            http://stackoverflow.com/questions/2938502/sending-post-data-in-android

                writer.flush()
                writer.close()
            }
            responseCode = connection.responseCode

            response = if (responseCode == HttpsURLConnection.HTTP_OK) {
                connection.inputStream.bufferedReader().readText()
//                val br = BufferedReader(InputStreamReader(connection.inputStream))
//                while ((line = br.readLine()) != null) {
//                    response += line
//                }
            } else {
                ""
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return HttpReturn(response, responseCode)
    }

    @Throws(UnsupportedEncodingException::class)
    private fun getPostDataString(params: Map<String, String>): String {
        val result = StringBuilder()
        var first = true
        for ((key, value) in params) {
            if (first)
                first = false
            else
                result.append("&")

            result.append(URLEncoder.encode(key, "UTF-8"))
            result.append("=")
            result.append(URLEncoder.encode(value, "UTF-8"))
        }

        return result.toString()
    }

    private fun get(url: String) : String {
        return URL(url).readText()
    }
}
