package me.femrek.pub_dev_version_fetcher.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext
import me.femrek.pub_dev_version_fetcher.repository.PackageInfoRepository
import me.femrek.pub_dev_version_fetcher.util.AppYamlUtils

class PubDevVersionCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters, context: ProcessingContext, resultSet: CompletionResultSet
    ) {
        val element = parameters.position

        val packageName = AppYamlUtils.findPackageName(element)
        if (packageName != null) {
            val packageInfo = PackageInfoRepository.fetchVersions(packageName)
            if (packageInfo != null) {
                var priorityCounter = 0.0

                // all versions
                if (packageInfo.versions.isNotEmpty()) {
                    for (version in packageInfo.versions) {
                        // versions are sorted first version to last by the pub.dev api.
                        // increasing counter puts the last version at the top of the popup.
                        priorityCounter++
                        resultSet.addElement(
                            PrioritizedLookupElement.withPriority(
                                LookupElementBuilder
                                    .create(version)
                                    .withTypeText("Version from pub.dev"),
                                priorityCounter
                            )
                        )
                    }
                }

                // latest
                resultSet.addElement(
                    PrioritizedLookupElement.withPriority(
                        LookupElementBuilder
                            .create("^${packageInfo.latest}")
                            .withPresentableText("latest")
                            .withLookupString("latest").withLookupString("^${packageInfo.latest}")
                            .withTypeText("Caret Latest from pub.dev"),
                        priorityCounter + 1
                    )
                )
            }
        }
    }
}
