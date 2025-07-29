package me.femrek.pub_dev_version_fetcher.dto

import kotlin.test.Test
import kotlin.test.assertEquals

class PackageVersionsDTOTest {
    @Test
    fun `fromJson should parse JSON correctly`() {
        val json = """
            {
                "latest": {"version": "2.0.0"},
                "versions": [
                    {"version": "1.0.0", "otherField": "value1"},
                    {"version": "1.1.0", "otherField": "value2"},
                    {"version": "1.1.0+123", "otherField": "value3"},
                    {"version": "2.0.0", "otherField": "value4"}
                ]
            }
        """.trimIndent()

        val packageVersions = PackageVersionsDTO.fromJson(json)

        assertEquals("2.0.0", packageVersions.latest)
        assertEquals(listOf("1.0.0", "1.1.0", "1.1.0+123", "2.0.0"), packageVersions.versions)
    }

}