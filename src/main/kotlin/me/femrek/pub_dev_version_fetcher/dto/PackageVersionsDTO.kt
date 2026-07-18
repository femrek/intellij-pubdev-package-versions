package me.femrek.pub_dev_version_fetcher.dto

import me.femrek.pub_dev_version_fetcher.util.AppDateTimeUtil

data class PackageVersionsDTO(
    val latest: PackageVersionDTO,
    val versions: List<PackageVersionDTO>
) {
    companion object {
        fun fromJson(json: String): PackageVersionsDTO {
            val jsonObject = org.json.JSONObject(json)

            // versions
            val versions = jsonObject.getJSONArray("versions").let { map ->
                List(map.length()) { i ->
                    PackageVersionDTO.fromJson(map.getJSONObject(i))
                }
            }

            // latest
            val latestObj = jsonObject.getJSONObject("latest");
            val latest = PackageVersionDTO.fromJson(latestObj)
            return PackageVersionsDTO(latest, versions)
        }
    }
}
