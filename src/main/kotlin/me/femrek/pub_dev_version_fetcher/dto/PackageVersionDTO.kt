package me.femrek.pub_dev_version_fetcher.dto

import me.femrek.pub_dev_version_fetcher.util.AppDateTimeUtil
import org.json.JSONObject

data class PackageVersionDTO(
    val name: String,
    val date: String,
) {
    companion object {
        fun fromJson(jsonObject: JSONObject): PackageVersionDTO {
            val name = jsonObject.getString("version")
            val published = AppDateTimeUtil.convertDateFormat(jsonObject.getString("published"));
            return PackageVersionDTO(name, published)
        }
    }
}
