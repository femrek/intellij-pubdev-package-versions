package me.femrek.pub_dev_version_fetcher.repository

import me.femrek.pub_dev_version_fetcher.dto.PackageVersionsDTO
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class PackageInfoRepository {
    companion object {
        fun fetchVersions(packageName: String): PackageVersionsDTO? {
            val client = HttpClient.newBuilder().build()
            val request =
                HttpRequest.newBuilder().uri(URI.create("https://pub.dev/api/packages/$packageName")).GET().build()

            val response = client.send(request, HttpResponse.BodyHandlers.ofString())
            if (response.statusCode() == 200) {
                return PackageVersionsDTO.Companion.fromJson(response.body())
            }
            return null
        }
    }
}
