package com.nuvio.app.features.updater

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class AppUpdaterVersionUtilsTest {
    @Test
    fun personalBuildTenSortsAfterPersonalBuildNine() {
        assertTrue(
            VersionUtils.compareVersions(
                first = "personal-0.4.20-personal.10",
                second = "personal-0.4.20-personal.9",
            ) > 0,
        )
    }

    @Test
    fun newestReleaseIsSelectedRegardlessOfGithubApiOrder() {
        val githubApiOrder = listOf(
            "personal-0.4.20-personal.9",
            "personal-0.4.20-personal.8",
            "personal-0.4.20-personal.10",
        )

        val newest = githubApiOrder.maxWithOrNull(VersionUtils::compareVersions)

        assertEquals("personal-0.4.20-personal.10", newest)
    }
}
