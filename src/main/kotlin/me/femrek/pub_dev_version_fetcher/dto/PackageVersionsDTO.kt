package me.femrek.pub_dev_version_fetcher.dto

data class PackageVersionsDTO(
    val latest: String,
    val versions: List<String>
) {
    companion object {
        fun fromJson(json: String): PackageVersionsDTO {
            val jsonObject = org.json.JSONObject(json)

            // versions
            val versions = jsonObject.getJSONArray("versions").let { map ->
                List(map.length()) { i ->
                    map.getJSONObject(i).getString("version")
                }
            }

            // latest
            val latest = jsonObject.getJSONObject("latest").getString("version")
            return PackageVersionsDTO(latest, versions)
        }
    }
}
