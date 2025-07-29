package me.femrek.pub_dev_version_fetcher.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns
import org.jetbrains.yaml.YAMLLanguage

class PubDevVersionCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement()
                .withLanguage(YAMLLanguage.INSTANCE)
                .inFile(PlatformPatterns.psiFile().withName("pubspec.yaml")),
            PubDevVersionCompletionProvider()
        )
    }
}
