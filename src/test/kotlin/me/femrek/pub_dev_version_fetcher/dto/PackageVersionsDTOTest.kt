package me.femrek.pub_dev_version_fetcher.dto

import kotlin.test.Test
import kotlin.test.assertEquals

class PackageVersionsDTOTest {
    @Test
    fun `fromJson should parse JSON correctly`() {
        val json = """
            {
                "latest": {"version": "2.0.0", "published": "2026-03-17T10:45:57.622079Z"},
                "versions": [
                    {"version": "1.0.0", "published": "2026-03-10T10:45:57.622079Z", "otherField": "value1"},
                    {"version": "1.1.0", "published": "2026-03-11T10:45:57.622079Z", "otherField": "value2"},
                    {"version": "1.1.0+123", "published": "2026-03-12T10:45:57.622079Z", "otherField": "value3"},
                    {"version": "2.0.0", "published": "2026-03-17T10:45:57.622079Z", "otherField": "value4"}
                ]
            }
        """.trimIndent()

        val packageVersions = PackageVersionsDTO.fromJson(json)

        assertEquals("2.0.0", packageVersions.latest.name)
        assertEquals(
            listOf("1.0.0", "1.1.0", "1.1.0+123", "2.0.0"),
            packageVersions.versions.map { it.name }
        )
    }

}